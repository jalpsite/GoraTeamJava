package com.gora.services;

import com.gora.dominio.Atributos;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Author : Taras Lehinevych  .
 * Date : 3/12/14 ,
 * Time : 7:02 PM
 * com.gora.dominio
 */

public interface AtributosService {

    public void save(Atributos tarea);

    public void update(Atributos tarea);

    public Atributos findById(Long id);

    public List<Atributos> findAll();
    
    public boolean eliminarXHabilidad(Long idHabilidad);
    
    public boolean eliminar(Long idAtributos);
    
    public List<Atributos> getAtributosXPersona(Long idPersona);

}
