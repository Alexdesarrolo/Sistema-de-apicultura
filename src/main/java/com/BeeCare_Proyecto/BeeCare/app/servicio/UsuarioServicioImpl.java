package com.BeeCare_Proyecto.BeeCare.app.servicio;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.BeeCare_Proyecto.BeeCare.app.entidad.Perfil;
import com.BeeCare_Proyecto.BeeCare.app.entidad.Usuario;
import com.BeeCare_Proyecto.BeeCare.app.repositorio.UsuarioRepositorio;

@Service
public class UsuarioServicioImpl implements UsuarioServicio{
	
	@Autowired
	private UsuarioRepositorio repositorio;
	
	@Lazy
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public List<Usuario> listarTodosLosUsuarios(Long id) {
		
		if(id != null) {
			System.out.println("holaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa " + id);
			return repositorio.findAll(id);
			
		}
		return repositorio.findAll(); //Lista todos los usuarios
	}

	@Override
	public Usuario guardarUsuario(Usuario usuario) {
		//List<Usuario> verificarExistencia = 
		//System.out.println("existencia: " + usuario.getId_usuario());
		if (obtenerUsuarioPorId(usuario.getId_usuario()) != null) {
			usuario.yaExiste();
			return usuario;
		}
		usuario = new Usuario (usuario.getId_usuario(), usuario.getPerfiles(), usuario.getNombreUsuario(), usuario.getCorreo(), passwordEncoder.encode(usuario.getContrasena()));
		return repositorio.save(usuario); //Guardamos el usuario
	}
	
	
	
	/*
	@Override
	public Usuario guardarUsuario(Usuario usuario) {
		return repositorio.save(usuario); //Guardamos el usuario
	}*/
	
	
	
	
	
	
	@Override
	public Usuario obtenerUsuarioPorId(Long id) {
		
		try {

			// Instrucciones cuando no hay una excepción
			return repositorio.findById(id).get();

		} catch (Exception ex) {

			// Instrucciones cuando se produce una excepcion
			return null;

		}
		
	}

	@Override
	public Usuario actualizarUsuario(Usuario usuario) {
		usuario = new Usuario (usuario.getId_usuario(), usuario.getPerfiles(), usuario.getNombreUsuario(), usuario.getCorreo(), passwordEncoder.encode(usuario.getContrasena()));
		return repositorio.save(usuario); //Actualizamos el usuario
	}

	@Override
	public void eliminarUsuario(Long id) {
		repositorio.deleteById(id);
	}

	@Override
	public Optional<Usuario> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = repositorio.findByNombreUsuario(username);
		System.out.println(username + "            llllllllllllllllllllllllllllllllllllllllll " + usuario);
		if(usuario == null) {
			System.out.print("hola2222222222222222222222222222222222222222222222222222222222");
			throw new UsernameNotFoundException("Usuario o password inválidos");
		}
		return new User(usuario.getNombreUsuario(),usuario.getContrasena(), mapearAutoridadesARoles(usuario.getPerfiles()));
	
	}
	
	private  Collection<? extends GrantedAuthority> mapearAutoridadesARoles(Collection<Perfil> perfiles){
		return perfiles.stream().map(perfil -> new SimpleGrantedAuthority(perfil.getDescripcion())).collect(Collectors.toList());
	}
	

}