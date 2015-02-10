package com.gora.services;

import com.gora.dominio.Ubigeo;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Author : Taras Lehinevych  .
 * Date : 3/12/14 ,
 * Time : 7:02 PM
 * com.gora.dominio
 */

public interface UbigeoService {

    public void save(Ubigeo ubigeo);

    public void update(Ubigeo ubigeo);

    public Ubigeo findById(Long id);

    public List<Ubigeo> findAll();

}
