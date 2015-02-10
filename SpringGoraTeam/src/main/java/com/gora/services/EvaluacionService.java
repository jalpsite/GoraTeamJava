package com.gora.services;

import com.gora.dominio.Evaluacion;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Author : Taras Lehinevych  .
 * Date : 3/12/14 ,
 * Time : 7:02 PM
 * com.gora.dominio
 */

public interface EvaluacionService {

    public void save(Evaluacion tarea);

    public void update(Evaluacion tarea);

    public Evaluacion findById(Long id);

    public List<Evaluacion> findAll();

}
