package com.gora.dao;

import java.util.List;

import com.gora.dominio.Competencia;
import com.gora.dominio.Habilidad;

/**
 * Created by IntelliJ IDEA.
 * Author : Jose Alpiste  .
 * Date : 3/12/14 ,
 * Time : 6:32 PM
 * com.gora.dominio
 */

public interface CompetenciaDao extends GenericDao<Competencia> {
	public List<Habilidad> getHabilidades(Long id);
}
