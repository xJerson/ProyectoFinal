package model;

import java.time.LocalDate;
import java.time.LocalDateTime;


public class Proyecto {

	private int idProyecto;
	private String nombre;
	private String descripcion;
	
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private String estado;
	private Usuario usuarioRegistro;
	private LocalDateTime fechaRegistro;
	private Usuario usuarioUltiModificacion;
	private LocalDateTime fechaUltiModificacion;
	
	public Proyecto() {
		//super();
	}

	
	public Proyecto(int idProyecto, String nombre, String descripcion, LocalDate fechaInicio, LocalDate fechaFin,
			String estado, Usuario usuarioRegistro, LocalDateTime fechaRegistro, Usuario usuarioUltiModificacion,
			LocalDateTime fechaUltiModificacion) {
		//super();
		this.idProyecto = idProyecto;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.estado = estado;
		this.usuarioRegistro = usuarioRegistro;
		this.fechaRegistro = fechaRegistro;
		this.usuarioUltiModificacion = usuarioUltiModificacion;
		this.fechaUltiModificacion = fechaUltiModificacion;
	}

	public int getIdProyecto() {
		return idProyecto;
	}

	public void setIdProyecto(int idProyecto) {
		this.idProyecto = idProyecto;
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

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Usuario getUsuarioRegistro() {
		return usuarioRegistro;
	}

	public void setUsuarioRegistro(Usuario usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}

	public LocalDateTime getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(LocalDateTime fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public Usuario getUsuarioUltiModificacion() {
		return usuarioUltiModificacion;
	}

	public void setUsuarioUltiModificacion(Usuario usuarioUltiModificacion) {
		this.usuarioUltiModificacion = usuarioUltiModificacion;
	}

	public LocalDateTime getFechaUltiModificacion() {
		return fechaUltiModificacion;
	}

	public void setFechaUltiModificacion(LocalDateTime fechaUltiModificacion) {
		this.fechaUltiModificacion = fechaUltiModificacion;
	}


	@Override
	public String toString() {
		return "Proyecto [idProyecto=" + idProyecto + ", nombre=" + nombre + ", descripcion=" + descripcion
				+ ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", estado=" + estado
				+ ", usuarioRegistro=" + usuarioRegistro + ", fechaRegistro=" + fechaRegistro
				+ ", usuarioUltiModificacion=" + usuarioUltiModificacion + ", fechaUltiModificacion="
				+ fechaUltiModificacion + "]";
	}
	
	
}
