package com.gora.daoImpl;

import com.gora.dao.HabilidadesDao;

import com.gora.dominio.Habilidades;

import org.springframework.stereotype.Repository;

/**
 * Created by IntelliJ IDEA. Author : Jose Alpiste . Date : 3/12/14 , Time :
 * 6:32 PM com.gora.dominio
 */

@Repository
public class HabilidadesDaoImpl extends GenericDaoImpl<Habilidades> implements
		HabilidadesDao {

	protected HabilidadesDaoImpl() {
		super(Habilidades.class);
		// TODO Auto-generated constructor stub
	}

}
