package edu.usal.negocio.DAO.Implementacion;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Hashtable;
import java.util.Scanner;

import edu.usal.Util.Conexion;
import edu.usal.negocio.DAO.Interfaces.ProvinciaDAO;
import edu.usal.negocio.Dominio.Provincia;

public class ProvinciaDAOImplementacionSQL implements ProvinciaDAO{

	private Connection conn;
	private PreparedStatement pstm;
	private ResultSet rst;
	private String query;

	@Override
	public Hashtable<Integer, String> obtenerProvincias() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		query="SELECT * FROM bdaerolinea.provincia";
		Hashtable<Integer, String> a = new Hashtable<>();
		conn=Conexion.obtenerConexion();
		pstm=conn.prepareStatement(query);
		rst=pstm.executeQuery();
		while(rst.next()) {
			a.put(rst.getInt(1), rst.getString(2));
		}
		Conexion.cerrarPrepStatement(pstm);
		Conexion.cerrarResultSet(rst);
		Conexion.cerrarConexion(conn);
		return a;
	}

	@Override
	public void crearProvincia(Provincia prov) throws ClassNotFoundException, SQLException {
		query="INSERT INTO bdaerolinea.provincia VALUES(?,?)";
		conn=Conexion.obtenerConexion();
		conn.setAutoCommit(false);
		pstm=conn.prepareStatement(query);
		pstm.setInt(1, prov.getIdProvincia());
		pstm.setString(2, prov.getNombreProvincia());
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
	public void actualizarProvincia(Provincia prov) throws ClassNotFoundException, SQLException {
		query="UPDATE bdaerolinea.provincia SET nombreProvincia=? WHERE idProvincia=?";
		conn=Conexion.obtenerConexion();
		conn.setAutoCommit(false);
		pstm=conn.prepareStatement(query);
		pstm.setString(1, prov.getNombreProvincia());
		pstm.setInt(2, prov.getIdProvincia());
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
	public void eliminarProvincia(int idProvincia) throws ClassNotFoundException, SQLException {
		query="DELETE FROM bdaerolinea.provincia WHERE idProvincia=?";
		conn=Conexion.obtenerConexion();
		conn.setAutoCommit(false);
		pstm=conn.prepareStatement(query);
		pstm.setInt(1, idProvincia);
		int pos=pstm.executeUpdate();
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
}
