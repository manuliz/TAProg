package edu.usal.negocio.DAO.Implementacion;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import edu.usal.Util.Conexion;
import edu.usal.negocio.DAO.Interfaces.LineasAereasDAO;
import edu.usal.negocio.DAO.Interfaces.PasajeroFrecuenteDAO;
import edu.usal.negocio.Dominio.Alianzas;
import edu.usal.negocio.Dominio.Cliente;
import edu.usal.negocio.Dominio.PasajeroFrecuente;

public class PasajeroFrecuenteDAOImplementacionSQL implements PasajeroFrecuenteDAO{
	
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
	
	public PasajeroFrecuente obtenerPasajeroFrecuente(int idPasajeroFrecuente) throws ClassNotFoundException, SQLException {
		query="SELECT * FROM bdaerolinea.pasajerofrecuente WHERE idPasajeroFrecuente=?";
		PasajeroFrecuente pf = new PasajeroFrecuente();
		conn=Conexion.obtenerConexion();
		pstm=conn.prepareStatement(query);
		pstm.setInt(1, idPasajeroFrecuente);
		rst=pstm.executeQuery();
		while(rst.next()) {
			pf.setIdPasajeroFrecuente(rst.getInt(1));
			pf.setNumero(rst.getString(2));
			pf.setCategoria(rst.getString(3));
			LineasAereasDAO la = new LineasAereasDAOImplementacionSQL();
			try {
				pf.setAerolinea(la.obtenerLineaAerea(rst.getInt(4)));
			} catch (IOException e) {
				System.out.println("No se pudo obtener la linea aerea dentro de pasajero frecuente.");
				e.printStackTrace();
			}
			pf.setAlianzas(Alianzas2(rst.getString(5)));
		}
		Conexion.cerrarPrepStatement(pstm);
		Conexion.cerrarResultSet(rst);
		Conexion.cerrarConexion(conn);
		return pf;
	}
	
	public void crearPasajeroFrecuente(Cliente cliente) throws ClassNotFoundException, SQLException {
		query="INSERT INTO bdaerolinea.pasajerofrecuente VALUES (?,?,?,?,?)";
		conn=Conexion.obtenerConexion();
		conn.setAutoCommit(false);
		pstm=conn.prepareStatement(query);
		pstm.setInt(1, cliente.getNumPasajeroFrec().getIdPasajeroFrecuente());
		pstm.setString(2, cliente.getNumPasajeroFrec().getNumero());
		pstm.setString(3, cliente.getNumPasajeroFrec().getCategoria());
		pstm.setInt(4, cliente.getNumPasajeroFrec().getAerolinea().getIdLineasAereas());
		pstm.setString(5, Alianzas1(cliente.getNumPasajeroFrec().getAlianzas()));
		int pos = pstm.executeUpdate();
		if(pos==1) {
			conn.commit();
			Conexion.cerrarPrepStatement(pstm);
			Conexion.cerrarConexion(conn);
		}
		conn.rollback();
		Conexion.cerrarPrepStatement(pstm);
		Conexion.cerrarConexion(conn);
		System.out.println("No se pudo crear el numero de Pasaporte frecuente!");
	}
	
	public void actualizarPasajeroFrecuente(Cliente cliente) throws ClassNotFoundException, SQLException {
		query="UPDATE bdaerolinea.pasajeroFrecuente SET numero=?, categoria=?, idAerolinea=?, alianza=? "
				+ "WHERE idPasajeroFrecuente=?";
		conn=Conexion.obtenerConexion();
		conn.setAutoCommit(false);
		pstm=conn.prepareStatement(query);
		pstm.setString(1, cliente.getNumPasajeroFrec().getNumero());
		pstm.setString(2, cliente.getNumPasajeroFrec().getCategoria());
		pstm.setInt(3, cliente.getNumPasajeroFrec().getAerolinea().getIdLineasAereas());
		pstm.setString(4, Alianzas1(cliente.getNumPasajeroFrec().getAlianzas()));
		pstm.setInt(5, cliente.getNumPasajeroFrec().getIdPasajeroFrecuente());
		int pos = pstm.executeUpdate();
		if(pos==1) {
			conn.commit();
			Conexion.cerrarPrepStatement(pstm);
			Conexion.cerrarConexion(conn);
		}
		conn.rollback();
		Conexion.cerrarPrepStatement(pstm);
		Conexion.cerrarConexion(conn);
		System.out.println("No se pudo actualizar el numero de pasajero frecuente!");
	}
	
	public void eliminarPasajeroFrecuente(Cliente cliente) throws ClassNotFoundException, SQLException {
		query="DELETE FROM bdaerolinea.pasajerofrecuente WHERE idPasajeroFrecuente=?";
		conn=Conexion.obtenerConexion();
		conn.setAutoCommit(false);
		pstm=conn.prepareStatement(query);
		pstm.setInt(2, cliente.getNumPasajeroFrec().getIdPasajeroFrecuente());
		int pos = pstm.executeUpdate();
		if(pos==1) {
			conn.commit();
			Conexion.cerrarPrepStatement(pstm);
			Conexion.cerrarConexion(conn);
		}
		conn.rollback();
		Conexion.cerrarPrepStatement(pstm);
		Conexion.cerrarConexion(conn);
		System.out.println("No se pudo elimina el pasajero frecuente!");
	}
}
