package edu.usal.negocio.DAO.Interfaces;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import edu.usal.negocio.Dominio.Aeropuerto;

public interface AeropuertoDAO {
	
	Aeropuerto obtenerAeropuerto(int idCiudad) throws FileNotFoundException, IOException;
	List<Aeropuerto> obtenerAeropuertos() throws FileNotFoundException, IOException;
	void crarAeropuerto(Aeropuerto aero) throws FileNotFoundException, IOException;
	void actualizarAeropuerto(Aeropuerto aero) throws FileNotFoundException, IOException;
	void aliminarAeropuerto(Aeropuerto aero) throws FileNotFoundException, IOException;

}
