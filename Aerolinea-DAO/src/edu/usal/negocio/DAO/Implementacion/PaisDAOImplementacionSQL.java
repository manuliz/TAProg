package edu.usal.negocio.DAO.Implementacion;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Hashtable;

import edu.usal.Util.Conexion;
import edu.usal.negocio.DAO.Interfaces.PaisDAO;
import edu.usal.negocio.Dominio.Pais;

public class PaisDAOImplementacionSQL implements PaisDAO{
	
	private Connection conn;
	private PreparedStatement pstm;
	private ResultSet rst;
	private String query;
	
	
	@Override
	public Hashtable<Integer, String> obtenerPaises() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		query="SELECT * FROM bdaerolinea.pais";
		Hashtable<Integer, String> haspais = new Hashtable<>();
		conn=Conexion.obtenerConexion();
		conn.setAutoCommit(false);
		pstm=conn.prepareStatement(query);
		rst=pstm.executeQuery();
		while(rst.next()) {
			haspais.put(rst.getInt(1), rst.getString(2));
		}
		Conexion.cerrarResultSet(rst);
		Conexion.cerrarPrepStatement(pstm);
		Conexion.cerrarConexion(conn);
		return haspais;
	}

	@Override
	public void crearPais(Pais pais) throws ClassNotFoundException, SQLException {
		query="INSERT INTO bdaerolinea.pais VALUES (?,?)";
		conn=Conexion.obtenerConexion();
		conn.setAutoCommit(false);
		pstm=conn.prepareStatement(query);
		pstm.setInt(1, pais.getIdPais());
		pstm.setString(2, pais.getNombrePais());
		int pos = pstm.executeUpdate();
		if(pos==1) {
			conn.commit();
			Conexion.cerrarPrepStatement(pstm);
			Conexion.cerrarConexion(conn);
		} else {
			conn.rollback();
			Conexion.cerrarPrepStatement(pstm);
			Conexion.cerrarConexion(conn);
		}
	}

	@Override
	public void actualizarPais(Pais pais) throws ClassNotFoundException, SQLException {
		query="UPDATE bdaerolinea.pais SET nombrePais=? WHERE idPais=?";
		conn=Conexion.obtenerConexion();
		conn.setAutoCommit(false);
		pstm=conn.prepareStatement(query);
		pstm.setInt(2, pais.getIdPais());
		pstm.setString(1, pais.getNombrePais());
		int pos = pstm.executeUpdate();
		if(pos == 1) {
			conn.commit();
			Conexion.cerrarPrepStatement(pstm);
			Conexion.cerrarConexion(conn);
		} else {
			conn.rollback();
			Conexion.cerrarPrepStatement(pstm);
			Conexion.cerrarConexion(conn);
		}
	}

	@Override
	public void eliminarPais(int idPais) throws ClassNotFoundException, SQLException {
		query="DELETE FROM bdaerolinea.pais WHERE idPais=?";
		conn=Conexion.obtenerConexion();
		conn.setAutoCommit(false);
		pstm=conn.prepareStatement(query);
		pstm.setInt(1, idPais);
		int pos = pstm.executeUpdate();
		if(pos == 1) {
			conn.commit();
			Conexion.cerrarPrepStatement(pstm);
			Conexion.cerrarConexion(conn);
		} else {
			conn.rollback();
			Conexion.cerrarPrepStatement(pstm);
			Conexion.cerrarConexion(conn);
		}
	}
}
