package edu.usal.negocio.DAO.Interfaces;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import edu.usal.negocio.Dominio.Provincia;

public interface ProvinciaDAO {
	
	Provincia obtenerProvincia(String nomProvincia) throws FileNotFoundException, IOException;
	List<Provincia> obtenerProvincias() throws FileNotFoundException, IOException;

}
