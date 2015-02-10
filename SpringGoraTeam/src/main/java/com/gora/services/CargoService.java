package com.gora.services;

import com.gora.dominio.Cargo;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Author : Taras Lehinevych  .
 * Date : 3/12/14 ,
 * Time : 7:02 PM
 * com.gora.dominio
 */

public interface CargoService {

    public void save(Cargo tarea);

    public void update(Cargo tarea);

    public Cargo findById(Long id);

    public List<Cargo> findAll();

}
