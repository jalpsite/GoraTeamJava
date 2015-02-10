package com.gora.services;

import com.gora.dominio.Tipodocumento;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Author : Taras Lehinevych  .
 * Date : 3/12/14 ,
 * Time : 7:02 PM
 * com.gora.dominio
 */

public interface TipodocumentoService {

    public void save(Tipodocumento tipodocumento);

    public void update(Tipodocumento tipodocumento);

    public Tipodocumento findById(Long id);

    public List<Tipodocumento> findAll();

}
