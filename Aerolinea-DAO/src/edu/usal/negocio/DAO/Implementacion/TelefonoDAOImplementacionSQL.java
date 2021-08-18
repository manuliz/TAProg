package edu.usal.negocio.DAO.Implementacion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import edu.usal.Util.Conexion;
import edu.usal.negocio.DAO.Interfaces.TelefonoDAO;
import edu.usal.negocio.Dominio.Cliente;
import edu.usal.negocio.Dominio.Telefono;

public class TelefonoDAOImplementacionSQL implements TelefonoDAO{
	
//	private Connection conn;
//	private PreparedStatement pstm;
//	private ResultSet rst;
	private String query;
	
	public Telefono obtenerTelefono(int idTelefono, Connection conn, PreparedStatement pstm, ResultSet rst) throws ClassNotFoundException, SQLException {
		query="Select * FROM bdaerolinea.telefono WHERE idTelefono=?";
		Telefono tel = new Telefono();
		conn=Conexion.obtenerConexion();
		pstm=conn.prepareStatement(query);
		pstm.setInt(1, idTelefono);
		rst=pstm.executeQuery();
		while(rst.next()) {
			tel.setIdTelefono(rst.getInt(1));
			tel.setNumCelular(rst.getString(2));
			tel.setNumLaboral(rst.getString(3));
			tel.setNumPersonal(rst.getString(4));
		}
		Conexion.cerrarPrepStatement(pstm);
		Conexion.cerrarResultSet(rst);
		return tel;
	}
	
	public void crearTelefono(Cliente cliente, Connection conn, PreparedStatement pstm) throws ClassNotFoundException, SQLException {
		query="INSERT INTO bdaerolinea.telefono VALUES(?,?,?,?)";
		conn=Conexion.obtenerConexion();
		conn.setAutoCommit(false);
		pstm=conn.prepareStatement(query);
		pstm.setInt(1, cliente.getTelefono().getIdTelefono());
		pstm.setString(2, cliente.getTelefono().getNumCelular());
		pstm.setString(3, cliente.getTelefono().getNumLaboral());
		pstm.setString(4, cliente.getTelefono().getNumPersonal());
		int pos = pstm.executeUpdate();
		if(pos==1) {
			conn.commit();
			Conexion.cerrarPrepStatement(pstm);
		} else {
			conn.rollback();
			Conexion.cerrarPrepStatement(pstm);
			Conexion.cerrarConexion(conn);
			System.out.println("No se pudo crear el telefono!");}
	}
	
	public void actualizarTelefono(Cliente cliente, Connection conn, PreparedStatement pstm) throws ClassNotFoundException, SQLException {
		query="UPDATE bdaerolinea.telefono SET numCelular=?, numLaboral=?, numPersonal=? WHERE idTelefono=?";
		conn=Conexion.obtenerConexion();
		conn.setAutoCommit(false);
		pstm=conn.prepareStatement(query);
		pstm.setString(1, cliente.getTelefono().getNumCelular());
		pstm.setString(2, cliente.getTelefono().getNumLaboral());
		pstm.setString(3,cliente.getTelefono().getNumPersonal());
		pstm.setInt(4, cliente.getTelefono().getIdTelefono());
		int pos = pstm.executeUpdate();
		if(pos==1) {
			conn.commit();
			Conexion.cerrarPrepStatement(pstm);
		} else {
			conn.rollback();
			Conexion.cerrarPrepStatement(pstm);
			Conexion.cerrarConexion(conn);
			System.out.println("No se pudo actualizar el telefono!");}
	}
	
	public boolean eliminarTelefono(Cliente cliente, Connection conn, PreparedStatement pstm) throws ClassNotFoundException, SQLException {
		query="DELETE FROM bdaerolinea.telefono WHERE idTelefono=?";
		conn=Conexion.obtenerConexion();
		conn.setAutoCommit(false);
		pstm=conn.prepareStatement(query);
		pstm.setInt(1, cliente.getTelefono().getIdTelefono());
		int pos = pstm.executeUpdate();
		if(pos==1) {
			conn.commit();
			Conexion.cerrarPrepStatement(pstm);
			return true;
		} else {
			conn.rollback();
			Conexion.cerrarPrepStatement(pstm);
			Conexion.cerrarConexion(conn);
			System.out.println("No se pudo eliminar el telefono!");
			return false;
		}
	}

}
