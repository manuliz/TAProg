package edu.usal.negocio.DAO.Interfaces;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Hashtable;
import java.util.List;

import edu.usal.negocio.Dominio.Pais;
import edu.usal.negocio.Dominio.Provincia;

public interface PaisDAO {
	
	public Hashtable<Integer, String> obtenerPaises() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException;
	
	void crearPais(Pais pais) throws ClassNotFoundException, SQLException;
	void actualizarPais(Pais pais) throws ClassNotFoundException, SQLException;
	void eliminarPais(int idPais) throws ClassNotFoundException, SQLException;

}
