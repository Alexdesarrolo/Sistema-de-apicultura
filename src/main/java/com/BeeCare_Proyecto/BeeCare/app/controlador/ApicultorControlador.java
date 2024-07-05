package com.BeeCare_Proyecto.BeeCare.app.controlador;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.BeeCare_Proyecto.BeeCare.app.entidad.Apicultor;
import com.BeeCare_Proyecto.BeeCare.app.servicio.ApicultorServicio;
import com.BeeCare_Proyecto.BeeCare.app.util.reportes.ApicultorExporterPDF;
import com.lowagie.text.DocumentException;

@Controller
public class ApicultorControlador {
	
	@Autowired//Inyectamos el servicio
	private ApicultorServicio servicio;
	
	@GetMapping({"/apicultores"})
	public String listarApicultores(Model modelo) {
		modelo.addAttribute("apicultores", servicio.listarTodosLosApicultores());
		return "apicultores"; //Nos retorna el archivo apicultores
	}
	
	@GetMapping("/apicultores/nuevo")
	public String mostarFormularioDeRegistrarApicultor(Model modelo) {
		
		Apicultor apicultor = new Apicultor();
		modelo.addAttribute("apicultor", apicultor);
		return "crear_apicultor";
	}
	
	@PostMapping("/apicultores")
	public String guardarApicultor(@ModelAttribute("apicultor") Apicultor apicultor) {
		servicio.guardarApicultor(apicultor);
		return "redirect:/apicultores";
	}
	
	@GetMapping("/apicultores/editar/{id}")
	public String mostrarFormularioDeEditar(@PathVariable Long id, Model modelo) {
		modelo.addAttribute("apicultor", servicio.obtenerApicultorPorId(id));
		return "editar_apicultor";
	}
	
	@PostMapping("/apicultores/{id}")
	public String actualizarApicultor(@PathVariable Long id, @ModelAttribute("apicultor") Apicultor apicultor, Model modelo) {
		Apicultor apicultorExistente = servicio.obtenerApicultorPorId(id);
		apicultorExistente.setCedula(id);
		apicultorExistente.setNombre1(apicultor.getNombre1());
		apicultorExistente.setNombre2(apicultor.getNombre2());
		apicultorExistente.setApellido1(apicultor.getApellido1());
		apicultorExistente.setApellido2(apicultor.getApellido2());
		apicultorExistente.setCorreo(apicultor.getCorreo());
		apicultorExistente.setCelular(apicultor.getCelular());
		
		servicio.actualizarApicultor(apicultorExistente);
		
		return "redirect:/apicultores";
	}
	
	@GetMapping("/apicultores/{id}")
	public String eliminarApicultor(@PathVariable Long id) {
		try {
			servicio.eliminarApicultor(id);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return "redirect:/apicultores";
	}
	
	@GetMapping("/exportarPDF")
	public void exportarListadoDeEmpleadosEnPDF(HttpServletResponse response) throws DocumentException, IOException {
		response.setContentType("application/pdf");
		
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String fechaActual = dateFormatter.format(new Date());
		
		String cabecera = "Content-Disposition";
		String valor = "attachment; filename=Apicultores_" + fechaActual + ".pdf";
		
		response.setHeader(cabecera, valor);
		
		List<Apicultor> apicultores = servicio.findAll();
		
		ApicultorExporterPDF exporter = new ApicultorExporterPDF(apicultores);
		exporter.exportar(response);
	}
}
