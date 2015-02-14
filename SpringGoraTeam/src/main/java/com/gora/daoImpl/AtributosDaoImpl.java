package com.gora.daoImpl;

import com.gora.dao.AtributosDao;
import com.gora.dominio.Atributos;

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
public class AtributosDaoImpl extends GenericDaoImpl<Atributos> implements AtributosDao {

	@Autowired
	private SessionFactory sessionFactory;

	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	protected AtributosDaoImpl() {
		super(Atributos.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean eliminarXHabilidad(Long idHabilidad) {
		Query query=sessionFactory.getCurrentSession().createQuery("delete from Atributos a where a.habilidad.idhabilidad=:id");
		query.setParameter("id",idHabilidad);
		try {
			query.executeUpdate();
		} catch (Exception e) {
			return false;
		}
		return true;
	}

}

