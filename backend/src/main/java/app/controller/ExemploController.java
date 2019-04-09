package app.controller;

import app.serializer.ExemploSerializer;
import app.service.ExemploService;
import app.util.Mensagem;
import app.util.json.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
public class ExemploController {

//	@Autowired
//	private ExemploRepository exemplosRepository;
//
//	@Autowired
//	private ExemploService exemplosService;
//
//	@Autowired
//	private ExemploSerializer serializer;
//
//
//	@GetMapping("/exemplos")
//	public Json findAll() {
//
//		List<Exemplo> exemplos = exemplosRepository.findAll();
//
//		return new Json(exemplos, serializer.findAll);
//	}
//
//	@GetMapping("/exemplos/{id}")
//	public Json findById(@PathVariable Long id) {
//
//		Exemplo exemplo = exemplosRepository.findById(id).get();
//
//		return new Json(exemplo, serializer.findById);
//	}
//
//	@PostMapping("/exemplos")
//	public Json create(@RequestBody Exemplo exemplo) {
//
//		exemplosService.create(exemplo);
//
//		return new Json(Mensagem.SUCESSO_PADRAO);
//	}
//
//	@PutMapping("/exemplos/{id}")
//	public Json update(@RequestBody Exemplo exemploAtualizado, @PathVariable Long id) {
//
//		exemplosService.update(id, exemploAtualizado);
//
//		return new Json(Mensagem.SUCESSO_PADRAO);
//	}
//
//	@DeleteMapping("/exemplos/{id}")
//	public Json delete(@PathVariable Long id) {
//
//		exemplosService.delete(id);
//
//		return new Json(Mensagem.SUCESSO_PADRAO);
//	}
//
//	// Exemplo para verificação de permissão
//	@PutMapping("/exemplos/admin/{id}")
//	@RolesAllowed("PERFIL_ADMIN")
//	public Json updateAsAdmin(@RequestBody Exemplo exemploAtualizado, @PathVariable Long id) {
//
//		exemplosService.update(id, exemploAtualizado);
//
//		return new Json(Mensagem.SUCESSO_PADRAO);
//	}
}
