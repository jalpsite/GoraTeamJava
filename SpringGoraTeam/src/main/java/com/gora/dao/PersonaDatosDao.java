package com.gora.dao;


import java.util.List;

import com.gora.dominio.Persona;
import com.gora.dominio.PersonaDatos;

/**
 * Created by IntelliJ IDEA.
 * Author : Jose Alpiste  .
 * Date : 3/12/14 ,
 * Time : 6:32 PM
 * com.gora.dominio
 */

public interface PersonaDatosDao extends GenericDao<PersonaDatos> {	
	public List<Persona> getPersonaByDNI(String dni);	
	public List<Persona> getPersonaByNomApe(String nomApe);
	public Object getDatosPrincipales(Long idProyecto,Long idPersona);
}
