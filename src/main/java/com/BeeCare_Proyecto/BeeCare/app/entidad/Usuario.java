package com.BeeCare_Proyecto.BeeCare.app.entidad;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table(name="usuario")
public class Usuario {
	@Id
	private Long id_usuario;
	
	//@Column(name = "id_perfil", nullable = false, length = 50)
	//private String id_perfil; 
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	@JoinTable(name="perfiles_usuarios"
	,joinColumns=@JoinColumn(name="id_usuario")
	,inverseJoinColumns=@JoinColumn(name="identificacion_perfil")
			)
	private Set<Perfil> perfiles;
	
	@Column(name = "nombre_usuario", nullable = false, length = 50, unique = true)
	private String nombreUsuario;
	
	@Column(name = "correo", nullable = false, length = 50, unique = true)
	private String correo;
	
	@Column(name = "contrasena", nullable = false)
	private String contrasena;
	
	
	public Usuario(Long id_usuario, Set<Perfil> perfiles, String usuario, String correo, String contraseña) {
		super();
		this.id_usuario = id_usuario;
		this.perfiles = perfiles;
		this.nombreUsuario = usuario;
		this.correo = correo;
		this.contrasena = contraseña;
	}
	
	public Usuario(Set<Perfil> perfiles, String usuario, String correo, String contraseña) {
		super();
		this.perfiles = perfiles;
		this.nombreUsuario = usuario;
		this.correo = correo;
		this.contrasena = contraseña;
	}
	
	public Usuario(String nombre_usuario) {
		super();
		this.nombreUsuario = nombre_usuario;
	}

	public Usuario() {
		
	}
	
	public Long getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(Long id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String usuario) {
		this.nombreUsuario = usuario;
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
	public void setContrasena(String contraseña) {
		this.contrasena = contraseña;
	}

	public Set<Perfil> getPerfiles() {
		return perfiles;
	}

	public void setPerfiles(Set<Perfil> perfiles) {
		this.perfiles = perfiles;
	}
	
	public void yaExiste() {
		System.out.println("Ya existeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
	}
	
	
	
	
	
}
