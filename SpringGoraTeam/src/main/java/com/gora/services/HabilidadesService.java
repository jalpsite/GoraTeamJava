package com.gora.services;

import com.gora.dominio.Habilidades;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Author : Taras Lehinevych  .
 * Date : 3/12/14 ,
 * Time : 7:02 PM
 * com.gora.dominio
 */

public interface HabilidadesService {

    public void save(Habilidades tarea);

    public void update(Habilidades tarea);

    public Habilidades findById(Long id);

    public List<Habilidades> findAll();
    
    

}