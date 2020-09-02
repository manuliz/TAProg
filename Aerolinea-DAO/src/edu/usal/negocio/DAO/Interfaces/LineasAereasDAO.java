package edu.usal.negocio.DAO.Interfaces;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import edu.usal.negocio.Dominio.LineasAereas;

public interface LineasAereasDAO {
	
	LineasAereas obtenerLineaAerea(int idLineaAerea) throws FileNotFoundException, IOException, ClassNotFoundException, SQLException;
	List<LineasAereas> obtenerLineasAereas() throws FileNotFoundException, IOException;
	void crearLineaAerea(LineasAereas lineasAereas) throws FileNotFoundException, IOException, ClassNotFoundException, SQLException;
	void actualizarLineaAerea(LineasAereas lineasAereas) throws FileNotFoundException, IOException, ClassNotFoundException, SQLException;
	void eliminarLineaAerea(int idLineaAereas) throws FileNotFoundException, IOException, ClassNotFoundException, SQLException;

}
