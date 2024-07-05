package com.BeeCare_Proyecto.BeeCare.app.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.BeeCare_Proyecto.BeeCare.app.entidad.Apiario;

@Repository
public interface ApiarioRepositorio extends JpaRepository<Apiario, Long> {	
	
	@Query("SELECT p FROM Apiario p WHERE p.id =:id")
	//SELECT * FROM usuario WHERE usuario.id_usuario = 1;
	public List<Apiario> findAll(Long id);

}
