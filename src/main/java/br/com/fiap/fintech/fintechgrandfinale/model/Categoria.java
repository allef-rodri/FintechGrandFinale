package br.com.fiap.fintech.fintechgrandfinale.model;


public class Categoria {
    private int idCategoria;
    private String dsCategoria;

    public Categoria(){}

    public Categoria(int idCategoria, String dsCategoria){
        this.idCategoria = idCategoria;
        this.dsCategoria = dsCategoria;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getDsCategoria() {
        return dsCategoria;
    }

    public void setDsCategoria(String dsCategoria) {
        this.dsCategoria = dsCategoria;
    }
}
