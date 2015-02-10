package com.gora.daoImpl;

import com.gora.dao.ClientDao;
import com.gora.dominio.Cliente;

import org.springframework.stereotype.Repository;

/**
 * Created by IntelliJ IDEA.
 * Author : Taras Lehinevych  .
 * Date : 3/12/14 ,
 * Time : 6:32 PM
 * com.gora.dominio
 */

@Repository
public class ClientDaoImpl extends GenericDaoImpl<Cliente> implements ClientDao {

	protected ClientDaoImpl() {
		super(Cliente.class);
		// TODO Auto-generated constructor stub
	}

}
