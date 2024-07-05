package com.BeeCare_Proyecto.BeeCare.app.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.BeeCare_Proyecto.BeeCare.app.entidad.Usuario;

public interface UsuarioServicio extends UserDetailsService{
	
	public List<Usuario> listarTodosLosUsuarios(Long id);
	
	public Usuario guardarUsuario(Usuario usuario);
	
	public Usuario obtenerUsuarioPorId(Long id);
	
	public Usuario actualizarUsuario(Usuario usuario);
	
	public void eliminarUsuario(Long id);
	
	public Optional<Usuario> findById(Long id); //Nos encuentra usuarios por el id
	
	
}
	
