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
import edu.usal.negocio.DAO.Interfaces.LineasAereasDAO;
import edu.usal.negocio.Dominio.LineasAereas;

public class LineasAereasDAOImplementacionStream implements LineasAereasDAO{
	
	private File arch;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	private FileInputStream fis;
	private FileOutputStream fos;
	private propertiesUtil properties;
	
	
	public LineasAereasDAOImplementacionStream() {
		super();
		properties = new propertiesUtil();
	}

	private void guardar(List<LineasAereas> lista1) throws FileNotFoundException, IOException {
		this.arch = new File(propertiesUtil.obtenerDirecArchivos(), propertiesUtil.obtenerNomLineasAereas());
		this.fos = new FileOutputStream(arch, false);
		this.oos = new ObjectOutputStream(fos);
		oos.writeObject(lista1);
		oos.close();
		fos.close();
	}

	@Override
	public LineasAereas obtenerLineaAerea(int idLineaAerea) throws FileNotFoundException, IOException {
		List<LineasAereas> lista2 = this.obtenerLineasAereas();
		for(LineasAereas a : lista2) {
			if(a.getIdLineasAereas() == idLineaAerea) {
				return a;
			}
		}
		return null;
	}

	@Override
	public List<LineasAereas> obtenerLineasAereas() throws FileNotFoundException, IOException {
		this.arch = new File(propertiesUtil.obtenerDirecArchivos(), propertiesUtil.obtenerNomLineasAereas());
		if(!arch.exists()) {
			arch = new File(propertiesUtil.obtenerDirecArchivos());
			arch.mkdir();
			arch = new File(propertiesUtil.obtenerDirecArchivos(), propertiesUtil.obtenerNomLineasAereas());
			arch.createNewFile();
			
			return new ArrayList<LineasAereas>();
		}
		List<LineasAereas> lista3 = new ArrayList();
		this.fis = new FileInputStream(arch);
		this.ois = new ObjectInputStream(fis);
		try {
			lista3 = (ArrayList<LineasAereas>)ois.readObject();
			ois.close();
			fis.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lista3;
	}

	@Override
	public void crearLineaAerea(LineasAereas lineasAereas) throws FileNotFoundException, IOException {
		List<LineasAereas> lista4 = this.obtenerLineasAereas();
		lista4.add(lineasAereas);
		
		this.guardar(lista4);
		
	}

	@Override
	public void actualizarLineaAerea(LineasAereas lineasAereas) throws FileNotFoundException, IOException {
		List<LineasAereas> lista5 = this.obtenerLineasAereas();
		for(LineasAereas a : lista5) {
			if(a.getIdLineasAereas() == lineasAereas.getIdLineasAereas()) {
				a.setAlianzas(lineasAereas.getAlianzas());
				a.setIdLineasAereas(lineasAereas.getIdLineasAereas());
				a.setNombreAerolinea(lineasAereas.getNombreAerolinea());
				
				this.guardar(lista5);
			}
		}
	}

	@Override
	public void eliminarLineaAerea(int idLineasAereas) throws FileNotFoundException, IOException {
		List<LineasAereas> lista6 = this.obtenerLineasAereas();
		for(LineasAereas a : lista6) {
			if(a.getIdLineasAereas() == idLineasAereas) {
				lista6.remove(a);
				
				this.guardar(lista6);
				return;
			}
		}
	}

}
