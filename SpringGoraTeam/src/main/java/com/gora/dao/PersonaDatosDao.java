package com.gora.dao;


import java.util.List;

import com.gora.dominio.PersonaDatos;

/**
 * Created by IntelliJ IDEA.
 * Author : Jose Alpiste  .
 * Date : 3/12/14 ,
 * Time : 6:32 PM
 * com.gora.dominio
 */

public interface PersonaDatosDao extends GenericDao<PersonaDatos> {	
	public List<PersonaDatos> getPersonaByDNI(String dni);	
	public List<PersonaDatos> getPersonaByNomApe(String nomApe);
}
