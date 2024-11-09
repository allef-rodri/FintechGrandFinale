package br.com.fiap.fintech.fintechgrandfinale.dao;


import br.com.fiap.fintech.fintechgrandfinale.exception.NenhumRegistroEncontradoException;
import br.com.fiap.fintech.fintechgrandfinale.factory.ConnectionFactory;
import br.com.fiap.fintech.fintechgrandfinale.model.Categoria;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDao {
    private Connection conexao;
    PreparedStatement stmt = null;

    public CategoriaDao() throws SQLException {
        conexao = ConnectionFactory.getConnection();
    }

    public List<Categoria> getAll() throws NenhumRegistroEncontradoException {
        String sql = "select * from t_categorias";
        List<Categoria> categorias = new ArrayList<Categoria>();

        try {
            stmt = conexao.prepareStatement(sql);
            ResultSet result = stmt.executeQuery();

            while (result.next()){
                Categoria categoria = new Categoria();
                categoria.setIdCategoria(result.getInt("ID_CATEGORIA"));
                categoria.setDsCategoria(result.getString("DS_CATEGORIA"));
                categorias.add(categoria);
            }

            if(categorias.isEmpty()){
                throw new NenhumRegistroEncontradoException("Nenhum registro encontrado.");
            }

            return categorias;
        }catch (SQLException e){
            System.err.println("Erro de SQL: " + e.getMessage());
        }
        return List.of();
    }

    public void cadastrarCategoria(Categoria categoria){
        String sql = "INSERT INTO T_CATEGORIAS(ID_CATEGORIA, DS_CATEGORIA)" +
                "VALUES (SQ_T_CATEGORIAS.NEXTVAL, ?)";

        try{
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, categoria.getDsCategoria());
            stmt.executeUpdate();
            System.out.println("Categoria cadastrado com sucesso");

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
