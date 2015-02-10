package com.gora.daoImpl;

import com.gora.dao.ProyectoDao;
import com.gora.dominio.Proyecto;

import org.springframework.stereotype.Repository;

/**
 * Created by IntelliJ IDEA.
 * Author : Jose Alpiste  .
 * Date : 3/12/14 ,
 * Time : 6:32 PM
 * com.gora.dominio
 */

@Repository
public class ProyectoDaoImpl extends GenericDaoImpl<Proyecto> implements ProyectoDao {

	protected ProyectoDaoImpl() {
		super(Proyecto.class);
		// TODO Auto-generated constructor stub
	}

}

