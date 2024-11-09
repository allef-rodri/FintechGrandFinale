package br.com.fiap.fintech.fintechgrandfinale.view.categoria;

import br.com.fiap.fintech.fintechgrandfinale.dao.CategoriaDao;
import br.com.fiap.fintech.fintechgrandfinale.model.Categoria;

import java.sql.SQLException;

public class CadastroCategoriaView {

    public static void main (String[] args){
        try{
            CategoriaDao categoriaDao = new CategoriaDao();

            Categoria categoriaRecebimentoSalario = new Categoria();
            categoriaRecebimentoSalario.setDsCategoria("Recebimento de salário");
            categoriaDao.cadastrarCategoria(categoriaRecebimentoSalario);

            Categoria categoriaRecebimentoHoraExtra = new Categoria();
            categoriaRecebimentoHoraExtra.setDsCategoria("Recebimento de hora extra");
            categoriaDao.cadastrarCategoria(categoriaRecebimentoHoraExtra);

            Categoria categoriaRecebimentoDividendo = new Categoria();
            categoriaRecebimentoDividendo.setDsCategoria("Recebimento de dividendo");
            categoriaDao.cadastrarCategoria(categoriaRecebimentoDividendo);

            Categoria categoriaMensalidadeFaculdade = new Categoria();
            categoriaMensalidadeFaculdade.setDsCategoria("Mensalidade da faculdade");
            categoriaDao.cadastrarCategoria(categoriaMensalidadeFaculdade);

            Categoria categoriaPagamentoAluguel = new Categoria();
            categoriaPagamentoAluguel.setDsCategoria("Pagamento de Aluguel");
            categoriaDao.cadastrarCategoria(categoriaPagamentoAluguel);

            categoriaDao.fecharConexao();
        }catch (SQLException e){
            System.err.println("Erro de SQL: " + e.getMessage());
        }
    }
}
