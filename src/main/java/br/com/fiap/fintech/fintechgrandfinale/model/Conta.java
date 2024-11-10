package br.com.fiap.fintech.fintechgrandfinale.model;

public class Conta {
    private int idConta;
    private int idUsuario;
    private double saldo;

    public Conta(){}

    public Conta(int idConta, int idUsuario, double saldo){
        this.idConta = idConta;
        this.idUsuario = idUsuario;
        this.saldo = saldo;
    }

    public Conta(int idUsuario){
        this.idUsuario = idUsuario;
        this.saldo = 0;
    }

    public int getIdConta() {
        return idConta;
    }

    public void setIdConta(int idConta) {
        this.idConta = idConta;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
