package app.model;

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
}
