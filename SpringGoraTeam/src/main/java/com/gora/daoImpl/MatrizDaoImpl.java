package com.gora.daoImpl;

import com.gora.dao.MatrizDao;
import com.gora.dominio.Matriz;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by IntelliJ IDEA.
 * Author : Jose Alpiste  .
 * Date : 3/12/14 ,
 * Time : 6:32 PM
 * com.gora.dominio
 */

@Repository
public class MatrizDaoImpl extends GenericDaoImpl<Matriz> implements MatrizDao {
	  	   
	protected MatrizDaoImpl() {
		super(Matriz.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean deshabilitarMatriz(Long idMatriz) {
		Query query=getCurrentSession().createQuery("update Matriz a set a.estado='D' where a.idmatriz=:id");
		query.setParameter("id", idMatriz);		
		int x=query.executeUpdate();			
		if(x>0)
			return true;
		else
			return false;
	}

}

