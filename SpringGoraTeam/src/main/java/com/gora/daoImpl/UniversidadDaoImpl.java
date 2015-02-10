package com.gora.daoImpl;

import com.gora.dao.UniversidadDao;
import com.gora.dominio.Universidad;

import org.springframework.stereotype.Repository;

/**
 * Created by IntelliJ IDEA.
 * Author : Jose Alpiste  .
 * Date : 3/12/14 ,
 * Time : 6:32 PM
 * com.gora.dominio
 */

@Repository
public class UniversidadDaoImpl extends GenericDaoImpl<Universidad> implements UniversidadDao {

	protected UniversidadDaoImpl() {
		super(Universidad.class);
		// TODO Auto-generated constructor stub
	}

}

