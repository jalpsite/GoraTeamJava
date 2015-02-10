package com.gora.daoImpl;

import com.gora.dao.EvaluacionDao;
import com.gora.dominio.Evaluacion;

import org.springframework.stereotype.Repository;

/**
 * Created by IntelliJ IDEA.
 * Author : Jose Alpiste  .
 * Date : 3/12/14 ,
 * Time : 6:32 PM
 * com.gora.dominio
 */

@Repository
public class EvaluacionDaoImpl extends GenericDaoImpl<Evaluacion> implements EvaluacionDao {

	protected EvaluacionDaoImpl() {
		super(Evaluacion.class);
		// TODO Auto-generated constructor stub
	}

}

