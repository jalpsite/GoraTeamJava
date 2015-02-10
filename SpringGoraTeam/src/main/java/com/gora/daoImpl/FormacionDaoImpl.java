package com.gora.daoImpl;

import java.util.List;

import com.gora.dao.FormacionDao;
import com.gora.dominio.Formacion;

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
public class FormacionDaoImpl extends GenericDaoImpl<Formacion> implements FormacionDao {

	@Autowired
    private SessionFactory sessionFactory;
 
    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
    
	protected FormacionDaoImpl() {
		super(Formacion.class);
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Formacion> getFormacionPersona(Long idPersona) {
		Query query=sessionFactory.getCurrentSession().createQuery("select a from Formacion a where a.persona.idpersona=:id");
		query.setParameter("id", idPersona);
		return query.list();
	}

}

