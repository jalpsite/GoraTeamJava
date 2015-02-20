package com.gora.services;


import com.gora.dominio.UsuarioRol;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Author : Jose Alpiste  .
 * Date : 3/12/14 ,
 * Time : 7:02 PM
 * com.gora.dominio
 */

public interface UsuarioRolService {

    public void save(UsuarioRol us);

    public void update(UsuarioRol us);

    public UsuarioRol findById(Long id);

    public List<UsuarioRol> findAll();   
    

}
