package br.com.fiap.fintech.fintechgrandfinale.controller;

import br.com.fiap.fintech.fintechgrandfinale.dao.ContaDao;
import br.com.fiap.fintech.fintechgrandfinale.dao.TransacaoDao;
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

import static java.lang.Integer.parseInt;

@WebServlet("/atualizarSaldoConta")
public class AtualizaSaldoContaServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int tipoTransacaoId  = parseInt(request.getParameter("tipoTransacao"));
        String item  = request.getParameter("item");
        String valorStr  = request.getParameter("valor");

        HttpSession sessao = request.getSession();
        Conta conta = (Conta) sessao.getAttribute("conta");
        int usuarioId = (int) sessao.getAttribute("usuarioId");

        try {
            if((valorStr != null || !valorStr.isEmpty())){
                double valor = Double.parseDouble(valorStr);
                double operacao;

                if(tipoTransacaoId == 7 || tipoTransacaoId == 8){
                    operacao = conta.getSaldo() - valor;
                }else{
                    operacao = conta.getSaldo() + valor;
                }

                TransacaoDao transacaoDao = new TransacaoDao();
                Transacao transacao = new Transacao(usuarioId, tipoTransacaoId, item, valor, conta.getIdConta());

                transacaoDao.cadastrarTransacao(transacao);

                ContaDao contaDao = new ContaDao();
                contaDao.updateSaldo(conta.getIdConta(), operacao);
                request.getRequestDispatcher("home.jsp").forward(request, response);
            }else{
                request.setAttribute("erro", "Não foi possível atualizar o saldo.");
                request.getRequestDispatcher("home.jsp").forward(request, response);
            }
        }catch (SQLException e){
            System.err.println("Erro de SQL: " + e.getMessage());
        }
    }
}
