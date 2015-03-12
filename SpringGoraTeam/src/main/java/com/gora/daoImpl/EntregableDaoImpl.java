package com.gora.daoImpl;

import com.gora.dao.EntregableDao;
import com.gora.dominio.Entregable;

import org.springframework.stereotype.Repository;

/**
 * Created by IntelliJ IDEA.
 * Author : Jose Alpiste  .
 * Date : 3/12/14 ,
 * Time : 6:32 PM
 * com.gora.dominio
 */

@Repository
public class EntregableDaoImpl extends GenericDaoImpl<Entregable> implements EntregableDao {

	protected EntregableDaoImpl() {
		super(Entregable.class);
		// TODO Auto-generated constructor stub
	}

}

