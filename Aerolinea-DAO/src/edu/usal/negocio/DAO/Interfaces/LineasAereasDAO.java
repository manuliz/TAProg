package edu.usal.negocio.DAO.Interfaces;

import java.util.List;

import edu.usal.negocio.Dominio.LineasAereas;

public interface LineasAereasDAO {
	
	LineasAereas obtenerLineaAerea(int idLineaAerea);
	List<LineasAereas> obtenerLineasAereas();
	void crearLineaAerea(LineasAereas lineasAereas);
	void actualizarLineaAerea(LineasAereas lineasAereas);
	void eliminarLineaAerea(LineasAereas lineasAereas);

}
