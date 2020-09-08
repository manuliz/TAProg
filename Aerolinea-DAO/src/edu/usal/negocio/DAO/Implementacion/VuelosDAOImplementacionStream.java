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
import java.util.Properties;

import edu.usal.Util.propertiesUtil;
import edu.usal.negocio.DAO.Interfaces.VuelosDAO;
import edu.usal.negocio.Dominio.Vuelos;

public class VuelosDAOImplementacionStream implements VuelosDAO{
	
	private File arch;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	private FileInputStream fis;
	private FileOutputStream fos;
	private propertiesUtil properties;
	
	public VuelosDAOImplementacionStream () {
		properties = new propertiesUtil();
	}
	
	private void guardar(List<Vuelos> lista1) throws FileNotFoundException, IOException {
		this.arch = new File(properties.obtenerDirecArchivos(), properties.obtenerNomArchVuelos());
		this.fos = new FileOutputStream(arch, false);
		this.oos = new ObjectOutputStream(fos);
		oos.writeObject(lista1);
		oos.close();
		fos.close();
	}

	@Override
	public Vuelos obtenerVuelo(String numVuelo) throws FileNotFoundException, IOException {
		List<Vuelos> lista2 = this.obtenerVuelos();
		for(Vuelos a : lista2) {
			if(a.getNumDeVuelos().equals(numVuelo)) {
				return a;
			}
		}
		return null;
	}

	@Override
	public List<Vuelos> obtenerVuelos() throws FileNotFoundException, IOException {
		this.arch = new File(properties.obtenerDirecArchivos(), properties.obtenerNomArchVuelos());
		if(!arch.exists()) {
			arch = new File(properties.obtenerDirecArchivos());
			arch.mkdir();
			arch = new File(properties.obtenerDirecArchivos(), properties.obtenerNomArchVuelos());
			arch.createNewFile();
			
			return new ArrayList<Vuelos>();
		}
		List<Vuelos> lista3 = new ArrayList<>();
		this.fis = new FileInputStream(arch);
		this.ois = new ObjectInputStream(fis);
		try {
			lista3 = (ArrayList<Vuelos>)ois.readObject();
			ois.close();
			fis.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista3;
	}

	@Override
	public void crearVuelo(Vuelos vuelo) throws FileNotFoundException, IOException {
		List<Vuelos> lista4 = this.obtenerVuelos();
		lista4.add(vuelo);
		
		this.guardar(lista4);
	}

	@Override
	public void actualizarVuelo(Vuelos vuelo) throws FileNotFoundException, IOException {
		List<Vuelos> lista5 = this.obtenerVuelos();
		if(lista5.isEmpty()) {
			return;
		}else {
			for(Vuelos a : lista5) {
				if(a.getNumDeVuelos() == vuelo.getNumDeVuelos()) {
					a.setIdVuelos(vuelo.getIdVuelos());
					a.setNumDeVuelos(vuelo.getNumDeVuelos());
					a.setCantDeAsientos(vuelo.getCantDeAsientos());
					a.setTiempoDeVuelo(vuelo.getTiempoDeVuelo());
					a.setAeropuertoSalida(vuelo.getAeropuertoSalida());
					a.setAeropuertoLlegada(vuelo.getAeropuertoLlegada());
					
					this.guardar(lista5);
				}
			}
		}
	}

	@Override
	public void eliminarVuelo(Vuelos vuelo) throws FileNotFoundException, IOException {
		List<Vuelos> lista6 = this.obtenerVuelos();
		if(lista6.isEmpty()) {
			return;
		}else {
			for(Vuelos a : lista6) {
				if(vuelo.getNumDeVuelos() == a.getNumDeVuelos());
				lista6.remove(a);
				
				this.guardar(lista6);
				return;
			}
		}
		
	}

}
