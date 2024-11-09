package br.com.fiap.fintech.fintechgrandfinale.view.tipoTransacao;

import br.com.fiap.fintech.fintechgrandfinale.model.TipoTransacao;
import br.com.fiap.fintech.fintechgrandfinale.dao.TipoTransacaoDao;
import java.sql.SQLException;

public class CadastroTipoTransacaoView {

    public static void main (String[] args){
        try{
            TipoTransacaoDao tipoTransacaoDao = new TipoTransacaoDao();

            TipoTransacao tipoTransacaoReceita = new TipoTransacao();
            tipoTransacaoReceita.setDsTipoTransacao("Receita");
            tipoTransacaoDao.cadastrarTipoTransacao(tipoTransacaoReceita);

            TipoTransacao tipoTransacaoPagamento = new TipoTransacao();
            tipoTransacaoPagamento.setDsTipoTransacao("Pagamento");
            tipoTransacaoDao.cadastrarTipoTransacao(tipoTransacaoPagamento);

            TipoTransacao tipoTransacaoInvestimento = new TipoTransacao();
            tipoTransacaoInvestimento.setDsTipoTransacao("Investimento");
            tipoTransacaoDao.cadastrarTipoTransacao(tipoTransacaoInvestimento);

            tipoTransacaoDao.fecharConexao();
        }catch (SQLException e){
            System.err.println("Erro de SQL: " + e.getMessage());
        }
    }
}
