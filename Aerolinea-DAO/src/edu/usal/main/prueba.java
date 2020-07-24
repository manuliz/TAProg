package edu.usal.main;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import edu.usal.negocio.DAO.Implementacion.ClienteDAOImplementacion;
import edu.usal.negocio.DAO.Implementacion.VuelosDAOImplementacion;
import edu.usal.negocio.DAO.Interfaces.ClienteDAO;
import edu.usal.negocio.DAO.Interfaces.VuelosDAO;
import edu.usal.negocio.Dominio.Aeropuerto;
import edu.usal.negocio.Dominio.Alianzas;
import edu.usal.negocio.Dominio.Cliente;
import edu.usal.negocio.Dominio.Direccion;
import edu.usal.negocio.Dominio.LineasAereas;
import edu.usal.negocio.Dominio.Pais;
import edu.usal.negocio.Dominio.PasajeroFrecuente;
import edu.usal.negocio.Dominio.Pasaporte;
import edu.usal.negocio.Dominio.Provincia;
import edu.usal.negocio.Dominio.Telefono;
import edu.usal.negocio.Dominio.Vuelos;

public class prueba {
	
public static void main(String[] args) {
		
		ClienteDAO cliente = new ClienteDAOImplementacion();
		Date hoy = Calendar.getInstance().getTime();
		
		// CLIENTE 1
		Pais pais1 = new Pais(1, "Argentina");
		Provincia prov1 = new Provincia(1, "Catamarca");
		Aeropuerto AE11 = new Aeropuerto(1, "BSAS", "JFK", pais1, prov1);
		Aeropuerto AE12 = new Aeropuerto(2, "CATAMARCA", "CATA", pais1, prov1);
		Vuelos v1 = new Vuelos(1, 2223, 1244, "12hs", AE11, AE12);
//		LineasAereas la1 = new LineasAereas(Alianzas.Airlink, 1, "ZALALLALA", v1);
//		Pasaporte pasa1 = new Pasaporte(1, "40643145", "Albertito fernandu", "Argentina", hoy, hoy );
//		Telefono telef1 = new Telefono(1,"1132645209", "1132645209", "1234567890");
//		PasajeroFrecuente pasajfrec1 = new PasajeroFrecuente(1,"321", "Discapacitado", la1, Alianzas.Air_China);
//		Direccion Direc1 = new Direccion(1, pais1, prov1, "Catamarca", "lala", "123", "2222");
//
//		Cliente cli1 = new Cliente(1,"Manuel Liz", "40643145", pasa1, "20-40643145-2", hoy, "manuel@hotmail.com", telef1, pasajfrec1, Direc1);
		
		//CLIENTE 2
		Pais pais2 = new Pais(2, "Russia");
		Provincia prov2 = new Provincia(2, "Moscow");
		Aeropuerto AE21 = new Aeropuerto(2, "ASDASD", "ASDCC", pais2, prov2);
		Aeropuerto AE22 = new Aeropuerto(2, "CASARACA", "CUTU", pais2, prov2);
		Vuelos v2 = new Vuelos(2, 11231, 231, "23hs", AE21, AE22);
//		LineasAereas la2 = new LineasAereas(Alianzas.Aeromexico, 2, "LAZAZAZA", v2);
//		Pasaporte pasa2 = new Pasaporte(2, "40608090", "Bladimir flor de putin", "Russia", hoy, hoy );
//		Telefono telef2 = new Telefono(2,"1133445566", "1122334455", "0987654321");
//		PasajeroFrecuente pasajfrec2 = new PasajeroFrecuente(2,"123", "Tarado", la2, Alianzas.Air_China);
//		Direccion Direc2 = new Direccion(2, pais2, prov2, "Rindur", "zaza", "312", "3333");
//
//		Cliente cli2 = new Cliente(2,"Mario Putinininini", "40640009", pasa2, "20-40640009-2", hoy, "sssss@hotmail.com", telef2, pasajfrec2, Direc2);
		
		
		
//		try {
//			cliente.crearCliente(cli1);
//			cliente.crearCliente(cli2);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		try {
//			Cliente clicli1 = cliente.obtenerCliente("40640009");
//			System.out.println(clicli1.toString());
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	
//		try {
//			List<Cliente> lissta = cliente.obtenerClientes();
//			for(Cliente l : lissta) {
//				System.out.println(l.toString());
//			}
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		try {
//			cliente.actualizarCliente(cli2);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		try {
//			cliente.eliminarCliente(cli1);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		//PRUEBA VUELOS
		VuelosDAO vuelos = new VuelosDAOImplementacion();
		
//		try {
//			vuelos.crearVuelo(v1);
//			vuelos.crearVuelo(v2);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		try {
//			vuelos.actualizarVuelo(v1);
//		} catch (IOException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//		}
	
//		try {
//			vuelos.eliminarVuelo(v2);
//		} catch (IOException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//		}
		
//		try {
//			Vuelos vue = vuelos.obtenerVuelo(11231);
//			System.out.println(vue.toString());
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		try {
//			List<Vuelos> ista = vuelos.obtenerVuelos();
//			for(Vuelos a : ista) {
//				System.out.println(a.toString());
//			}
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
				
		
	}
}
