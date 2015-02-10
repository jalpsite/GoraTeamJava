package com.gora.services;

import com.gora.dominio.Cronograma;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Author : Taras Lehinevych  .
 * Date : 3/12/14 ,
 * Time : 7:02 PM
 * com.gora.dominio
 */

public interface CronogramaService {

    public void save(Cronograma cronograma);

    public void update(Cronograma cronograma);

    public Cronograma findById(Long id);

    public List<Cronograma> findAll();

}
