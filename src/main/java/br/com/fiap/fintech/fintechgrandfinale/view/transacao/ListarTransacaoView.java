package br.com.fiap.fintech.fintechgrandfinale.view.transacao;


import br.com.fiap.fintech.fintechgrandfinale.dao.TransacaoDao;
import br.com.fiap.fintech.fintechgrandfinale.exception.NenhumRegistroEncontradoException;
import br.com.fiap.fintech.fintechgrandfinale.model.Transacao;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;


public class ListarTransacaoView {
    public static void main(String[] args){
        try{
            TransacaoDao transacaoDao = new TransacaoDao();

            List<Transacao> transacoes = transacaoDao.getAll();

            for (Transacao transacao : transacoes){
                DateTimeFormatter dataFormatada = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                System.out.println();
                System.out.println("ID: " + transacao.getIdTransacao());
                System.out.println("ID DO USUARIO: " + transacao.getIdUsuario());
                System.out.println("DESCRIÇÃO: " + transacao.getDsTransacao());
                System.out.println("VALOR: " + transacao.getValor());
                System.out.println("DATA DO REGISTRO: " + LocalDate.parse(transacao.getDtRegistro().toString()).format(dataFormatada));
                System.out.println("ID DA CONTA: " + transacao.getIdConta());
                System.out.println();
            }
            transacaoDao.fecharConexao();

        }catch(SQLException e) {
            System.err.println("Erro de SQL: " + e.getMessage());
        }catch(NenhumRegistroEncontradoException e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }
}
