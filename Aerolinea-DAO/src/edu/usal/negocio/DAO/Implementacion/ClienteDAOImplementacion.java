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

import edu.usal.negocio.DAO.Interfaces.ClienteDAO;
import edu.usal.negocio.dominio.Cliente;
import edu.usal.util.propertiesUtil;

public class ClienteDAOImplementacion implements ClienteDAO{
	
	private propertiesUtil properties;
	private File arch;
	private FileOutputStream fos;
	private FileInputStream fis;
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	
	private void guardar(List<Cliente> lista) throws IOException, FileNotFoundException {
		this.arch = new File(properties.obtenerDirecCliente(), properties.obtenerNomArchCliente());
		this.fos = new FileOutputStream(this.arch, false);
		this.oos = new ObjectOutputStream(this.fos);
		oos.writeObject(lista);
		oos.close();
		fos.close();
	}

	@Override
	public Cliente obtenerCliente(String dni) throws IOException, FileNotFoundException  {
		List<Cliente> lista1 = obtenerClientes();
		for(Cliente a : lista1) {
			if(a.getDni().equals(dni)) {
				return a;
			}
		}
		return null;
	}

	@Override
	public List obtenerClientes() throws IOException, FileNotFoundException {
		this.arch = new File (properties.obtenerDirecCliente(), properties.obtenerNomArchCliente());
		if(!arch.exists()) {
			System.out.println("No existe el archivo de clientes, se crea un archivo nuevo");
			arch = new File(properties.obtenerDirecCliente());
			arch.mkdir();
			arch = new File(properties.obtenerDirecCliente(),properties.obtenerNomArchCliente());
			arch.createNewFile();
			
			return new ArrayList<Cliente>();
		}
		List<Cliente> listaCli = new ArrayList<>();
		this.fis = new FileInputStream(this.arch);
		this.ois = new ObjectInputStream(this.fis);
		try {
			listaCli = (ArrayList<Cliente>)ois.readObject();
			this.ois.close();
			this.fis.close();
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}

		return listaCli;
	}

	@Override
	public void crearCliente(Cliente cliente) throws FileNotFoundException, IOException {
		List<Cliente> lista2 = this.obtenerClientes();
		lista2.add(cliente);
		
		this.guardar(lista2);
	}

	@Override
	public void actualizarCliente(Cliente cliente) throws FileNotFoundException, IOException {
		List<Cliente> lista3 = this.obtenerClientes();
		
		if(lista3.isEmpty()) {
			return;
		}else {
		for(Cliente a : lista3) {
			if(a.getDni().equals(cliente.getDni())) {
					a.setIdCliente(cliente.getIdCliente());
					a.setNombreApellido(cliente.getNombreApellido());
					a.setDni(cliente.getDni());
					a.setPasaporte(cliente.getPasaporte());
					a.setCuit_cuil(cliente.getCuit_cuil());
					a.setFechaNac(cliente.getFechaNac());
					a.seteMail(cliente.geteMail());
					a.setTelefono(cliente.getTelefono());
					a.setNumPasajeroFrec(cliente.getNumPasajeroFrec());
					a.setDireccion(cliente.getDireccion());
					
					this.guardar(lista3);
				}
			}
		}
		
	}

	@Override
	public void eliminarCliente(Cliente cliente) throws FileNotFoundException, IOException {
		List<Cliente> lista4 = this.obtenerClientes();
		
		if(lista4.isEmpty()) {
			return;
		}else {
			for(Cliente a: lista4) {
				if(a.getDni().equals(cliente.getDni()) || a.getCuit_cuil().equals(cliente.getCuit_cuil())){
					lista4.remove(a);
					this.guardar(lista4);
					return;
				}
			}
		}
		
	}
	

}
