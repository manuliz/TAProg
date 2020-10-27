package edu.usal.negocio.DAO.Factory;

import edu.usal.negocio.DAO.Implementacion.LineasAereasDAOImplementacionSQL;
import edu.usal.negocio.DAO.Implementacion.LineasAereasDAOImplementacionStream;
import edu.usal.negocio.DAO.Interfaces.LineasAereasDAO;

public class LineasAereasFactory {
	
	public static LineasAereasDAO obtenerImplementacion(String selec) {
		if(selec.equalsIgnoreCase("SQL")) {
			return new LineasAereasDAOImplementacionSQL();
		} else if(selec.equalsIgnoreCase("Stream")){
			return new LineasAereasDAOImplementacionStream();
		}
		return null;
	}

}
