package com.gora.daoImpl;

import com.gora.dao.GradoDao;
import com.gora.dominio.Grado;

import org.springframework.stereotype.Repository;

/**
 * Created by IntelliJ IDEA.
 * Author : Jose Alpiste  .
 * Date : 3/12/14 ,
 * Time : 6:32 PM
 * com.gora.dominio
 */

@Repository
public class GradoDaoImpl extends GenericDaoImpl<Grado> implements GradoDao {

	protected GradoDaoImpl() {
		super(Grado.class);
		// TODO Auto-generated constructor stub
	}

}

