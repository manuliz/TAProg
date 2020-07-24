package edu.usal.negocio.Dominio;

import java.io.Serializable;

public class Telefono implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int idTelefono;
	private String numCelular;
	private String numLaboral;
	private String numPersonal;
	
	public Telefono(int idTelefono, String numCelular, String numLaboral, String numPersonal) {
		super();
		this.idTelefono = idTelefono;
		this.numCelular = numCelular;
		this.numLaboral = numLaboral;
		this.numPersonal = numPersonal;
	}

	public int getIdTelefono() {
		return idTelefono;
	}

	public void setIdTelefono(int idTelefono) {
		this.idTelefono = idTelefono;
	}

	public String getNumCelular() {
		return numCelular;
	}

	public void setNumCelular(String numCelular) {
		this.numCelular = numCelular;
	}

	public String getNumLaboral() {
		return numLaboral;
	}

	public void setNumLaboral(String numLaboral) {
		this.numLaboral = numLaboral;
	}

	public String getNumPersonal() {
		return numPersonal;
	}

	public void setNumPersonal(String numPersonal) {
		this.numPersonal = numPersonal;
	}

	@Override
	public String toString() {
		return "Telefono [idTelefono=" + idTelefono + ", numCelular=" + numCelular + ", numLaboral=" + numLaboral
				+ ", numPersonal=" + numPersonal + "]";
	}

}
