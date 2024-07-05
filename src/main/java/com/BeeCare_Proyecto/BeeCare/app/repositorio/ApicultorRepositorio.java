package com.BeeCare_Proyecto.BeeCare.app.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BeeCare_Proyecto.BeeCare.app.entidad.Apicultor;

@Repository
public interface ApicultorRepositorio  extends JpaRepository<Apicultor, Long>{
	
}
