package edu.usal.negocio.DAO.Interfaces;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import edu.usal.negocio.Dominio.Cliente;
import edu.usal.negocio.Dominio.Direccion;

public interface DireccionDAO {
	
	Direccion obtenerDireccion(int idDireccion, Connection conn, PreparedStatement pstm, ResultSet rst) throws ClassNotFoundException, SQLException;
	void crearDireccion(Cliente cliente, Connection conn, PreparedStatement pstm) throws ClassNotFoundException, SQLException;
	void actualizarDireccion(Cliente cliente, Connection conn, PreparedStatement pstm) throws ClassNotFoundException, SQLException;
	boolean eliminarDireccion(Cliente cliente, Connection conn, PreparedStatement pstm) throws ClassNotFoundException, SQLException;

}
