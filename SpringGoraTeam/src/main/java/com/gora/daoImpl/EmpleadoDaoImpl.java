package com.gora.daoImpl;

import com.gora.dao.EmpleadoDao;
import com.gora.dominio.Empleado;

import org.springframework.stereotype.Repository;

/**
 * Created by IntelliJ IDEA.
 * Author : Jose Alpiste  .
 * Date : 3/12/14 ,
 * Time : 6:32 PM
 * com.gora.dominio
 */

@Repository
public class EmpleadoDaoImpl extends GenericDaoImpl<Empleado> implements EmpleadoDao {

	protected EmpleadoDaoImpl() {
		super(Empleado.class);
		// TODO Auto-generated constructor stub
	}

}

