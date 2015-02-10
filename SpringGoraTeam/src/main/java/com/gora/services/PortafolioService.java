package com.gora.services;

import com.gora.dominio.Portafolio;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Author : Taras Lehinevych  .
 * Date : 3/12/14 ,
 * Time : 7:02 PM
 * com.gora.dominio
 */

public interface PortafolioService {

    public void save(Portafolio tarea);

    public void update(Portafolio tarea);

    public Portafolio findById(Long id);

    public List<Portafolio> findAll();

}
