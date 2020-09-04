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
import edu.usal.negocio.DAO.Interfaces.LineasAereasDAO;
import edu.usal.negocio.Dominio.Alianzas;
import edu.usal.negocio.Dominio.LineasAereas;
import edu.usal.negocio.Dominio.Vuelos;

public final class LineasAereasDAOImplementacionSQL implements LineasAereasDAO{

	private Connection conn;
	private PreparedStatement pstm;
	private ResultSet rst;
	private String query;
	
	private String Alianzas1 (Alianzas alianza) {
		String alianza1 = String.valueOf(alianza);
		return alianza1;
	}
	
	private Alianzas Alianzas2(String Stalianza) {
		Alianzas al = Alianzas.valueOf(Stalianza);
		return al;
	}
	
	
	@Override
	public LineasAereas obtenerLineaAerea(int idLineaAerea) throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		query="SELECT * FROM bdaerolinea.aerolinea WHERE IDAerolinea=?";
		LineasAereas aero = new LineasAereas();
		conn=Conexion.obtenerConexion();
		pstm=conn.prepareStatement(query);
		pstm.setInt(1, idLineaAerea);
		rst=pstm.executeQuery();
		while(rst.next()) {
			aero.setAlianzas(Alianzas2(rst.getString(1)));
			aero.setIdLineasAereas(rst.getInt(2));
			aero.setNombreAerolinea(rst.getString(3));
		}
		Conexion.cerrarResultSet(rst);
		Conexion.cerrarPrepStatement(pstm);
		Conexion.cerrarConexion(conn);
		return aero;
	}

	@Override
	public List<LineasAereas> obtenerLineasAereas() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		query="SELECT * FROM bdaerolinea.aerolinea";
		List<LineasAereas> la = new ArrayList<>();
		LineasAereas a;
		conn=Conexion.obtenerConexion();
		pstm=conn.prepareStatement(query);
		rst =pstm.executeQuery();
		while(rst.next()) {
			List<Vuelos> lv = new ArrayList<>();
			a = new LineasAereas();
			a.setAlianzas(Alianzas2(rst.getString(1)));
			a.setIdLineasAereas(rst.getInt(2));
			a.setNombreAerolinea(rst.getString(3));
			String query2="SELECT * FROM bdaerolinea.vuelos WHERE id_Aerolinea";
			PreparedStatement pstm2 = conn.prepareStatement(query2);
			pstm2.setInt(2,a.getIdLineasAereas());
			ResultSet rst2 = pstm2.executeQuery();
			while(rst2.next()) {
				Vuelos vl = new Vuelos();
				vl.setIdVuelos(rst2.getInt(1));
				vl.setNumDeVuelos(rst2.getInt(2));
				vl.setCantDeAsientos(rst2.getInt(3));
				vl.setTiempoDeVuelo(rst2.getString(4));
				vl.setAeropuertoSalida(rst2.getInt(6));
				
			}
		}
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
	public void actualizarLineaAerea(LineasAereas lineasAereas) throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		query="UPDATE bdaerolinea.aerolinea SET alianza=?, nombreAerolinea=? WHERE IDAerolinea=?";
		conn=Conexion.obtenerConexion();
		conn.setAutoCommit(false);
		pstm=conn.prepareStatement(query);
		pstm.setString(1, Alianzas1(lineasAereas.getAlianzas()));
		pstm.setString(2, lineasAereas.getNombreAerolinea());
		pstm.setInt(3, lineasAereas.getIdLineasAereas());
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
	public void eliminarLineaAerea(int idLineasAereas) throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		query="DELETE FROM bdaerolinea.aerolinea WHERE IDAerolinea=?";
		conn=Conexion.obtenerConexion();
		conn.setAutoCommit(false);
		pstm=conn.prepareStatement(query);
		pstm.setInt(1, idLineasAereas);
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
