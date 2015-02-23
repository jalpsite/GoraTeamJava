package com.gora.daoImpl;

import com.gora.dao.UsuarioRolDao;
import com.gora.dominio.UsuarioRol;
import org.springframework.stereotype.Repository;

/**
 * Created by IntelliJ IDEA.
 * Author : Jose Alpiste  .
 * Date : 3/12/14 ,
 * Time : 6:32 PM
 * com.gora.dominio
 */

@Repository
public class UsuarioRolDaoImpl extends GenericDaoImpl<UsuarioRol> implements UsuarioRolDao {
	
    
	protected UsuarioRolDaoImpl() {
		super(UsuarioRol.class);
		// TODO Auto-generated constructor stub
	}

	

}

