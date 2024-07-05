package com.BeeCare_Proyecto.BeeCare.app.servicio;

import java.util.List;

import com.BeeCare_Proyecto.BeeCare.app.entidad.Colmena;

public interface ColmenaServicio {
	
	public List<Colmena> listarTodosLasColmenas();

	public Colmena guardarColmena(Colmena colmena);

	public Colmena obtenerColmenaPorId(Long id);

	public Colmena actualizarColmena(Colmena colmena);

	public void eliminarColmena(Long id);

}
