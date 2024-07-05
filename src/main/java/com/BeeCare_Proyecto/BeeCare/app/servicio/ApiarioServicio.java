package com.BeeCare_Proyecto.BeeCare.app.servicio;

import java.util.List;

import com.BeeCare_Proyecto.BeeCare.app.entidad.Apiario;
import com.BeeCare_Proyecto.BeeCare.app.entidad.Apicultor;

public interface ApiarioServicio {

	public List<Apiario> listarTodosLosApiarios(Long id);

	public Apiario guardarApiario(Apiario apiario);

	public Apiario obtenerApiarioPorId(Long id);

	public Apiario actualizarApiario(Apiario apiario);

	public void eliminarApiario(Long id);

}
