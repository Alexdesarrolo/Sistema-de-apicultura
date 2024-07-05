package com.BeeCare_Proyecto.BeeCare.app.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "apiario")
@Data
public class Apiario {
	
	@Id
	private long id;
	
	@Column(name = "nombre", nullable=false, length = 60)
	private String nombre;
	
	@Column(name = "numeroColmenas", nullable = false)
	private int numeroColmenas;
	
	@Column(name = "direccion", nullable=false, length = 60)
	private String direccion;
	
	@ManyToOne
	@JoinColumn(name = "_apicultor")
	private Apicultor apicultor;
	
	@ManyToOne
	@JoinColumn(name = "_municipio")
	private Municipio municipio;
	
	public Apiario() {
		super();
	}

	public Apiario(String nombre, int numeroColmenas, String direccion, Apicultor apicultor, Municipio municipio) {
		super();
		this.nombre = nombre;
		this.numeroColmenas = numeroColmenas;
		this.direccion = direccion;
		this.apicultor = apicultor;
		this.municipio = municipio;
	}

	public Apiario(long id, String nombre, int numeroColmenas, String direccion, Apicultor apicultor,
			Municipio municipio) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.numeroColmenas = numeroColmenas;
		this.direccion = direccion;
		this.apicultor = apicultor;
		this.municipio = municipio;
	}

	
	public Apiario(String nombre, int numeroColmenas, String direccion, Apicultor apicultor) {
		super();
		this.nombre = nombre;
		this.numeroColmenas = numeroColmenas;
		this.direccion = direccion;
		this.apicultor = apicultor;
	}

	public Apiario(long id) {
		super();
		this.id = id;
	}

	public Apiario(Municipio municipio) {
		super();
		this.municipio = municipio;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNumeroColmenas() {
		return numeroColmenas;
	}

	public void setNumeroColmenas(int numeroColmenas) {
		this.numeroColmenas = numeroColmenas;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Apicultor getApicultor() {
		return apicultor;
	}

	public void setApicultor(Apicultor apicultor) {
		this.apicultor = apicultor;
	}

	public Municipio getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}
	
	
	

}
