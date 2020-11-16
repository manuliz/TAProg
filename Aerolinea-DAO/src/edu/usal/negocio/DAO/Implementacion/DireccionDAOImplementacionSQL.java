package edu.usal.negocio.DAO.Implementacion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import edu.usal.Util.Conexion;
import edu.usal.negocio.DAO.Interfaces.DireccionDAO;
import edu.usal.negocio.DAO.Interfaces.PaisDAO;
import edu.usal.negocio.DAO.Interfaces.ProvinciaDAO;
import edu.usal.negocio.Dominio.Cliente;
import edu.usal.negocio.Dominio.Direccion;

public class DireccionDAOImplementacionSQL implements DireccionDAO{
	
	private Connection conn;
	private PreparedStatement pstm;
	private ResultSet rst;
	private String query;
	PaisDAO pd = new PaisDAOImplementacionSQL();
	ProvinciaDAO ppd = new ProvinciaDAOImplementacionSQL();
	
	public void crearDireccion(Cliente cliente) throws ClassNotFoundException, SQLException {
		query="INSERT INTO bdaerolinea.direccion VALUES(?,?,?,?,?,?,?)";
		conn=Conexion.obtenerConexion();
		conn.setAutoCommit(false);
		pstm=conn.prepareStatement(query);
		pstm.setInt(1,cliente.getDireccion().getIdDireccion());
		pstm.setInt(2, cliente.getDireccion().getPais().getIdPais());
		pstm.setInt(3, cliente.getDireccion().getProv().getIdProvincia());
		pstm.setString(4, cliente.getDireccion().getCiudad());
		pstm.setString(5, cliente.getDireccion().getCalle());
		pstm.setString(6, cliente.getDireccion().getAltura());
		pstm.setString(7, cliente.getDireccion().getCodPostal());
		int pos = pstm.executeUpdate();
		if(pos==1) {
			conn.commit();
			Conexion.cerrarPrepStatement(pstm);
			Conexion.cerrarConexion(conn);
		}
		conn.rollback();
		Conexion.cerrarPrepStatement(pstm);
		Conexion.cerrarConexion(conn);
		System.out.println("No se pudo crear la direccion!");
	}
	
	public void actualizarDireccion(Cliente cliente) throws ClassNotFoundException, SQLException {
		query="UPDATE bdaerolinea.direccion SET idPais=?, idProvincia=?, ciudad=?, calle=?, altura=?, codPostal=? WHERE idDireccion=?";
		conn=Conexion.obtenerConexion();
		pstm=conn.prepareStatement(query);
		pstm.setInt(1, cliente.getDireccion().getPais().getIdPais());
		pstm.setInt(2, cliente.getDireccion().getProv().getIdProvincia());
		pstm.setString(3, cliente.getDireccion().getCiudad());
		pstm.setString(4, cliente.getDireccion().getCalle());
		pstm.setString(5, cliente.getDireccion().getAltura());
		pstm.setString(6, cliente.getDireccion().getCodPostal());
		pstm.setInt(7, cliente.getDireccion().getIdDireccion());
		int pos = pstm.executeUpdate();
		if(pos==1) {
			conn.commit();
			Conexion.cerrarPrepStatement(pstm);
			Conexion.cerrarConexion(conn);
		}
		conn.rollback();
		Conexion.cerrarPrepStatement(pstm);
		Conexion.cerrarConexion(conn);
		System.out.println("No se pudo actualizar la direccion!");
	}
	
	public void eliminarDireccion(Cliente cliente) throws ClassNotFoundException, SQLException {
		query="DELETE FROM bdaerolinea.direccion WHERE idDireccion=?";
		conn=Conexion.obtenerConexion();
		conn.setAutoCommit(false);
		pstm=conn.prepareStatement(query);
		pstm.setInt(1, cliente.getDireccion().getIdDireccion());
		int pos = pstm.executeUpdate();
		if(pos==1) {
			conn.commit();
			Conexion.cerrarPrepStatement(pstm);
			Conexion.cerrarConexion(conn);
		}
		conn.rollback();
		Conexion.cerrarPrepStatement(pstm);
		Conexion.cerrarConexion(conn);
		System.out.println("No se pudo eliminar la direccion!");
	}

	@Override
	public Direccion obtenerDireccion(int idDireccion) throws ClassNotFoundException, SQLException {
		query="SELECT * FROM bdaerolinea.direccion WHERE idDireccion=?";
		conn=Conexion.obtenerConexion();
		Direccion direc = new Direccion();
		pstm=conn.prepareStatement(query);
		pstm.setInt(1, idDireccion);
		rst=pstm.executeQuery();
		while(rst.next()) {
			direc.setIdDireccion(rst.getInt(1));
			direc.setPais(pd.obtenerPais(rst.getInt(2)));
			direc.setProv(ppd.obtenerProvincia(rst.getInt(3)));
			direc.setCiudad(rst.getString(4));
			direc.setCalle(rst.getString(5));
			direc.setAltura(rst.getString(6));
			direc.setCodPostal(rst.getString(7));
		}
		Conexion.cerrarPrepStatement(pstm);
		Conexion.cerrarResultSet(rst);
		Conexion.cerrarConexion(conn);
		return direc;
	}
}
