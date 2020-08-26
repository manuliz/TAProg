package edu.usal.negocio.Dominio;

import java.io.Serializable;

public class Aeropuerto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int idAeropuerto;
	private String ciudad;
	private String identificacionAeropuerto;
	Pais pais;
	Provincia provincia;
	
	public Aeropuerto() {
		
	}
	
	public Aeropuerto(int idAeropuerto, String ciudad, String identificacionAeropuerto, Pais pais, Provincia provincia) {
		super();
		this.idAeropuerto = idAeropuerto;
		this.ciudad = ciudad;
		this.identificacionAeropuerto = identificacionAeropuerto;
		this.pais = pais;
		this.provincia = provincia;
	}

	public int getIdAeropuerto() {
		return idAeropuerto;
	}

	public void setIdAeropuerto(int idCiudad) {
		this.idAeropuerto = idCiudad;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getIdentificacionAeropuerto() {
		return identificacionAeropuerto;
	}

	public void setIdentificacionAeropuerto(String identificacionAeropuerto) {
		this.identificacionAeropuerto = identificacionAeropuerto;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public Provincia getProvincia() {
		return provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}

	@Override
	public String toString() {
		return "Aeropuerto [idCiudad=" + idAeropuerto + ", ciudad=" + ciudad + ", identificacionAeropuerto="
				+ identificacionAeropuerto + ", pais=" + pais + ", provincia=" + provincia + "]";
	}

}
