package br.com.fiap.fintech.fintechgrandfinale.controller;

import br.com.fiap.fintech.fintechgrandfinale.dao.ContaDao;
import br.com.fiap.fintech.fintechgrandfinale.dao.TransacaoDao;
import br.com.fiap.fintech.fintechgrandfinale.dao.UsuarioDao;
import br.com.fiap.fintech.fintechgrandfinale.model.Conta;
import br.com.fiap.fintech.fintechgrandfinale.model.Transacao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/recarregar")
public class RecarregarTelaHome extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpSession sessao = httpRequest.getSession(false);
        Integer usuarioId = (Integer) sessao.getAttribute("usuarioId");

        if (sessao != null && usuarioId != null) {
            try {
                ContaDao contaDao = new ContaDao();
                TransacaoDao transacaoDao = new TransacaoDao();
                Conta conta = contaDao.getContaPorIdUsuario(usuarioId);
                List<Transacao> transacoes = transacaoDao.getTransacoesPorUsuario(usuarioId);

                sessao.setAttribute("conta", conta);
                sessao.setAttribute("transacoes", transacoes);

                contaDao.fecharConexao();
                transacaoDao.fecharConexao();

                request.getRequestDispatcher("home.jsp").forward(request, response);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
