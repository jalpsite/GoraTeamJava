package com.gora.daoImpl;

import com.gora.dao.AtributosDao;
import com.gora.dominio.Atributos;

import org.springframework.stereotype.Repository;

/**
 * Created by IntelliJ IDEA.
 * Author : Jose Alpiste  .
 * Date : 3/12/14 ,
 * Time : 6:32 PM
 * com.gora.dominio
 */

@Repository
public class AtributosDaoImpl extends GenericDaoImpl<Atributos> implements AtributosDao {

	protected AtributosDaoImpl() {
		super(Atributos.class);
		// TODO Auto-generated constructor stub
	}

}

