package com.gora.daoImpl;

import com.gora.dao.RecursosDao;
import com.gora.dominio.Recursos;

import org.springframework.stereotype.Repository;

/**
 * Created by IntelliJ IDEA.
 * Author : Jose Alpiste  .
 * Date : 3/12/14 ,
 * Time : 6:32 PM
 * com.gora.dominio
 */

@Repository
public class RecursosDaoImpl extends GenericDaoImpl<Recursos> implements RecursosDao {

	protected RecursosDaoImpl() {
		super(Recursos.class);
		// TODO Auto-generated constructor stub
	}

}

