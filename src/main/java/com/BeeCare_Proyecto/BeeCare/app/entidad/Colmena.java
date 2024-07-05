package com.BeeCare_Proyecto.BeeCare.app.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="colmena")
public class Colmena {
	
	@Id
	private Long id;
	
	@Column(name = "descripcion", nullable = false, length = 30)
	private String descripcion;
	
	@ManyToOne
	@JoinColumn(name = "apiario_id")
	private Apiario apiario;

	public Colmena() {
		super();
	}

	public Colmena(Long id, String descripcion, Apiario apiario) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.apiario = apiario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Apiario getApiario() {
		return apiario;
	}

	public void setApiario(Apiario apiario) {
		this.apiario = apiario;
	}
	
	
		
		
		


}
