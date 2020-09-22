package edu.usal.negocio.DAO.Implementacion;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.usal.Util.Conexion;
import edu.usal.negocio.DAO.Interfaces.AeropuertoDAO;
import edu.usal.negocio.Dominio.Aeropuerto;

public class AeropuertoDAOImplementacionSQL implements AeropuertoDAO{
	
	private Connection conn;
	private PreparedStatement pstm;
	private String query;
	private ResultSet rst;

	@Override
	public Aeropuerto obtenerAeropuerto(int idCiudad) throws FileNotFoundException, IOException, SQLException, ClassNotFoundException {
		query="SELECT * FROM bdaerolinea.aeropuerto WHERE idAeropuerto=?";
		Aeropuerto ae = new Aeropuerto();
		conn=Conexion.obtenerConexion();
		pstm=conn.prepareStatement(query);
		pstm.setInt(1, idCiudad);
		rst=pstm.executeQuery();
		while(rst.next()) {
			ae.setIdAeropuerto(idCiudad);
			ae.setCiudad(rst.getString(2));
			ae.setIdentificacionAeropuerto(rst.getString(3));
			ae.setPais(null);
			ae.setProvincia(null);
		}
		
		Conexion.cerrarResultSet(rst);
		Conexion.cerrarPrepStatement(pstm);
		Conexion.cerrarConexion(conn);		
		return ae;
	}

	@Override
	public List<Aeropuerto> obtenerAeropuertos() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		query="SELECT * FROM bdaerolinea.aeropuerto";
		Aeropuerto ae;
		List<Aeropuerto> aer = new ArrayList<>();
		conn=Conexion.obtenerConexion();
		pstm=conn.prepareStatement(query);
		rst=pstm.executeQuery();
		while(rst.next()) {
			ae =  new Aeropuerto();
			ae.setIdAeropuerto(rst.getInt(1));
			ae.setCiudad(rst.getString(2));
			ae.setIdentificacionAeropuerto(rst.getString(3));
			ae.setPais(null);
			ae.setProvincia(null);
			aer.add(ae);
		}
		Conexion.cerrarResultSet(rst);
		Conexion.cerrarPrepStatement(pstm);
		Conexion.cerrarConexion(conn);
		return aer;
	}

	@Override
	public void crearAeropuerto(Aeropuerto aero) throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		query="INSERT INTO bdaerolinea.aeropuerto VALUES (?,?,?,?,?,?)";
		conn=
		Conexion.obtenerConexion();
		conn.setAutoCommit(false);
		pstm=conn.prepareStatement(query);
		pstm.setInt(1, aero.getIdAeropuerto());
		pstm.setString(2, aero.getCiudad());
		pstm.setString(3,aero.getIdentificacionAeropuerto());
		pstm.setInt(4, aero.getPais().getIdPais());
		pstm.setInt(5, aero.getProvincia().getIdProvincia());
		pstm.setString(6, null);
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
	public void actualizarAeropuerto(Aeropuerto aero) throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		query="UPDATE bdaerolinea.aeropuerto SET ciudad=?, identifAeropuerto=?, idPais=?, idProvincia=?, provinciaOtro=? WHERE idAeropuerto=?";
		conn=Conexion.obtenerConexion();
		conn.setAutoCommit(false);
		pstm=conn.prepareStatement(query);
		pstm.setString(1, aero.getCiudad());
		pstm.setString(2, aero.getIdentificacionAeropuerto());
		pstm.setInt(3, aero.getPais().getIdPais());
		pstm.setInt(4, aero.getProvincia().getIdProvincia());
		pstm.setString(5, null);
		pstm.setInt(6, aero.getIdAeropuerto());
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
	public void eliminarAeropuerto(int idAero) throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		query="DELETE FROM bdaerolinea.aeropuerto WHERE idAeropuerto=?";
		conn=Conexion.obtenerConexion();
		conn.setAutoCommit(false);
		pstm=conn.prepareStatement(query);
		pstm.setInt(1, idAero);
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

}
