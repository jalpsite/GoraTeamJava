package com.gora.services;

import com.gora.dominio.PersonaDatos;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Author : Taras Lehinevych  .
 * Date : 3/12/14 ,
 * Time : 7:02 PM
 * com.gora.dominio
 */

public interface PersonaDatosService {

    public void save(PersonaDatos persona);

    public void update(PersonaDatos persona);

    public PersonaDatos findById(Long id);

    public List<PersonaDatos> findAll();
    
    public List<PersonaDatos> getPersonaByDNI(String dni);
	
	public List<PersonaDatos> getPersonaByNomApe(String nomApe);
       

}
