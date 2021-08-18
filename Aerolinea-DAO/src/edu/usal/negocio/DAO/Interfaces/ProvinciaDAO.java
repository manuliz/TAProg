package edu.usal.negocio.DAO.Interfaces;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Hashtable;
import java.util.List;

import edu.usal.negocio.Dominio.Provincia;

public interface ProvinciaDAO {
	
	public Hashtable<Integer, String> obtenerProvincias() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException;;
	Provincia obtenerProvincia(int idProvincia) throws ClassNotFoundException, SQLException;
	void crearProvincia(Provincia prov) throws ClassNotFoundException, SQLException, IOException;
	void actualizarProvincia(Provincia prov) throws ClassNotFoundException, SQLException;
	void eliminarProvincia(int idProvincia) throws ClassNotFoundException, SQLException;
	
}
