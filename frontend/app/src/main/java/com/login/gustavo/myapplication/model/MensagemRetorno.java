package com.login.gustavo.myapplication.model;

import java.io.Serializable;

public class MensagemRetorno implements Serializable {

    private boolean sucesso;
    private String mensagemErro;

    public MensagemRetorno() {
    }

    public MensagemRetorno(boolean sucesso, String mensagemErro) {
        this.sucesso = sucesso;
        this.mensagemErro = mensagemErro;
    }

    public boolean isSucesso() {
        return sucesso;
    }

    public void setSucesso(boolean sucesso) {
        this.sucesso = sucesso;
    }

    public String getMensagemErro() {
        return mensagemErro;
    }

    public void setMensagemErro(String mensagemErro) {
        this.mensagemErro = mensagemErro;
    }
}
