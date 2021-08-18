package edu.usal.negocio.DAO.Interfaces;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import edu.usal.negocio.Dominio.Ventas;

public interface VentasDAO {
	
	Ventas obtenerVenta(int idVenta) throws FileNotFoundException, IOException, ClassNotFoundException, SQLException;
	List<Ventas> obtenerVentas() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException;
	void crearVenta(Ventas venta) throws FileNotFoundException, IOException, ClassNotFoundException, SQLException;
	void actualizarVenta(Ventas venta) throws FileNotFoundException, IOException, ClassNotFoundException, SQLException;
	void eliminarVenta(int id) throws FileNotFoundException, IOException, ClassNotFoundException, SQLException;
	 
}

