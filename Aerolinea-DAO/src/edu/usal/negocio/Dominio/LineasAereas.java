package edu.usal.negocio.Dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class LineasAereas implements Serializable{
	
	private static final long serialVersionUID = 1L;
	Alianzas alianzas;
	private int idLineasAereas;
	private String nombreAerolinea;
	private ArrayList<Vuelos> lv;
	
	public LineasAereas() {
		
	}
	
	public LineasAereas(Alianzas alianzas, int idLineasAereas, String nombreAerolinea, ArrayList<Vuelos> lv) {
		super();
		this.alianzas = alianzas;
		this.idLineasAereas = idLineasAereas;
		this.nombreAerolinea = nombreAerolinea;
		this.lv = lv;
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

	public ArrayList<Vuelos> getLv() {
		return lv;
	}

	public void setLv(ArrayList<Vuelos> lv) {
		this.lv = lv;
	}

	@Override
	public String toString() {
		return "LineasAereas [alianzas=" + alianzas + ", idLineasAereas=" + idLineasAereas + ", nombreAerolinea="
				+ nombreAerolinea + ", Vuelos=" + lv + "]";
	}

	

}
