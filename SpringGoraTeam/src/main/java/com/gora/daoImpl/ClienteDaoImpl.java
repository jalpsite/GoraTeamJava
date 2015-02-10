package com.gora.daoImpl;

import com.gora.dao.ClienteDao;
import com.gora.dominio.Cliente;

import org.springframework.stereotype.Repository;

/**
 * Created by IntelliJ IDEA.
 * Author : Jose Alpiste  .
 * Date : 3/12/14 ,
 * Time : 6:32 PM
 * com.gora.dominio
 */

@Repository
public class ClienteDaoImpl extends GenericDaoImpl<Cliente> implements ClienteDao {

	protected ClienteDaoImpl() {
		super(Cliente.class);
		// TODO Auto-generated constructor stub
	}

}

