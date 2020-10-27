package edu.usal.negocio.DAO.Factory;

import edu.usal.negocio.DAO.Implementacion.PaisDAOImplementacionSQL;
import edu.usal.negocio.DAO.Implementacion.PaisDAOImplementacionString;
import edu.usal.negocio.DAO.Interfaces.PaisDAO;

public class PaisFactory {
	
	public static PaisDAO obtenerImplementacion(String selec) {
		if(selec.equalsIgnoreCase("SQL")) {
			return new PaisDAOImplementacionSQL();
		} else if(selec.equalsIgnoreCase("String")) {
			return new PaisDAOImplementacionString();
		}
		return null;
	}

}
