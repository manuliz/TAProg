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
	
	public String obtenerDirecCliente() {
		return properties.getProperty("direcCliente");
	}
	
	public String obtenerNomArchCliente() {
		return properties.getProperty("nomArchCliente");
	}
	
	public String obtenerDirecVuelos() {
		return properties.getProperty("direcVuelos");
	}
	
	public String obtenerNomArchVuelos() {
		return properties.getProperty("nomArchVuelos");
	}
	
	public String obtenerDirecLineasAereas() {
		return properties.getProperty("direcLineasAereas");
	}
	
	public String obtenerNomLineasAereas() {
		return properties.getProperty("nomArchLineasAereas");
	}
	
	public String obtenerDirecPais() {
		return properties.getProperty("direcPais");
	}
	
	public String obtenerNomArchPais() {
		return properties.getProperty("nomArchPais");
	}
	
	public String obtenerDirecAerolineas() {
		return properties.getProperty("direcAerolineas");
	}
	
	public String obtenerNomArchAerolineas() {
		return properties.getProperty("nomArchAerolineas");
	}
	
	public String obtenerDirecAlianzas() {
		return properties.getProperty("direcAlianzas");
	}
	
	public String obtenerNomArchAlianzas() {
		return properties.getProperty("nomArchAlianzas");
	}
	
	public String obtenerDirecProvincias() {
		return properties.getProperty("direcProvincias");
	}
	
	public String obtenerNomArchProvincias() {
		return properties.getProperty("nomArchProvincias");
	}
}
