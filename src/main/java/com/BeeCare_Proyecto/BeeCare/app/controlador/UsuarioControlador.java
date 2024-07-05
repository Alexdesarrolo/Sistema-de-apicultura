package com.BeeCare_Proyecto.BeeCare.app.controlador;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.BeeCare_Proyecto.BeeCare.app.entidad.Usuario;
import com.BeeCare_Proyecto.BeeCare.app.repositorio.PerfilRepositorio;
import com.BeeCare_Proyecto.BeeCare.app.servicio.PerfilServicio;
import com.BeeCare_Proyecto.BeeCare.app.servicio.UsuarioServicio;
import com.BeeCare_Proyecto.BeeCare.app.servicio.UsuarioServicioImpl;


@Controller
public class UsuarioControlador {
	@Autowired//Inyectamos el servicio
	private UsuarioServicio servicio;
	
	@Autowired//Inyectamos el repositorio
	private PerfilRepositorio perfiles;
	
	@Autowired
	private UsuarioServicioImpl usuarioServicioImpl;
	
	@RequestMapping({"/usuarios"})
	public String listarUsuarios(Model modelo, @Param("id") Long id) {
		
		modelo.addAttribute("usuarios", servicio.listarTodosLosUsuarios(id));
		modelo.addAttribute("id", id);
		//modelo.addAttribute("usuario", new Usuario());
		return "usuarios"; //Nos retorna el archivo usuarios
	}
	
	@GetMapping("/usuarios/nuevo")
	public String mostarFormularioDeRegistrarUsuario(Model modelo) {
		
		Usuario usuario = new Usuario();
		modelo.addAttribute("usuario", usuario);
		//System.out.println(perfiles.findAll());
		modelo.addAttribute("perfiles", perfiles.findAll());
		return "crear_usuario";
	}
	
	@PostMapping("/usuarios")
	public String guardarUsuario(@ModelAttribute("usuario") Usuario usuario) {
		usuarioServicioImpl.guardarUsuario(usuario);
		return "redirect:/usuarios";
	}
	
	@GetMapping("/usuarios/editar/{id}")
	public String mostrarFormularioDeEditar(@PathVariable Long id, Model modelo) {
		modelo.addAttribute("usuario", servicio.obtenerUsuarioPorId(id));
		modelo.addAttribute("perfiles", perfiles.findAll());
		return "editar_usuario";
	}
	
	@PostMapping("/usuarios/{id}")
	public String actualizarUsuario(@PathVariable Long id, @ModelAttribute("usuario") Usuario usuario, Model modelo) {
		Usuario usuarioExistente = servicio.obtenerUsuarioPorId(id);
		usuarioExistente.setId_usuario(id);
		//usuarioExistente.setNombre(estudiante.getNombre());
		usuarioExistente.setPerfiles(usuario.getPerfiles());
		usuarioExistente.setNombreUsuario(usuario.getNombreUsuario());
		usuarioExistente.setCorreo(usuario.getCorreo());
		usuarioExistente.setContrasena(usuario.getContrasena());
		
		usuarioServicioImpl.actualizarUsuario(usuarioExistente);
		
		return "redirect:/usuarios";
	}
	
	@GetMapping("/usuarios/{id}")
	public String eliminarUsuario(@PathVariable Long id) {
		servicio.eliminarUsuario(id);
		return "redirect:/usuarios";
	}
	
	
	
}
