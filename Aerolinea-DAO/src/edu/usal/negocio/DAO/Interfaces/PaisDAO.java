package edu.usal.negocio.DAO.Interfaces;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Hashtable;
import java.util.List;

import edu.usal.negocio.Dominio.Pais;

public interface PaisDAO {
	
	public Hashtable<Integer, String> obtenerPaises() throws FileNotFoundException, IOException;;

}
