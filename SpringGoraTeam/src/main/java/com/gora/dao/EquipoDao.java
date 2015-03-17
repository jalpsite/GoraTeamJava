package com.gora.dao;

import java.util.List;

import com.gora.dominio.Equipo;
import com.gora.dominio.Persona;

/**
 * Created by IntelliJ IDEA.
 * Author : Jose Alpiste  .
 * Date : 3/12/14 ,
 * Time : 6:32 PM
 * com.gora.dominio
 */

public interface EquipoDao extends GenericDao<Equipo> {	
	public List<Persona> getPersonasEquipo(Long idEquipo);
}
