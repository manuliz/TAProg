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
import edu.usal.negocio.DAO.Interfaces.PaisDAO;
import edu.usal.negocio.Dominio.Pais;

public class PaisDAOImplementacionString implements PaisDAO{
	
	private File arch;
	private BufferedReader br;
	private BufferedWriter	bw;
	private FileReader fr;
	private FileWriter fw;
	private propertiesUtil properties;
	private Scanner scan;
	
	
	
	public PaisDAOImplementacionString() {
		this.properties = new propertiesUtil();
	}

	private Pais parceoPais(String cas) {
		String ars[] = cas.split(";");
		Pais p = new Pais();
		p.setIdPais(Integer.valueOf(ars[0]));
		p.setNombrePais(ars[1]);
		
		return null;
	}

	@Override
	public Pais obtenerPais(String nomPais) throws FileNotFoundException, IOException {
		List<Pais> lista1 = this.obtenerPaises();
		for(Pais a : lista1) {
			if(a.getNombrePais().equals(nomPais)) {
				return a;
			}
		}
		return null;
	}

	@Override
	public List<Pais> obtenerPaises() throws FileNotFoundException, IOException {
		this.arch = new File(properties.obtenerDirecPais(), properties.obtenerNomArchPais());
		if(!arch.exists()) {
			arch = new File(properties.obtenerDirecPais());
			arch.mkdir();
			arch = new File (properties.obtenerDirecPais(), properties.obtenerNomArchPais());
			arch.createNewFile();
			
			return new ArrayList<Pais>();
		}
		
		this.fr = new FileReader(arch);
		this.br = new BufferedReader(fr);
		List<Pais> lista2 = new ArrayList();
		this.scan = new Scanner(arch);
		
		while(scan.hasNextLine()) {
			lista2.add(this.parceoPais(scan.nextLine()));
		}
		
		br.close();
		fr.close();
		scan.close();
		
		return lista2;
	}
	
}
