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
import edu.usal.negocio.DAO.Interfaces.ClienteDAO;
import edu.usal.negocio.DAO.Interfaces.DireccionDAO;
import edu.usal.negocio.DAO.Interfaces.LineasAereasDAO;
import edu.usal.negocio.DAO.Interfaces.PasajeroFrecuenteDAO;
import edu.usal.negocio.DAO.Interfaces.PasaporteDAO;
import edu.usal.negocio.DAO.Interfaces.TelefonoDAO;
import edu.usal.negocio.Dominio.Alianzas;
import edu.usal.negocio.Dominio.Cliente;
import edu.usal.negocio.Dominio.PasajeroFrecuente;
import edu.usal.negocio.Dominio.Pasaporte;
import edu.usal.negocio.Dominio.Telefono;

public class ClienteDAOImplementacionSQL implements ClienteDAO{
	
	private Connection conn;
	private PreparedStatement pstm;
	private ResultSet rst;
	private String query;
	PasaporteDAO pd = new PasaporteDAOImplementacionSQL();
	TelefonoDAO td = new TelefonoDAOImplementacionSQL();
	PasajeroFrecuenteDAO pfd = new PasajeroFrecuenteDAOImplementacionSQL();
	DireccionDAO dd = new DireccionDAOImplementacionSQL();
	
	private Date TimestampADate(Timestamp ts) {
		java.util.Date d = new java.util.Date(ts.getTime());
		return d;
	}
	
	private Timestamp DateATimestamp(java.util.Date d) {
		Timestamp ts = new Timestamp(d.getTime());
		return ts;
	}
	

	@Override
	public Cliente obtenerCliente(String dni) throws IOException, FileNotFoundException, ClassNotFoundException, SQLException {
		query="SELECT * FROM bdaerolinea.cliente WHERE dni=?";
		Cliente cli = new Cliente();
		conn=Conexion.obtenerConexion();
		pstm=conn.prepareStatement(query);
		pstm.setString(1, dni);
		rst=pstm.executeQuery();
		while(rst.next()) {
			cli.setIdCliente(rst.getInt(1));
			cli.setNombreApellido(rst.getString(2));
			cli.setDni(rst.getString(3));
			cli.setPasaporte(pd.obtenerPasaporte(rst.getInt(4)));
			cli.setCuit_cuil(rst.getString(5));
			cli.setFechaNac(TimestampADate(rst.getTimestamp(6)));
			cli.seteMail(rst.getString(7));
			cli.setTelefono(td.obtenerTelefono(rst.getInt(8)));
			cli.setNumPasajeroFrec(pfd.obtenerPasajeroFrecuente(rst.getInt(9)));
			cli.setDireccion(dd.obtenerDireccion(rst.getInt(10)));
		}
		Conexion.cerrarPrepStatement(pstm);
		Conexion.cerrarResultSet(rst);
		Conexion.cerrarConexion(conn);
		return cli;
	}

	@Override
	public List<Cliente> obtenerClientes() throws IOException, FileNotFoundException, ClassNotFoundException, SQLException {
		query="SELECT * FROM bdaerolinea.cliente";
		List<Cliente> listaCli = new ArrayList<>();
		Cliente cli;
		conn=Conexion.obtenerConexion();
		pstm=conn.prepareStatement(query);
		rst=pstm.executeQuery();
		while(rst.next()) {
			cli = new Cliente();
			cli.setIdCliente(rst.getInt(1));
			cli.setNombreApellido(rst.getString(2));
			cli.setDni(rst.getString(3));
			cli.setPasaporte(pd.obtenerPasaporte(rst.getInt(4)));
			cli.setCuit_cuil(rst.getString(5));
			cli.setFechaNac(TimestampADate(rst.getTimestamp(6)));
			cli.seteMail(rst.getString(7));
			cli.setTelefono(td.obtenerTelefono(rst.getInt(8)));
			cli.setNumPasajeroFrec(pfd.obtenerPasajeroFrecuente(rst.getInt(9)));
			cli.setDireccion(dd.obtenerDireccion(rst.getInt(10)));
			listaCli.add(cli);
		}
		Conexion.cerrarResultSet(rst);
		Conexion.cerrarPrepStatement(pstm);
		Conexion.cerrarConexion(conn);
		
		return listaCli;
	}

	@Override
	public void crearCliente(Cliente cliente) throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		query="INSERT INTO bdaerolinea.cliente VALUES(?,?,?,?,?,?,?,?)";
		conn=Conexion.obtenerConexion();
		conn.setAutoCommit(false);
		pstm=conn.prepareStatement(query);
		pstm.setInt(1, cliente.getIdCliente());
		pstm.setString(2,cliente.getNombreApellido());
		pstm.setString(3, cliente.getDni());
		pd.crearPasaporte(cliente);
		pstm.setInt(4, cliente.getPasaporte().getIdPasaporte());
		pstm.setString(5, cliente.getCuit_cuil());
		pstm.setTimestamp(6, DateATimestamp(cliente.getFechaNac()));
		pstm.setString(7,cliente.geteMail());
		td.crearTelefono(cliente);
		pstm.setInt(8, cliente.getTelefono().getIdTelefono());
		pfd.crearPasajeroFrecuente(cliente);
		pstm.setInt(9, cliente.getNumPasajeroFrec().getIdPasajeroFrecuente());
		dd.crearDireccion(cliente);
		pstm.setInt(10, cliente.getDireccion().getIdDireccion());
		int pos = pstm.executeUpdate();
		if(pos==1) {
			conn.commit();
			Conexion.cerrarPrepStatement(pstm);
			Conexion.cerrarConexion(conn);
		}
		conn.rollback();
		Conexion.cerrarPrepStatement(pstm);
		Conexion.cerrarConexion(conn);
		System.out.println("No se puedo generar el cliente.");
		
	}
	
	@Override
	public void actualizarCliente(Cliente cliente) throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		query="UPDATE bdaerolinea.cliente SET nombreApellido=?, idPasaporte=?, cuit-cuil=?, fechaNacimiento=?, eMail=?, idTelefono=?,"
				+ " idPasajeroFrecuente=?, idDireccion=? WHERE dni=?";
		conn=Conexion.obtenerConexion();
		conn.setAutoCommit(false);
		pstm=conn.prepareStatement(query);
		pstm.setString(1, cliente.getNombreApellido());
		pd.actualizarPasaporte(cliente);
		pstm.setInt(2,  cliente.getPasaporte().getIdPasaporte());
		pstm.setString(3, cliente.getCuit_cuil());
		pstm.setTimestamp(4, DateATimestamp(cliente.getFechaNac()));
		pstm.setString(5, cliente.geteMail());
		td.actualizarTelefono(cliente);
		pstm.setInt(6, cliente.getTelefono().getIdTelefono());
		pfd.actualizarPasajeroFrecuente(cliente);
		pstm.setInt(7,cliente.getNumPasajeroFrec().getIdPasajeroFrecuente());
		dd.actualizarDireccion(cliente);
		pstm.setInt(8, cliente.getDireccion().getIdDireccion());
		pstm.setString(9, cliente.getDni());
		int pos = pstm.executeUpdate();
		if(pos==1) {
			conn.commit();
			Conexion.cerrarPrepStatement(pstm);
			Conexion.cerrarConexion(conn);
		}
		conn.rollback();
		Conexion.cerrarPrepStatement(pstm);
		Conexion.cerrarConexion(conn);
		System.out.println("No se pudo actualizar el cliente!");
		
	}
	
	@Override
	public void eliminarCliente(Cliente cliente) throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		query="DELETE FROM bdaerolinea.cliente WHERE dni=?";
		conn=Conexion.obtenerConexion();
		conn.setAutoCommit(false);
		pstm=conn.prepareStatement(query);
		pstm.setString(1, cliente.getDni());
		pd.eliminarPasaporte(cliente);
		td.eliminarTelefono(cliente);
		pfd.eliminarPasajeroFrecuente(cliente);
		dd.eliminarDireccion(cliente);
		int pos = pstm.executeUpdate();
		if(pos==1) {
			conn.commit();
			Conexion.cerrarPrepStatement(pstm);
			Conexion.cerrarConexion(conn);
		}
		conn.rollback();
		Conexion.cerrarPrepStatement(pstm);
		Conexion.cerrarConexion(conn);
		System.out.println("No se pudo eliminar al cliente!");
		
	}
	
}
