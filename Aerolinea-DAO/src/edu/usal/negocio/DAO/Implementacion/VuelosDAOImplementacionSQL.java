package edu.usal.negocio.DAO.Implementacion;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Date;
import edu.usal.Util.Conexion;
import edu.usal.negocio.DAO.Interfaces.VuelosDAO;
import edu.usal.negocio.Dominio.Vuelos;

public class VuelosDAOImplementacionSQL implements VuelosDAO{
	
	private Connection conn;
	private PreparedStatement pstm;
	private String query;
	
	private Timestamp DateATimestamp(java.util.Date d) {
		Timestamp ts = new Timestamp(d.getTime());
		return ts;
	}
	
	private Date TimestampADate(Timestamp ts) {
		java.util.Date d = new java.util.Date(ts.getTime());
		
		return d;
	}

	@Override
	public Vuelos obtenerVuelo(int numVuelo) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Vuelos> obtenerVuelos() throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void crearVuelo(Vuelos vuelo) throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		
		query = "INSERT INTO bdaerolinea.vuelos (idVuelo, numVuelo, cantAsientos, tiempoDevUelo, idAerolinea, idAeropuertoSalida, idAeropuertoLlegada, fhSalida, fhLlegada) VALUES (?,?,?,?,?,?,?,?,?)";
		conn=Conexion.obtenerConexion();
		conn.setAutoCommit(false);
		pstm=conn.prepareStatement(query);
		pstm.setInt(1,vuelo.getIdVuelos());
		pstm.setInt(2,vuelo.getNumDeVuelos());
		pstm.setInt(3, vuelo.getCantDeAsientos());
		pstm.setString(4, vuelo.getTiempoDeVuelo());
		pstm.setInt(5, vuelo.getLineaAerea().getIdLineasAereas());
		pstm.setInt(6, vuelo.getAeropuertoSalida().getIdAeropuerto());
		pstm.setInt(7, vuelo.getAeropuertoLlegada().getIdAeropuerto());
		pstm.setTimestamp(8, DateATimestamp(vuelo.getFhSalida()));
		pstm.setTimestamp(9, DateATimestamp(vuelo.getFhLlegada()));
		
		int pos = pstm.executeUpdate();
		if(pos==0) {
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
	public void actualizarVuelo(Vuelos vuelo) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarVuelo(Vuelos vuelo) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		
	}

}
