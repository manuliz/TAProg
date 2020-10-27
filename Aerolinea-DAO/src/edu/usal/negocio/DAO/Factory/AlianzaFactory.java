package edu.usal.negocio.DAO.Factory;

import edu.usal.negocio.DAO.Implementacion.AlianzasDAOImplementacionString;
import edu.usal.negocio.DAO.Interfaces.AlianzasDAO;

public class AlianzaFactory {
	
	public static AlianzasDAO obtenerImplementacion(String selec) {
		if(selec.equalsIgnoreCase("String")) {
			return new AlianzasDAOImplementacionString();
		}
		return null;
	}

}
