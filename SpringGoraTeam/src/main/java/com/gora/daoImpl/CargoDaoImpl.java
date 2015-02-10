package com.gora.daoImpl;

import com.gora.dao.CargoDao;
import com.gora.dominio.Cargo;

import org.springframework.stereotype.Repository;

/**
 * Created by IntelliJ IDEA.
 * Author : Jose Alpiste  .
 * Date : 3/12/14 ,
 * Time : 6:32 PM
 * com.gora.dominio
 */

@Repository
public class CargoDaoImpl extends GenericDaoImpl<Cargo> implements CargoDao {

	protected CargoDaoImpl() {
		super(Cargo.class);
		// TODO Auto-generated constructor stub
	}

}

