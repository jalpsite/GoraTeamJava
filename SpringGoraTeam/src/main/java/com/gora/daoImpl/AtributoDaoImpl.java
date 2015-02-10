package com.gora.daoImpl;

import com.gora.dao.AtributoDao;
import com.gora.dominio.Atributo;

import org.springframework.stereotype.Repository;

/**
 * Created by IntelliJ IDEA.
 * Author : Jose Alpiste  .
 * Date : 3/12/14 ,
 * Time : 6:32 PM
 * com.gora.dominio
 */

@Repository
public class AtributoDaoImpl extends GenericDaoImpl<Atributo> implements AtributoDao {

	protected AtributoDaoImpl() {
		super(Atributo.class);
		// TODO Auto-generated constructor stub
	}

}

