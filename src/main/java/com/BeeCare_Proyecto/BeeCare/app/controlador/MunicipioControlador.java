package com.BeeCare_Proyecto.BeeCare.app.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.BeeCare_Proyecto.BeeCare.app.entidad.Departamento;
import com.BeeCare_Proyecto.BeeCare.app.entidad.Municipio;
import com.BeeCare_Proyecto.BeeCare.app.servicio.DepartamentoServicioImpl;
import com.BeeCare_Proyecto.BeeCare.app.servicio.MunicipioServicioImpl;

@Controller
public class MunicipioControlador {
	
	@Autowired//Inyectamos el servicio
	private MunicipioServicioImpl servicio;
	
	@Autowired
	private DepartamentoServicioImpl servicio2;
	
	@GetMapping({"/municipios"})
	public String listarMunicipio(Model modelo) {
		modelo.addAttribute("municipios", servicio.listarTodosLosMuncipios());
		return "municipios"; 
	}
	
	@GetMapping("/municipios/nuevo")
	public String mostrarFormularioDeRegistrarMunicipio(Model modelo) {
		List<Departamento> listaDepartamentos = servicio2.listarTodosLosDepartamentos();
		
		Municipio municipio = new Municipio();
		modelo.addAttribute("municipio", municipio);
		modelo.addAttribute("listaDepartamentos", listaDepartamentos);
		return "crear_municipio";
	}
	
	@PostMapping("/municipios")
	public String guardarMunicipio(@ModelAttribute("municipio") Municipio municipio) {
		servicio.guardarMunicipio(municipio);
		return "redirect:/municipios";
	}
	
	@GetMapping("/municipios/editar/{id}")
	public String mostrarFormularioDeEditar(@PathVariable Long id, Model modelo) {
		modelo.addAttribute("municipio", servicio.obtenerMunicipioPorId(id));
        List<Departamento> listaDepartamentos = servicio2.listarTodosLosDepartamentos();
		modelo.addAttribute("listaDepartamentos", listaDepartamentos);

		return "editar_municipio";
	}
	
	@PostMapping("/municipios/{id}")
	public String actualizarMunicipio(@PathVariable Long id, @ModelAttribute("municipio") Municipio municipio, Model modelo) {
		Municipio municipioExistente = servicio.obtenerMunicipioPorId(id);
		municipioExistente.setIdentificacion_municipio(id);
		municipioExistente.setDescripcion(municipio.getDescripcion());
				
		servicio.actualizarMunicipio(municipioExistente);
		
		return "redirect:/municipios";
	}
	
	@GetMapping("/municipios/{id}")
	public String eliminarMunicipios(@PathVariable Long id) {
		try {
			servicio.eliminarMunicipio(id);
		} catch (Exception e) {
			System.out.println("Hay informacion dependiente-----------------------------------------------------+");
		}
		
		return "redirect:/municipios";
	}


}
