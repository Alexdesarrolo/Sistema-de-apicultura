package com.BeeCare_Proyecto.BeeCare.app.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BeeCare_Proyecto.BeeCare.app.entidad.Colmena;
import com.BeeCare_Proyecto.BeeCare.app.repositorio.ColmenaRepositorio;

@Service
public class ColmenaServicioImpl implements ColmenaServicio {

	@Autowired
	private ColmenaRepositorio repositorio;

	@Override
	public List<Colmena> listarTodosLasColmenas() {
		return repositorio.findAll();
	}

	@Override
	public Colmena guardarColmena(Colmena colmena) {
		return repositorio.save(colmena);
	}

	@Override
	public Colmena obtenerColmenaPorId(Long id) {
		return repositorio.findById(id).get();
	}

	@Override
	public Colmena actualizarColmena(Colmena colmena) {
		return repositorio.save(colmena);
	}

	@Override
	public void eliminarColmena(Long id) {
		repositorio.deleteById(id);

	}

}
