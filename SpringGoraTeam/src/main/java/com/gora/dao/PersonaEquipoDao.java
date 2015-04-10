package com.gora.dao;

import com.gora.dominio.PersonaEquipo;

/**
 * Created by IntelliJ IDEA.
 * Author : Jose Alpiste  .
 * Date : 3/12/14 ,
 * Time : 6:32 PM
 * com.gora.dominio
 */

public interface PersonaEquipoDao extends GenericDao<PersonaEquipo> {
	public int quitarPersonaEquipo(Long idProyecto, Long idPersona);
	public int cambiarRol(Long idProyecto, Long idPersona, Long idEquipoRol);
}
