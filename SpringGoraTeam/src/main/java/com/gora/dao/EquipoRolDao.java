package com.gora.dao;


import java.util.List;

import com.gora.dominio.EquipoRol;
import com.gora.dominio.Persona;


/**
 * Created by IntelliJ IDEA.
 * Author : Jose Alpiste  .
 * Date : 3/12/14 ,
 * Time : 6:32 PM
 * com.gora.dominio
 */

public interface EquipoRolDao extends GenericDao<EquipoRol> {
	public List<EquipoRol> equipoRolesXProyecto(Long idProyecto);
	public List<Persona> getPersonasEquipoRol(Long idEquipoRol);
	public int eliminarEquipoRol(Long idEquipoRol);
}
