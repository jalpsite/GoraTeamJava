package com.gora.daoImpl;

import com.gora.dao.EtapaDao;
import com.gora.dominio.Etapa;

import org.springframework.stereotype.Repository;

/**
 * Created by IntelliJ IDEA.
 * Author : Jose Alpiste  .
 * Date : 3/12/14 ,
 * Time : 6:32 PM
 * com.gora.dominio
 */

@Repository
public class EtapaDaoImpl extends GenericDaoImpl<Etapa> implements EtapaDao {

	protected EtapaDaoImpl() {
		super(Etapa.class);
		// TODO Auto-generated constructor stub
	}

}

