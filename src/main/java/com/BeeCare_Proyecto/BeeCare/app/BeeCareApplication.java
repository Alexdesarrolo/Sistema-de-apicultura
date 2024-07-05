package com.BeeCare_Proyecto.BeeCare.app;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.BeeCare_Proyecto.BeeCare.app.entidad.Perfil;
import com.BeeCare_Proyecto.BeeCare.app.entidad.Usuario;
import com.BeeCare_Proyecto.BeeCare.app.repositorio.PerfilRepositorio;
import com.BeeCare_Proyecto.BeeCare.app.repositorio.UsuarioRepositorio;
import com.BeeCare_Proyecto.BeeCare.app.servicio.UsuarioServicioImpl;

@SpringBootApplication
public class BeeCareApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(BeeCareApplication.class, args);
	}
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private UsuarioRepositorio repositorio;
	
	@Autowired
	private PerfilRepositorio perf;
	
	@Autowired
	private UsuarioServicioImpl usuarioServicioImpl;
	
	@Override
	public void run(String... args) throws Exception {
		
		/*
		Usuario usuario1 = new Usuario(10l,"u", "Alexader10", "Alexander@gmail.com", "Giraldo");
		repositorio.save(usuario1);
		*/
		
		Set<Perfil> conjunto2 = new HashSet<>(); 
		Perfil perfil = new Perfil(10l, "Administrador");
		conjunto2.add(perfil);
		perf.save( perfil);
		
			
			
			
		
		
		
			
		
		
		if(usuarioServicioImpl.obtenerUsuarioPorId(01l) == null) {
			Usuario usuario2 = new Usuario(01l, conjunto2, "Alex", "magaly@gmail.com", 
				passwordEncoder.encode("123"));
		
			repositorio.save(usuario2);	
			
		}
	
		
		
		//Long id_usuario, String id_Perfil, String usuario, String correo, String contraseña
	
		
	}

}
