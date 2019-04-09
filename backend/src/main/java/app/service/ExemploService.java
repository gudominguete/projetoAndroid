package app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.util.validation.ModelValidator;

@Service
public class ExemploService {

//	@Autowired
//	private ExemploRepository exemplosRepository;
//
//
//	public void create(Exemplo exemplo) {
//
//		ModelValidator.validate(exemplo);
//
//		exemplosRepository.save(exemplo);
//	}
//
//	public void update(Long id, Exemplo exemploAtualizado) {
//
//		Exemplo exemplo = exemplosRepository.findById(id).get();
//
//		exemplo.update(exemploAtualizado);
//
//		ModelValidator.validate(exemplo);
//
//		exemplosRepository.save(exemplo);
//	}
//
//	public void delete(Long id) {
//
//		Exemplo exemplo = exemplosRepository.findById(id).get();
//
//		exemplosRepository.delete(exemplo);
//	}
}
