package br.com.fiap.fintech.fintechgrandfinale.view.categoria;

import br.com.fiap.fintech.fintechgrandfinale.dao.CategoriaDao;
import br.com.fiap.fintech.fintechgrandfinale.exception.NenhumRegistroEncontradoException;
import br.com.fiap.fintech.fintechgrandfinale.model.Categoria;

import java.sql.SQLException;
import java.util.List;


public class ListarCategoriaView {
    public static void main(String[] args){
        try{
            CategoriaDao categoriaDao = new CategoriaDao();
            List<Categoria> categorias = categoriaDao.getAll();

            for (Categoria categoria : categorias){
                System.out.println();
                System.out.println("ID: " + categoria.getIdCategoria());
                System.out.println("DESCRIÇÃO: " + categoria.getDsCategoria());
                System.out.println();
            }

            categoriaDao.fecharConexao();
        }catch(SQLException e) {
            System.err.println("Erro de SQL: " + e.getMessage());
        }catch(NenhumRegistroEncontradoException e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }
}
