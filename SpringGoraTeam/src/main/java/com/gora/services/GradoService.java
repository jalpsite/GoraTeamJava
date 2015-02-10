package com.gora.services;

import com.gora.dominio.Grado;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Author : Taras Lehinevych  .
 * Date : 3/12/14 ,
 * Time : 7:02 PM
 * com.gora.dominio
 */

public interface GradoService {

    public void save(Grado tarea);

    public void update(Grado tarea);

    public Grado findById(Long id);

    public List<Grado> findAll();

}