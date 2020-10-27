package edu.usal.negocio.DAO.Factory;

import edu.usal.negocio.DAO.Implementacion.ProvinciaDAOImplementacionSQL;
import edu.usal.negocio.DAO.Implementacion.ProvinciaDAOImplementacionString;
import edu.usal.negocio.DAO.Interfaces.ProvinciaDAO;

public class ProvinciaFactory {
	
	public static ProvinciaDAO obtenerImplementacion(String selec) {
		if (selec.equalsIgnoreCase("SQL")) {
			return new ProvinciaDAOImplementacionSQL();
		} else if(selec.equalsIgnoreCase("String")) {
			return new ProvinciaDAOImplementacionString();
		}
		return null;
	}

}
