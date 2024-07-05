package com.BeeCare_Proyecto.BeeCare.app.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "perfil")
public class Perfil {

	@Id
	private Long identificacion_perfil;

	@Column(name = "descripcion", nullable = false, length = 25, unique = true)
	private String descripcion;

	public Perfil() {

	}

	public Perfil(Long identificacion_perfil, String descripcion) {
		super();
		this.identificacion_perfil = identificacion_perfil;
		this.descripcion = descripcion;
	}

	public Long getIdentificacion_perfil() {
		return identificacion_perfil;
	}

	public void setIdentificacion_perfil(Long identificacion_perfil) {
		this.identificacion_perfil = identificacion_perfil;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
