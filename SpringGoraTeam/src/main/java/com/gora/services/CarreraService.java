package com.gora.services;

import com.gora.dominio.Carrera;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Author : Taras Lehinevych  .
 * Date : 3/12/14 ,
 * Time : 7:02 PM
 * com.gora.dominio
 */

public interface CarreraService {

    public void save(Carrera carrera);

    public void update(Carrera carrera);

    public Carrera findById(Long id);

    public List<Carrera> findAll();

}
