package app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
@PropertySource("classpath:application.properties")
public class Config {

	public static final String SCHEMA_PUBLIC = "public";
	public static final String SCHEMA_USUARIOS = "usuarios";
	
	private static Config instance;
	
	private Environment env;
	
	public final String dateFormat;
	
	@Autowired
	public Config(Environment env) {

		this.env = env;
		
		// Carregando configurações.
		dateFormat = getConfig("date.format");
		
		if (instance != null)
			return;
		
		instance = this;
	}
	
	private String getConfig(String key) {
		
		return this.env.getProperty(key);
	}
	
	private int getIntConfig(String key, int defaultValue) {
		
		String config = getConfig(key);
		
		return config != null ? Integer.parseInt(config) : defaultValue;
	}

	public static Config get() {
		
		return instance;
	}
	
}