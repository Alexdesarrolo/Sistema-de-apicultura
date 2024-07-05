package com.BeeCare_Proyecto.BeeCare.app.servicio;

import java.util.List;

import com.BeeCare_Proyecto.BeeCare.app.entidad.Apicultor;

public interface ApicultorServicio {
	
	public List<Apicultor> listarTodosLosApicultores();
	
	public Apicultor guardarApicultor(Apicultor apicultor);
	
	public Apicultor obtenerApicultorPorId(Long id);
	
	public Apicultor actualizarApicultor(Apicultor apicultor);
	
	public void eliminarApicultor(Long id);

	public List<Apicultor> findAll();
}
