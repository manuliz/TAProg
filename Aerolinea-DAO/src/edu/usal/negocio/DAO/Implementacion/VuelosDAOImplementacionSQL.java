package edu.usal.negocio.DAO.Implementacion;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import edu.usal.Util.Conexion;
import edu.usal.negocio.DAO.Interfaces.LineasAereasDAO;
import edu.usal.negocio.DAO.Interfaces.VuelosDAO;
import edu.usal.negocio.Dominio.Aeropuerto;
import edu.usal.negocio.Dominio.LineasAereas;
import edu.usal.negocio.Dominio.Vuelos;

public class VuelosDAOImplementacionSQL implements VuelosDAO{
	
	private Connection conn;
	private PreparedStatement pstm;
	private String query;
	private ResultSet rst;
	
	private Timestamp DateATimestamp(java.util.Date d) {
		Timestamp ts = new Timestamp(d.getTime());
		return ts;
	}
	
	private Date TimestampADate(Timestamp ts) {
		java.util.Date d = new java.util.Date(ts.getTime());
		return d;
	}
	
	private LineasAereas intAlineaAerea(int id) {
		LineasAereas ln1 = new LineasAereas(null,id,null);
		return ln1;
	}
	
	private Aeropuerto intAaeropuerto(int id) {
		Aeropuerto ae = new Aeropuerto(id, null,null,null,null);
		return ae;
	}

	@Override
	public Vuelos obtenerVuelo(String numVuelo) throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		query="SELECT FROM bdaerolinea.vuelos WHERE idVuelo=?";
		Vuelos vu = new Vuelos();
		conn=Conexion.obtenerConexion();
		pstm=conn.prepareStatement(query);
		pstm.setString(1, numVuelo);
		rst=pstm.executeQuery();
		while(rst.next()) {
			vu.setIdVuelos(rst.getInt(1));
			vu.setNumDeVuelos(rst.getString(2));
			vu.setCantDeAsientos(rst.getInt(3));
			vu.setTiempoDeVuelo(rst.getString(4));
			vu.setLineaAerea(intAlineaAerea(rst.getInt(5)));
			vu.setAeropuertoSalida(intAaeropuerto(rst.getInt(6)));
			vu.setAeropuertoLlegada(intAaeropuerto(rst.getInt(7)));
			vu.setFhSalida(TimestampADate(rst.getTimestamp(8)));
			vu.setFhLlegada(TimestampADate(rst.getTimestamp(9)));
		}
		Conexion.cerrarResultSet(rst);
		Conexion.cerrarPrepStatement(pstm);
		Conexion.cerrarConexion(conn);
		return vu;
	}

	@Override
	public List<Vuelos> obtenerVuelos() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		List<Vuelos> lv = new ArrayList<Vuelos>();
		Vuelos vue;
		query="SELECT * FROM bdaerolinea.vuelos";
		conn=Conexion.obtenerConexion();
		pstm=conn.prepareStatement(query);
		rst=pstm.executeQuery();
		while(rst.next()) {
			vue = new Vuelos();
			vue.setIdVuelos(rst.getInt(1));
			vue.setNumDeVuelos(rst.getString(2));
			vue.setCantDeAsientos(rst.getInt(3));
			vue.setTiempoDeVuelo(rst.getString(4));
			vue.setLineaAerea(null);//puede ser null solo o usar el metodo intAlineasAereas
			vue.setAeropuertoSalida(null);//puede ser null solo o usar el metodo intAaeropuerto (vamos a probar si anda en el mvc asi o con el metodo)
			vue.setAeropuertoLlegada(null);//'''
			vue.setFhSalida(TimestampADate(rst.getTimestamp(8)));
			vue.setFhLlegada(TimestampADate(rst.getTimestamp(9)));
			lv.add(vue);
		}
		Conexion.cerrarResultSet(rst);
		Conexion.cerrarPrepStatement(pstm);
		Conexion.cerrarConexion(conn);
		return lv;
	}

	@Override
	public void crearVuelo(Vuelos vuelo) throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		
		query = "INSERT INTO bdaerolinea.vuelos VALUES (?,?,?,?,?,?,?,?,?)";
		conn=Conexion.obtenerConexion();
		conn.setAutoCommit(false);
		pstm=conn.prepareStatement(query);
		pstm.setInt(1,vuelo.getIdVuelos());
		pstm.setString(2,vuelo.getNumDeVuelos());
		pstm.setInt(3, vuelo.getCantDeAsientos());
		pstm.setString(4, vuelo.getTiempoDeVuelo());
		pstm.setInt(5, vuelo.getLineaAerea().getIdLineasAereas());
		pstm.setInt(6, vuelo.getAeropuertoSalida().getIdAeropuerto());
		pstm.setInt(7, vuelo.getAeropuertoLlegada().getIdAeropuerto());
		pstm.setTimestamp(8, DateATimestamp(vuelo.getFhSalida()));
		pstm.setTimestamp(9, DateATimestamp(vuelo.getFhLlegada()));
		
		int pos = pstm.executeUpdate();
		if(pos==1) {
			conn.commit();
			Conexion.cerrarPrepStatement(pstm);
			Conexion.cerrarConexion(conn);	
		}
		conn.rollback();
		Conexion.cerrarPrepStatement(pstm);
		Conexion.cerrarConexion(conn);
		System.out.println("No se pudo completar la transaccion.");
	}

	@Override
	public void actualizarVuelo(Vuelos vuelo) throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		query="UPDATE bdarolinea.vuelos SET numVuelo=?, cantAsientos=?, tiempoDeVuelo=?, id_Aerolinea=?, idAeropuertoSalida=?, idAeropuertoLlegada=?,"
				+ " fhSalida=?, fhLlegada=? where idVuelo=?";
		conn=Conexion.obtenerConexion();
		conn.setAutoCommit(false);
		pstm=conn.prepareStatement(query);
		pstm.setString(1, vuelo.getNumDeVuelos());
		pstm.setInt(2, vuelo.getCantDeAsientos());
		pstm.setString(2, vuelo.getTiempoDeVuelo());
		pstm.setInt(4, vuelo.getLineaAerea().getIdLineasAereas());
		pstm.setInt(5, vuelo.getAeropuertoSalida().getIdAeropuerto());
		pstm.setInt(6,  vuelo.getAeropuertoLlegada().getIdAeropuerto());
		pstm.setTimestamp(7, DateATimestamp(vuelo.getFhSalida()));
		pstm.setTimestamp(8, DateATimestamp(vuelo.getFhLlegada()));
		pstm.setInt(9, vuelo.getIdVuelos());
		
		int pos = pstm.executeUpdate();
		if(pos==1) {
			conn.commit();
			Conexion.cerrarPrepStatement(pstm);
			Conexion.cerrarConexion(conn);
		}else {
			conn.rollback();
			Conexion.cerrarPrepStatement(pstm);
			Conexion.cerrarConexion(conn);
		}
		
	}

	@Override
	public void eliminarVuelo(String numVuelo) throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		query="DELETE FROM bdaerolinea.vuelos WHERE idVuelo=?";
		conn=Conexion.obtenerConexion();
		conn.setAutoCommit(false);
		pstm=conn.prepareStatement(query);
		pstm.setString(1, numVuelo);
		int pos = pstm.executeUpdate();
		if(pos==1) {
			conn.commit();
			Conexion.cerrarPrepStatement(pstm);
			Conexion.cerrarConexion(conn);
		}else {
			conn.rollback();
			Conexion.cerrarPrepStatement(pstm);
			Conexion.cerrarConexion(conn);
		}
		
	}

}
