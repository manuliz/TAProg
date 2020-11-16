package edu.usal.Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class obtenerID {
	
	private static Connection conn;
	private static PreparedStatement pstm;
	private static ResultSet rst;
	private static String query;
	
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
	
	
//	public static void main (String[] args) {
//		System.out.println(obtenerID.incrementarIdLineaAerea());
//	}

}


