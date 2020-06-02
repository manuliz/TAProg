package edu.usal.negocio;

import java.util.Date;

public class Cliente {
	
	private int idCliente;
	private String nombreApellido;
	private String dni;
	Pasaporte pasaporte;
	private String cuit_cuil;
	private Date fechaNac;
	private String eMail;
	Telefono telefono;
	PasajeroFrecuente numPasajeroFrec;
	Direccion direccion;
	
	public Cliente(int idCliente, String nombreApellido, String dni, Pasaporte pasaporte, String cuit_cuil,
			Date fechaNac, String eMail, Telefono telefono, PasajeroFrecuente numPasajeroFrec, Direccion direccion) {
		super();
		this.idCliente = idCliente;
		this.nombreApellido = nombreApellido;
		this.dni = dni;
		this.pasaporte = pasaporte;
		this.cuit_cuil = cuit_cuil;
		this.fechaNac = fechaNac;
		this.eMail = eMail;
		this.telefono = telefono;
		this.numPasajeroFrec = numPasajeroFrec;
		this.direccion = direccion;
	}

	public Cliente() {
		super();
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombreApellido() {
		return nombreApellido;
	}

	public void setNombreApellido(String nombreApellido) {
		this.nombreApellido = nombreApellido;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Pasaporte getPasaporte() {
		return pasaporte;
	}

	public void setPasaporte(Pasaporte pasaporte) {
		this.pasaporte = pasaporte;
	}

	public String getCuit_cuil() {
		return cuit_cuil;
	}

	public void setCuit_cuil(String cuit_cuil) {
		this.cuit_cuil = cuit_cuil;
	}

	public Date getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public Telefono getTelefono() {
		return telefono;
	}

	public void setTelefono(Telefono telefono) {
		this.telefono = telefono;
	}

	public PasajeroFrecuente getNumPasajeroFrec() {
		return numPasajeroFrec;
	}

	public void setNumPasajeroFrec(PasajeroFrecuente numPasajeroFrec) {
		this.numPasajeroFrec = numPasajeroFrec;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", nombreApellido=" + nombreApellido + ", dni=" + dni
				+ ", pasaporte=" + pasaporte + ", cuit_cuil=" + cuit_cuil + ", fechaNac=" + fechaNac + ", eMail="
				+ eMail + ", telefono=" + telefono + ", numPasajeroFrec=" + numPasajeroFrec + ", direccion=" + direccion
				+ "]";
	}

}
