package edu.usal.negocio.Dominio;

import java.io.Serializable;

public class PasajeroFrecuente implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int idPasajeroFrecuente;
	private String numero;
	private String categoria;
	LineasAereas aerolinea;
	Alianzas alianzas;
	
	public PasajeroFrecuente(int idPasajeroFrecuente, String numero, String categoria, LineasAereas aerolinea,
			Alianzas alianzas) {
		super();
		this.idPasajeroFrecuente = idPasajeroFrecuente;
		this.numero = numero;
		this.categoria = categoria;
		this.aerolinea = aerolinea;
		this.alianzas = alianzas;
	}

	public PasajeroFrecuente() {
		super();
	}


	public int getIdPasajeroFrecuente() {
		return idPasajeroFrecuente;
	}

	public void setIdPasajeroFrecuente(int idPasajeroFrecuente) {
		this.idPasajeroFrecuente = idPasajeroFrecuente;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public LineasAereas getAerolinea() {
		return aerolinea;
	}

	public void setAerolinea(LineasAereas aerolinea) {
		this.aerolinea = aerolinea;
	}

	public Alianzas getAlianzas() {
		return alianzas;
	}

	public void setAlianzas(Alianzas alianzas) {
		this.alianzas = alianzas;
	}

	@Override
	public String toString() {
		return "PasajeroFrecuente [idPasajeroFrecuente=" + idPasajeroFrecuente + ", numero=" + numero + ", categoria="
				+ categoria + ", aerolinea=" + aerolinea + ", alianzas=" + alianzas + "]";
	}

}
