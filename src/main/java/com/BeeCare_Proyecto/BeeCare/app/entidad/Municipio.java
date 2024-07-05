package com.BeeCare_Proyecto.BeeCare.app.entidad;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "municipio")
public class Municipio {

	@Id
	private Long identificacion_municipio;
	
	@Column(name = "descripcion", nullable = false, length = 60, unique = true)
	private String descripcion;
	
	@ManyToOne
	@JoinColumn(name = "departamento_id")
	private Departamento departamento;
	
	
	public Municipio() {
		
	}
	
	public Municipio(Long identificacion_municipio, String descripcion, Departamento departamento) {
		super();
		this.identificacion_municipio = identificacion_municipio;
		this.descripcion = descripcion;
		this.departamento = departamento;
	}

	public Municipio(String descripcion, Departamento departamento) {
		super();
		this.descripcion = descripcion;
		this.departamento = departamento;
	}

	public Municipio(Long identificacion_municipio, String descripcion) {
		super();
		this.identificacion_municipio = identificacion_municipio;
		this.descripcion = descripcion;
		
	}
		public Municipio(String descripcion) {
		super();
		this.descripcion = descripcion;
	}

	public Long getIdentificacion_municipio() {
		return identificacion_municipio;
	
	}
	
	public void setIdentificacion_municipio(Long identificacion_municipio) {
		this.identificacion_municipio = identificacion_municipio;
		
	}
	
	public String getDescripcion() {
		return descripcion;
		
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}



	
}
