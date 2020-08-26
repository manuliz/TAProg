package edu.usal.Util;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class propertiesUtil {
	
public static Properties properties = obtenerProperties();
	
	private static Properties obtenerProperties() {
		properties = new Properties();
		try {
//			properties.load(new FileReader("config.properties"));
			properties.load(ClassLoader.getSystemResourceAsStream("config.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return properties;
	}
	
	public static String obtenerDirecArchivos() {
		return properties.getProperty("direcArchivos");
	}
	
	public static String obtenerNomArchCliente() {
		return properties.getProperty("nomArchCliente");
	}
	
	public static String obtenerNomArchVuelos() {
		return properties.getProperty("nomArchVuelos");
	}
	
	public static  String obtenerNomLineasAereas() {
		return properties.getProperty("nomArchLineasAereas");
	}
	
	public static String obtenerNomArchPais() {
		return properties.getProperty("nomArchPais");
	}
	
	public static String obtenerNomArchAerolineas() {
		return properties.getProperty("nomArchAerolineas");
	}
	
	public static String obtenerNomArchAlianzas() {
		return properties.getProperty("nomArchAlianzas");
	}
	
	public static String obtenerNomArchProvincias() {
		return properties.getProperty("nomArchProvincias");
	}
	
	public static String obtenerNomArchAeropuerto() {
		return properties.getProperty("nomArchAeropuerto");
	}
	
	public static String obtenerNomArchVentas() {
		return properties.getProperty("nomArchVentas");
	}
	
	public static String obtenerDriver() {
		return properties.getProperty("DRIVER");
	}
	
	public static String obtenerURL() {
		return properties.getProperty("URL");
	}
	
	public static String obtenerUsu() {
		return properties.getProperty("USER");
	}
	
	public static String obtenerCon() {
		return properties.getProperty("PASSWORD");
	}
}
