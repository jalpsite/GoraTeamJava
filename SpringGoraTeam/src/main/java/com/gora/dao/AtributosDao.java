package com.gora.dao;

import java.util.List;

import com.gora.dominio.Atributos;

/**
 * Created by IntelliJ IDEA.
 * Author : Jose Alpiste  .
 * Date : 3/12/14 ,
 * Time : 6:32 PM 
 * com.gora.dominio
 */

public interface AtributosDao extends GenericDao<Atributos> {
	public boolean eliminarXHabilidad(Long idHabilidad);
	public boolean eliminar(Long idAtributos);	
	public List<Atributos> getAtributosXPersona(Long idPersona);
	public Atributos getAtributosXPersonaXCompXHab(Long idPersona, Long idHabilidades, Long idAtributo);
}
