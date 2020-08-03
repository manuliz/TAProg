package edu.usal.Util;

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
	
	public String obtenerDirecArchivos() {
		return properties.getProperty("direcArchivos");
	}
	
	public String obtenerNomArchCliente() {
		return properties.getProperty("nomArchCliente");
	}
	
	public String obtenerNomArchVuelos() {
		return properties.getProperty("nomArchVuelos");
	}
	
	public String obtenerNomLineasAereas() {
		return properties.getProperty("nomArchLineasAereas");
	}
	
	public String obtenerNomArchPais() {
		return properties.getProperty("nomArchPais");
	}
	
	public String obtenerNomArchAerolineas() {
		return properties.getProperty("nomArchAerolineas");
	}
	
	public String obtenerNomArchAlianzas() {
		return properties.getProperty("nomArchAlianzas");
	}
	
	public String obtenerNomArchProvincias() {
		return properties.getProperty("nomArchProvincias");
	}
}
