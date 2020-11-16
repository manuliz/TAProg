package edu.usal.negocio.DAO.Interfaces;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import edu.usal.negocio.Dominio.Cliente;

public interface ClienteDAO {
	
	Cliente obtenerCliente(String dni) throws IOException, FileNotFoundException, ClassNotFoundException, SQLException;
	List<Cliente> obtenerClientes() throws IOException, FileNotFoundException, ClassNotFoundException, SQLException;
	void crearCliente(Cliente cliente) throws FileNotFoundException, IOException, ClassNotFoundException, SQLException;
	void actualizarCliente(Cliente cliente) throws FileNotFoundException, IOException, ClassNotFoundException, SQLException;
	void eliminarCliente(Cliente cliente) throws FileNotFoundException, IOException, ClassNotFoundException, SQLException;

}
