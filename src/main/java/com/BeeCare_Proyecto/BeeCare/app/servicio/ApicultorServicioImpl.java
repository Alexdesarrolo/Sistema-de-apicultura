package com.BeeCare_Proyecto.BeeCare.app.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BeeCare_Proyecto.BeeCare.app.entidad.Apicultor;
import com.BeeCare_Proyecto.BeeCare.app.repositorio.ApicultorRepositorio;

@Service
public class ApicultorServicioImpl implements ApicultorServicio{
	
	@Autowired
	private ApicultorRepositorio repositorio;
	
	@Override
	public List<Apicultor> listarTodosLosApicultores() {
		return repositorio.findAll(); //Lista todos los apicultores
	}

	@Override
	public Apicultor guardarApicultor(Apicultor apicultor) {
		if(obtenerApicultorPorId(apicultor.getCedula()) != null) {
			return null;
		}
		return repositorio.save(apicultor); //Guardamos el apicultor
	}

	@Override
	public Apicultor obtenerApicultorPorId(Long id) {
		try {
			return repositorio.findById(id).get();
		}catch (Exception e) {
			return null;
		}
		
	}

	@Override
	public Apicultor actualizarApicultor(Apicultor apicultor) {
		return repositorio.save(apicultor);
	}

	@Override
	public void eliminarApicultor(Long id) {
		repositorio.deleteById(id);
		
	}

	@Override
	public List<Apicultor> findAll() {
		return (List<Apicultor>) repositorio.findAll();		
	}
	
	
}
