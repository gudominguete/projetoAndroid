package app.exception;

import app.util.Mensagem;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class AppException extends RuntimeException {

	private static final long serialVersionUID = 4657491283614755649L;

	public AppException(Mensagem mensagem, Object... args) {
		
		super(mensagem.getTexto(args));
	}

	public AppException(String mensagem, Throwable causa) {
		
		super(mensagem, causa);
	}

}
