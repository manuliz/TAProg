package edu.usal.negocio.DAO.Interfaces;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Hashtable;


public interface AlianzasDAO {
	
	public Hashtable<Integer, String> obtenerAlianzas() throws FileNotFoundException, IOException;

}
