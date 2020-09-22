package edu.usal.negocio.DAO.Implementacion;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import edu.usal.Util.propertiesUtil;
import edu.usal.negocio.DAO.Interfaces.AeropuertoDAO;
import edu.usal.negocio.Dominio.Aeropuerto;

public class AeropuertoDAOImplementacionStream implements AeropuertoDAO{
	
	private File arch;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	private FileInputStream fis;
	private FileOutputStream fos;
	private propertiesUtil properties;
	
	
	

	public AeropuertoDAOImplementacionStream() {
		super();
		this.properties = new propertiesUtil();
	}
	
	private void guardar(List<Aeropuerto> lisAero) throws FileNotFoundException, IOException {
		this.arch = new File(properties.obtenerDirecArchivos(), properties.obtenerNomArchAeropuerto());
		this.fos = new FileOutputStream(arch, false);
		this.oos = new ObjectOutputStream(fos);
		oos.writeObject(lisAero);
		oos.close();
		fos.close();
	}

	@Override
	public Aeropuerto obtenerAeropuerto(int idCiudad) throws FileNotFoundException, IOException {
		List<Aeropuerto> lista1 = this.obtenerAeropuertos();
		for(Aeropuerto a : lista1) {
			if(a.getIdAeropuerto() == idCiudad) {
				return a;
			}
		}
		return null;
	}

	@Override
	public List<Aeropuerto> obtenerAeropuertos() throws FileNotFoundException, IOException {
		this.arch = new File(propertiesUtil.obtenerDirecArchivos(), propertiesUtil.obtenerNomArchAeropuerto());
		if(!arch.exists()) {
			this.arch = new File(propertiesUtil.obtenerDirecArchivos());
			arch.mkdir();
			this.arch = new File(propertiesUtil.obtenerDirecArchivos(), propertiesUtil.obtenerNomArchAeropuerto());
			arch.createNewFile();
			
			return new ArrayList<Aeropuerto>();
		}
		List<Aeropuerto> lista2 = new ArrayList<>();
		this.fis = new FileInputStream(arch);
		this.ois = new ObjectInputStream(fis);
		try {
			lista2 = (ArrayList<Aeropuerto>)ois.readObject();
			this.ois.close();
			this.fis.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return lista2;
	}

	@Override
	public void crearAeropuerto(Aeropuerto aero) throws FileNotFoundException, IOException {
		List<Aeropuerto> lista3 = this.obtenerAeropuertos();
		lista3.add(aero);
		
		this.guardar(lista3);
		
	}

	@Override
	public void actualizarAeropuerto(Aeropuerto aero) throws FileNotFoundException, IOException {
		List<Aeropuerto> lista4 = this.obtenerAeropuertos();
		if(lista4.isEmpty()) {
			return;
		}else {
		for(Aeropuerto b : lista4) {
			if(b.getIdAeropuerto() == aero.getIdAeropuerto()) {
					b.setIdAeropuerto(aero.getIdAeropuerto());
					b.setCiudad(aero.getCiudad());
					b.setIdentificacionAeropuerto(aero.getIdentificacionAeropuerto());
					b.setPais(aero.getPais());
					b.setProvincia(aero.getProvincia());
					
					this.guardar(lista4);
				}
			}
		}
	}

	@Override
	public void eliminarAeropuerto(int idAero) throws FileNotFoundException, IOException {
		List<Aeropuerto> lista5 = this.obtenerAeropuertos();
		
		if(lista5.isEmpty()) {
			return;
		}else {
			for(Aeropuerto a : lista5) {
				if(idAero == a.getIdAeropuerto()) {
					lista5.remove(a);
					
					this.guardar(lista5);
					return;
				}
			}
		}

		
	}

}
