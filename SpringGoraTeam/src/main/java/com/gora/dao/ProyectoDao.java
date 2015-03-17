package com.gora.dao;

import java.util.List;

import com.gora.dominio.Proyecto;

/**
 * Created by IntelliJ IDEA.
 * Author : Jose Alpiste  .
 * Date : 3/12/14 ,
 * Time : 6:32 PM
 * com.gora.dominio
 */

public interface ProyectoDao extends GenericDao<Proyecto> {	
	public List<Proyecto> buscarProyecto(String busqueda);
}

