package app.util.json;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.vividsolutions.jts.geom.Geometry;

import app.Config;
import flexjson.JSONSerializer;
import flexjson.transformer.DateTransformer;

public class JsonUtil {
	
	
	public static JSONSerializer createSerializer(String ... includes) {
		
		return new JSONSerializer()
			.include(includes)
			.exclude("*")
			.prettyPrint(false)
			.transform(new DateTransformer(Config.get().dateFormat), Date.class);
	}
	
	
	public static ObjectMapper createObjectMapper() {
		
		ObjectMapper mapper = new ObjectMapper();
		SimpleModule simpleModule = new SimpleModule();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		mapper.registerModule(simpleModule);
		mapper.registerModule(new Jdk8Module());
		
		mapper.setDateFormat(new SimpleDateFormat(Config.get().dateFormat));
		
		return mapper;
	}
}
