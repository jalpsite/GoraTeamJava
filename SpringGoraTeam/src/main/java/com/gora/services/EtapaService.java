package com.gora.services;

import com.gora.dominio.Etapa;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Author : Taras Lehinevych  .
 * Date : 3/12/14 ,
 * Time : 7:02 PM
 * com.gora.dominio
 */

public interface EtapaService {

    public void save(Etapa etapa);

    public void update(Etapa etapa);

    public Etapa findById(Long id);

    public List<Etapa> findAll();

}
