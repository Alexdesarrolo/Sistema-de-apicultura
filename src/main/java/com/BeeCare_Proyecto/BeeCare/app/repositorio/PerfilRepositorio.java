package com.BeeCare_Proyecto.BeeCare.app.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BeeCare_Proyecto.BeeCare.app.entidad.Apicultor;
import com.BeeCare_Proyecto.BeeCare.app.entidad.Perfil;

@Repository
public interface PerfilRepositorio extends JpaRepository<Perfil, Long>{

}
