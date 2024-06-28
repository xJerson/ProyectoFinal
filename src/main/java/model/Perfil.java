package model;


public class Perfil {
	
	private int idPerfil;
	private String nombre;
	
	
	
	@Override
	public String toString() {
		return "Perfil [idPerfil=" +
						idPerfil + 
						", nombre="
						+ nombre + "]";
	}



	public Perfil() {
		//super();
	}



	public Perfil(int idPerfil, String nombre) {
		//super();
		this.idPerfil = idPerfil;
		this.nombre = nombre;
	}



	public int getIdPerfil() {
		return idPerfil;
	}



	public void setIdPerfil(int idPerfil) {
		this.idPerfil = idPerfil;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
