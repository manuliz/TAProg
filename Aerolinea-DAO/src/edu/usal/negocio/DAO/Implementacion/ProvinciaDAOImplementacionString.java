package edu.usal.negocio.DAO.Implementacion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;

import edu.usal.Util.propertiesUtil;
import edu.usal.negocio.DAO.Interfaces.ProvinciaDAO;
import edu.usal.negocio.Dominio.Provincia;

public class ProvinciaDAOImplementacionString implements ProvinciaDAO{
	
	private File arch;
	private propertiesUtil properties;
	private Scanner scan;
	private FileWriter fwr;
	private BufferedWriter bwr;
	private Hashtable<Integer, String> hp = new Hashtable<>();
	private Enumeration<Integer> cod;
	private Enumeration<String> nom;
	private Hashtable<Integer, String> provs = new Hashtable<>();

	public ProvinciaDAOImplementacionString() {
		this.properties = new propertiesUtil();
	}


	@Override
	public Hashtable<Integer, String> obtenerProvincias() throws FileNotFoundException, IOException {
		this.arch = new File(propertiesUtil.obtenerDirecArchivos(), propertiesUtil.obtenerNomArchProvincias());
		this.scan = new Scanner(arch);
		Hashtable<Integer, String> hash = new Hashtable<>();
		if(arch.canRead()) {
			while(scan.hasNextLine()) {
				String[] ars = scan.nextLine().split(";");
				hash.put(Integer.valueOf(ars[0]), ars[1]);
			}
		}
		return hash;
	}


	@Override
	public void crearProvincia(Provincia prov) throws IOException {
		
		provs = this.obtenerProvincias();		
		this.arch = new File(propertiesUtil.obtenerDirecArchivos(), propertiesUtil.obtenerNomArchProvincias());
		this.scan = new Scanner(arch);
		if(!arch.exists()) {
			arch.createNewFile();
		} else if(arch.canRead()) {
			provs.put(prov.getIdProvincia(), prov.getNombreProvincia());
			cod = provs.keys();
			nom = provs.elements();
			String ars[];
			while(cod.hasMoreElements() || nom.hasMoreElements()) {
				
			}
				
		}
	}
	
	@Override
	public void actualizarProvincia(Provincia prov) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void eliminarProvincia(int idProvincia) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Provincia obtenerProvincia(int idProvincia) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
		
}
