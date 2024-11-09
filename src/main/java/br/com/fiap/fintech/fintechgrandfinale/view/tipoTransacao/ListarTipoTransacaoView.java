package br.com.fiap.fintech.fintechgrandfinale.view.tipoTransacao;


import br.com.fiap.fintech.fintechgrandfinale.dao.TipoTransacaoDao;
import br.com.fiap.fintech.fintechgrandfinale.exception.NenhumRegistroEncontradoException;
import br.com.fiap.fintech.fintechgrandfinale.model.TipoTransacao;

import java.sql.SQLException;
import java.util.List;


public class ListarTipoTransacaoView {
    public static void main(String[] args){
        try{
            TipoTransacaoDao tipoTransacaoDao = new TipoTransacaoDao();
            List<TipoTransacao> tipoTransacaos = tipoTransacaoDao.getAll();

            for (TipoTransacao tipoTransacao : tipoTransacaos){
                System.out.println();
                System.out.println("ID: " + tipoTransacao.getIdTipoTransacao());
                System.out.println("DESCRIÇÃO: " + tipoTransacao.getDsTipoTransacao());
                System.out.println();
            }

            tipoTransacaoDao.fecharConexao();

        }catch(SQLException e) {
            System.err.println("Erro de SQL: " + e.getMessage());
        }catch(NenhumRegistroEncontradoException e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }
}
