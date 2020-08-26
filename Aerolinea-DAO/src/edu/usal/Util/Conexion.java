package edu.usal.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {
	
	public static Connection obtenerConexion() throws ClassNotFoundException, SQLException {
		
		Connection conn;
		
		Class.forName(propertiesUtil.obtenerDriver());
		
		conn = DriverManager.getConnection(propertiesUtil.obtenerURL(),propertiesUtil.obtenerUsu(),propertiesUtil.obtenerCon());
		
		if(!conn.isClosed()) {
			System.out.println("Conexion establecida");
		}
		
		return conn;
	}
	
	public static void cerrarResultSet(ResultSet rs) throws SQLException {
		rs.close();
	}
	
	public static void cerrarStatement(Statement st) throws SQLException {
		st.close();
	}
	
	public static void cerrarPrepStatement(PreparedStatement pst) throws SQLException {
		pst.close();
	}
	
	public static void cerrarConexion(Connection con) throws SQLException {
		con.close();
		if(con.isClosed()) {
			System.out.println("Conexion cerrada");
		}
	}

}
