package com.gora.services;

import com.gora.dominio.Recursos;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Author : Taras Lehinevych  .
 * Date : 3/12/14 ,
 * Time : 7:02 PM
 * com.gora.dominio
 */

public interface RecursosService {

    public void save(Recursos rec);

    public void update(Recursos rec);

    public Recursos findById(Long id);

    public List<Recursos> findAll();

}
