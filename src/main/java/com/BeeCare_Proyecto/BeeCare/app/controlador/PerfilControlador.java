package com.BeeCare_Proyecto.BeeCare.app.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.BeeCare_Proyecto.BeeCare.app.entidad.Perfil;
import com.BeeCare_Proyecto.BeeCare.app.servicio.PerfilServicio;


@Controller
public class PerfilControlador {
	
	@Autowired//Inyectamos el servicio
	private PerfilServicio servicio;
	
	@GetMapping({"/perfiles"})
	public String listarPerfiles(Model modelo) {
		modelo.addAttribute("perfiles", servicio.listarTodosLosPerfiles());
		return "perfiles"; 
	}
	
	@GetMapping("/perfiles/nuevo")
	public String mostarFormularioDeRegistrarApicultor(Model modelo) {
		
		Perfil perfil = new Perfil();
		modelo.addAttribute("perfil", perfil);
		return "crear_perfil";
	}
	
	@PostMapping("/perfiles")
	public String guardarPerfil(@ModelAttribute("perfil") Perfil perfil) {
		servicio.guardarPerfil(perfil);
		return "redirect:/perfiles";
	}
	
	@GetMapping("/perfiles/editar/{id}")
	public String mostrarFormularioDeEditar(@PathVariable Long id, Model modelo) {
		modelo.addAttribute("perfil", servicio.obtenerPerfilPorId(id));
		return "editar_perfil";
	}
	
	@PostMapping("/perfiles/{id}")
	public String actualizarPerfil(@PathVariable Long id, @ModelAttribute("perfil") Perfil perfil, Model modelo) {
		Perfil perfilExistente = servicio.obtenerPerfilPorId(id);
		perfilExistente.setIdentificacion_perfil(id);
		perfilExistente.setDescripcion(perfil.getDescripcion());
				
		servicio.actualizarPerfil(perfilExistente);
		
		return "redirect:/perfiles";
	}
	
	@GetMapping("/perfiles/{id}")
	public String eliminarPerfiles(@PathVariable Long id) {
		try {
			servicio.eliminarPerfil(id);
		}catch(Exception e){
			
		}
		
		return "redirect:/perfiles";
	}

}
