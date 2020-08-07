package edu.usal.negocio.DAO.Implementacion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
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
	

	public ProvinciaDAOImplementacionString() {
		this.properties = new propertiesUtil();
	}


	@Override
	public Hashtable<Integer, String> obtenerProvincias() throws FileNotFoundException, IOException {
		this.arch = new File(properties.obtenerDirecArchivos(), properties.obtenerNomArchProvincias());
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
		
}
