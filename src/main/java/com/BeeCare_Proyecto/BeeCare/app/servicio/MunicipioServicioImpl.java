package com.BeeCare_Proyecto.BeeCare.app.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BeeCare_Proyecto.BeeCare.app.entidad.Municipio;
import com.BeeCare_Proyecto.BeeCare.app.repositorio.MunicipioRepositorio;

@Service
public class MunicipioServicioImpl implements MunicipioServicio{

	@Autowired
	private MunicipioRepositorio repositorio;

	@Override
	public List<Municipio> listarTodosLosMuncipios() {
		return (List<Municipio>) repositorio.findAll();
	}

	@Override
	public Municipio guardarMunicipio(Municipio municipio) {
		if(obtenerMunicipioPorId(municipio.getIdentificacion_municipio()) != null) {
			System.out.println("Ya existe__________________________________________________________________");
			return null;
			
		}
		return repositorio.save(municipio);
	}

	@Override
	public Municipio obtenerMunicipioPorId(Long id) {
		try {
			return repositorio.findById(id).get();
		}catch (Exception e) {
			return null;
		}
		
	}

	@Override
	public Municipio actualizarMunicipio(Municipio municipio) {
		return repositorio.save(municipio);
	}

	@Override
	public void eliminarMunicipio(Long id) {
		repositorio.deleteById(id);
		
	}

}
