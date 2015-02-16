package com.gora.dao;

import java.util.List;

import com.gora.dominio.Atributo;

/**
 * Created by IntelliJ IDEA.
 * Author : Jose Alpiste  .
 * Date : 3/12/14 ,
 * Time : 6:32 PM 
 * com.gora.dominio
 */

public interface AtributoDao extends GenericDao<Atributo> {
	public List<Atributo> getAtributosExtracto(Long idPersona, Long idHabilidad);
}
