package com.gora.daoImpl;

import com.gora.dao.TipoiniciativaDao;
import com.gora.dominio.Tipoiniciativa;

import org.springframework.stereotype.Repository;

/**
 * Created by IntelliJ IDEA.
 * Author : Jose Alpiste  .
 * Date : 3/12/14 ,
 * Time : 6:32 PM
 * com.gora.dominio
 */

@Repository
public class TipoiniciativaDaoImpl extends GenericDaoImpl<Tipoiniciativa> implements TipoiniciativaDao {

	protected TipoiniciativaDaoImpl() {
		super(Tipoiniciativa.class);
		// TODO Auto-generated constructor stub
	}

}

