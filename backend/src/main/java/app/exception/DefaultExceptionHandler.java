package app.exception;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import app.util.Mensagem;
import app.util.json.Json.JsonMensagem;

@ControllerAdvice
public class DefaultExceptionHandler extends ResponseEntityExceptionHandler{

	private Log logger = LogFactory.getLog(ExceptionHandler.class);

	@ExceptionHandler(value = {Exception.class})
	protected ResponseEntity<Object> handleConflict(Exception ex, WebRequest request) {

		logger.error(ex.getMessage(), ex);

		JsonMensagem json = new JsonMensagem();
		json.mensagem = Mensagem.ERRO_PADRAO.getTexto();
		
		return handleExceptionInternal(ex,
				json,
				new HttpHeaders(), 
				HttpStatus.INTERNAL_SERVER_ERROR, request);
	}
	
	@ExceptionHandler(value = {AppException.class})
	protected ResponseEntity<Object> handlerAppException(Exception ex, WebRequest request) {

		logger.error(ex.getMessage(), ex);

		JsonMensagem json = new JsonMensagem();
		json.mensagem = ex.getMessage();
		
		return handleExceptionInternal(ex,
				json,
				new HttpHeaders(), 
				HttpStatus.INTERNAL_SERVER_ERROR, request);
	}

}
