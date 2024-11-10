package br.com.fiap.fintech.fintechgrandfinale.dao;

import br.com.fiap.fintech.fintechgrandfinale.exception.NenhumRegistroEncontradoException;
import br.com.fiap.fintech.fintechgrandfinale.factory.ConnectionFactory;
import br.com.fiap.fintech.fintechgrandfinale.model.Transacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TransacaoDao {
    private Connection conexao;
    PreparedStatement stmt = null;

    public TransacaoDao() throws SQLException {
        conexao = ConnectionFactory.getConnection();
    }

    public List<Transacao> getAll() throws NenhumRegistroEncontradoException {
        String sql = "select * from t_transacoes order by DT_REGISTRO desc";
        List<Transacao> transacoes = new ArrayList<Transacao>();

        try{
            stmt = conexao.prepareStatement(sql);
            ResultSet result = stmt.executeQuery();

            while (result.next()) {
                Transacao transacao = new Transacao();
                transacao.setIdTransacao(result.getInt("ID_TRANSACAO"));
                transacao.setIdUsuario(result.getInt("ID_USUARIO"));
                transacao.setIdTipoTranasacao(result.getInt("ID_TIPO_TRANSACAO"));
                transacao.setIdCategoria(result.getInt("ID_CATEGORIA"));
                transacao.setDsTransacao(result.getString("DS_TRANSACAO"));
                transacao.setValor(result.getDouble("VALOR"));
                transacao.setDtRegistro(result.getDate("DT_REGISTRO"));
                transacao.setIdConta(result.getInt("ID_CONTA"));
                transacoes.add(transacao);
            }

            if (transacoes.isEmpty()) {
                throw new NenhumRegistroEncontradoException("Nenhum registro encontrado");
            }
            return transacoes;
        }catch (SQLException e){
            System.err.println("Erro de SQL: " + e.getMessage());
        }
        return List.of();
    }

    public List<Transacao> getTransacoesPorUsuario(int usuarioId) {
        String sql = "select * from t_transacoes where id_usuario = ? order by DT_REGISTRO desc";
        List<Transacao> transacoes = new ArrayList<Transacao>();

        try{
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, usuarioId);
            ResultSet result = stmt.executeQuery();

            while (result.next()) {
                Transacao transacao = new Transacao();
                transacao.setIdTransacao(result.getInt("ID_TRANSACAO"));
                transacao.setIdUsuario(result.getInt("ID_USUARIO"));
                transacao.setIdTipoTranasacao(result.getInt("ID_TIPO_TRANSACAO"));
                transacao.setIdCategoria(result.getInt("ID_CATEGORIA"));
                transacao.setDsTransacao(result.getString("DS_TRANSACAO"));
                transacao.setValor(result.getDouble("VALOR"));
                transacao.setDtRegistro(result.getDate("DT_REGISTRO"));
                transacao.setIdConta(result.getInt("ID_CONTA"));
                transacoes.add(transacao);
            }
            return transacoes;
        }catch (SQLException e){
            System.err.println("Erro de SQL: " + e.getMessage());
        }
        return List.of();
    }

    public void cadastrarTransacao(Transacao transacao) {
        String sql = "INSERT INTO T_TRANSACOES " +
                "(ID_TRANSACAO, ID_USUARIO, ID_TIPO_TRANSACAO, ID_CATEGORIA, DS_TRANSACAO, VALOR, DT_REGISTRO, ID_CONTA)" +
                "VALUES (SQ_T_TRANSACOES.NEXTVAL, ?, ? , ?, ?, ?, ?, ?)";

        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, transacao.getIdUsuario());
            stmt.setInt(2, transacao.getIdTipoTranasacao());
            stmt.setInt(3, transacao.getIdCategoria());
            stmt.setString(4, transacao.getDsTransacao());
            stmt.setDouble(5, transacao.getValor());
            stmt.setDate(6, new java.sql.Date(transacao.getDtRegistro().getTime()));
            stmt.setInt(7, transacao.getIdConta());
            stmt.executeUpdate();

            System.out.println("Transação cadastrado com sucesso");
        }catch (SQLException e){
            System.err.println("Erro de SQL: " + e.getMessage());
        }
    }

    public void fecharConexao() {
        try {
            conexao.close();
        }catch (SQLException e){
            System.err.println("Erro de SQL: " + e.getMessage());
        }
    }
}
