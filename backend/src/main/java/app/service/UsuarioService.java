package app.service;

import app.model.Usuario;
import app.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

    public Usuario salvarUsuario(String usuario, String senha) {
        Usuario usuarioModel = usuarioRepository.findByLogin(usuario);
        if(usuarioModel == null) {
            usuarioModel = new Usuario(usuario,senha);
        }

        return usuarioRepository.save(usuarioModel);
	}

	public Usuario autenticar(String usuario, String senha){
        return usuarioRepository.findByLoginAndSenha(usuario, senha);
    }

}
