package com.gora.daoImpl;

import com.gora.dao.IniciativaDao;
import com.gora.dominio.Iniciativa;

import org.springframework.stereotype.Repository;

/**
 * Created by IntelliJ IDEA.
 * Author : Jose Alpiste  .
 * Date : 3/12/14 ,
 * Time : 6:32 PM
 * com.gora.dominio
 */

@Repository
public class IniciativaDaoImpl extends GenericDaoImpl<Iniciativa> implements IniciativaDao {

	protected IniciativaDaoImpl() {
		super(Iniciativa.class);
		// TODO Auto-generated constructor stub
	}

}

