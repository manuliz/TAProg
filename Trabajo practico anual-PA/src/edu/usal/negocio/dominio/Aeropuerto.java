package edu.usal.negocio.dominio;

public class Aeropuerto {
	
	private int idCiudad;
	private String ciudad;
	private String identificacionAeropuerto;
	Pais pais;
	Provincia provincia;
	
	public Aeropuerto(int idCiudad, String ciudad, String identificacionAeropuerto, Pais pais, Provincia provincia) {
		super();
		this.idCiudad = idCiudad;
		this.ciudad = ciudad;
		this.identificacionAeropuerto = identificacionAeropuerto;
		this.pais = pais;
		this.provincia = provincia;
	}

	public int getIdCiudad() {
		return idCiudad;
	}

	public void setIdCiudad(int idCiudad) {
		this.idCiudad = idCiudad;
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
		return "Aeropuerto [idCiudad=" + idCiudad + ", ciudad=" + ciudad + ", identificacionAeropuerto="
				+ identificacionAeropuerto + ", pais=" + pais + ", provincia=" + provincia + "]";
	}

}
