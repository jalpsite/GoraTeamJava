package com.gora.daoImpl;

import com.gora.dao.TipoproyectoDao;
import com.gora.dominio.Tipoproyecto;

import org.springframework.stereotype.Repository;

/**
 * Created by IntelliJ IDEA.
 * Author : Jose Alpiste  .
 * Date : 3/12/14 ,
 * Time : 6:32 PM
 * com.gora.dominio
 */

@Repository
public class TipoproyectoDaoImpl extends GenericDaoImpl<Tipoproyecto> implements TipoproyectoDao {

	protected TipoproyectoDaoImpl() {
		super(Tipoproyecto.class);
		// TODO Auto-generated constructor stub
	}

}

