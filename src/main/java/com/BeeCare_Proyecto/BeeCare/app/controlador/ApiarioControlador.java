package com.BeeCare_Proyecto.BeeCare.app.controlador;

import java.util.List;

import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.BeeCare_Proyecto.BeeCare.app.entidad.Apiario;
import com.BeeCare_Proyecto.BeeCare.app.entidad.Apicultor;
import com.BeeCare_Proyecto.BeeCare.app.entidad.Departamento;
import com.BeeCare_Proyecto.BeeCare.app.entidad.Municipio;
import com.BeeCare_Proyecto.BeeCare.app.repositorio.PerfilRepositorio;
import com.BeeCare_Proyecto.BeeCare.app.servicio.ApiarioServicio;
import com.BeeCare_Proyecto.BeeCare.app.servicio.ApicultorServicioImpl;
import com.BeeCare_Proyecto.BeeCare.app.servicio.MunicipioServicioImpl;

@Controller
public class ApiarioControlador {

	@Autowired
	private ApiarioServicio servicio;
	
	@Autowired
	private MunicipioServicioImpl sMunicipio;
	
	@Autowired
	private ApicultorServicioImpl sApicultor;
	

	@GetMapping({ "/apiarios"})
	public String listarApiarios(Model modelo, @Param("id") Long id) {
		modelo.addAttribute("apiarios", servicio.listarTodosLosApiarios(id));
		modelo.addAttribute("id", id);
		return "apiarios";

	}

	@GetMapping("/apiarios/nuevo")
	public String mostrarFormularioDeRegistrarMunicipio(Model modelo) {
		List<Municipio> listaMunicipios = sMunicipio.listarTodosLosMuncipios();
		List<Apicultor> listaApicultores = sApicultor.listarTodosLosApicultores();
		
		Apiario apiario = new Apiario();
		modelo.addAttribute("apiario", apiario);
		modelo.addAttribute("listaMunicipios", listaMunicipios);
		modelo.addAttribute("listaApicultores", listaApicultores);
		return "crear_apiario";
	}

	@PostMapping("/apiarios")
	public String guardarApiario(@ModelAttribute("apiario") Apiario apiario) {
		servicio.guardarApiario(apiario);
		return "redirect:/apiarios";
	}

	@GetMapping("/apiarios/editar/{id}")
	public String mostrarFormularioDeEditar(@PathVariable Long id, Model modelo) {
		modelo.addAttribute("apiario", servicio.obtenerApiarioPorId(id));
		List<Municipio> listaMunicipios = sMunicipio.listarTodosLosMuncipios();
		modelo.addAttribute("listaMunicipios", listaMunicipios);
		List<Apicultor> listaApicultores = sApicultor.listarTodosLosApicultores();
		modelo.addAttribute("listaApicultores", listaApicultores);

		return "editar_apiario";
	}

	@PostMapping("/apiarios/{id}")
	public String actualizarApiario(@PathVariable Long id, @ModelAttribute("apiario") Apiario apiario,
			Model modelo) {
		Apiario apiarioExistente = servicio.obtenerApiarioPorId(id);
		apiarioExistente.setId(id);
		apiarioExistente.setNombre(apiario.getNombre());
		apiarioExistente.setNumeroColmenas(apiario.getNumeroColmenas());
		apiarioExistente.setDireccion(apiario.getDireccion());
		apiarioExistente.setApicultor(apiario.getApicultor());
		apiarioExistente.setMunicipio(apiario.getMunicipio());


		servicio.actualizarApiario(apiarioExistente);

		return "redirect:/apicultores";
	}
	
	@GetMapping("/apiarios/consultar/{id}")
	public String consultarApiario(@PathVariable Long id, Model modelo) {
		modelo.addAttribute("apiario", servicio.obtenerApiarioPorId(id));
		List<Municipio> listaMunicipios = sMunicipio.listarTodosLosMuncipios();
		modelo.addAttribute("listaMunicipios", listaMunicipios);
		List<Apicultor> listaApicultores = sApicultor.listarTodosLosApicultores();
		modelo.addAttribute("listaApicultores", listaApicultores);

		return "consultar_apiario";
	}
	
	
	@GetMapping("/apiarios/{id}")
	public String eliminarApicultor(@PathVariable Long id) {
		try {
			servicio.eliminarApiario(id);
		} catch (Exception e) {
		
		}
		
		return "redirect:/apiarios";
	}

}
