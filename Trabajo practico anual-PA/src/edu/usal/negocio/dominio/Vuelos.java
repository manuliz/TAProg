package edu.usal.negocio.dominio;

public class Vuelos {
	
	private int idVuelos;
	private int numDeVuelos;
	private int cantDeAsientos;
	private String tiempoDeVuelo;
	Aeropuerto aeropuertoSalida;
	Aeropuerto aeropuertoLlegada;
	
	public Vuelos(int idVuelos, int numDeVuelos, int cantDeAsientos, String tiempoDeVuelo, Aeropuerto aeropuertoSalida,
			Aeropuerto aeropuertoLlegada) {
		super();
		this.idVuelos = idVuelos;
		this.numDeVuelos = numDeVuelos;
		this.cantDeAsientos = cantDeAsientos;
		this.tiempoDeVuelo = tiempoDeVuelo;
		this.aeropuertoSalida = aeropuertoSalida;
		this.aeropuertoLlegada = aeropuertoLlegada;
	}

	public int getIdVuelos() {
		return idVuelos;
	}

	public void setIdVuelos(int idVuelos) {
		this.idVuelos = idVuelos;
	}

	public int getNumDeVuelos() {
		return numDeVuelos;
	}

	public void setNumDeVuelos(int numDeVuelos) {
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

	@Override
	public String toString() {
		return "Vuelos [idVuelos=" + idVuelos + ", numDeVuelos=" + numDeVuelos + ", cantDeAsientos=" + cantDeAsientos
				+ ", tiempoDeVuelo=" + tiempoDeVuelo + ", aeropuertoSalida=" + aeropuertoSalida + ", aeropuertoLlegada="
				+ aeropuertoLlegada + "]";
	}

}
