package edu.usal.negocio.DAO.Interfaces;

import java.sql.SQLException;

import edu.usal.negocio.Dominio.Cliente;
import edu.usal.negocio.Dominio.Telefono;

public interface TelefonoDAO {
	
	Telefono obtenerTelefono(int idTelefono) throws ClassNotFoundException, SQLException;
	void crearTelefono(Cliente cliente) throws ClassNotFoundException, SQLException;
	void actualizarTelefono(Cliente cliente) throws ClassNotFoundException, SQLException;
	boolean eliminarTelefono(Cliente cliente) throws ClassNotFoundException, SQLException;

}
