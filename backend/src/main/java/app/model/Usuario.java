package app.model;

import app.Config;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(schema = Config.SCHEMA_USUARIOS, name = "usuario")
public class Usuario implements Serializable {


    @Id
    @GeneratedValue
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
