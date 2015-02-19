package com.gora.dao;

import java.util.List;

import com.gora.dominio.Usuario;
import com.gora.dominio.UsuarioRol;

/**
 * Created by IntelliJ IDEA.
 * Author : Jose Alpiste  .
 * Date : 3/12/14 ,
 * Time : 6:32 PM
 * com.gora.dominio
 */

public interface UsuarioDao extends GenericDao<Usuario> {
	public Object login(String correo,String dni);	
	public List<UsuarioRol> rolesUsuario(Long idUsuario);
}
