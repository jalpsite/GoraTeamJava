package com.gora.services;

import com.gora.dominio.Tipoiniciativa;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Author : Taras Lehinevych  .
 * Date : 3/12/14 ,
 * Time : 7:02 PM
 * com.gora.dominio
 */

public interface TipoIniciativaService {

    public void save(Tipoiniciativa tipoiniciativa);

    public void update(Tipoiniciativa tipoiniciativa);

    public Tipoiniciativa findById(Long id);

    public List<Tipoiniciativa> findAll();

}
