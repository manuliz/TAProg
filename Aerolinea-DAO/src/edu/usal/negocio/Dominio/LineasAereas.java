package edu.usal.negocio.Dominio;

import java.io.Serializable;

public class LineasAereas implements Serializable{
	
	private static final long serialVersionUID = 1L;
	Alianzas alianzas;
	private int idLineasAereas;
	private String nombreAerolinea;
	
	
	public LineasAereas() {
		
	}
	
	public LineasAereas(Alianzas alianzas, int idLineasAereas, String nombreAerolinea) {
		super();
		this.alianzas = alianzas;
		this.idLineasAereas = idLineasAereas;
		this.nombreAerolinea = nombreAerolinea;
		
	}

	public Alianzas getAlianzas() {
		return alianzas;
	}

	public void setAlianzas(Alianzas alianzas) {
		this.alianzas = alianzas;
	}

	public int getIdLineasAereas() {
		return idLineasAereas;
	}

	public void setIdLineasAereas(int idLineasAereas) {
		this.idLineasAereas = idLineasAereas;
	}

	public String getNombreAerolinea() {
		return nombreAerolinea;
	}

	public void setNombreAerolinea(String nombreAerolinea) {
		this.nombreAerolinea = nombreAerolinea;
	}

	@Override
	public String toString() {
		return "LineasAereas [alianzas=" + alianzas + ", idLineasAereas=" + idLineasAereas + ", nombreAerolinea="
				+ nombreAerolinea + "]";
	}

}
