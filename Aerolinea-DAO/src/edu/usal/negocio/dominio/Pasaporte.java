package edu.usal.negocio.dominio;

import java.util.Date;

public class Pasaporte {
	
	private int idPasaporte;
	private String numDePasaporte;
	private String autoridadDeEmision;
	private String paisDeEmision;
	private Date fechaEmision;
	private Date fechaVencimiento;
	
	public Pasaporte(int idPasaporte, String numDePasaporte, String autoridadDeEmision, String paisDeEmision,
			Date fechaEmision, Date fechaVencimiento) {
		super();
		this.idPasaporte = idPasaporte;
		this.numDePasaporte = numDePasaporte;
		this.autoridadDeEmision = autoridadDeEmision;
		this.paisDeEmision = paisDeEmision;
		this.fechaEmision = fechaEmision;
		this.fechaVencimiento = fechaVencimiento;
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

	public String getPaisDeEmision() {
		return paisDeEmision;
	}

	public void setPaisDeEmision(String paisDeEmision) {
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
