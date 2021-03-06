package edu.usal.negocio.DAO.Factory;

import edu.usal.negocio.DAO.Implementacion.ClienteDAOImplementacionSQL;
import edu.usal.negocio.DAO.Implementacion.ClienteDAOImplementacionStream;
import edu.usal.negocio.DAO.Interfaces.ClienteDAO;

public class ClienteFactory {
	
	public static ClienteDAO obtenerImplementacion(String selec) {
		if(selec.equalsIgnoreCase("Stream")) {
			return new ClienteDAOImplementacionStream();
		} else if(selec.equalsIgnoreCase("SQL")) {
			return new ClienteDAOImplementacionSQL();
		}
		return null;
	}

}
