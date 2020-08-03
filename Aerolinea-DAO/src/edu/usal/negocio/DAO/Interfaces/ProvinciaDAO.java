package edu.usal.negocio.DAO.Interfaces;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Hashtable;
import java.util.List;

import edu.usal.negocio.Dominio.Provincia;

public interface ProvinciaDAO {
	
	public Hashtable<Integer, String> obtenerProvincias() throws FileNotFoundException, IOException;;
	
}
