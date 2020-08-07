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
import edu.usal.negocio.DAO.Interfaces.VentasDAO;
import edu.usal.negocio.Dominio.Ventas;

public class VentasDAOImplementacionStream implements VentasDAO{
	
	private File arch;
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	private FileInputStream fis;
	private FileOutputStream fos;
	private propertiesUtil properties;
	

	public VentasDAOImplementacionStream() {
		super();
		this.properties = new propertiesUtil();
	}
	
	private void guardar(List<Ventas> listaa) throws FileNotFoundException, IOException {
		this.arch = new File(properties.obtenerDirecArchivos(), properties.obtenerNomArchVentas());
		this.fos = new FileOutputStream(arch, false);
		this.oos = new ObjectOutputStream(fos);
		oos.writeObject(listaa);
		oos.close();
		fos.close();
	}

	@Override
	public Ventas obtenerVenta(int idVenta) throws FileNotFoundException, IOException {
		List<Ventas> lista1 = this.obtenerVentas();
		for(Ventas a : lista1) {
			if(a.getIdVenta() == idVenta) {
				return a;
			}
		}
		return null;
	}

	@Override
	public List<Ventas> obtenerVentas() throws FileNotFoundException, IOException {
		this.arch = new File(properties.obtenerDirecArchivos(), properties.obtenerNomArchVentas());
		if(!arch.exists()) {
			this.arch = new File(properties.obtenerDirecArchivos());
			arch.mkdir();
			this.arch = new File(properties.obtenerDirecArchivos(), properties.obtenerNomArchVentas());
			arch.createNewFile();
			
			return new ArrayList<Ventas>();
		}
		List<Ventas> lista2 = new ArrayList<>();
		this.fis = new FileInputStream(arch);
		this.ois = new ObjectInputStream(fis);
		try {
			lista2 = (ArrayList<Ventas>)ois.readObject();
			ois.close();
			fis.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista2;
	}

	@Override
	public void crearVenta(Ventas venta) throws FileNotFoundException, IOException {
		List<Ventas> lista3 = this.obtenerVentas();
		lista3.add(venta);
		
		this.guardar(lista3);
		
	}

	@Override
	public void actualizarVenta(Ventas venta) throws FileNotFoundException, IOException {
		List<Ventas> lista4 = this.obtenerVentas();
		if(lista4.isEmpty()) {
			return;
		}else {
			for(Ventas a : lista4) {
				if(a.getIdVenta() == venta.getIdVenta()) {
					a.setIdVenta(venta.getIdVenta());
					a.setCliente(venta.getCliente());
					a.setVuelo(venta.getVuelo());
					a.setAerolinea(venta.getAerolinea());
					a.setFechaYhoraVenta(venta.getFechaYhoraVenta());
					a.setFormaPago(venta.getFormaPago());
				
					this.guardar(lista4);
					return;
				}
			}
		}
	}

	@Override
	public void eliminarVenta(Ventas venta) throws FileNotFoundException, IOException {
		List<Ventas> lista5 = this.obtenerVentas();
		if(lista5.isEmpty()) {
			return;
		}else {
			for(Ventas a : lista5) {
				if(a.getIdVenta() == venta.getIdVenta()) {
					lista5.remove(a);
					
					this.guardar(lista5);
					return;
				}
			}
		}
	}
	
	

}
