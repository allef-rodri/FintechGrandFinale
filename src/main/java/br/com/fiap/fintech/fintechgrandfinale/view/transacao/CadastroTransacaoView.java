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
            transacaoContaVinicius.setIdUsuario(3);
            transacaoContaVinicius.setIdTipoTranasacao(3);
            transacaoContaVinicius.setIdCategoria(2);
            transacaoContaVinicius.setDsTransacao("Salario do mês de outubro");
            transacaoContaVinicius.setValor(2000);
            transacaoContaVinicius.setDtRegistro(new Date());
            transacaoContaVinicius.setIdConta(9);
            transacaoDao.cadastrarReceita(transacaoContaVinicius);

            Transacao transacaoDiego = new Transacao();
            transacaoDiego.setIdUsuario(4);
            transacaoDiego.setIdTipoTranasacao(4);
            transacaoDiego.setIdCategoria(6);
            transacaoDiego.setDsTransacao("Pagamento do aluguel referente ao mês de outubro");
            transacaoDiego.setValor(1000);
            transacaoDiego.setDtRegistro(new Date());
            transacaoDiego.setIdConta(10);
            transacaoDao.cadastrarReceita(transacaoDiego);

            Transacao transacaoTeste = new Transacao();
            transacaoTeste.setIdUsuario(5);
            transacaoTeste.setIdTipoTranasacao(4);
            transacaoTeste.setIdCategoria(5);
            transacaoTeste.setDsTransacao("Mensalidade da faculdade do mês de outubro");
            transacaoTeste.setValor(800);
            transacaoTeste.setDtRegistro(new Date());
            transacaoTeste.setIdConta(11);
            transacaoDao.cadastrarReceita(transacaoTeste);

            Transacao transacaoAllef = new Transacao();
            transacaoAllef.setIdUsuario(1);
            transacaoAllef.setIdTipoTranasacao(5);
            transacaoAllef.setIdCategoria(4);
            transacaoAllef.setDsTransacao("Recebimento de dividendo mercado imobiliario");
            transacaoAllef.setValor(500);
            transacaoAllef.setDtRegistro(new Date());
            transacaoAllef.setIdConta(12);
            transacaoDao.cadastrarReceita(transacaoAllef);

            Transacao transacaoRafael = new Transacao();
            transacaoRafael.setIdUsuario(2);
            transacaoRafael.setIdTipoTranasacao(3);
            transacaoRafael.setIdCategoria(3);
            transacaoRafael.setDsTransacao("Recebimento de horas extras");
            transacaoRafael.setValor(600);
            transacaoRafael.setDtRegistro(new Date());
            transacaoRafael.setIdConta(13);
            transacaoDao.cadastrarReceita(transacaoRafael);

            transacaoDao.fecharConexao();
        }catch (SQLException e){
            System.err.println("Erro de SQL: " + e.getMessage());
        }
    }
}
