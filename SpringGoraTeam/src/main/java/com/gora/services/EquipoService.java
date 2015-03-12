package com.gora.services;

import com.gora.dominio.Equipo;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Author : Taras Lehinevych  .
 * Date : 3/12/14 ,
 * Time : 7:02 PM
 * com.gora.dominio
 */

public interface EquipoService {

    public void save(Equipo equipo);

    public void update(Equipo equipo);

    public Equipo findById(Long id);

    public List<Equipo> findAll();

}
