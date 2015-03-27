package com.gora.services;

import com.gora.dominio.Tipoproyecto;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Author : Taras Lehinevych  .
 * Date : 3/12/14 ,
 * Time : 7:02 PM
 * com.gora.dominio
 */

public interface TipoproyectoService {

    public void save(Tipoproyecto tipoproyecto);

    public void update(Tipoproyecto tipoproyecto);

    public Tipoproyecto findById(Long id);

    public List<Tipoproyecto> findAll();

    public List<Tipoproyecto> buscarTipoProyecto(String cadena);
}
