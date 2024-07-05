package com.BeeCare_Proyecto.BeeCare.app.controlador;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.BeeCare_Proyecto.BeeCare.app.entidad.Departamento;
import com.BeeCare_Proyecto.BeeCare.app.servicio.DepartamentoServicioImpl;

@Controller
public class DepartamentoControlador {

	@Autowired // Inyectamos el servicio
	private DepartamentoServicioImpl servicio;

	@GetMapping({ "/departamentos" })
	public String listarDepartamento(Model modelo) {
		modelo.addAttribute("listaDepartamentos", servicio.listarTodosLosDepartamentos());
		return "departamentos";
	}

	@GetMapping("/departamentos/nuevo")
	public String mostarFormularioDeRegistrarDepartamentoNuevo(Model modelo) {
	    Departamento departamento = new Departamento();
		modelo.addAttribute("departamento", departamento);
		return "crear_departamento";
	}

	@PostMapping("/departamentos")
	public String guardarDepartamento(@ModelAttribute("departamento") Departamento departamento,
			RedirectAttributes ra) {
		servicio.guardarDepartamento(departamento, ra);
		ra.addFlashAttribute("msgExito", "El departamento ha sido creado correctamente. ");
		return "redirect:/departamentos";
	}

	@GetMapping("/departamentos/editar/{id}")
	public String mostrarFormularioDeEditar(@PathVariable Long id, Model modelo) {
		modelo.addAttribute("departamento", servicio.obtenerDepartamentoPorId(id));
		return "editar_departamento";
	}

	@PostMapping("/departamentos/{id}")
	public String actualizarDepartamento(@PathVariable Long id,
			@ModelAttribute("departamento") Departamento departamento, Model modelo) {
		Departamento departamentoExistente = servicio.obtenerDepartamentoPorId(id);
		departamentoExistente.setIdentificacion_departamento(id);
		departamentoExistente.setDescripcion(departamento.getDescripcion());

		servicio.actualizarDepartamento(departamentoExistente);

		return "redirect:/departamentos";
	}

	@GetMapping("/departamentos/{id}")
	public String eliminarDepartamentos(@PathVariable Long id) {
		try {
			servicio.eliminarDepartamento(id);
		}catch(Exception e){
			System.out.println("Hay informacion dependiente-----------------------------------------------------");
		}
		
		return "redirect:/departamentos";
	}

}
