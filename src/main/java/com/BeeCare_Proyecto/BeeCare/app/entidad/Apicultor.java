package com.BeeCare_Proyecto.BeeCare.app.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="apicultor")
public class Apicultor {
	
	@Id
	private Long cedula;
	
	@Column(name = "nombre1", nullable = false, length = 25)
	private String nombre1;
	
	@Column(name = "nombre2", nullable = false, length = 25)
	private String nombre2;
	
	
	@Column(name = "apellido1", nullable = false, length = 25)
	private String apellido1;
	
	@Column(name = "apellido2", nullable = false, length = 25)
	private String apellido2;
	
	@Column(name = "correo", nullable = false, length = 50)
	private String correo;
	
	@Column(name = "celular", nullable = false, length = 15)
	private String celular;

	public Apicultor(Long cedula, String nombre1, String nombre2, String apellido1, String apellido2, String correo,
			String celular) {
		super();
		this.cedula = cedula;
		this.nombre1 = nombre1;
		this.nombre2 = nombre2;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.correo = correo;
		this.celular = celular;
	}
	
	public Apicultor() {
		
	}

	public Long getCedula() {
		return cedula;
	}

	public void setCedula(Long cedula) {
		this.cedula = cedula;
	}

	public String getNombre1() {
		return nombre1;
	}

	public void setNombre1(String nombre1) {
		this.nombre1 = nombre1;
	}

	public String getNombre2() {
		return nombre2;
	}

	public void setNombre2(String nombre2) {
		this.nombre2 = nombre2;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}
	
	
	
}
