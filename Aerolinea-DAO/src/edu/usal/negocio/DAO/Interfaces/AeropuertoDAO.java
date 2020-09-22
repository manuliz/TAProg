package edu.usal.negocio.DAO.Interfaces;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import edu.usal.negocio.Dominio.Aeropuerto;

public interface AeropuertoDAO {
	
	Aeropuerto obtenerAeropuerto(int idCiudad) throws FileNotFoundException, IOException, SQLException, ClassNotFoundException;
	List<Aeropuerto> obtenerAeropuertos() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException;
	void crearAeropuerto(Aeropuerto aero) throws FileNotFoundException, IOException, ClassNotFoundException, SQLException;
	void actualizarAeropuerto(Aeropuerto aero) throws FileNotFoundException, IOException, ClassNotFoundException, SQLException;
	void eliminarAeropuerto(int idAero) throws FileNotFoundException, IOException, ClassNotFoundException, SQLException;

}
