package com.gora.services;

import com.gora.dominio.Formacion;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Author : Taras Lehinevych  .
 * Date : 3/12/14 ,
 * Time : 7:02 PM
 * com.gora.dominio
 */

public interface FormacionService {

    public void save(Formacion formacion);

    public void update(Formacion formacion);

    public Formacion findById(Long id);

    public List<Formacion> findAll();
    
    public List<Formacion> getFormacionPersona(Long idPersona);

}