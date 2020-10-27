package edu.usal.negocio.DAO.Factory;

import edu.usal.negocio.DAO.Implementacion.VentasDAOImplementacionStream;
import edu.usal.negocio.DAO.Interfaces.VentasDAO;

public class VentasFactory {
	
	public static VentasDAO obtenerImplementacion(String selec) {
		if(selec.equalsIgnoreCase("Stream")) {
			return new VentasDAOImplementacionStream();
		}
		return null;
	}

}
