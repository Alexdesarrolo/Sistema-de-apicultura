package com.BeeCare_Proyecto.BeeCare.app.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.BeeCare_Proyecto.BeeCare.app.entidad.Departamento;
import com.BeeCare_Proyecto.BeeCare.app.repositorio.DepartamentoRepositorio;

@Service
public class DepartamentoServicioImpl implements DepartamentoServicio {
	
	@Autowired
	private DepartamentoRepositorio repositorio;

	@Override
	public List<Departamento> listarTodosLosDepartamentos() {
		return repositorio.findAll();
	}

	@Override
	public Departamento guardarDepartamento(Departamento departamento, RedirectAttributes ra) {
		return repositorio.save(departamento);
	}

	@Override
	public Departamento obtenerDepartamentoPorId(Long id) {
		return repositorio.findById(id).get();
	}

	@Override
	public Departamento actualizarDepartamento(Departamento departamento) {
		return repositorio.save(departamento);
	}

	@Override
	public void eliminarDepartamento(Long id) {
		repositorio.deleteById(id);
		
	}

}
