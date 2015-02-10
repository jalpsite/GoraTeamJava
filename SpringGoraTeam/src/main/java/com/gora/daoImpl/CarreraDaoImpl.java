package com.gora.daoImpl;

import com.gora.dao.CarreraDao;
import com.gora.dominio.Carrera;

import org.springframework.stereotype.Repository;

/**
 * Created by IntelliJ IDEA.
 * Author : Jose Alpiste  .
 * Date : 3/12/14 ,
 * Time : 6:32 PM
 * com.gora.dominio
 */

@Repository
public class CarreraDaoImpl extends GenericDaoImpl<Carrera> implements CarreraDao {

	protected CarreraDaoImpl() {
		super(Carrera.class);
		// TODO Auto-generated constructor stub
	}

}

