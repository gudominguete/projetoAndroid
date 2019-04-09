package app.serializer;

import org.springframework.stereotype.Component;

import app.util.json.JsonUtil;
import flexjson.JSONSerializer;

@Component
public class ExemploSerializer {

	public final JSONSerializer findAll = JsonUtil.createSerializer("id", "nome", "dataCadastro", "idade");
	
	public final JSONSerializer findById = JsonUtil.createSerializer("id", "nome", "dataCadastro", "idade");
}
