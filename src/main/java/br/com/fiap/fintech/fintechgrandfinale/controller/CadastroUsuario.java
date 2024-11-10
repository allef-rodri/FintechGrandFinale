package br.com.fiap.fintech.fintechgrandfinale.controller;

import br.com.fiap.fintech.fintechgrandfinale.HelloServlet;
import br.com.fiap.fintech.fintechgrandfinale.dao.UsuarioDao;
import br.com.fiap.fintech.fintechgrandfinale.model.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

@WebServlet("/cadastroUsuario")
public class CadastroUsuario extends HelloServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String confirmeSenha = request.getParameter("confirmeSenha");
        String login = null;

        if(nome.isEmpty() || nome == null){
            request.setAttribute("erro", "Nome inválido");
            request.getRequestDispatcher("cadastro_usuarios.jsp").forward(request, response);
            return;
        }

        if((email != null  || !email.isEmpty()) && email.contains("@")){
            login = email.split("@")[0];
        }else{
            request.setAttribute("erro", "Email inválido");
            request.getRequestDispatcher("cadastro_usuarios.jsp").forward(request, response);
            return;
        }

        if(!Objects.equals(senha, confirmeSenha)  || senha.isEmpty() || confirmeSenha.isEmpty()){
            request.setAttribute("erro", "Senhas não correspondem");
            request.getRequestDispatcher("cadastro_usuarios.jsp").forward(request, response);
            return;
        }


        try {
            UsuarioDao usuarioDao = new UsuarioDao();
            Usuario usuarioDB = usuarioDao.getIdUsuarioPorEmail(email);

            if(usuarioDB != null){
                request.setAttribute("erro", "E-mail já cadastrado");
                request.getRequestDispatcher("cadastro_usuarios.jsp").forward(request, response);
                return;
            }

            Usuario usuario = new Usuario(nome, email, login, senha);
            usuarioDao.cadastrarUsuario(usuario);
            request.getRequestDispatcher("index.jsp").forward(request, response);

            usuarioDao.fecharConexao();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
