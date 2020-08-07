package edu.usal.negocio.DAO.Interfaces;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import edu.usal.negocio.Dominio.Ventas;

public interface VentasDAO {
	
	Ventas obtenerVenta(int idVenta) throws FileNotFoundException, IOException;
	List<Ventas> obtenerVentas() throws FileNotFoundException, IOException;
	void crearVenta(Ventas venta) throws FileNotFoundException, IOException;
	void actualizarVenta(Ventas venta) throws FileNotFoundException, IOException;
	void eliminarVenta(Ventas venta) throws FileNotFoundException, IOException;
	 
}

