package com.BeeCare_Proyecto.BeeCare.app.servicio;

import java.util.List;

import com.BeeCare_Proyecto.BeeCare.app.entidad.Perfil;

public interface PerfilServicio {

	public List<Perfil> listarTodosLosPerfiles();

	public Perfil guardarPerfil(Perfil perfil);

	public Perfil obtenerPerfilPorId(Long id);

	public Perfil actualizarPerfil(Perfil perfil);

	public void eliminarPerfil(Long id);

}
