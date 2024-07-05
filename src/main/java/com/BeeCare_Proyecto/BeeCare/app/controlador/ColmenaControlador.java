package com.BeeCare_Proyecto.BeeCare.app.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.BeeCare_Proyecto.BeeCare.app.entidad.Apiario;
import com.BeeCare_Proyecto.BeeCare.app.entidad.Colmena;
import com.BeeCare_Proyecto.BeeCare.app.entidad.Departamento;
import com.BeeCare_Proyecto.BeeCare.app.servicio.ApiarioServicio;
import com.BeeCare_Proyecto.BeeCare.app.servicio.ApiarioServicioImpl;
import com.BeeCare_Proyecto.BeeCare.app.servicio.ColmenaServicio;

@Controller
public class ColmenaControlador {

		@Autowired // Inyectamos el servicio
		private ColmenaServicio servicio;
		
		@Autowired // Inyectamos el apiario
		private ApiarioServicioImpl apiarioServicioImpl;

		@GetMapping({ "/colmenas"})
		public String listarColmenas(Model modelo) {
			modelo.addAttribute("colmenas", servicio.listarTodosLasColmenas());
			return "colmenas"; // Nos retorna el archivo apicultores
		}

		@GetMapping("/colmenas/nuevo")
		public String mostarFormularioDeRegistrarColmena(Model modelo) {
			List<Apiario> listaApiarios = apiarioServicioImpl.listarTodosLosApiarios();

			Colmena colmena = new Colmena();
			modelo.addAttribute("colmena", colmena);
			modelo.addAttribute("listaApiarios", listaApiarios);
			
			return "crear_colmena";
		}

		@PostMapping("/colmenas")
		public String guardarColmena(@ModelAttribute("colmena") Colmena colmena) {
			
			
			servicio.guardarColmena(colmena);
			
			return "redirect:/colmenas";
		}

		@GetMapping("/colmenas/editar/{id}")
		public String mostrarFormularioDeEditar(@PathVariable Long id, Model modelo) {
			List<Apiario> listaApiarios = apiarioServicioImpl.listarTodosLosApiarios();
			
			modelo.addAttribute("colmena", servicio.obtenerColmenaPorId(id));
			modelo.addAttribute("listaApiarios", listaApiarios);
			
			return "editar_colmena";
		}

		@PostMapping("/colmenas/{id}")
		public String actualizarColmena(@PathVariable Long id, @ModelAttribute("colmena") Colmena colmena,
				Model modelo) {
			Colmena colmenaExistente = servicio.obtenerColmenaPorId(id);
			colmenaExistente.setId(id);
			colmenaExistente.setDescripcion(colmena.getDescripcion());
			colmenaExistente.setApiario(colmena.getApiario());

			servicio.actualizarColmena(colmenaExistente);

			return "redirect:/colmenas";
		}
		
		
		@GetMapping("/colmenas/consultar/{id}")
		public String consultarColmena(@PathVariable Long id, Model modelo) {
			List<Apiario> listaApiarios = apiarioServicioImpl.listarTodosLosApiarios();
			
			modelo.addAttribute("colmena", servicio.obtenerColmenaPorId(id));
			modelo.addAttribute("listaApiarios", listaApiarios);
			
			return "consultar_colmena";
		}

		@GetMapping("/colmenas/{id}")
		public String eliminarColmena(@PathVariable Long id) {
			servicio.eliminarColmena(id);
			return "redirect:/colmenas";
		}
}
