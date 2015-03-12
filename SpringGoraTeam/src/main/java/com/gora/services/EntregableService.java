package com.gora.services;

import com.gora.dominio.Entregable;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Author : Taras Lehinevych  .
 * Date : 3/12/14 ,
 * Time : 7:02 PM
 * com.gora.dominio
 */

public interface EntregableService {

    public void save(Entregable entre);

    public void update(Entregable entre);

    public Entregable findById(Long id);

    public List<Entregable> findAll();

}
