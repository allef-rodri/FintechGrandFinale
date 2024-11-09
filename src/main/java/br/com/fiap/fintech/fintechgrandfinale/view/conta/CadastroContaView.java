package br.com.fiap.fintech.fintechgrandfinale.view.conta;

import br.com.fiap.fintech.fintechgrandfinale.dao.ContaDao;
import br.com.fiap.fintech.fintechgrandfinale.model.Conta;

import java.sql.SQLException;

public class CadastroContaView {

    public static void main (String[] args){
        try{
            ContaDao contaDao = new ContaDao();

            Conta contaVinicius = new Conta();
            contaVinicius.setIdUsuario(3);
            contaVinicius.setSaldo(6000.00);
            contaDao.cadastrarConta(contaVinicius);

            Conta contaDiego = new Conta();
            contaDiego.setIdUsuario(4);
            contaDiego.setSaldo(36000.00);
            contaDao.cadastrarConta(contaDiego);

            Conta contaTeste = new Conta();
            contaTeste.setIdUsuario(5);
            contaTeste.setSaldo(8000.00);
            contaDao.cadastrarConta(contaTeste);

            Conta contaAllef = new Conta();
            contaAllef.setIdUsuario(1);
            contaAllef.setSaldo(5500.00);
            contaDao.cadastrarConta(contaAllef);

            Conta contaRafael = new Conta();
            contaRafael.setIdUsuario(2);
            contaRafael.setSaldo(6000.00);
            contaDao.cadastrarConta(contaRafael);

            contaDao.fecharConexao();
        }catch (SQLException e){
            System.err.println("Erro de SQL: " + e.getMessage());
        }
    }
}
