package edu.usal.negocio.Dominio;

import java.io.Serializable;
import java.util.Date;

public class Pasaporte implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int idPasaporte;
	private String numDePasaporte;
	private String autoridadDeEmision;
	private Pais paisDeEmision;
	private Date fechaEmision;
	private Date fechaVencimiento;
	
	public Pasaporte(int idPasaporte, String numDePasaporte, String autoridadDeEmision, Pais paisDeEmision,
			Date fechaEmision, Date fechaVencimiento) {
		super();
		this.idPasaporte = idPasaporte;
		this.numDePasaporte = numDePasaporte;
		this.autoridadDeEmision = autoridadDeEmision;
		this.paisDeEmision = paisDeEmision;
		this.fechaEmision = fechaEmision;
		this.fechaVencimiento = fechaVencimiento;
	}
	
	public Pasaporte() {
		super();
	}

	public int getIdPasaporte() {
		return idPasaporte;
	}

	public void setIdPasaporte(int idPasaporte) {
		this.idPasaporte = idPasaporte;
	}

	public String getNumDePasaporte() {
		return numDePasaporte;
	}

	public void setNumDePasaporte(String numDePasaporte) {
		this.numDePasaporte = numDePasaporte;
	}

	public String getAutoridadDeEmision() {
		return autoridadDeEmision;
	}

	public void setAutoridadDeEmision(String autoridadDeEmision) {
		this.autoridadDeEmision = autoridadDeEmision;
	}

	public Pais getPaisDeEmision() {
		return paisDeEmision;
	}

	public void setPaisDeEmision(Pais paisDeEmision) {
		this.paisDeEmision = paisDeEmision;
	}

	public Date getFechaEmision() {
		return fechaEmision;
	}

	public void setFechaEmision(Date fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	@Override
	public String toString() {
		return "Pasaporte [idPasaporte=" + idPasaporte + ", numDePasaporte=" + numDePasaporte + ", autoridadDeEmision="
				+ autoridadDeEmision + ", paisDeEmision=" + paisDeEmision + ", fechaEmision=" + fechaEmision
				+ ", fechaVencimiento=" + fechaVencimiento + "]";
	}

}
