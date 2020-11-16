package edu.usal.negocio.DAO.Interfaces;

import java.sql.SQLException;

import edu.usal.negocio.Dominio.Cliente;
import edu.usal.negocio.Dominio.PasajeroFrecuente;

public interface PasajeroFrecuenteDAO {
	
	PasajeroFrecuente obtenerPasajeroFrecuente(int idPasajeroFrecuente) throws ClassNotFoundException, SQLException;
	void crearPasajeroFrecuente(Cliente cliente) throws ClassNotFoundException, SQLException;
	void actualizarPasajeroFrecuente(Cliente cliente) throws ClassNotFoundException, SQLException;
	void eliminarPasajeroFrecuente(Cliente cliente) throws ClassNotFoundException, SQLException;

}
