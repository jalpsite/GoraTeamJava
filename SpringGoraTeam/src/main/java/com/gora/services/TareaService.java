package com.gora.services;

import com.gora.dominio.Tarea;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Author : Taras Lehinevych  .
 * Date : 3/12/14 ,
 * Time : 7:02 PM
 * com.gora.dominio
 */

public interface TareaService {

    public void save(Tarea tarea);

    public void update(Tarea tarea);

    public Tarea findById(Long id);

    public List<Tarea> findAll();

}
