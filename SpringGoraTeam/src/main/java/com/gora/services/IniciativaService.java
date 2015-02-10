package com.gora.services;

import com.gora.dominio.Iniciativa;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Author : Taras Lehinevych  .
 * Date : 3/12/14 ,
 * Time : 7:02 PM
 * com.gora.dominio
 */

public interface IniciativaService {

    public void save(Iniciativa tarea);

    public void update(Iniciativa tarea);

    public Iniciativa findById(Long id);

    public List<Iniciativa> findAll();

}