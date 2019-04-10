package com.login.gustavo.myapplication.model;

import java.io.Serializable;

public class Usuario implements Serializable {

    private Long id;

    private String login;

    private String senha;

    public Usuario() {

    }

    public Usuario(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }
}
