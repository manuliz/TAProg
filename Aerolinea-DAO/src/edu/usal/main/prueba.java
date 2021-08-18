package edu.usal.main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.Formatter;
import java.util.Hashtable;
import java.util.List;
import java.util.StringTokenizer;

import edu.usal.Util.obtenerID;
import edu.usal.negocio.DAO.Implementacion.AeropuertoDAOImplementacionStream;
import edu.usal.negocio.DAO.Implementacion.AlianzasDAOImplementacionString;
import edu.usal.negocio.DAO.Implementacion.ClienteDAOImplementacionStream;
import edu.usal.negocio.DAO.Implementacion.LineasAereasDAOImplementacionStream;
import edu.usal.negocio.DAO.Implementacion.PaisDAOImplementacionString;
import edu.usal.negocio.DAO.Implementacion.ProvinciaDAOImplementacionString;
import edu.usal.negocio.DAO.Implementacion.VentasDAOImplementacionStream;
import edu.usal.negocio.DAO.Implementacion.VuelosDAOImplementacionStream;
import edu.usal.negocio.DAO.Interfaces.AeropuertoDAO;
import edu.usal.negocio.DAO.Interfaces.AlianzasDAO;
import edu.usal.negocio.DAO.Interfaces.ClienteDAO;
import edu.usal.negocio.DAO.Interfaces.LineasAereasDAO;
import edu.usal.negocio.DAO.Interfaces.PaisDAO;
import edu.usal.negocio.DAO.Interfaces.ProvinciaDAO;
import edu.usal.negocio.DAO.Interfaces.VentasDAO;
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
		
//		ClienteDAO cliente = new ClienteDAOImplementacionStream();
//		Date hoy = Calendar.getInstance().getTime();
		
//		// CLIENTE 1
//		Pais pais1 = new Pais(3, "Estados Unidos");
//		Provincia prov1 = new Provincia(3, "Miami");
//		Pais pais4 = new Pais(4, "Brasil");
//		Provincia prov4 = new Provincia(4, "Santa catarina");
//		Aeropuerto AE11 = new Aeropuerto(3, "Florida", "FLD", pais1, prov1, null);
//		Aeropuerto AE12 = new Aeropuerto(5, "Florianopolis", "FNP", pais4, prov4, null);
////		Vuelos v1 = new Vuelos(1, 2223, 1244, "12hs", AE11, AE12);
//		LineasAereas la1 = new LineasAereas(Alianzas.Airlink, 1, "ZALALLALA");
//		Pasaporte pasa1 = new Pasaporte(1, "40643145", "Albertito fernandu", "Argentina", hoy, hoy );
//		Telefono telef1 = new Telefono(1,"1132645209", "1132645209", "1234567890");
//		PasajeroFrecuente pasajfrec1 = new PasajeroFrecuente(1,"321", "Discapacitado", la1, Alianzas.Air_China);
//		Direccion Direc1 = new Direccion(1, pais1, prov1, "Catamarca", "lala", "123", "2222");
//
//		Cliente cli1 = new Cliente(1,"Manuel Liz", "40643145", pasa1, "20-40643145-2", hoy, "manuel@hotmail.com", telef1, pasajfrec1, Direc1);
//		
//		//CLIENTE 2
//		Pais pais2 = new Pais(3, "Estados Unidos");
//		Provincia prov2 = new Provincia(3, "California");	
//		Pais pais3 = new Pais(4, "Uruguay");
//		Provincia prov3 = new Provincia(4, "Montevideo");
//		Aeropuerto AE21 = new Aeropuerto(6, "Los angeles", "LAX", pais2, prov2, null);
//		Aeropuerto AE22 = new Aeropuerto(7, "Punta del este", "PES", pais3, prov3, null);
////		Vuelos v2 = new Vuelos(2, 11231, 231, "23hs", AE21, AE22);
//		LineasAereas la2 = new LineasAereas(Alianzas.Dragonair, 2, "iiiiLAZuZuZA");
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
//		VuelosDAO vuelos = new VuelosDAOImplementacionStream();
		
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
		
//		LineasAereasDAO lineas = new LineasAereasDAOImplementacionStream();
		
//		LineasAereas la21 = new LineasAereas(Alianzas.Air_Berlin,0,"Air Berlin") ;
//		LineasAereas la22 = new LineasAereas(Alianzas.Aeroflot,1,"Aeroflot"); 
//		LineasAereas la23 = new LineasAereas(Alianzas.Adria_Airways,2,"Adria Airways") ;
//		LineasAereas la24 = new LineasAereas(Alianzas.Niki,3,"Niki");
//		LineasAereas la25 = new LineasAereas(Alianzas.Aerolineas_Argentinas,4,"Aerolíneas Argentinas");
//		LineasAereas la26 = new LineasAereas(Alianzas.Aegean_Airlines,5,"Aegean Airlines"); 
//		LineasAereas la27 = new LineasAereas(Alianzas.American_Airlines,6,"American Airlines");
//		LineasAereas la28 = new LineasAereas(Alianzas.Austral_Lineas_Aereas,7,"Austral Líneas Aéreas"); 
//		LineasAereas la29 = new LineasAereas(Alianzas.Olympic_Air,8,"Olympic Air") ;
//		LineasAereas la30 = new LineasAereas(Alianzas.American_Eagle,9,"American Eagle") ;
//		LineasAereas la31 = new LineasAereas(Alianzas.Aeromexico,10,"Aeromexico");
//		LineasAereas la32 = new LineasAereas(Alianzas.Air_Canada,11,"Air Canada"); 
//		LineasAereas la33 = new LineasAereas(Alianzas.US_Airways,12,"US Airways");
//		LineasAereas la34 = new LineasAereas(Alianzas.Aeromexico_Connect,13,"Aeroméxico Connect") ;
//		LineasAereas la35 = new LineasAereas(Alianzas.Air_Canada_Express,14,"Air Canada Express"); 
//		LineasAereas la36 = new LineasAereas(Alianzas.US_Airways_Express,15,"US Airways Express"); 
//		LineasAereas la37 = new LineasAereas(Alianzas.Air_Europa,16,"Air Europa");
//		LineasAereas la38 = new LineasAereas(Alianzas.Air_Canada_Rouge,17,"Air Canada Rouge");
//		LineasAereas la39 = new LineasAereas(Alianzas.US_Airways_Shuttle,18,"US Airways Shuttle");
//		LineasAereas la40 = new LineasAereas(Alianzas.Air_France,19,"Air France");
//		LineasAereas la1 = new LineasAereas(Alianzas.Air_China,20,"Air China") ;
//		LineasAereas la2 = new LineasAereas(Alianzas.British_Airways,21,"British Airways"); 
//		LineasAereas la3 = new LineasAereas(Alianzas.Alitalia,22,"Alitalia") ;
//		LineasAereas la4 = new LineasAereas(Alianzas.Dalian_Airlines,23,"Dalian Airlines");
//		LineasAereas la5 = new LineasAereas(Alianzas.BA_CityFlyer,24,"BA CityFlyer");
//		LineasAereas la6 = new LineasAereas(Alianzas.China_Airlines,25,"China Airlines"); 
//		LineasAereas la7 = new LineasAereas(Alianzas.Air_India,26,"Air India");
//		LineasAereas la8 = new LineasAereas(Alianzas.British_Airways_Limited,27,"British Airways Limited"); 
//		LineasAereas la9 = new LineasAereas(Alianzas.Mandarin_Airlines,28,"Mandarin Airlines") ;
//		LineasAereas la10 = new LineasAereas(Alianzas.Air_India_Regional,29,"Air India Regional") ;
//		LineasAereas la11 = new LineasAereas(Alianzas.Comair,30,"Comair");
//		LineasAereas la12 = new LineasAereas(Alianzas.China_Eastern_Airlines,31,"China Eastern Airlines"); 
//		LineasAereas la13 = new LineasAereas(Alianzas.Air_New_Zealand,32,"Air New Zealand");
//		LineasAereas la14 = new LineasAereas(Alianzas.OpenSkies,33,"OpenSkies") ;
//		LineasAereas la15 = new LineasAereas(Alianzas.Shanghai_Airlines,34,"Shanghai Airlines"); 
//		LineasAereas la16 = new LineasAereas(Alianzas.Air_New_Zealand_Link,35,"Air New Zealand Link"); 
//		LineasAereas la17 = new LineasAereas(Alianzas.Sun_Air,36,"Sun-Air");
//		LineasAereas la18 = new LineasAereas(Alianzas.China_Southern_Airlines,37,"China Southern Airlines");
//		LineasAereas la19 = new LineasAereas(Alianzas.All_Nippon_Airways,38,"All Nippon Airways");
//		LineasAereas la20 = new LineasAereas(Alianzas.Cathay_Pacific,39,"Cathay Pacific");
	
		
//				try {

//					lineas.crearLineaAerea(la35);
//					lineas.crearLineaAerea(la36);
//					lineas.crearLineaAerea(la37);
//					lineas.crearLineaAerea(la38);
//					lineas.crearLineaAerea(la39);
//					lineas.crearLineaAerea(la40);
//					lineas.crearLineaAerea(la20);
//					lineas.crearLineaAerea(la1);
//					lineas.crearLineaAerea(la2);
//					lineas.crearLineaAerea(la3);
//					lineas.crearLineaAerea(la4);
//					lineas.crearLineaAerea(la5);
//					lineas.crearLineaAerea(la6);
//					lineas.crearLineaAerea(la7);
//					lineas.crearLineaAerea(la8);
//					lineas.crearLineaAerea(la9);
//					lineas.crearLineaAerea(la10);
//					lineas.crearLineaAerea(la11);
//					lineas.crearLineaAerea(la12);
//					lineas.crearLineaAerea(la13);
//					lineas.crearLineaAerea(la14);
//					lineas.crearLineaAerea(la15);
//					lineas.crearLineaAerea(la16);
//					lineas.crearLineaAerea(la17);
//					lineas.crearLineaAerea(la18);
//					lineas.crearLineaAerea(la19);
//					lineas.crearLineaAerea(la20);
//				} catch (ClassNotFoundException | IOException | SQLException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}

		
//		try {
//			lineas.actualizarLineaAerea(la1);
//		} catch (IOException | ClassNotFoundException | SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		try {
//			lineas.eliminarLineaAerea(41);
//		} catch (IOException | ClassNotFoundException | SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	
//		try {
//				LineasAereas linea1 = lineas.obtenerLineaAerea(2);
//				System.out.println(linea1.toString());
//			} catch (ClassNotFoundException | SQLException | IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}

		

//		try {
//			List<LineasAereas> lista1 = lineas.obtenerLineasAereas();
//			for(LineasAereas a : lista1) {
//				System.out.println(a.toString());
//			}
//		} catch (ClassNotFoundException | IOException | SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}


		
//		AeropuertoDAO aero = new AeropuertoDAOImplementacionStream();
//		VentasDAO ven = new VentasDAOImplementacionStream();
		
//		Provincia prov9 = new Provincia(0, "Buenos Aires");
//		Pais pais9 = new Pais(0, "Afganistan");
//		Provincia prov10 = new Provincia(1, "Catamarca");
//		Pais pais10 = new Pais(1, "Albania");
//		Provincia prov3 = new Provincia(2, "Chaco");
//		Pais pais3 = new Pais(2, "Alemania");
//		Provincia prov4 = new Provincia(3, "Chubut");
//		Pais pais4 = new Pais(3, "Andorra");
//		Provincia prov5 = new Provincia(4, "Cordoba");
//		Pais pais5 = new Pais(4, "Angola");
//		Provincia prov6 = new Provincia(5, "Corrientes");
//		Pais pais6 = new Pais(5, "Antigua y Barbuda");
//		Provincia prov7 = new Provincia(6, "Entre rios");
//		Pais pais7 = new Pais(6, "Arabia saudita");
//		Provincia prov8 = new Provincia(7, "Formosa");
//		Pais pais8 = new Pais(7, "Argelia");
//		Provincia prov11 = new Provincia(8, "Jujuy");
//		Pais pais11 = new Pais(8, "Argentina");
		
//		Aeropuerto AE13 = new Aeropuerto(0, "Buenos Aires", "AER", pais11, prov9, null);
//		Aeropuerto AE14 = new Aeropuerto(1, "Catamarca", "CAT", pais11, prov10, null);
//		Aeropuerto AE15 = new Aeropuerto(2, "Chaco", "CHA", pais11, prov3, null);
//		Aeropuerto AE16 = new Aeropuerto(3, "Chubut", "CHU", pais11, prov4, null);
//		Aeropuerto AE17 = new Aeropuerto(4, "Cordoba", "COR", pais11, prov5, null);
//		Aeropuerto AE18 = new Aeropuerto(5, "Corrientes", "CRR", pais11, prov6, null);
//		Aeropuerto AE19 = new Aeropuerto(6, "Entre Rios", "ENR", pais11, prov7, null);
//		Aeropuerto AE20 = new Aeropuerto(7, "Formosa", "FOR", pais11, prov8, null);
//		Aeropuerto AE21 = new Aeropuerto(8, "Jujuy", "JUJ", pais11, prov11, null);
		
		
//		try {
//			aero.crearAeropuerto(AE13);
//			aero.crearAeropuerto(AE14);
//			aero.crearAeropuerto(AE15);
//			aero.crearAeropuerto(AE16);
//			aero.crearAeropuerto(AE17);
//			aero.crearAeropuerto(AE18);
//			aero.crearAeropuerto(AE19);
//			aero.crearAeropuerto(AE20);
//			aero.crearAeropuerto(AE21);
//		} catch (ClassNotFoundException | SQLException | IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		
//		try {
//			try {
//				aero.actualizarAeropuerto(AE11);
//			} catch (ClassNotFoundException | SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		try {
//			try {
//				aero.eliminarAeropuerto(0);
//				aero.eliminarAeropuerto(1);
//				aero.eliminarAeropuerto(2);
//				aero.eliminarAeropuerto(3);
//				aero.eliminarAeropuerto(4);
//				aero.eliminarAeropuerto(5);
//				aero.eliminarAeropuerto(6);
//				aero.eliminarAeropuerto(7);
//			} catch (ClassNotFoundException | SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		Aeropuerto as;
//		try {
//			as = aero.obtenerAeropuerto(1);
//			System.out.println(as.toString());
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		
		

//		try {
//			List<Aeropuerto> aa = aero.obtenerAeropuertos();
//			for(Aeropuerto a : aa) {
//				System.out.println(a.toString());
//				}
//			} catch (ClassNotFoundException | SQLException | IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			}

		
		//----------------------------------PARTE STRING----------------------------------------
		
		ProvinciaDAO prov = new ProvinciaDAOImplementacionString();
//		PaisDAO pa = new PaisDAOImplementacionString();
//		AlianzasDAO al =new AlianzasDAOImplementacionString();
		
//		try {
//			Hashtable<Integer, String> hashprov = prov.obtenerProvincias();
//			Enumeration<String> valor = hashprov.elements();
//			while(valor.hasMoreElements()) {
//				System.out.println("Prov:"+valor.nextElement());
//			}
//		} catch (IOException | ClassNotFoundException | SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
//		try {
//			Hashtable<Integer, String> hashpa = pa.obtenerPaises();
//			Enumeration<String> key = hashpa.elements();
//			while(key.hasMoreElements()) {
//				System.out.println("Pais: "+key.nextElement());
//			}
//		} catch (IOException | ClassNotFoundException | SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
//		try {
//		Hashtable<Integer, String> hashal = al.obtenerAlianzas();
//		Enumeration<String> key = hashal.elements();
//		while(key.hasMoreElements()) {
//			System.out.println("Alianza: "+key.nextElement());
//		}
//	} catch (IOException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
		
		Formatter fmt = new Formatter();
		String nomAero = "Manuel Airlines";
		String palabra;
		String palabra1;
		String palabra2;
		StringTokenizer st = new StringTokenizer(nomAero);
	
		
			while(st.hasMoreTokens()) {
				palabra = st.nextToken();
				palabra1 = palabra.substring(0, 1);
				palabra = st.nextToken();
				palabra2 = palabra.substring(0, 1);
				System.out.println(palabra1+""+palabra2);
			}
			
		
		
		
		
			
			
		

		}
	}

