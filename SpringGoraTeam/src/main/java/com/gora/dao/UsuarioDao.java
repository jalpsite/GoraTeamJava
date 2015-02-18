package com.gora.dao;

import com.gora.dominio.Usuario;

/**
 * Created by IntelliJ IDEA.
 * Author : Jose Alpiste  .
 * Date : 3/12/14 ,
 * Time : 6:32 PM
 * com.gora.dominio
 */

public interface UsuarioDao extends GenericDao<Usuario> {
	public Object login(String correo,String dni);	
}
