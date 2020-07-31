package edu.usal.negocio.DAO.Implementacion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import edu.usal.Util.propertiesUtil;
import edu.usal.negocio.DAO.Interfaces.ProvinciaDAO;
import edu.usal.negocio.Dominio.Provincia;

public class ProvinciaDAOImplementacionString implements ProvinciaDAO{
	
	private File arch;
	private FileWriter fw;
	private FileReader fr;
	private BufferedWriter bw;
	private BufferedReader br;
	private propertiesUtil properties;
	private Scanner scan;
	
	

	public ProvinciaDAOImplementacionString() {
		this.properties = new propertiesUtil();
	}
	
	public Provincia parceoProvincia(String cas) {
		String ars[] = cas.split(";");
		Provincia prov =  new Provincia();
		prov.setIdProvincia(Integer.valueOf(ars[0]));
		prov.setNombreProvincia(ars[1]);
		
		return prov;
	}

	@Override
	public Provincia obtenerProvincia(String nomProvincia) throws FileNotFoundException, IOException {
		List<Provincia> lista1 = this.obtenerProvincias();
		for(Provincia a : lista1) {
			if(a.getNombreProvincia().equals(nomProvincia)) {
				return a;
			}
		}
		return null;
	}

	@Override
	public List<Provincia> obtenerProvincias() throws FileNotFoundException, IOException {
		this.arch = new File(properties.obtenerDirecProvincias(), properties.obtenerNomArchProvincias());
		if(!arch.exists()) {
			arch = new File(properties.obtenerDirecProvincias());
			arch.mkdir();
			arch = new File(properties.obtenerDirecProvincias(), properties.obtenerNomArchProvincias());
			arch.createNewFile();
			
			return new ArrayList<Provincia>();
		}
		
		this.fr = new FileReader(arch);
		this.br = new BufferedReader(fr);
		List<Provincia> lista2 = new ArrayList();
		this.scan = new Scanner(arch);
		
		while(scan.hasNextLine()) {
			lista2.add(this.parceoProvincia(scan.nextLine()));
		}
		
		br.close();
		fr.close();
		scan.close();
		return lista2;
	}
	
}
