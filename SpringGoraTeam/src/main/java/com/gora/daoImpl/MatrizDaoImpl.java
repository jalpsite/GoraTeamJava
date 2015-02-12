package com.gora.daoImpl;

import com.gora.dao.MatrizDao;
import com.gora.dominio.Matriz;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

	@Autowired
    private SessionFactory sessionFactory;
 
    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
    
	protected MatrizDaoImpl() {
		super(Matriz.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void desactivarMatriz(Long idCompetencia) {
		Query query	=sessionFactory.getCurrentSession().createQuery("update Matriz a set a.estado='D' where a.competencia.idcompetencia=:comp");
		query.setParameter("comp", idCompetencia);
		query.executeUpdate();
	}

}

