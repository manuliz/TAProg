package edu.usal.negocio.Dominio;

import java.io.Serializable;

public class Pais implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int idPais;
	private String nombrePais;
	
	public Pais() {
		
	}
	
	public Pais(int idPais, String nombrePais) {
		super();
		this.idPais = idPais;
		this.nombrePais = nombrePais;
	}

	public int getIdPais() {
		return idPais;
	}

	public void setIdPais(int idPais) {
		this.idPais = idPais;
	}

	public String getNombrePais() {
		return nombrePais;
	}

	public void setNombrePais(String nombrePais) {
		this.nombrePais = nombrePais;
	}

	@Override
	public String toString() {
		return "Pais [idPais=" + idPais + ", nombrePais=" + nombrePais + "]";
	}

}
