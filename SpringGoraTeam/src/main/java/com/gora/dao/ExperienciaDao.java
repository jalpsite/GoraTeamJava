package com.gora.dao;

import java.util.List;

import com.gora.dominio.Experiencia;

/**
 * Created by IntelliJ IDEA.
 * Author : Jose Alpiste  .
 * Date : 3/12/14 ,
 * Time : 6:32 PM
 * com.gora.dominio
 */

public interface ExperienciaDao extends GenericDao<Experiencia> {
	List<Experiencia> getExperienciasPersona(Long idPersona);
	void eliminarExperiencia(Long idExperiencia);
	
}
