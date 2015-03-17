package com.gora.services;

import com.gora.dominio.Proyecto;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Author : Jose Alpiste  .
 * Date : 3/12/14 ,
 * Time : 7:02 PM
 * com.gora.dominio
 */

public interface ProyectoService {

    public void save(Proyecto proyecto);

    public void update(Proyecto proyecto);

    public Proyecto findById(Long id);

    public List<Proyecto> findAll();
    
    public List<Proyecto> buscarProyecto(String busqueda);

}
