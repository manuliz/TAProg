package edu.usal.negocio.DAO.Implementacion;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.usal.Util.Conexion;
import edu.usal.negocio.DAO.Interfaces.ClienteDAO;
import edu.usal.negocio.DAO.Interfaces.LineasAereasDAO;
import edu.usal.negocio.DAO.Interfaces.VentasDAO;
import edu.usal.negocio.DAO.Interfaces.VuelosDAO;
import edu.usal.negocio.Dominio.Alianzas;
import edu.usal.negocio.Dominio.Ventas;
import edu.usal.negocio.Dominio.Vuelos;

public class VentasDAOImplementacionSQL implements VentasDAO{
	
	private Connection conn;
	private PreparedStatement pstm;
	private String query;
	private ResultSet rst;
	ClienteDAO CLID = new ClienteDAOImplementacionSQL();
	VuelosDAO VUED = new VuelosDAOImplementacionSQL();
	LineasAereasDAO LIND = new LineasAereasDAOImplementacionSQL();
	
	
	@Override
	public Ventas obtenerVenta(int idVenta) throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		query="SELECT * FROM bdaerolinea.ventas WHERE idVentas=?";
		Ventas ven = new Ventas();
		conn=Conexion.obtenerConexion();
		pstm=conn.prepareStatement(query);
		pstm.setInt(1, idVenta);
		rst=pstm.executeQuery();
		while(rst.next()) {
			ven.setIdVenta(rst.getInt(1));
			ven.setCliente(CLID.obtenerCliente(obtenerDniCliente(rst.getInt(2), conn, pstm, rst)));
			ven.setVuelo(VUED.obtenerVuelo(obtenerNumVuelo(rst.getInt(3), conn, pstm, rst)));
			ven.setAerolinea(LIND.obtenerLineaAerea(rst.getInt(4)));
			ven.setFechaYhoraVenta(TimestampADate(rst.getTimestamp(5)));
			ven.setFormaPago(rst.getString(6));
			ven.setCuotas(rst.getInt(7));
			ven.setTotAPagar(rst.getInt(8));
		}
		Conexion.cerrarPrepStatement(pstm);
		Conexion.cerrarResultSet(rst);
		Conexion.cerrarConexion(conn);
		return ven;
	}
	@Override
	public List<Ventas> obtenerVentas() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		query="SELECT * FROM bdaerolinea.ventas";
		List<Ventas> liVen = new ArrayList<>();
		Ventas ven;
		conn=Conexion.obtenerConexion();
		pstm=conn.prepareStatement(query);
		rst=pstm.executeQuery();
		while(rst.next()) {
			ven = new Ventas();
			ven.setIdVenta(rst.getInt(1));
			ven.setCliente(CLID.obtenerCliente(obtenerDniCliente(rst.getInt(2), conn, pstm, rst)));
			ven.setVuelo(VUED.obtenerVuelo(obtenerNumVuelo(rst.getInt(3), conn, pstm, rst)));
			ven.setAerolinea(LIND.obtenerLineaAerea(rst.getInt(4)));
			ven.setFechaYhoraVenta(TimestampADate(rst.getTimestamp(5)));
			ven.setFormaPago(rst.getString(6));
			ven.setCuotas(rst.getInt(7));
			ven.setTotAPagar(rst.getInt(8));
			liVen.add(ven);
		}
		Conexion.cerrarPrepStatement(pstm);
		Conexion.cerrarResultSet(rst);
		Conexion.cerrarConexion(conn);
		return liVen;
	}
	@Override
	public void crearVenta(Ventas venta) throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		query="INSERT INTO bdaerolinea.ventas VALUES (?,?,?,?,?,?,?,?)";
		conn=Conexion.obtenerConexion();
		conn.setAutoCommit(false);
		pstm=conn.prepareStatement(query);
		pstm.setInt(1, venta.getIdVenta());
		pstm.setInt(2, venta.getCliente().getIdCliente());
		pstm.setInt(3, venta.getVuelo().getIdVuelos());
		pstm.setInt(4, venta.getAerolinea().getIdLineasAereas());
		pstm.setTimestamp(5, DateATimestamp(venta.getFechaYhoraVenta()));
		pstm.setString(6, venta.getFormaPago());
		if(venta.getCuotas() == 0) {
			pstm.setNull(7, Types.INTEGER);
		}else {
			pstm.setInt(7, venta.getCuotas());
		}
		pstm.setInt(8, venta.getTotAPagar());
		int pos = pstm.executeUpdate();
		if(pos==1) {
			this.descontarAsientos(venta, conn);
			conn.commit();
			Conexion.cerrarPrepStatement(pstm);
			Conexion.cerrarConexion(conn);
		} else {
			conn.rollback();
			Conexion.cerrarPrepStatement(pstm);
			Conexion.cerrarConexion(conn);
			System.out.println("No se pudo realizar la venta");
		}
	}
	
	private Vuelos descontarAsientos(Ventas venta,Connection cn) throws SQLException {
		query="UPDATE bdaerolinea.vuelos set cantAsientos=cantAsientos-1 WHERE numVuelo=?";
		pstm=cn.prepareStatement(query);
		pstm.setString(1, venta.getVuelo().getNumDeVuelos());
		int pos = pstm.executeUpdate();
		if(pos==1) {
			Conexion.cerrarPrepStatement(pstm);
		} else {
			Conexion.cerrarPrepStatement(pstm);
			System.out.println("No se pudo descontar la cantidad de asientos.");
		}
		return null;
	}
	
	@Override
	public void actualizarVenta(Ventas venta) throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		query="UPDATE bdaerolinea.ventas SET idCliente=?, idVuelo=?, idAerolinea=?, fechaYHora=?, "
				+ "formaPago=?, cuotas=?, totAPagar=? WHERE idVentas=?";
		conn=Conexion.obtenerConexion();
		conn.setAutoCommit(false);
		pstm=conn.prepareStatement(query);
		pstm.setInt(8, venta.getIdVenta());
		pstm.setInt(1, venta.getCliente().getIdCliente());
		pstm.setInt(2, venta.getVuelo().getIdVuelos());
		pstm.setInt(3, venta.getAerolinea().getIdLineasAereas());
		pstm.setTimestamp(4, DateATimestamp(venta.getFechaYhoraVenta()));
		pstm.setString(5, venta.getFormaPago());
		if(venta.getCuotas() == 0) {
			pstm.setNull(6, Types.INTEGER);
		}else {
			pstm.setInt(6, venta.getCuotas());
		}
		pstm.setInt(7, venta.getTotAPagar());
		int pos = pstm.executeUpdate();
		if(pos==1) {
			conn.commit();
			Conexion.cerrarPrepStatement(pstm);
			Conexion.cerrarConexion(conn);
		} else {
			conn.rollback();
			Conexion.cerrarPrepStatement(pstm);
			Conexion.cerrarConexion(conn);
			System.out.println("No se puedo actualizar la vuenta");
		}
		
	}
	@Override
	public void eliminarVenta(int id) throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		query="DELETE FROM bdaerolinea.ventas WHERE idVentas=?";
		conn=Conexion.obtenerConexion();
		conn.setAutoCommit(false);
		pstm=conn.prepareStatement(query);
		pstm.setInt(1, id);
		int pos = pstm.executeUpdate();
		if(pos==1) {
			conn.commit();
			Conexion.cerrarPrepStatement(pstm);
			Conexion.cerrarConexion(conn);
		} else {
			conn.rollback();
			Conexion.cerrarPrepStatement(pstm);
			Conexion.cerrarConexion(conn);
			System.out.println("No se pudo eliminar la venta");
		}
	}
	
	private Date TimestampADate(Timestamp ts) {
		java.util.Date d = new java.util.Date(ts.getTime());
		return d;
	}
	
	private Timestamp DateATimestamp(java.util.Date d) {
		Timestamp ts = new Timestamp(d.getTime());
		return ts;
	}
	
	private String Alianzas1 (Alianzas alianza) {
		String alianza1 = String.valueOf(alianza);
		return alianza1;
	}
	
	private Alianzas Alianzas2(String Stalianza) {
		Alianzas al = Alianzas.valueOf(Stalianza);
		return al;
	}
	
	private String obtenerDniCliente(int id, Connection con, PreparedStatement pt, ResultSet rs) throws ClassNotFoundException, SQLException {
		query="SELECT dni FROM bdaerolinea.cliente WHERE idCliente=?";
		String dniCli = null;
		con=Conexion.obtenerConexion();
		pt=con.prepareStatement(query);
		pt.setInt(1, id);
		rs=pt.executeQuery();
		while(rs.next()) {
			dniCli = rs.getString(1);
		}
		return dniCli;
	}
	
	private String obtenerNumVuelo(int id, Connection con, PreparedStatement pt, ResultSet rs) throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		query="SELECT numVuelo FROM bdaerolinea.vuelos WHERE idVuelo=?";
		String numVu = null;
		con=Conexion.obtenerConexion();
		pt=con.prepareStatement(query);
		pt.setInt(1, id);
		rs=pt.executeQuery();
		while(rs.next()) {
			numVu = rs.getString(1);
		}
		return numVu;
	}
	
}
