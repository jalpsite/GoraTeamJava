package com.gora.services;

import com.gora.dominio.Usuario;
import com.gora.dominio.UsuarioRol;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Author : Jose Alpiste  .
 * Date : 3/12/14 ,
 * Time : 7:02 PM
 * com.gora.dominio
 */

public interface UsuarioService {

    public void save(Usuario us);

    public void update(Usuario us);

    public Usuario findById(Long id);

    public List<Usuario> findAll();
    
    public Object login(String correo,String dni);
    
    public List<UsuarioRol> rolesUsuario(Long idUsuario);

}
