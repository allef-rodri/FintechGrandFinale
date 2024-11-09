package br.com.fiap.fintech.fintechgrandfinale.view.conta;

import br.com.fiap.fintech.fintechgrandfinale.dao.ContaDao;
import br.com.fiap.fintech.fintechgrandfinale.exception.NenhumRegistroEncontradoException;
import br.com.fiap.fintech.fintechgrandfinale.model.Conta;

import java.sql.SQLException;
import java.util.List;


public class ListarContaView {
    public static void main(String[] args){
        try{
            ContaDao contaDao = new ContaDao();
            List<Conta> contas = contaDao.getAll();

            for (Conta conta : contas){
                System.out.println();
                System.out.println("ID: " + conta.getIdConta());
                System.out.println("ID do usuário: " + conta.getIdUsuario());
                System.out.println("Saldo: " + conta.getSaldo());
                System.out.println();
            }
            contaDao.fecharConexao();
        }catch(SQLException e) {
            System.err.println("Erro de SQL: " + e.getMessage());
        }catch(NenhumRegistroEncontradoException e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }
}
