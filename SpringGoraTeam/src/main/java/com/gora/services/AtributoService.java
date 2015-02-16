package com.gora.services;

import com.gora.dominio.Atributo;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Author : Taras Lehinevych  .
 * Date : 3/12/14 ,
 * Time : 7:02 PM
 * com.gora.dominio
 */

public interface AtributoService {

    public void save(Atributo tarea);

    public void update(Atributo tarea);

    public Atributo findById(Long id);

    public List<Atributo> findAll();
    
    public List<Atributo> getAtributosExtracto(Long idPersona, Long idHabilidad);

}
