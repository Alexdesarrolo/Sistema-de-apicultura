package com.BeeCare_Proyecto.BeeCare.app.servicio;

import java.util.List;

import com.BeeCare_Proyecto.BeeCare.app.entidad.Municipio;

public interface MunicipioServicio {
	
	public List<Municipio> listarTodosLosMuncipios();

	public Municipio guardarMunicipio(Municipio municipio);

	public Municipio obtenerMunicipioPorId(Long id);

	public Municipio actualizarMunicipio(Municipio municipio);

	public void eliminarMunicipio(Long id);

}
