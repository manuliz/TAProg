package edu.usal.negocio.DAO.Factory;

import edu.usal.negocio.DAO.Implementacion.VuelosDAOImplementacionSQL;
import edu.usal.negocio.DAO.Implementacion.VuelosDAOImplementacionStream;
import edu.usal.negocio.DAO.Interfaces.VuelosDAO;

public class VuelosFactory {
	
	public static VuelosDAO obtenerImplementacion(String selec) {
		if(selec.equalsIgnoreCase("SQL")) {
			return new VuelosDAOImplementacionSQL();
		} else if(selec.equalsIgnoreCase("Stream")) {
			return new VuelosDAOImplementacionStream();
		}
		return null;
	}

}
