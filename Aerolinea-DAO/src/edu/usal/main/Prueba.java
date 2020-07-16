package edu.usal.main;

import java.util.Calendar;
import java.util.Date;

import edu.usal.negocio.DAO.Implementacion.ClienteDAOImplementacion;
import edu.usal.negocio.DAO.Interfaces.ClienteDAO;
import edu.usal.negocio.dominio.Aeropuerto;
import edu.usal.negocio.dominio.Alianzas;
import edu.usal.negocio.dominio.Cliente;
import edu.usal.negocio.dominio.Direccion;
import edu.usal.negocio.dominio.LineasAereas;
import edu.usal.negocio.dominio.Pais;
import edu.usal.negocio.dominio.PasajeroFrecuente;
import edu.usal.negocio.dominio.Pasaporte;
import edu.usal.negocio.dominio.Provincia;
import edu.usal.negocio.dominio.Telefono;
import edu.usal.negocio.dominio.Vuelos;

public class Prueba {

	public static void main(String[] args) {
		
		ClienteDAO cliente = new ClienteDAOImplementacion();
		Date hoy = Calendar.getInstance().getTime();
		
		Pasaporte pasa1 = new Pasaporte(1, "40643145", "Albertito fernandu", "Argentina", hoy, hoy );
		Telefono telef1 = new Telefono(1,"1132645209", "1132645209", "1234567890");
		PasajeroFrecuente pasajfrec1 = new PasajeroFrecuente(1,"321", "Discapacitado", la1, Alianzas.Air_China);
		Direccion Direc1 = new Direccion(1, pais1, prov1, "Catamarca", "lala", "123", "2222");
		Pais pais1 = new Pais(1, "Argentina");
		Provincia prov1 = new Provincia(1, "Catamarca");
		LineasAereas la1 = new LineasAereas(Alianzas.Airlink, 1, "ZALALLALA", v1);
		Vuelos v1 = new Vuelos(1, 2223, 120, "12hs", AE11, AE12);
		Aeropuerto AE11 = new Aeropuerto(1, "BSAS", "JFK", pais1, prov1);
		Aeropuerto AE12 = new Aeropuerto(2, "CATAMARCA", "CATA", pais1, prov1);
		Cliente cli1 = new Cliente(1,"Manuel Liz", "40643145", pasa1, "20-40643145-2", hoy, "manuel@hotmail.com", telef1, pasajfrec1, Direc1);

	}

}
