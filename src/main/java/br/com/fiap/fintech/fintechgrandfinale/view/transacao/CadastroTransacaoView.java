package br.com.fiap.fintech.fintechgrandfinale.view.transacao;

import br.com.fiap.fintech.fintechgrandfinale.dao.TransacaoDao;
import br.com.fiap.fintech.fintechgrandfinale.model.Transacao;

import java.sql.SQLException;
import java.util.Date;

public class CadastroTransacaoView {

    public static void main (String[] args){
        try{
            TransacaoDao transacaoDao = new TransacaoDao();

            Transacao transacaoContaVinicius = new Transacao();
            transacaoContaVinicius.setIdUsuario(11);
            transacaoContaVinicius.setIdTipoTranasacao(6);
            transacaoContaVinicius.setIdCategoria(12);
            transacaoContaVinicius.setDsTransacao("Salario do mês de novembro");
            transacaoContaVinicius.setValor(4000);
            transacaoContaVinicius.setDtRegistro(new Date());
            transacaoContaVinicius.setIdConta(19);
            transacaoDao.cadastrarTransacao(transacaoContaVinicius);

            transacaoDao.fecharConexao();
        }catch (SQLException e){
            System.err.println("Erro de SQL: " + e.getMessage());
        }
    }
}
