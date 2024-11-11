package br.com.fiap.fintech.fintechgrandfinale.view.categoria;

import br.com.fiap.fintech.fintechgrandfinale.dao.CategoriaDao;
import br.com.fiap.fintech.fintechgrandfinale.model.Categoria;

import java.sql.SQLException;

public class CadastroCategoriaView {

    public static void main (String[] args){
        try{
            CategoriaDao categoriaDao = new CategoriaDao();

            Categoria categoriaRecebimentoSalario = new Categoria();
            categoriaRecebimentoSalario.setDsCategoria("Transação default");
            categoriaDao.cadastrarCategoria(categoriaRecebimentoSalario);


            categoriaDao.fecharConexao();
        }catch (SQLException e){
            System.err.println("Erro de SQL: " + e.getMessage());
        }
    }
}
