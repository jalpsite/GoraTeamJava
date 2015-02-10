package com.gora.daoImpl;

import com.gora.dao.PortafolioDao;
import com.gora.dominio.Portafolio;

import org.springframework.stereotype.Repository;

/**
 * Created by IntelliJ IDEA.
 * Author : Jose Alpiste  .
 * Date : 3/12/14 ,
 * Time : 6:32 PM
 * com.gora.dominio
 */

@Repository
public class PortafolioDaoImpl extends GenericDaoImpl<Portafolio> implements PortafolioDao {

	protected PortafolioDaoImpl() {
		super(Portafolio.class);
		// TODO Auto-generated constructor stub
	}

}

