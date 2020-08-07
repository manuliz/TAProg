package edu.usal.negocio.DAO.Implementacion;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Scanner;

import edu.usal.Util.propertiesUtil;
import edu.usal.negocio.DAO.Interfaces.AlianzasDAO;

public class AlianzasDAOImplementacionString implements AlianzasDAO{
	
	private File arch;
	private Scanner scan;
	private propertiesUtil properties;
	
	

	public AlianzasDAOImplementacionString() {
		super();
		this.properties = new propertiesUtil();
	}



	@Override
	public Hashtable<Integer, String> obtenerAlianzas() throws FileNotFoundException, IOException {
		this.arch = new File(properties.obtenerDirecArchivos(), properties.obtenerNomArchAlianzas());
		this.scan = new Scanner(arch);
		Hashtable<Integer, String> hashAl = new Hashtable<>();
		if(arch.canRead()) {
			while(scan.hasNextLine()) {
				String[] ars = scan.nextLine().split(";");
				hashAl.put(Integer.valueOf(ars[0]), ars[1]);
			}
		}
		return hashAl;
	}

}
