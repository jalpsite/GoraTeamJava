package com.gora.daoImpl;

import com.gora.dao.RolDao;
import com.gora.dominio.Rol;
import org.springframework.stereotype.Repository;

/**
 * Created by IntelliJ IDEA.
 * Author : Jose Alpiste  .
 * Date : 3/12/14 ,
 * Time : 6:32 PM
 * com.gora.dominio
 */

@Repository
public class RolDaoImpl extends GenericDaoImpl<Rol> implements RolDao {

	protected RolDaoImpl() {
		super(Rol.class);
		// TODO Auto-generated constructor stub
	}

}

