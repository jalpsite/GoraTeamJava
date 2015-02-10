package com.gora.daoImpl;

import com.gora.dao.TareaDao;
import com.gora.dominio.Tarea;

import org.springframework.stereotype.Repository;

/**
 * Created by IntelliJ IDEA.
 * Author : Jose Alpiste  .
 * Date : 3/12/14 ,
 * Time : 6:32 PM
 * com.gora.dominio
 */

@Repository
public class TareaDaoImpl extends GenericDaoImpl<Tarea> implements TareaDao {

	protected TareaDaoImpl() {
		super(Tarea.class);
		// TODO Auto-generated constructor stub
	}

}

