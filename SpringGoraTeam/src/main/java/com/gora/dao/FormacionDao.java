package com.gora.dao;

import java.util.List;

import com.gora.dominio.Formacion;

/**
 * Created by IntelliJ IDEA.
 * Author : Jose Alpiste  .
 * Date : 3/12/14 ,
 * Time : 6:32 PM
 * com.gora.dominio
 */

public interface FormacionDao extends GenericDao<Formacion> {
	List<Formacion> getFormacionPersona(Long idPersona);
	void eliminarFormacion(Long idFormacion);
}
