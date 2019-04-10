package app.util.json;

import app.util.Mensagem;
import flexjson.JSONSerializer;
import lombok.Getter;

public class Json {

	private Object data;
	private JSONSerializer jsonSerializer;

	public Json(Object data) {

		this.data = data;
	}

	public Json(Object data, JSONSerializer jsonSerializer) {

		this.data = data;
		this.jsonSerializer = jsonSerializer;
	}
	
	public Json(Mensagem msg, Object data, JSONSerializer jsonSerializer) {
		
		JsonMensagem msgObj = new JsonMensagem();
		msgObj.mensagem = msg.getTexto();
		msgObj.dados = data;
		
		this.data = msgObj;
		this.jsonSerializer = jsonSerializer;		
	}
	
	public Json(Mensagem msg, Object data) {
		
		this(msg, data, null);	
	}

	public Json(Mensagem msg) {
		
		this(msg, null, null);	
	}

	public static class JsonMensagem {
		
		public String mensagem;
		public Object dados;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public JSONSerializer getJsonSerializer() {
		return jsonSerializer;
	}

	public void setJsonSerializer(JSONSerializer jsonSerializer) {
		this.jsonSerializer = jsonSerializer;
	}
}
