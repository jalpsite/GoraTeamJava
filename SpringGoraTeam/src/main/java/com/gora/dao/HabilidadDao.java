package com.gora.dao;

import java.util.List;

import com.gora.dominio.Atributo;
import com.gora.dominio.Habilidad;

/**
 * Created by IntelliJ IDEA.
 * Author : Jose Alpiste  .
 * Date : 3/12/14 ,
 * Time : 6:32 PM
 * com.gora.dominio
 */

public interface HabilidadDao extends GenericDao<Habilidad> {	
	public List<Atributo> getAtributos(Long id);
}
