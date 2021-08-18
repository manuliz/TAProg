package edu.usal.negocio.Dominio;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

public class Ventas implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int idVenta;
	Cliente cliente;
	Vuelos vuelo;
	LineasAereas aerolinea;
	private Date fechaYhoraVenta;
	private String formaPago;
	private int cuotas;
	private int totAPagar;
	

	public Ventas(int idVenta, Cliente cliente, Vuelos vuelo, LineasAereas aerolinea, Date fechaYhoraVenta,
			String formaPago, int cuotas, int totAPagar) {
		super();
		this.idVenta = idVenta;
		this.cliente = cliente;
		this.vuelo = vuelo;
		this.aerolinea = aerolinea;
		this.fechaYhoraVenta = fechaYhoraVenta;
		this.formaPago = formaPago;
		this.cuotas = cuotas;
		this.totAPagar = totAPagar;
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

	public int getCuotas() {
		return cuotas;
	}

	public void setCuotas(int cuotas) {
		this.cuotas = cuotas;
	}

	public int getTotAPagar() {
		return totAPagar;
	}

	public void setTotAPagar(int totAPagar) {
		this.totAPagar = totAPagar;
	}

	@Override
	public String toString() {
		return "Ventas [idVenta=" + idVenta + ", cliente=" + cliente + ", vuelo=" + vuelo + ", aerolinea=" + aerolinea
				+ ", fechaYhoraVenta=" + fechaYhoraVenta + ", formaPago=" + formaPago + ", cuotas=" + cuotas
				+ ", totAPagar=" + totAPagar + "]";
	}

}
