package br.com.fiap.fintech.fintechgrandfinale.dao;

import br.com.fiap.fintech.fintechgrandfinale.exception.NenhumRegistroEncontradoException;
import br.com.fiap.fintech.fintechgrandfinale.factory.ConnectionFactory;
import br.com.fiap.fintech.fintechgrandfinale.model.TipoTransacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TipoTransacaoDao {
    private Connection conexao;
    PreparedStatement stmt = null;

    public TipoTransacaoDao() throws SQLException {
        conexao = ConnectionFactory.getConnection();
    }

    public List<TipoTransacao> getAll() throws NenhumRegistroEncontradoException {
        String sql = "select * from t_tipo_transacao";
        List<TipoTransacao> tipoTransacaos = new ArrayList<TipoTransacao>();

        try {
            stmt = conexao.prepareStatement(sql);
            ResultSet result = stmt.executeQuery();

            while (result.next()){
                TipoTransacao tipoTransacao = new TipoTransacao();
                tipoTransacao.setIdTipoTransacao(result.getInt("ID_TIPO_TRANSACAO"));
                tipoTransacao.setDsTipoTransacao(result.getString("DS_TIPO_TRANSACAO"));
                tipoTransacaos.add(tipoTransacao);
            }

            if(tipoTransacaos.isEmpty()){
                throw new NenhumRegistroEncontradoException("Nenhum registro encontrado.");
            }

            return tipoTransacaos;
        }catch (SQLException e){
            System.err.println("Erro de SQL: " + e.getMessage());
        }
        return List.of();
    }

    public void cadastrarTipoTransacao(TipoTransacao tipoTransacao){
        String sql = "INSERT INTO T_TIPO_TRANSACAO(ID_TIPO_TRANSACAO, DS_TIPO_TRANSACAO)" +
                "VALUES (SQ_T_TIPO_TRANSACAO.NEXTVAL, ?)";

        try{
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, tipoTransacao.getDsTipoTransacao());
            stmt.executeUpdate();
            System.out.println("Tipo Transação cadastrado com sucesso");

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
