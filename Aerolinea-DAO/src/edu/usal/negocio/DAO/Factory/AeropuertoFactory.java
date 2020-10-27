package edu.usal.negocio.DAO.Factory;

import edu.usal.negocio.DAO.Implementacion.AeropuertoDAOImplementacionSQL;
import edu.usal.negocio.DAO.Implementacion.AeropuertoDAOImplementacionStream;
import edu.usal.negocio.DAO.Interfaces.AeropuertoDAO;

public class AeropuertoFactory {
	
	public static AeropuertoDAO obtenerImplementacion(String selec) {
		if(selec.equalsIgnoreCase("SQL")) {
			return new AeropuertoDAOImplementacionSQL();
		} else if(selec.equalsIgnoreCase("Stream")) {
			return new AeropuertoDAOImplementacionStream();
		}
		return null;
	}

}
