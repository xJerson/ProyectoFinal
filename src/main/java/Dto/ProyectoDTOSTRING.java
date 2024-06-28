package Dto;

import model.Usuario;

public class ProyectoDTOSTRING {
	private String nombre;
    private String descripcion;
    private String fechaInicio;
    private String fechaFin;    
    private String estado;
    private Usuario usuarioRegistro;
    public ProyectoDTOSTRING(){
    }
    
    
	public ProyectoDTOSTRING(String nombre, String descripcion, String fechaInicio, String fechaFin, String estado,
		Usuario usuarioRegistro) {
		//super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.estado = estado;
		this.usuarioRegistro = usuarioRegistro;
	}


	public Usuario getUsuarioRegistro() {
		return usuarioRegistro;
	}


	public void setUsuarioRegistro(Usuario usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}


	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public String getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
    
    
}
