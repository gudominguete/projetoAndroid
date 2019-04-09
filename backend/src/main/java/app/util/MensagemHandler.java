package app.util;

import java.util.Locale;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Component;

@Component
public class MensagemHandler {

	@Autowired
	private MessageSource messageSource;

	//TODO:. Extrair esses valores para o arquivo de configuração
	Locale ptBr = new Locale("pt", "BR");
	
	private static MessageSourceAccessor accessor;

	@PostConstruct
	private void init() {

		accessor = new MessageSourceAccessor(messageSource, ptBr);
	}

	public static String get(String code, Object... args) {

		return accessor.getMessage(code, args);
	}
}
