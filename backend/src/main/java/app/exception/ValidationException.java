package app.exception;

import java.util.Collections;
import java.util.Set;

import javax.validation.ConstraintViolation;

import app.util.Mensagem;

public class ValidationException extends AppException {

	private static final long serialVersionUID = -47332445987710531L;
	
	private Set<ConstraintViolation<?>> errors;
	
	public ValidationException(Mensagem mensagem, Object... args) {
		
		super(mensagem, args);
	}

	
	public <T> ValidationException(Set<ConstraintViolation<T>> errors) {
		
		super(Mensagem.ERRO_VALIDACAO_PADRAO);
		this.errors = Collections.unmodifiableSet(errors);
	}


	public Set<ConstraintViolation<?>> getErrors() {
		return errors;
	}
}
