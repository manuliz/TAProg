package edu.usal.negocio.DAO.Implementacion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import edu.usal.Util.Conexion;
import edu.usal.negocio.DAO.Interfaces.PasaporteDAO;
import edu.usal.negocio.Dominio.Cliente;
import edu.usal.negocio.Dominio.Pasaporte;

public class PasaporteDAOImplementacionSQL implements PasaporteDAO{
	
	private Connection conn;
	private PreparedStatement pstm;
	private ResultSet rst;
	private String query;
	
	private Date TimestampADate(Timestamp ts) {
		java.util.Date d = new java.util.Date(ts.getTime());
		return d;
	}
	
	private Timestamp DateATimestamp(java.util.Date d) {
		Timestamp ts = new Timestamp(d.getTime());
		return ts;
	}
	
	public Pasaporte obtenerPasaporte(int idPasaporte) throws ClassNotFoundException, SQLException {
		query="SELECT * FROM bdaerolinea.pasaporte WHERE idPasaporte=?";
		Pasaporte pasap = new Pasaporte();
		conn=Conexion.obtenerConexion();
		pstm=conn.prepareStatement(query);
		pstm.setInt(1, idPasaporte);
		rst=pstm.executeQuery();
		while(rst.next()) {
			pasap.setIdPasaporte(rst.getInt(1));
			pasap.setNumDePasaporte(rst.getString(2));
			pasap.setAutoridadDeEmision(rst.getString(3));
			pasap.setPaisDeEmision(rst.getString(4));
			pasap.setFechaEmision(TimestampADate(rst.getTimestamp(5)));
			pasap.setFechaVencimiento(TimestampADate(rst.getTimestamp(6)));
		}
		Conexion.cerrarPrepStatement(pstm);
		Conexion.cerrarResultSet(rst);
		return pasap;
	}
	
	public void crearPasaporte(Cliente cliente) throws ClassNotFoundException, SQLException {
		query="INSERT INTO bdaerolinea.pasaporte VALUES (?,?,?,?,?,?)";
		conn=Conexion.obtenerConexion();
		conn.setAutoCommit(false);
		pstm=conn.prepareStatement(query);
		pstm.setInt(1, cliente.getPasaporte().getIdPasaporte());
		pstm.setString(2, cliente.getPasaporte().getNumDePasaporte());
		pstm.setString(3, cliente.getPasaporte().getAutoridadDeEmision());
		pstm.setString(4, cliente.getPasaporte().getPaisDeEmision());
		pstm.setTimestamp(5, DateATimestamp(cliente.getPasaporte().getFechaEmision()));
		pstm.setTimestamp(6, DateATimestamp(cliente.getPasaporte().getFechaVencimiento()));
		int pos = pstm.executeUpdate();
		if(pos==1) {
			conn.commit();
			Conexion.cerrarPrepStatement(pstm);
		} else {
			conn.rollback();
			Conexion.cerrarPrepStatement(pstm);
			Conexion.cerrarConexion(conn);
			System.out.println("No se pudo generar el pasaporte.");}
	}
	
	public void actualizarPasaporte(Cliente cliente) throws ClassNotFoundException, SQLException {
		query="UPDATE bdaerolinea.pasaporte SET numDePasaporte=?, autoridadDeEmision=?, paisDeEmision=?,"
				+ " fechaEmision=?, fechaVensimiento=? WHERE idPasaporte=?";
		conn=Conexion.obtenerConexion();
		conn.setAutoCommit(false);
		pstm=conn.prepareStatement(query);
		pstm.setString(1, cliente.getPasaporte().getNumDePasaporte());
		pstm.setString(2, cliente.getPasaporte().getAutoridadDeEmision());
		pstm.setString(3, cliente.getPasaporte().getPaisDeEmision());
		pstm.setTimestamp(4, DateATimestamp(cliente.getPasaporte().getFechaEmision()));
		pstm.setTimestamp(5, DateATimestamp(cliente.getPasaporte().getFechaVencimiento()));
		pstm.setInt(6, cliente.getPasaporte().getIdPasaporte());
		int pos = pstm.executeUpdate();
		if(pos==1) {
			conn.commit();
			Conexion.cerrarPrepStatement(pstm);
		} else {
			conn.rollback();
			Conexion.cerrarPrepStatement(pstm);
			Conexion.cerrarConexion(conn);
			System.out.println("No se pudo actualizar el pasaporte!");}
	}
	
	public boolean eliminarPasaporte(Cliente cliente) throws ClassNotFoundException, SQLException {
		query="DELETE FROM bdaerolinea.pasaporte WHERE idPasaporte=?";
		conn=Conexion.obtenerConexion();
		conn.setAutoCommit(false);
		pstm=conn.prepareStatement(query);
		pstm.setInt(1, cliente.getPasaporte().getIdPasaporte());
		int pos = pstm.executeUpdate();
		if(pos==1) {
			conn.commit();
			Conexion.cerrarPrepStatement(pstm);
			return true;
		} else {
			conn.rollback();
			Conexion.cerrarPrepStatement(pstm);
			Conexion.cerrarConexion(conn);
			System.out.println("No se pudo eliminar el pasaporte!");
			return false;
			}
	}
}
