package edu.usal.negocio.DAO.Interfaces;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import edu.usal.negocio.Dominio.Vuelos;

public interface VuelosDAO {
	
	Vuelos obtenerVuelo(int numVuelo) throws FileNotFoundException, IOException;
	List<Vuelos> obtenerVuelos() throws FileNotFoundException, IOException;
	void crearVuelo(Vuelos vuelo) throws FileNotFoundException, IOException;
	void actualizarVuelo(Vuelos vuelo) throws FileNotFoundException, IOException;
	void eliminarVuelo(Vuelos vuelo) throws FileNotFoundException, IOException;

}
