package br.com.fiap.fintech.fintechgrandfinale.dao;

import br.com.fiap.fintech.fintechgrandfinale.factory.ConnectionFactory;
import br.com.fiap.fintech.fintechgrandfinale.model.Conta;
import br.com.fiap.fintech.fintechgrandfinale.exception.NenhumRegistroEncontradoException;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContaDao {
    private Connection conexao;
    PreparedStatement stmt = null;

    public ContaDao() throws SQLException {
        conexao = ConnectionFactory.getConnection();
    }

    public List<Conta> getAll() throws NenhumRegistroEncontradoException {
        String sql = "select * from t_contas";
        List<Conta> contas = new ArrayList<Conta>();

        try {
            stmt = conexao.prepareStatement(sql);
            ResultSet result = stmt.executeQuery();

            while (result.next()){
                Conta conta = new Conta();

                conta.setIdConta(result.getInt("ID_CONTA"));
                conta.setIdUsuario(result.getInt("ID_USUARIO"));
                conta.setSaldo(result.getInt("SALDO"));
                contas.add(conta);
            }

            if(contas.isEmpty()){
                throw new NenhumRegistroEncontradoException("Nenhum registro encontrado.");
            }

            return contas;
        }catch (SQLException e){
            System.err.println("Erro de SQL: " + e.getMessage());
        }
        return List.of();
    }

    public void cadastrarConta(Conta conta){
        String sql = "INSERT INTO T_CONTAS(ID_CONTA, ID_USUARIO, SALDO)" +
                "VALUES (SQ_T_CONTAS.NEXTVAL, ?, ?)";

        try{
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, conta.getIdUsuario());
            stmt.setDouble(2, conta.getSaldo());
            stmt.executeUpdate();
            System.out.println("Conta cadastrado com sucesso");

        }catch (SQLException e){
            System.err.println("Erro de SQL: " + e.getMessage());
        }
    }

    public  void fecharConexao(){
        try{
            conexao.close();
        }catch (SQLException e){
            System.err.println("Erro de SQL: " + e.getMessage());
        }
    }
}
