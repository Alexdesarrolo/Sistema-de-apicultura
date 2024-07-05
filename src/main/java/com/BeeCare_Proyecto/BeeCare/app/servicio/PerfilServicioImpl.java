package com.BeeCare_Proyecto.BeeCare.app.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BeeCare_Proyecto.BeeCare.app.entidad.Perfil;
import com.BeeCare_Proyecto.BeeCare.app.repositorio.PerfilRepositorio;

@Service
public class PerfilServicioImpl implements PerfilServicio {
	
	@Autowired
	private PerfilRepositorio repositorio;

	@Override
	public List<Perfil> listarTodosLosPerfiles() {
		return repositorio.findAll();
	}

	@Override
	public Perfil guardarPerfil(Perfil perfil) {
		
		if (obtenerPerfilPorId(perfil.getIdentificacion_perfil()) != null) {
			return null;
		}
		
		return repositorio.save(perfil);
	}

	@Override
	public Perfil obtenerPerfilPorId(Long id) {
		try {
			return repositorio.findById(id).get();
		}catch(Exception e){
			return null;
			
		}
		
	}

	@Override
	public Perfil actualizarPerfil(Perfil perfil) {
		return repositorio.save(perfil);
	}

	@Override
	public void eliminarPerfil(Long id) {
		repositorio.deleteById(id);
		
	}

}
