package edu.usal.negocio.DAO.Interfaces;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import edu.usal.negocio.Dominio.Pais;

public interface PaisDAO {
	
	Pais obtenerPais(String nomPais) throws FileNotFoundException, IOException;
	List<Pais> obtenerPaises() throws FileNotFoundException, IOException;

}
