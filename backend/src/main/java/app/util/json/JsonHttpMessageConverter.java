package app.util.json;

import java.io.IOException;
import java.io.OutputStream;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import com.fasterxml.jackson.databind.ObjectMapper;

import flexjson.JSONSerializer;

/**
 * Classe responsável por serializar json na resposta http quando um método
 * de controller retornar uma instância da classe Json.
 */
public class JsonHttpMessageConverter extends AbstractHttpMessageConverter<Json> {

	private final ObjectMapper defaultObjectMapper;


	public JsonHttpMessageConverter(ObjectMapper defaultObjectMapper) {
		
		// Configurando o MimeType das requests que serão tratadas por este converter.
		super(new MediaType(MediaType.APPLICATION_JSON.getType(), MediaType.APPLICATION_JSON.getSubtype()));
		
		// Object mapper padrão (jackson) a ser utilizado quando não houver um serializador
		// específico configurado.
		this.defaultObjectMapper = defaultObjectMapper;
	}
	

	@Override
	protected boolean supports(Class<?> clazz) {

		// Configura para que métodos de controllers que retornem uma instância da
		// classe Json tenham o conteúdo de sua response tratada por este converter.
		return Json.class.isAssignableFrom(clazz);
	}

	@Override
	protected Json readInternal(Class<? extends Json> clazz, HttpInputMessage inputMessage)
			throws IOException, HttpMessageNotReadableException {

		// Retornando sempre nulo pois para a leitura de dados da requisição é
		// utilizado o converter padrâo (jackson).
		return null;
	}

	@Override
	protected void writeInternal(Json json, HttpOutputMessage outputMessage)
			throws IOException, HttpMessageNotWritableException {
		
		OutputStream outputStream = outputMessage.getBody();
		JSONSerializer jsonSerializer = json.getJsonSerializer();
		Object object = json.getData();

		if (jsonSerializer != null) {

			outputStream.write(jsonSerializer.serialize(object).getBytes())		;

		} else {
			this.defaultObjectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
			this.defaultObjectMapper.writeValue(outputStream, object);
		}

		outputStream.close();
	}
}
