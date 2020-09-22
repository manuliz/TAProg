package edu.usal.main;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;

import edu.usal.negocio.DAO.Implementacion.AeropuertoDAOImplementacionSQL;
import edu.usal.negocio.DAO.Implementacion.LineasAereasDAOImplementacionSQL;
import edu.usal.negocio.DAO.Implementacion.PaisDAOImplementacionSQL;
import edu.usal.negocio.DAO.Implementacion.ProvinciaDAOImplementacionSQL;
import edu.usal.negocio.DAO.Implementacion.VuelosDAOImplementacionSQL;
import edu.usal.negocio.DAO.Interfaces.AeropuertoDAO;
import edu.usal.negocio.DAO.Interfaces.LineasAereasDAO;
import edu.usal.negocio.DAO.Interfaces.PaisDAO;
import edu.usal.negocio.DAO.Interfaces.ProvinciaDAO;
import edu.usal.negocio.DAO.Interfaces.VuelosDAO;
import edu.usal.negocio.Dominio.Aeropuerto;
import edu.usal.negocio.Dominio.Alianzas;
import edu.usal.negocio.Dominio.LineasAereas;
import edu.usal.negocio.Dominio.Pais;
import edu.usal.negocio.Dominio.Provincia;
import edu.usal.negocio.Dominio.Vuelos;

public class pruebaSQL {

	public static void main(String[] args) {
		
		
		
		//-------------------LINEAS AEREAS-------------------------
//		LineasAereasDAO lineas = new LineasAereasDAOImplementacionSQL();
//		
//		LineasAereas la4 = new LineasAereas(Alianzas.Adria_Airways, 1, "Adria Airways");
//		LineasAereas la5 = new LineasAereas(Alianzas.Aerolíneas_Argentinas, 2, "Aerolineas Argentinas");
//		LineasAereas la6 = new LineasAereas(Alianzas.Aeromexico, 3, "Aeromexico");
//		LineasAereas la7 = new LineasAereas(Alianzas.Air_Europa, 4, "Air Europa");
//		LineasAereas la8 = new LineasAereas(Alianzas.Air_New_Zealand_Link, 5, "Air New Zealand");
//		LineasAereas la9 = new LineasAereas(Alianzas.American_Airlines, 6, "American Airlines");
//		LineasAereas la10 = new LineasAereas(Alianzas.British_Airways, 7, "British Airlines");
//		LineasAereas la11 = new LineasAereas(Alianzas.Delta_Air_Lines, 8, "Delta Airlines");
//		LineasAereas la12 = new LineasAereas(Alianzas.LAN_Argentina, 9, "LAN");
//		LineasAereas la13 = new LineasAereas(Alianzas.Qatar_Airways, 10, "Qatar Ariways");
//		LineasAereas la14 = new LineasAereas(Alianzas.United_Airlines, 11, "United Airlines");
//		LineasAereas la15 = new LineasAereas(Alianzas.Portugalia, 12, "Portugalia");
//		LineasAereas la16 = new LineasAereas(Alianzas.Air_Mauritius, 13, "Maurito Airlines");
//		LineasAereas la17 = new LineasAereas(Alianzas.KLM, 14, "KLM");
//		
//		try {
//			lineas.crearLineaAerea(la4);
//			lineas.crearLineaAerea(la5);
//			lineas.crearLineaAerea(la6);
//			lineas.crearLineaAerea(la7);
//			lineas.crearLineaAerea(la8);
//			lineas.crearLineaAerea(la9);
//			lineas.crearLineaAerea(la10);
//			lineas.crearLineaAerea(la11);
//			lineas.crearLineaAerea(la12);
//			lineas.crearLineaAerea(la13);
//			lineas.crearLineaAerea(la14);
//			lineas.crearLineaAerea(la15);
//			lineas.crearLineaAerea(la16);
//			lineas.crearLineaAerea(la17);
//		} catch (ClassNotFoundException | IOException | SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		try {
//			ld.actualizarLineaAerea(la1);
//		} catch (ClassNotFoundException | IOException | SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		try {
//			ld.eliminarLineaAerea(2);
//		} catch (ClassNotFoundException | IOException | SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		try {
//			LineasAereas ln = ld.obtenerLineaAerea(3);
//			System.out.println(ln.toString());
//		} catch (ClassNotFoundException | IOException | SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

//		try {
//			List<LineasAereas> ln = lineas.obtenerLineasAereas();
//			for(LineasAereas a : ln) {
//				System.out.println(a.toString());
//			}
//		} catch (ClassNotFoundException | IOException | SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		//-----------------------------------VUELOS----------------------------
		
		Date hoy = Calendar.getInstance().getTime();
		Pais pais1 = new Pais(1, "Argentina");
		Provincia prov1 = new Provincia(1, "Buenos Aires");
		Pais pais2 = new Pais(2, "Estados Unidos");
		Provincia prov2 = new Provincia(2, "Salta");
		Provincia pr4 = new Provincia(4,"Los Angeles");
		Aeropuerto AE11 = new Aeropuerto(1, "Buenos Aires", "JFK", pais1, prov1);
		Aeropuerto AE12 = new Aeropuerto(2, "California", "LAX", pais2, prov2);
		LineasAereas la1 = new LineasAereas(Alianzas.Aerolíneas_Argentinas, 2, "Aerolineas Argentinas");
		Vuelos v1 = new Vuelos(1,"AA-0001",36,"8Hs",la1,AE11,AE12,hoy,hoy);
		Pais p3 = new Pais(3,"Costa Rica");
		Provincia pr3 = new Provincia(3,"Rio negro"); 
		
		
		VuelosDAO vd = new VuelosDAOImplementacionSQL();
		
//		try {
//			vd.crearVuelo(v1);
//		} catch (ClassNotFoundException | IOException | SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		//-------------------------PROVINCIA-----------------------
		ProvinciaDAO pv = new ProvinciaDAOImplementacionSQL();
		

		
//		try {
//			Hashtable<Integer, String> hashprov = pv.obtenerProvincias();
//			Enumeration<Integer> val = hashprov.keys();
//			Enumeration<String> val1 = hashprov.elements();
//			while(val.hasMoreElements()) {
//				System.out.println(val.nextElement()+" "+val1.nextElement());
//			}
//		} catch (ClassNotFoundException | IOException | SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		try {
//			pv.crearProvincia(prov2);
//			pv.crearProvincia(pr3);
//		} catch (ClassNotFoundException | SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		try {
//			pv.actualizarProvincia(pr3);
//		} catch (ClassNotFoundException | SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		try {
//			pv.eliminarProvincia(3);
//		} catch (ClassNotFoundException | SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		//--------------------------PAIS---------------------------
		PaisDAO pp = new PaisDAOImplementacionSQL();
		
//		try {
//			pp.crearPais(pais1);
//			pp.crearPais(pais2);
//			pp.crearPais(p3);
//		} catch (ClassNotFoundException | SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		try {
//			pp.actualizarPais(p3);
//		} catch (ClassNotFoundException | SQLException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		
//		try {
//			pp.eliminarPais(2);
//		} catch (ClassNotFoundException | SQLException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		
//		try {
//			Hashtable<Integer, String> haspais = pp.obtenerPaises();
//			Enumeration<Integer> en = haspais.keys();
//			Enumeration<String> en1 = haspais.elements();
//			while(en.hasMoreElements() || en1.hasMoreElements()) {
//				System.out.println(en.nextElement().toString()+" "+en1.nextElement().toString());
//			}
//		} catch (ClassNotFoundException | IOException | SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		//-----------------------------AEROPUERTO-------------------------
		
		AeropuertoDAO ae = new AeropuertoDAOImplementacionSQL();
		
//		try {
//			ae.crearAeropuerto(AE11);
//			ae.crearAeropuerto(AE12);
//		} catch (ClassNotFoundException | IOException | SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		try {
//			ae.actualizarAeropuerto(AE12);
//		} catch (ClassNotFoundException | IOException | SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		try {
//			ae.eliminarAeropuerto(2);
//		} catch (ClassNotFoundException | IOException | SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		try {
//			Aeropuerto a = ae.obtenerAeropuerto(1);
//			System.out.println(a.toString());
//		} catch (ClassNotFoundException | IOException | SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		try {
//			List<Aeropuerto> aer = ae.obtenerAeropuertos();
//			for(Aeropuerto a : aer) {
//				System.out.println(a.toString());
//			}
//		} catch (ClassNotFoundException | IOException | SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}


	}
}
