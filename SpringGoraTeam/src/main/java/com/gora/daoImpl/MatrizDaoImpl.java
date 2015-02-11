package com.gora.daoImpl;

import com.gora.dao.MatrizDao;
import com.gora.dominio.Matriz;

import org.springframework.stereotype.Repository;

/**
 * Created by IntelliJ IDEA.
 * Author : Jose Alpiste  .
 * Date : 3/12/14 ,
 * Time : 6:32 PM
 * com.gora.dominio
 */

@Repository
public class MatrizDaoImpl extends GenericDaoImpl<Matriz> implements MatrizDao {

	protected MatrizDaoImpl() {
		super(Matriz.class);
		// TODO Auto-generated constructor stub
	}

}

