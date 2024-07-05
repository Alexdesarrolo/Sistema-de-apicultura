package com.BeeCare_Proyecto.BeeCare.app.entidad;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "departamento")
public class Departamento {

	@Id
	private Long identificacion_departamento;

	@Column(name = "descripcion", nullable = false, length = 60, unique = true)
	private String descripcion;

	public Long getIdentificacion_departamento() {
		return identificacion_departamento;
	}

	public void setIdentificacion_departamento(Long identificacion_departamento) {
		this.identificacion_departamento = identificacion_departamento;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Departamento(Long identificacion_departamento, String descripcion) {
		super();
		this.identificacion_departamento = identificacion_departamento;
		this.descripcion = descripcion;
	}

	public Departamento(Long identificacion_departamento) {
		super();
		this.identificacion_departamento = identificacion_departamento;
	}

	public Departamento(String descripcion) {
		super();
		this.descripcion = descripcion;

	}

	public Departamento() {
		super();
	}

}
