package com.BeeCare_Proyecto.BeeCare.app.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.BeeCare_Proyecto.BeeCare.app.entidad.Usuario;


@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long>{
	
	
	
	//public Usuario findByNombre_usuario(String nombre_usuario); //El error esta aqui+
	//public Usuario  findByCorreo(String correo0);
	
	//public Usuario findByUsuario(String nombre_usuario);
	
	public Usuario  findByNombreUsuario(String nombreUsuario);
	
	@Query("SELECT p FROM Usuario p WHERE p.id_usuario =:id_usuario")
	//SELECT * FROM usuario WHERE usuario.id_usuario = 1;
	public List<Usuario> findAll(Long id_usuario);
}
