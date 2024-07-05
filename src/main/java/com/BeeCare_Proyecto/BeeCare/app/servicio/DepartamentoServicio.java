package com.BeeCare_Proyecto.BeeCare.app.servicio;

import java.util.List;


import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.BeeCare_Proyecto.BeeCare.app.entidad.Departamento;


public interface DepartamentoServicio {
	
	public List<Departamento> listarTodosLosDepartamentos();

	public Departamento guardarDepartamento(Departamento departamento,RedirectAttributes ra);

	public Departamento obtenerDepartamentoPorId(Long id);

	public Departamento actualizarDepartamento(Departamento departamento);

	public void eliminarDepartamento(Long id);
	
	
	

}
