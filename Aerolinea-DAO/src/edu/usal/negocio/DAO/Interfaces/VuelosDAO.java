package edu.usal.negocio.DAO.Interfaces;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import edu.usal.negocio.Dominio.Vuelos;

public interface VuelosDAO {
	
	Vuelos obtenerVuelo(String numVuelo) throws FileNotFoundException, IOException, ClassNotFoundException, SQLException;
	List<Vuelos> obtenerVuelos() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException;
	void crearVuelo(Vuelos vuelo) throws FileNotFoundException, IOException, ClassNotFoundException, SQLException;
	void actualizarVuelo(Vuelos vuelo) throws FileNotFoundException, IOException, ClassNotFoundException, SQLException;
	void eliminarVuelo(String numVuelo) throws FileNotFoundException, IOException, ClassNotFoundException, SQLException;

}
