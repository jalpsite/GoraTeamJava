package com.gora.daoImpl;

import com.gora.dao.CronogramaDao;
import com.gora.dominio.Cronograma;

import org.springframework.stereotype.Repository;

/**
 * Created by IntelliJ IDEA.
 * Author : Jose Alpiste  .
 * Date : 3/12/14 ,
 * Time : 6:32 PM
 * com.gora.dominio
 */

@Repository
public class CronogramaDaoImpl extends GenericDaoImpl<Cronograma> implements CronogramaDao {

	protected CronogramaDaoImpl() {
		super(Cronograma.class);
		// TODO Auto-generated constructor stub
	}

}

