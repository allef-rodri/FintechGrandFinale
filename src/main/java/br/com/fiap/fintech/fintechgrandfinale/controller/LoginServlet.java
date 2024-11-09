package br.com.fiap.fintech.fintechgrandfinale.controller;

import br.com.fiap.fintech.fintechgrandfinale.dao.UsuarioDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        try{
            UsuarioDao usuarioDao = new UsuarioDao();
            if(usuarioDao.login(email, senha)){
                HttpSession sessao = request.getSession();
                sessao.setAttribute("usuario", email);
                response.sendRedirect("home.jsp");
            }else{
                request.setAttribute("erro", "Email ou senha incorretos");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        }catch (SQLException e){
            System.err.println("Erro de SQL: " + e.getMessage());
        }

    }
}
