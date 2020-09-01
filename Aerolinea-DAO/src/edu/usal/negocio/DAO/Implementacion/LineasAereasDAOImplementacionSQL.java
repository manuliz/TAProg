package edu.usal.negocio.DAO.Implementacion;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import edu.usal.Util.Conexion;
import edu.usal.negocio.DAO.Interfaces.LineasAereasDAO;
import edu.usal.negocio.Dominio.Alianzas;
import edu.usal.negocio.Dominio.LineasAereas;

public final class LineasAereasDAOImplementacionSQL implements LineasAereasDAO{

	private Connection conn;
	private PreparedStatement pstm;
	private String query;
	
	private String Alianzas1 (Alianzas alianza) {
		String alianza1 = String.valueOf(alianza);
		return alianza1;
	}
	
	
	@Override
	public LineasAereas obtenerLineaAerea(int idLineaAerea) throws FileNotFoundException, IOException {
		
		return null;
	}

	@Override
	public List<LineasAereas> obtenerLineasAereas() throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void crearLineaAerea(LineasAereas lineasAereas) throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		
		query="INSERT INTO bdaerolinea.aerolinea VALUES (?,?,?)";
		conn=Conexion.obtenerConexion();
		conn.setAutoCommit(false);
		pstm=conn.prepareStatement(query);
		pstm.setString(1,Alianzas1(lineasAereas.getAlianzas()));
		pstm.setInt(2, lineasAereas.getIdLineasAereas());
		pstm.setString(3, lineasAereas.getNombreAerolinea());
		
		int pos = pstm.executeUpdate();
		if(pos==1) {
			conn.commit();
			Conexion.cerrarPrepStatement(pstm);
			Conexion.cerrarConexion(conn);		
		}else {
			conn.rollback();
			Conexion.cerrarPrepStatement(pstm);
			Conexion.cerrarConexion(conn);
			System.out.println("No se pudo completar la transaccion.");
			}
	}

	@Override
	public void actualizarLineaAerea(LineasAereas lineasAereas) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarLineaAerea(LineasAereas lineasAereas) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		
	}

}
