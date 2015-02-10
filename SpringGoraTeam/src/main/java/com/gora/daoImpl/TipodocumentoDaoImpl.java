package com.gora.daoImpl;

import com.gora.dao.TipodocumentoDao;
import com.gora.dominio.Tipodocumento;

import org.springframework.stereotype.Repository;

/**
 * Created by IntelliJ IDEA.
 * Author : Jose Alpiste  .
 * Date : 3/12/14 ,
 * Time : 6:32 PM
 * com.gora.dominio
 */

@Repository
public class TipodocumentoDaoImpl extends GenericDaoImpl<Tipodocumento> implements TipodocumentoDao {

	protected TipodocumentoDaoImpl() {
		super(Tipodocumento.class);
		// TODO Auto-generated constructor stub
	}

}

