package com.gora.dao;

import java.util.List;

import com.gora.dominio.Cliente;

/**
 * Created by IntelliJ IDEA.
 * Author : Jose Alpiste  .
 * Date : 3/12/14 ,
 * Time : 6:32 PM
 * com.gora.dominio
 */

public interface ClienteDao extends GenericDao<Cliente> {
	public List<Cliente> buscarXEmpresa(String empresa);
	public List<Cliente> buscarXContacto(String contacto);
	
}
