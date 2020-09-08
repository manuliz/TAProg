package edu.usal.main;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import edu.usal.negocio.DAO.Implementacion.LineasAereasDAOImplementacionSQL;
import edu.usal.negocio.DAO.Implementacion.VuelosDAOImplementacionSQL;
import edu.usal.negocio.DAO.Interfaces.LineasAereasDAO;
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
		Pais pais2 = new Pais(2, "Argentina");
		Provincia prov2 = new Provincia(2, "Salta");
		Aeropuerto AE11 = new Aeropuerto(1, "Buenos Aires", "JFK", pais1, prov1);
		Aeropuerto AE12 = new Aeropuerto(2, "Salta", "Salta", pais2, prov2);
		LineasAereas la1 = new LineasAereas(Alianzas.Aerolíneas_Argentinas, 2, "Aerolineas Argentinas");
		Vuelos v1 = new Vuelos(1,"AA-0001",36,"8Hs",la1,AE11,AE12,hoy,hoy);
		
		VuelosDAO vd = new VuelosDAOImplementacionSQL();
		
		try {
			vd.crearVuelo(v1);
		} catch (ClassNotFoundException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
}
