package com.BeeCare_Proyecto.BeeCare.app.dto;

import javax.persistence.Column;
import javax.persistence.Id;

public class UsuarioRegistroDTO {
	@Id
	private Long id_usuario;
	private String nombre_usuario;
	private String correo;
	private String contrasena;

	public Long getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Long id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getNombre_usuario() {
		return nombre_usuario;
	}

	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public UsuarioRegistroDTO(Long id_usuario, String nombre_usuario, String correo, String contrasena) {
		super();
		this.id_usuario = id_usuario;
		this.nombre_usuario = nombre_usuario;
		this.correo = correo;
		this.contrasena = contrasena;
	}

	public UsuarioRegistroDTO(String nombre_usuario, String correo, String contrasena) {
		super();
		this.nombre_usuario = nombre_usuario;
		this.correo = correo;
		this.contrasena = contrasena;
	}

	public UsuarioRegistroDTO(String nombre_usuario) {
		super();
		this.nombre_usuario = nombre_usuario;
	}

	public UsuarioRegistroDTO() {

	}

}
