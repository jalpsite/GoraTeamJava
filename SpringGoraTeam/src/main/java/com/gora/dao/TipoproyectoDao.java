package com.gora.dao;

import java.util.List;

import com.gora.dominio.Tipoproyecto;

/**
 * Created by IntelliJ IDEA.
 * Author : Jose Alpiste  .
 * Date : 3/12/14 ,
 * Time : 6:32 PM
 * com.gora.dominio
 */

public interface TipoproyectoDao extends GenericDao<Tipoproyecto> {
	public List<Tipoproyecto> buscarTipoProyecto(String cadena);
}
