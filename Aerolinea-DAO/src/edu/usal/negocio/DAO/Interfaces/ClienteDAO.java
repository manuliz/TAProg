package edu.usal.negocio.DAO.Interfaces;

import java.io.IOException;
import java.util.List;
import java.io.FileNotFoundException;
import edu.usal.negocio.dominio.Cliente;

public interface ClienteDAO {
	
	Cliente obtenerCliente(String dni) throws IOException, FileNotFoundException;
	List obtenerClientes() throws IOException, FileNotFoundException;
	void crearCliente(Cliente cliente) throws FileNotFoundException, IOException;
	void actualizarCliente(Cliente cliente) throws FileNotFoundException, IOException;
	void eliminarCliente(Cliente cliente) throws FileNotFoundException, IOException;
	

}
