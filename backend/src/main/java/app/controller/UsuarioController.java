package app.controller;

import app.model.MensagemRetorno;
import app.model.Usuario;
import app.service.UsuarioService;
import app.util.json.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {


	@Autowired
	private UsuarioService usuarioService;

    @PostMapping("/usuario/cadastro")
    public Json cadastro(String usuario, String senha) {

        Usuario user = usuarioService.salvarUsuario(usuario, senha);
        MensagemRetorno mensagemRetorno;
        if(user == null) {
            mensagemRetorno = new MensagemRetorno(false, "Serviço indisponível no momento. Tente novamente mais tarde.");
            return new Json(mensagemRetorno);
        }
        mensagemRetorno = new MensagemRetorno(true, null);
        
        return new Json(mensagemRetorno);
    }


    @PostMapping("/usuario/autenticar")
    public Json autenticar(String usuario, String senha) {
        System.out.println(usuario);
        Usuario user = usuarioService.autenticar(usuario, senha);
        MensagemRetorno mensagemRetorno;
        if(user == null) {
            mensagemRetorno = new MensagemRetorno(false, "Serviço indisponível no momento. Tente novamente mais tarde.");
            return new Json(mensagemRetorno);
        }
        mensagemRetorno = new MensagemRetorno(true, null);

        return new Json(mensagemRetorno);
    }
}
