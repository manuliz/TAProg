package edu.usal.negocio.Dominio;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Vuelos implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int idVuelos;
	private String numDeVuelos;
	private int cantDeAsientos;
	private int asientosDisponibles;
	private String tiempoDeVuelo;
	private LineasAereas lineaAerea;
	Aeropuerto aeropuertoSalida;
	Aeropuerto aeropuertoLlegada;
	private Date fhSalida;
	private Date fhLlegada;
	private List<Cliente> lcli;
	
	public Vuelos() {
		
	}

	public Vuelos(int idVuelos, String numDeVuelos, int cantDeAsientos, String tiempoDeVuelo, LineasAereas lineaAerea,
			Aeropuerto aeropuertoSalida, Aeropuerto aeropuertoLlegada, Date fhSalida, Date fhLlegada) {
		super();
		this.idVuelos = idVuelos;
		this.numDeVuelos = numDeVuelos;
		this.cantDeAsientos = cantDeAsientos;
		this.tiempoDeVuelo = tiempoDeVuelo;
		this.lineaAerea = lineaAerea;
		this.aeropuertoSalida = aeropuertoSalida;
		this.aeropuertoLlegada = aeropuertoLlegada;
		this.fhSalida = fhSalida;
		this.fhLlegada = fhLlegada;
	}
	
	public Vuelos(int idVuelos, String numDeVuelos, int cantDeAsientos, String tiempoDeVuelo, LineasAereas lineaAerea,
			Aeropuerto aeropuertoSalida, Aeropuerto aeropuertoLlegada, Date fhSalida, Date fhLlegada,
			List<Cliente> lcli) {
		super();
		this.idVuelos = idVuelos;
		this.numDeVuelos = numDeVuelos;
		this.cantDeAsientos = cantDeAsientos;
		this.tiempoDeVuelo = tiempoDeVuelo;
		this.lineaAerea = lineaAerea;
		this.aeropuertoSalida = aeropuertoSalida;
		this.aeropuertoLlegada = aeropuertoLlegada;
		this.fhSalida = fhSalida;
		this.fhLlegada = fhLlegada;
		this.lcli = lcli;
	}

	public int getIdVuelos() {
		return idVuelos;
	}

	public void setIdVuelos(int idVuelos) {
		this.idVuelos = idVuelos;
	}

	public String getNumDeVuelos() {
		return numDeVuelos;
	}

	public void setNumDeVuelos(String numDeVuelos) {
		this.numDeVuelos = numDeVuelos;
	}

	public int getCantDeAsientos() {
		return cantDeAsientos;
	}

	public void setCantDeAsientos(int cantDeAsientos) {
		this.cantDeAsientos = cantDeAsientos;
	}

	public String getTiempoDeVuelo() {
		return tiempoDeVuelo;
	}

	public void setTiempoDeVuelo(String tiempoDeVuelo) {
		this.tiempoDeVuelo = tiempoDeVuelo;
	}

	public Aeropuerto getAeropuertoSalida() {
		return aeropuertoSalida;
	}

	public void setAeropuertoSalida(Aeropuerto aeropuertoSalida) {
		this.aeropuertoSalida = aeropuertoSalida;
	}

	public Aeropuerto getAeropuertoLlegada() {
		return aeropuertoLlegada;
	}

	public void setAeropuertoLlegada(Aeropuerto aeropuertoLlegada) {
		this.aeropuertoLlegada = aeropuertoLlegada;
	}

	public Date getFhSalida() {
		return fhSalida;
	}

	public void setFhSalida(Date fhSalida) {
		this.fhSalida = fhSalida;
	}

	public Date getFhLlegada() {
		return fhLlegada;
	}

	public void setFhLlegada(Date fhLlegada) {
		this.fhLlegada = fhLlegada;
	}

	public LineasAereas getLineaAerea() {
		return lineaAerea;
	}

	public void setLineaAerea(LineasAereas lineaAerea) {
		this.lineaAerea = lineaAerea;
	}

	public int getAsientosDisponibles() {
		return asientosDisponibles;
	}

	public void setAsientosDisponibles(int asientosDisponibles) {
		this.asientosDisponibles = asientosDisponibles;
	}

	@Override
	public String toString() {
		return "Vuelos [idVuelos=" + idVuelos + ", numDeVuelos=" + numDeVuelos + ", cantDeAsientos=" + cantDeAsientos
				+ ", tiempoDeVuelo=" + tiempoDeVuelo + ", lineaAerea=" + lineaAerea + ", aeropuertoSalida="
				+ aeropuertoSalida + ", aeropuertoLlegada=" + aeropuertoLlegada + ", fhSalida=" + fhSalida
				+ ", fhLlegada=" + fhLlegada + ", lcli=" + lcli + "]";
	}
	
}
