package edu.usal.negocio.DAO.Interfaces;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import edu.usal.negocio.Dominio.Cliente;
import edu.usal.negocio.Dominio.Telefono;

public interface TelefonoDAO {
	
	Telefono obtenerTelefono(int idTelefono, Connection conn, PreparedStatement pstm, ResultSet rst) throws ClassNotFoundException, SQLException;
	void crearTelefono(Cliente cliente, Connection conn, PreparedStatement pstm) throws ClassNotFoundException, SQLException;
	void actualizarTelefono(Cliente cliente, Connection conn, PreparedStatement pstm) throws ClassNotFoundException, SQLException;
	boolean eliminarTelefono(Cliente cliente, Connection conn, PreparedStatement pstm) throws ClassNotFoundException, SQLException;

}
