package edu.usal.negocio.Dominio;

import java.io.Serializable;

public class Direccion implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int idDireccion;
	Pais pais;
	Provincia prov;
	private String ciudad;
	private String calle;
	private String altura;
	private String codPostal;
	
	public Direccion(int idDireccion, Pais pais, Provincia prov, String ciudad, String calle, String altura,
			String codPostal) {
		super();
		this.idDireccion = idDireccion;
		this.pais = pais;
		this.prov = prov;
		this.ciudad = ciudad;
		this.calle = calle;
		this.altura = altura;
		this.codPostal = codPostal;
	}

	public Direccion() {
		super();
	}

	public int getIdDireccion() {
		return idDireccion;
	}

	public void setIdDireccion(int idDireccion) {
		this.idDireccion = idDireccion;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public Provincia getProv() {
		return prov;
	}

	public void setProv(Provincia prov) {
		this.prov = prov;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getAltura() {
		return altura;
	}

	public void setAltura(String altura) {
		this.altura = altura;
	}

	public String getCodPostal() {
		return codPostal;
	}

	public void setCodPostal(String codPostal) {
		this.codPostal = codPostal;
	}

	@Override
	public String toString() {
		return "Direccion [idDireccion=" + idDireccion + ", pais=" + pais + ", prov=" + prov + ", ciudad=" + ciudad
				+ ", calle=" + calle + ", altura=" + altura + ", codPostal=" + codPostal + "]";
	}

}
