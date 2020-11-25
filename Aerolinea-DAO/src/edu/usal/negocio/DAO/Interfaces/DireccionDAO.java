package edu.usal.negocio.DAO.Interfaces;

import java.sql.SQLException;

import edu.usal.negocio.Dominio.Cliente;
import edu.usal.negocio.Dominio.Direccion;

public interface DireccionDAO {
	
	Direccion obtenerDireccion(int idDireccion) throws ClassNotFoundException, SQLException;
	void crearDireccion(Cliente cliente) throws ClassNotFoundException, SQLException;
	void actualizarDireccion(Cliente cliente) throws ClassNotFoundException, SQLException;
	boolean eliminarDireccion(Cliente cliente) throws ClassNotFoundException, SQLException;

}
