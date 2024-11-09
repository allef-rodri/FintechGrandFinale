package br.com.fiap.fintech.fintechgrandfinale.model;

public class TipoTransacao {
    private int idTipoTransacao;
    private String dsTipoTransacao;

    public TipoTransacao(){}

    public TipoTransacao(int idTipoTransacao, String dsTipoTransacao) {
        this.idTipoTransacao = idTipoTransacao;
        this.dsTipoTransacao = dsTipoTransacao;
    }

    public int getIdTipoTransacao() {
        return idTipoTransacao;
    }

    public void setIdTipoTransacao(int idTipoTransacao) {
        this.idTipoTransacao = idTipoTransacao;
    }

    public String getDsTipoTransacao() {
        return dsTipoTransacao;
    }

    public void setDsTipoTransacao(String dsTipoTransacao) {
        this.dsTipoTransacao = dsTipoTransacao;
    }
}
