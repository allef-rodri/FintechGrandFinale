package br.com.fiap.fintech.fintechgrandfinale.dao;

import br.com.fiap.fintech.fintechgrandfinale.exception.NenhumRegistroEncontradoException;
import br.com.fiap.fintech.fintechgrandfinale.factory.ConnectionFactory;
import br.com.fiap.fintech.fintechgrandfinale.model.Conta;
import br.com.fiap.fintech.fintechgrandfinale.model.Transacao;
import br.com.fiap.fintech.fintechgrandfinale.model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDao {
    private Connection conexao;
    PreparedStatement stmt = null;

    public UsuarioDao() throws SQLException {
        conexao = ConnectionFactory.getConnection();
    }

    public List<Usuario>getAll()throws NenhumRegistroEncontradoException {
        String sql = "select * from T_USUARIOS order by DT_CADASTRO desc";
        List<Usuario> usuarios = new ArrayList<Usuario>();

        try{
            stmt = conexao.prepareStatement(sql);
            ResultSet result = stmt.executeQuery();

            while (result.next()) {
                Usuario usuario = new Usuario();
                usuario.setId_usuario(result.getInt("ID_USUARIO"));
                usuario.setNome(result.getString("NOME"));
                usuario.setEmail(result.getString("EMAIL"));
                usuario.setLogin(result.getString("LOGIN"));
                usuario.setSenha(result.getString("SENHA"));
                usuario.setDt_cadastro(result.getDate("DT_CADASTRO"));
                usuario.setAtivo(result.getInt("ATIVO"));
                usuarios.add(usuario);
            }

            if (usuarios.isEmpty()) {
                throw new NenhumRegistroEncontradoException("Nenhum registro encontrado");
            }
            return usuarios;
        }catch (SQLException e){
            System.err.println("Erro de SQL: " + e.getMessage());
        }
        return List.of();
    }

    public Usuario login(String email, String senha){
        String sql = "select * from T_USUARIOS where email = ? and senha = ? and  ROWNUM = 1";
        Usuario usuario = new Usuario();

        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.setString(2, senha);
            ResultSet result = stmt.executeQuery();

            while (result.next()) {
                usuario.setId_usuario(result.getInt("ID_USUARIO"));
                usuario.setNome(result.getString("NOME"));
                usuario.setEmail(result.getString("EMAIL"));
                usuario.setLogin(result.getString("LOGIN"));
                usuario.setSenha(result.getString("SENHA"));
                usuario.setDt_cadastro(result.getDate("DT_CADASTRO"));
                usuario.setAtivo(result.getInt("ATIVO"));
            }
            return usuario;
        }catch (SQLException e){
            System.err.println("Erro de SQL: " + e.getMessage());
        }
        return usuario;
    }

    public void cadastrarUsuario(Usuario usuario) {
        String sql = "INSERT INTO T_USUARIOS " +
                "(ID_USUARIO, NOME, EMAIL, LOGIN, SENHA, DT_CADASTRO, ATIVO)" +
                "VALUES (SQ_T_USUARIOS.NEXTVAL, ?, ? , ?, ?, ?, 1)";

        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getLogin());
            stmt.setString(4, usuario.getSenha());
            stmt.setDate(5, new java.sql.Date(usuario.getDt_cadastro().getTime()));
            stmt.executeUpdate();

           Usuario usuarioCreated = this.getIdUsuarioPorEmail(usuario.getEmail());

            ContaDao contaDao = new ContaDao();
            Conta conta = new Conta(usuarioCreated.getId_usuario());
            contaDao.cadastrarConta(conta);

            System.out.println("Usuario cadastrado com sucesso");
        }catch (SQLException e){
            System.err.println("Erro de SQL: " + e.getMessage());
        }
    }

    public Usuario getIdUsuarioPorEmail(String email){
        String sql = "select * from T_USUARIOS where email = ? and  ROWNUM = 1";
        Usuario usuario = null;
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, email);
            ResultSet result = stmt.executeQuery();

            while (result.next()) {

                int id = result.getInt("ID_USUARIO");
                String nome = result.getString("NOME");
                String emailDB = result.getString("EMAIL");
                String login = result.getString("LOGIN");

                usuario = new Usuario(id, nome, emailDB, login);
            }
            return usuario;
        }catch (SQLException e){
            System.err.println("Erro de SQL: " + e.getMessage());
        }
        return usuario;
    }

    public void fecharConexao() {
        try {
            conexao.close();
        }catch (SQLException e){
            System.err.println("Erro de SQL: " + e.getMessage());
        }
    }
}
