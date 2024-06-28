package model;

import java.time.LocalDate;

public class Tarea {

	private int idTarea;
	private String descripcion;
	private Usuario idEmpleado;
	private String estado;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	
	public Tarea() {
		//super();
	}

	public Tarea(int idTarea, String descripcion, Usuario idEmpleado, String estado, LocalDate fechaInicio,
			LocalDate fechaFin) {
		super();
		this.idTarea = idTarea;
		this.descripcion = descripcion;
		this.idEmpleado = idEmpleado;
		this.estado = estado;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
	}

	public int getIdTarea() {
		return idTarea;
	}

	public void setIdTarea(int idTarea) {
		this.idTarea = idTarea;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Usuario getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(Usuario idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
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
	
	
}
