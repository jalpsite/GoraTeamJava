package com.gora.daoImpl;

import com.gora.dao.UbigeoDao;
import com.gora.dominio.Ubigeo;

import org.springframework.stereotype.Repository;

/**
 * Created by IntelliJ IDEA.
 * Author : Jose Alpiste  .
 * Date : 3/12/14 ,
 * Time : 6:32 PM
 * com.gora.dominio
 */

@Repository
public class UbigeoDaoImpl extends GenericDaoImpl<Ubigeo> implements UbigeoDao {

	protected UbigeoDaoImpl() {
		super(Ubigeo.class);
		// TODO Auto-generated constructor stub
	}

}

