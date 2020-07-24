package edu.usal.negocio.Dominio;

import java.io.Serializable;
import java.util.Date;

public class Ventas implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int idVenta;
	Cliente cliente;
	Vuelos vuelo;
	LineasAereas aerolinea;
	private Date fechaYhoraVenta;
	private String formaPago;
	
	public Ventas(int idVenta, Cliente cliente, Vuelos vuelo, LineasAereas aerolinea, Date fechaYhoraVenta,
			String formaPago) {
		super();
		this.idVenta = idVenta;
		this.cliente = cliente;
		this.vuelo = vuelo;
		this.aerolinea = aerolinea;
		this.fechaYhoraVenta = fechaYhoraVenta;
		this.formaPago = formaPago;
	}

	public Ventas() {
		super();
	}

	public int getIdVenta() {
		return idVenta;
	}

	public void setIdVenta(int idVenta) {
		this.idVenta = idVenta;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Vuelos getVuelo() {
		return vuelo;
	}

	public void setVuelo(Vuelos vuelo) {
		this.vuelo = vuelo;
	}

	public LineasAereas getAerolinea() {
		return aerolinea;
	}

	public void setAerolinea(LineasAereas aerolinea) {
		this.aerolinea = aerolinea;
	}

	public Date getFechaYhoraVenta() {
		return fechaYhoraVenta;
	}

	public void setFechaYhoraVenta(Date fechaYhoraVenta) {
		this.fechaYhoraVenta = fechaYhoraVenta;
	}

	public String getFormaPago() {
		return formaPago;
	}

	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}

	@Override
	public String toString() {
		return "Ventas [idVenta=" + idVenta + ", cliente=" + cliente + ", vuelo=" + vuelo + ", aerolinea=" + aerolinea
				+ ", fechaYhoraVenta=" + fechaYhoraVenta + ", formaPago=" + formaPago + "]";
	}

}
