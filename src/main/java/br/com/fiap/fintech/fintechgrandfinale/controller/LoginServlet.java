package br.com.fiap.fintech.fintechgrandfinale.controller;

import br.com.fiap.fintech.fintechgrandfinale.dao.ContaDao;
import br.com.fiap.fintech.fintechgrandfinale.dao.TransacaoDao;
import br.com.fiap.fintech.fintechgrandfinale.dao.UsuarioDao;
import br.com.fiap.fintech.fintechgrandfinale.model.Conta;
import br.com.fiap.fintech.fintechgrandfinale.model.Transacao;
import br.com.fiap.fintech.fintechgrandfinale.model.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        try {
            UsuarioDao usuarioDao = new UsuarioDao();
            ContaDao contaDao = new ContaDao();
            TransacaoDao transacaoDao = new TransacaoDao();


            Usuario usuario = usuarioDao.login(email, senha);
            if (usuario.getId_usuario() != null) {
                Conta conta = contaDao.getContaPorIdUsuario(usuario.getId_usuario());
                List<Transacao> transacoes = transacaoDao.getTransacoesPorUsuario(usuario.getId_usuario());

                HttpSession sessao = request.getSession();
                sessao.setAttribute("usuarioId", usuario.getId_usuario());
                sessao.setAttribute("usuario", email);
                sessao.setAttribute("conta", conta);

                request.setAttribute("transacoes", transacoes);

                usuarioDao.fecharConexao();
                contaDao.fecharConexao();
                transacaoDao.fecharConexao();
                request.getRequestDispatcher("home.jsp").forward(request, response);
            } else {
                request.setAttribute("erro", "Email ou senha incorretos");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            System.err.println("Erro de SQL: " + e.getMessage());
        }
    }
}
