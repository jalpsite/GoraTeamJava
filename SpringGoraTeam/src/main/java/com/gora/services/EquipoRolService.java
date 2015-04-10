package com.gora.services;


import com.gora.dominio.EquipoRol;



import com.gora.dominio.Persona;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Author : Taras Lehinevych  .
 * Date : 3/12/14 ,
 * Time : 7:02 PM
 * com.gora.dominio
 */

public interface EquipoRolService {

    public void save(EquipoRol equiporol);

    public void update(EquipoRol equiporol);

    public EquipoRol findById(Long id);

    public List<EquipoRol> findAll();
      
    public List<EquipoRol> equipoRolesXProyecto(Long idProyecto);

    public List<Persona> getPersonasEquipoRol(Long idEquipoRol);
    
    public int eliminarEquipoRol(Long idEquipoRol);
}
