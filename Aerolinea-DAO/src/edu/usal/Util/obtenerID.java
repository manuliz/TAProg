package edu.usal.Util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Hashtable;

import edu.usal.negocio.DAO.Interfaces.ProvinciaDAO;

public class obtenerID {
	
	private static Connection conn;
	private static PreparedStatement pstm;
	private static ResultSet rst;
	private static String query;
	private static Hashtable<Integer, String> hp;
	private static ProvinciaDAO ppc;
	
	public static int incrementarIdLineaAerea () {
		int id = 0;
		query="select MAX(IDAerolinea) from bdaerolinea.aerolinea";
		try {
			conn=Conexion.obtenerConexion();
			pstm=conn.prepareStatement(query);
			rst=pstm.executeQuery();
			while(rst.next()) {
				id=rst.getInt(1);
				id++;
			}
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		try {
			Conexion.cerrarResultSet(rst);
			Conexion.cerrarPrepStatement(pstm);
			Conexion.cerrarConexion(conn);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		return id;	
	}
	
	public static int incrementarIdVentas () {
		int id = 0;
		query="select MAX(idventas) from bdaerolinea.ventas";
		try {
			conn=Conexion.obtenerConexion();
			pstm=conn.prepareStatement(query);
			rst=pstm.executeQuery();
			while(rst.next()) {
				id=rst.getInt(1);
				id++;
			}
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		try {
			Conexion.cerrarResultSet(rst);
			Conexion.cerrarPrepStatement(pstm);
			Conexion.cerrarConexion(conn);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		return id;	
	}
	
	public static int incrementarIdAeropuerto() {
		int id = 0;
		query="select MAX(idAeropuerto) from bdaerolinea.aeropuerto";
		try {
			conn=Conexion.obtenerConexion();
			pstm=conn.prepareStatement(query);
			rst=pstm.executeQuery();
			while(rst.next()) {
				id=rst.getInt(1);
				id++;
			}
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		try {
			Conexion.cerrarResultSet(rst);
			Conexion.cerrarPrepStatement(pstm);
			Conexion.cerrarConexion(conn);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		return id;	
	}
	
	public static int incrementarIdCliente() {
		int id = 0;
		query="select MAX(idCliente) from bdaerolinea.cliente";
		try {
			conn=Conexion.obtenerConexion();
			pstm=conn.prepareStatement(query);
			rst=pstm.executeQuery();
			while(rst.next()) {
				id=rst.getInt(1);
				id++;
			}
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		try {
			Conexion.cerrarResultSet(rst);
			Conexion.cerrarPrepStatement(pstm);
			Conexion.cerrarConexion(conn);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		return id;	
	}
	
	public static int incrementarIdDireccion() {
		int id = 0;
		query="select MAX(idDireccion) from bdaerolinea.direccion";
		try {
			conn=Conexion.obtenerConexion();
			pstm=conn.prepareStatement(query);
			rst=pstm.executeQuery();
			while(rst.next()) {
				id=rst.getInt(1);
				id++;
			}
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		try {
			Conexion.cerrarResultSet(rst);
			Conexion.cerrarPrepStatement(pstm);
			Conexion.cerrarConexion(conn);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		return id;	
	}
	
	public static int incrementarIdPais() {
		int id = 0;
		query="select MAX(idPais) from bdaerolinea.pais";
		try {
			conn=Conexion.obtenerConexion();
			pstm=conn.prepareStatement(query);
			rst=pstm.executeQuery();
			while(rst.next()) {
				id=rst.getInt(1);
				id++;
			}
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		try {
			Conexion.cerrarResultSet(rst);
			Conexion.cerrarPrepStatement(pstm);
			Conexion.cerrarConexion(conn);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		return id;	
	}
	
	public static int incrementarIdPasajeroFrecuente() {
		int id = 0;
		query="select MAX(idPasajeroFrecuente) from bdaerolinea.pasajerofrecuente";
		try {
			conn=Conexion.obtenerConexion();
			pstm=conn.prepareStatement(query);
			rst=pstm.executeQuery();
			while(rst.next()) {
				id=rst.getInt(1);
				id++;
			}
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		try {
			Conexion.cerrarResultSet(rst);
			Conexion.cerrarPrepStatement(pstm);
			Conexion.cerrarConexion(conn);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		return id;	
	}
	
	
	public static int incrementarIdPasaporte() {
		int id = 0;
		query="select MAX(idPasaporte) from bdaerolinea.pasaporte";
		try {
			conn=Conexion.obtenerConexion();
			pstm=conn.prepareStatement(query);
			rst=pstm.executeQuery();
			while(rst.next()) {
				id=rst.getInt(1);
				id++;
			}
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		try {
			Conexion.cerrarResultSet(rst);
			Conexion.cerrarPrepStatement(pstm);
			Conexion.cerrarConexion(conn);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		return id;	
	}
	
	public static int incrementarIdProvincia() {
		int id = 0;
		query="select MAX(idProvincia) from bdaerolinea.provincia";
		try {
			conn=Conexion.obtenerConexion();
			pstm=conn.prepareStatement(query);
			rst=pstm.executeQuery();
			while(rst.next()) {
				id=rst.getInt(1);
				id++;
			}
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		try {
			Conexion.cerrarResultSet(rst);
			Conexion.cerrarPrepStatement(pstm);
			Conexion.cerrarConexion(conn);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		return id;	
	}
	
	public static int incrementarIdProvincia1() {
		int id=0;
		try {
			hp = ppc.obtenerProvincias();
			Enumeration<Integer> en = hp.keys();
			while(en.hasMoreElements()) {
				id++;
				en.nextElement();
			}
		} catch (ClassNotFoundException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return id;
	}
	
	public static int incrementarIdTelefono() {
		int id = 0;
		query="select MAX(idTelefono) from bdaerolinea.telefono";
		try {
			conn=Conexion.obtenerConexion();
			pstm=conn.prepareStatement(query);
			rst=pstm.executeQuery();
			while(rst.next()) {
				id=rst.getInt(1);
				id++;
			}
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		try {
			Conexion.cerrarResultSet(rst);
			Conexion.cerrarPrepStatement(pstm);
			Conexion.cerrarConexion(conn);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		return id;	
	}
	
	public static int incrementarIdVuelos() {
		int id = 0;
		query="select MAX(idVuelo) from bdaerolinea.vuelos";
		try {
			conn=Conexion.obtenerConexion();
			pstm=conn.prepareStatement(query);
			rst=pstm.executeQuery();
			while(rst.next()) {
				id=rst.getInt(1);
				id++;
			}
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		try {
			Conexion.cerrarResultSet(rst);
			Conexion.cerrarPrepStatement(pstm);
			Conexion.cerrarConexion(conn);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		return id;	
	}
	
//	public static void main (String[] args) {
//		System.out.println(obtenerID.incrementarIdCliente());
//	}

}


