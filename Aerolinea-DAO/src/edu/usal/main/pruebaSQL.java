package edu.usal.main;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

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
		
		Date hoy = Calendar.getInstance().getTime();
		Pais pais1 = new Pais(1, "Argentina");
		Provincia prov1 = new Provincia(1, "Catamarca");
		Aeropuerto AE11 = new Aeropuerto(1, "BSAS", "JFK", pais1, prov1);
		Aeropuerto AE12 = new Aeropuerto(2, "CATAMARCA", "CATA", pais1, prov1);
		LineasAereas la1 = new LineasAereas(Alianzas.Aerolíneas_Argentinas, 4, "PAL");
		Vuelos v1 = new Vuelos(1, 2223, 5 , 1244, "12hs", la1, AE11, AE12, hoy, hoy);
		
		
		VuelosDAO vd = new VuelosDAOImplementacionSQL();
		LineasAereasDAO ld = new LineasAereasDAOImplementacionSQL();
		
		try {
			ld.crearLineaAerea(la1);
		} catch (ClassNotFoundException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		try {
//			vd.crearVuelo(v1);
//		} catch (ClassNotFoundException | IOException | SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	}

}
