package edu.usal.negocio.DAO.Interfaces;

import java.sql.SQLException;

import edu.usal.Util.Conexion;
import edu.usal.negocio.Dominio.Cliente;
import edu.usal.negocio.Dominio.Pasaporte;

public interface PasaporteDAO {
	
	Pasaporte obtenerPasaporte(int idPasaporte) throws ClassNotFoundException, SQLException;
	void crearPasaporte(Cliente cliente) throws ClassNotFoundException, SQLException;
	void actualizarPasaporte(Cliente cliente) throws ClassNotFoundException, SQLException;
	boolean eliminarPasaporte(Cliente cliente) throws ClassNotFoundException, SQLException;

}
