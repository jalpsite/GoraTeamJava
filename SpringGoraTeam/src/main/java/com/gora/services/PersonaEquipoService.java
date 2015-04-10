package com.gora.services;

import com.gora.dominio.PersonaEquipo;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Author : Taras Lehinevych  .
 * Date : 3/12/14 ,
 * Time : 7:02 PM
 * com.gora.dominio
 */

public interface PersonaEquipoService {

    public void save(PersonaEquipo per_e);

    public void update(PersonaEquipo per_e);

    public PersonaEquipo findById(Long id);

    public List<PersonaEquipo> findAll();
    
    public int quitarPersonaEquipo(Long idProyecto, Long idPersona);

    public int cambiarRol(Long idProyecto, Long idPersona, Long idEquipoRol);
}