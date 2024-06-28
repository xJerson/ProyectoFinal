package model;

import java.time.LocalDateTime;

public class Usuario {

	private int idUsuario;
	private String nombreCompleto;
	private String correo;
	private String contrase�a;
	private Perfil perfil;
	private int usuarioRegistro;
	private LocalDateTime fechaRegistro;
	private int usuarioUltModificacion;
	private LocalDateTime fechaUltModificacion;
	
	public Usuario() {
		//super();
	}

	public Usuario(int idUsuario, String nombreCompleto, String correo, String contrase�a, Perfil perfil,
			int usuarioRegistro, LocalDateTime fechaRegistro, int usuarioUltModificacion,
			LocalDateTime fechaUltModificacion) {
		//super();
		this.idUsuario = idUsuario;
		this.nombreCompleto = nombreCompleto;
		this.correo = correo;
		this.contrase�a = contrase�a;
		this.perfil = perfil;
		this.usuarioRegistro = usuarioRegistro;
		this.fechaRegistro = fechaRegistro;
		this.usuarioUltModificacion = usuarioUltModificacion;
		this.fechaUltModificacion = fechaUltModificacion;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContrase�a() {
		return contrase�a;
	}

	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public int getUsuarioRegistro() {
		return usuarioRegistro;
	}

	public void setUsuarioRegistro(int usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}

	public LocalDateTime getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(LocalDateTime fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public int getUsuarioUltModificacion() {
		return usuarioUltModificacion;
	}

	public void setUsuarioUltModificacion(int usuarioUltModificacion) {
		this.usuarioUltModificacion = usuarioUltModificacion;
	}

	public LocalDateTime getFechaUltModificacion() {
		return fechaUltModificacion;
	}

	public void setFechaUltModificacion(LocalDateTime fechaUltModificacion) {
		this.fechaUltModificacion = fechaUltModificacion;
	}

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", nombreCompleto=" + nombreCompleto + ", correo=" + correo
				+ ", contrase�a=" + contrase�a + ", perfil=" + perfil + ", usuarioRegistro=" + usuarioRegistro
				+ ", fechaRegistro=" + fechaRegistro + ", usuarioUltModificacion=" + usuarioUltModificacion
				+ ", fechaUltModificacion=" + fechaUltModificacion + "]";
	}


	
	
}
