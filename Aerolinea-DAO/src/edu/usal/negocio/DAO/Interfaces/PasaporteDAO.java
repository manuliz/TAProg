package edu.usal.negocio.DAO.Interfaces;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import edu.usal.Util.Conexion;
import edu.usal.negocio.Dominio.Cliente;
import edu.usal.negocio.Dominio.Pasaporte;

public interface PasaporteDAO {
	
	Pasaporte obtenerPasaporte(int idPasaporte, Connection conn, PreparedStatement pstm, ResultSet rst) throws ClassNotFoundException, SQLException, FileNotFoundException, IOException;
	void crearPasaporte(Cliente cliente, Connection conn, PreparedStatement pstm) throws ClassNotFoundException, SQLException;
	void actualizarPasaporte(Cliente cliente, Connection conn, PreparedStatement pstm) throws ClassNotFoundException, SQLException;
	boolean eliminarPasaporte(Cliente cliente, Connection conn, PreparedStatement pstm) throws ClassNotFoundException, SQLException;

}
