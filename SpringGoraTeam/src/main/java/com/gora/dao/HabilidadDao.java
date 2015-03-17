package com.gora.dao;

import java.util.List;

import com.gora.dominio.Atributo;
import com.gora.dominio.Habilidad;
import com.gora.dominio.Habilidades;

/**
 * Created by IntelliJ IDEA.
 * Author : Jose Alpiste  .
 * Date : 3/12/14 ,
 * Time : 6:32 PM
 * com.gora.dominio
 */

public interface HabilidadDao extends GenericDao<Habilidad> {	
	public List<Atributo> getAtributos(Long id);	
	public List<Habilidades> getHabilidadesExtracto(Long idPersona, Long idCompetencia);		
	public boolean eliminarXMatriz(Long idMatriz);
	public List<Habilidad> getHabilidadXMatriz(Long idMatriz);
	public boolean eliminar(Long idHabilidad);
	public List<Habilidad> getHabilidadXPersona(Long idPersona);
	public Habilidad getHabilidadXPersonaXComp(Long idPersona, Long idCompetencia, Long idHabilidades);
}
