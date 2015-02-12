package com.gora.services;

import com.gora.dominio.Matriz;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Author : Taras Lehinevych  .
 * Date : 3/12/14 ,
 * Time : 7:02 PM
 * com.gora.dominio
 */

public interface MatrizService {

    public void save(Matriz tarea);

    public void update(Matriz tarea);

    public Matriz findById(Long id);

    public List<Matriz> findAll();
    
    public void desactivarMatriz(Long idCompetencia);

}
