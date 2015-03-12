package com.gora.daoImpl;

import com.gora.dao.EquipoDao;
import com.gora.dominio.Equipo;

import org.springframework.stereotype.Repository;

/**
 * Created by IntelliJ IDEA.
 * Author : Jose Alpiste  .
 * Date : 3/12/14 ,
 * Time : 6:32 PM
 * com.gora.dominio
 */

@Repository
public class EquipoDaoImpl extends GenericDaoImpl<Equipo> implements EquipoDao {

	protected EquipoDaoImpl() {
		super(Equipo.class);
		// TODO Auto-generated constructor stub
	}

}

