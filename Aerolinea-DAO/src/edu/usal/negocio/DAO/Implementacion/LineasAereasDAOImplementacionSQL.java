package edu.usal.negocio.DAO.Implementacion;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.usal.Util.Conexion;
import edu.usal.negocio.DAO.Interfaces.LineasAereasDAO;
import edu.usal.negocio.Dominio.Aeropuerto;
import edu.usal.negocio.Dominio.Alianzas;
import edu.usal.negocio.Dominio.LineasAereas;
import edu.usal.negocio.Dominio.Pais;
import edu.usal.negocio.Dominio.Provincia;
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
	
	private Date TimestampADate(Timestamp ts) {
		java.util.Date d = new java.util.Date(ts.getTime());
		return d;
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
			la.add(a);
			String query2="SELECT * FROM bdaerolinea.vuelos WHERE id_Aerolinea=?";
			PreparedStatement pstm2 = conn.prepareStatement(query2);
			pstm2.setInt(1,a.getIdLineasAereas());
			ResultSet rst2 = pstm2.executeQuery();
			while(rst2.next()) {
				Vuelos vl = new Vuelos();				
				vl.setIdVuelos(rst2.getInt(1));
				vl.setNumDeVuelos(rst2.getString(2));
				vl.setCantDeAsientos(rst2.getInt(3));
				vl.setTiempoDeVuelo(rst2.getString(4));
				vl.setLineaAerea(a);
				String query3 = "SELECT FROM bdaerolinea.aeropuerto WHERE idAeropuerto=?";
				PreparedStatement pstm3 = conn.prepareStatement(query3);
				pstm3.setInt(1, rst2.getInt(6));
				ResultSet rst3 = pstm3.executeQuery();
				while(rst3.next()) {
					Aeropuerto as = new Aeropuerto();
					as.setIdAeropuerto(rst3.getInt(1));
					as.setCiudad(rst3.getString(2));
					as.setIdentificacionAeropuerto(rst3.getString(3));
					String query4 = "SELECT FROM bdaerolinea.pais WHERE idPais=?";
					PreparedStatement pstm4 = conn.prepareStatement(query4);
					pstm3.setInt(1, rst3.getInt(4));
					ResultSet rst4 = pstm4.executeQuery();
					while(rst4.next()) {
						Pais p = new Pais();
						p.setIdPais(rst4.getInt(1));
						p.setNombrePais(rst4.getString(2));
						as.setPais(p);
					}
					String query5 = "SELECT FROM bdaerolinea.provincia WHERE idProvincia=?";
					PreparedStatement pstm5 = conn.prepareStatement(query5);
					pstm5.setInt(1, rst3.getInt(5));
					ResultSet rst5 = pstm5.executeQuery();
					while(rst5.next()) {
						Provincia pr = new Provincia();
						pr.setIdProvincia(rst5.getInt(1));
						pr.setNombreProvincia(rst5.getString(2));
						as.setProvincia(pr);
					}
					vl.setAeropuertoSalida(as);
				}
				String query6 = "SELECT FROM bdaerolinea.aeropuerto WHERE idAeropuerto=?";
				PreparedStatement pstm6 = conn.prepareStatement(query6);
				pstm6.setInt(1, rst2.getInt(7));
				ResultSet rst6 = pstm6.executeQuery();
				while(rst6.next()) {
					Aeropuerto al = new Aeropuerto();
					al.setIdAeropuerto(rst6.getInt(1));
					al.setCiudad(rst6.getString(2));
					al.setIdentificacionAeropuerto(rst6.getString(3));
					String query7 = "SELECT FROM bdaerolinea.pais WHERE idPais=?";
					PreparedStatement pstm7 = conn.prepareStatement(query7);
					pstm7.setInt(1, rst6.getInt(4));
					ResultSet rst7 = pstm7.executeQuery();
					while(rst7.next()) {
						Pais p = new Pais();
						p.setIdPais(rst7.getInt(1));
						p.setNombrePais(rst7.getString(2));
						al.setPais(p);
					}
					String query8 = "SELECT FROM bdaerolinea.provincia WHERE idProvincia=?";
					PreparedStatement pstm8 = conn.prepareStatement(query8);
					pstm8.setInt(1, rst6.getInt(5));
					ResultSet rst8 = pstm8.executeQuery();
					while(rst8.next()) {
						Provincia pr = new Provincia();
						pr.setIdProvincia(rst8.getInt(1));
						pr.setNombreProvincia(rst8.getString(2));
						al.setProvincia(pr);
					}
					vl.setAeropuertoLlegada(al);
				}
				vl.setFhLlegada(TimestampADate(rst2.getTimestamp(8)));
				vl.setFhSalida(TimestampADate(rst2.getTimestamp(9)));
				lv.add(vl);
			}
		}
		Conexion.cerrarResultSet(rst);
		Conexion.cerrarPrepStatement(pstm);
		Conexion.cerrarConexion(conn);
		return la;
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
