package edu.usal.negocio.DAO.Interfaces;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import edu.usal.negocio.Dominio.Cliente;

public interface ClienteDAO {
	
	Cliente obtenerCliente(String dni) throws IOException, FileNotFoundException;
	List<Cliente> obtenerClientes() throws IOException, FileNotFoundException;
	void crearCliente(Cliente cliente) throws FileNotFoundException, IOException;
	void actualizarCliente(Cliente cliente) throws FileNotFoundException, IOException;
	void eliminarCliente(Cliente cliente) throws FileNotFoundException, IOException;

}
