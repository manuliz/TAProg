package edu.usal.negocio;

public class Provincia {
	
	private int idProvincia;
	private String nombreProvincia;
	
	public Provincia(int idProvincia, String nombreProvincia) {
		super();
		this.idProvincia = idProvincia;
		this.nombreProvincia = nombreProvincia;
	}

	public int getIdProvincia() {
		return idProvincia;
	}

	public void setIdProvincia(int idProvincia) {
		this.idProvincia = idProvincia;
	}

	public String getNombreProvincia() {
		return nombreProvincia;
	}

	public void setNombreProvincia(String nombreProvincia) {
		this.nombreProvincia = nombreProvincia;
	}

	@Override
	public String toString() {
		return "Provincia [idProvincia=" + idProvincia + ", nombreProvincia=" + nombreProvincia + "]";
	}

}
