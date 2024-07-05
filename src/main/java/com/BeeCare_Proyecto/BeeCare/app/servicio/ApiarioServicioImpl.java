package com.BeeCare_Proyecto.BeeCare.app.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BeeCare_Proyecto.BeeCare.app.entidad.Apiario;
import com.BeeCare_Proyecto.BeeCare.app.entidad.Apicultor;
import com.BeeCare_Proyecto.BeeCare.app.repositorio.ApiarioRepositorio;

@Service
public class ApiarioServicioImpl implements ApiarioServicio {

	@Autowired
	private ApiarioRepositorio repositorio;
	
	@Override
	public List<Apiario> listarTodosLosApiarios(Long id) {
		if(id != null) {
			System.out.println("holaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa " + id);
			return repositorio.findAll(id);
		}
		return repositorio.findAll();
	}
	
	public List<Apiario> listarTodosLosApiarios() {//Sobrecarga del metodo listarTodosLosApiarios
		return repositorio.findAll();
	}
	
	@Override
	public Apiario guardarApiario(Apiario apiario) {
		if(obtenerApiarioPorId(apiario.getId()) != null) {
			return null;
		}
		return repositorio.save(apiario); //Guardamos el apicultor
	}

	@Override
	public Apiario obtenerApiarioPorId(Long id) {
		try {
			return repositorio.findById(id).get();
		} catch (Exception e) {
			return null;
		}
		
	}

	@Override
	public Apiario actualizarApiario(Apiario apiario) {
		return repositorio.save(apiario);
	}

	@Override
	public void eliminarApiario(Long id) {
		repositorio.deleteById(id);
		
	}
	
	
	

}
