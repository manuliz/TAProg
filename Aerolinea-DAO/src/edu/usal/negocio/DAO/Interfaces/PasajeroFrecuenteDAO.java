package edu.usal.negocio.DAO.Interfaces;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import edu.usal.negocio.Dominio.Cliente;
import edu.usal.negocio.Dominio.PasajeroFrecuente;

public interface PasajeroFrecuenteDAO {
	
	PasajeroFrecuente obtenerPasajeroFrecuente(int idPasajeroFrecuente, Connection conn, PreparedStatement pstm, ResultSet rst) throws ClassNotFoundException, SQLException, FileNotFoundException, IOException;
	void crearPasajeroFrecuente(Cliente cliente, Connection conn, PreparedStatement pstm) throws ClassNotFoundException, SQLException;
	void actualizarPasajeroFrecuente(Cliente cliente, Connection conn, PreparedStatement pstm) throws ClassNotFoundException, SQLException;
	boolean eliminarPasajeroFrecuente(Cliente cliente, Connection conn, PreparedStatement pstm) throws ClassNotFoundException, SQLException;

}
