package br.com.fiap.fintech.fintechgrandfinale.model;

import java.util.Date;

public class Usuario {
    private int id_usuario;
    private String nome;
    private String email;
    private String login;
    private String senha;
    private Date dt_cadastro;
    private int ativo;

    public Usuario() {
    }

    public Usuario(int id_usuario, String nome, String email, String login) {
        this.id_usuario = id_usuario;
        this.nome = nome;
        this.email = email;
        this.login = login;
    }

    public Usuario(String nome, String email, String login, String senha) {
        this.nome = nome;
        this.email = email;
        this.login = login;
        this.senha = senha;
        this.dt_cadastro = new Date();
        this.ativo = 1;
    }

    public Usuario(int id_usuario, String nome, String email, String login, String senha, Date dt_cadastro, int ativo) {
        this.id_usuario = id_usuario;
        this.nome = nome;
        this.email = email;
        this.login = login;
        this.senha = senha;
        this.dt_cadastro = dt_cadastro;
        this.ativo = ativo;
    }

    public Integer getId_usuario() {
        return  id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Date getDt_cadastro() {
        return dt_cadastro;
    }

    public void setDt_cadastro(Date dt_cadastro) {
        this.dt_cadastro = dt_cadastro;
    }

    public int getAtivo() {
        return ativo;
    }

    public void setAtivo(int ativo) {
        this.ativo = ativo;
    }
}
