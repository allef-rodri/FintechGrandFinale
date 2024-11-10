package br.com.fiap.fintech.fintechgrandfinale.model;

import java.util.Date;

public class Transacao {
    private int idTransacao;
    private int idUsuario;
    private int idTipoTransacao;
    private int idCategoria;
    private String dsTransacao;
    private double valor;
    private Date dtRegistro;
    private int idConta;

    public Transacao() {
    }

    public Transacao(int idUsuario, int idTipoTransacao, String dsTransacao, double valor, int idConta) {
        this.idUsuario = idUsuario;
        this.idTipoTransacao = idTipoTransacao;
        this.idCategoria = 17;
        this.dsTransacao = dsTransacao;
        this.valor = valor;
        this.dtRegistro = new Date();
        this.idConta = idConta;
    }

    public Transacao(int idTransacao, int idUsuario, int idTipoTranasacao, int idCategoria, String dsTransacao, double valor, Date dtRegistro, int idConta) {
        this.idTransacao = idTransacao;
        this.idUsuario = idUsuario;
        this.idTipoTransacao = idTipoTranasacao;
        this.idCategoria = idCategoria;
        this.dsTransacao = dsTransacao;
        this.valor = valor;
        this.dtRegistro = dtRegistro;
        this.idConta = idConta;
    }

    public int getIdTransacao() {
        return idTransacao;
    }

    public void setIdTransacao(int idTransacao) {
        this.idTransacao = idTransacao;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdTipoTranasacao() {
        return idTipoTransacao;
    }

    public void setIdTipoTranasacao(int idTipoTranasacao) {
        this.idTipoTransacao = idTipoTranasacao;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getDsTransacao() {
        return dsTransacao;
    }

    public void setDsTransacao(String dsTransacao) {
        this.dsTransacao = dsTransacao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public java.sql.Date getDtRegistro() {
        return new java.sql.Date(dtRegistro.getTime());
    }

    public void setDtRegistro(Date dtRegistro) {
        this.dtRegistro = dtRegistro;
    }

    public int getIdConta() {
        return idConta;
    }

    public void setIdConta(int idConta) {
        this.idConta = idConta;
    }
}