package com.gora.services;

import com.gora.dominio.Universidad;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Author : Jose Alpiste  .
 * Date : 3/12/14 ,
 * Time : 7:02 PM
 * com.gora.dominio
 */

public interface UniversidadService {

    public void save(Universidad universidad);

    public void update(Universidad universidad);

    public Universidad findById(Long id);

    public List<Universidad> findAll();

}
