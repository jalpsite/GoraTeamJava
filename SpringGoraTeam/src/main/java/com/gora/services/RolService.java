package com.gora.services;
import com.gora.dominio.Rol;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Author : Taras Lehinevych  .
 * Date : 3/12/14 ,
 * Time : 7:02 PM
 * com.gora.dominio
 */

public interface RolService {

    public void save(Rol rol);

    public void update(Rol rol);

    public Rol findById(Long id);

    public List<Rol> findAll();

}
