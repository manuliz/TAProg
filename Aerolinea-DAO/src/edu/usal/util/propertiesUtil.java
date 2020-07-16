package edu.usal.util;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class propertiesUtil {
	
	public Properties properties = obtenerProperties();
	
	private Properties obtenerProperties() {
		properties = new Properties();
		try {
			properties.load(new FileReader("config.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return properties;
	}
	
	public String obtenerDirecCliente() {
		return properties.getProperty("direcCliente");
	}
	
	public String obtenerNomArchCliente() {
		return properties.getProperty("nomArchCliente");
	}

}
