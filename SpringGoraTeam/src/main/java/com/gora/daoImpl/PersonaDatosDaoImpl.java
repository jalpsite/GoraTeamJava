package com.gora.daoImpl;

import java.util.List;

import com.gora.dao.PersonaDatosDao;
import com.gora.dominio.PersonaDatos;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by IntelliJ IDEA. Author : Jose Alpiste . Date : 3/12/14 , Time :
 * 6:32 PM com.gora.dominio
 */

@Repository
public class PersonaDatosDaoImpl extends GenericDaoImpl<PersonaDatos> implements
		PersonaDatosDao {

	@Autowired
    private SessionFactory sessionFactory;
	
	public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
	protected PersonaDatosDaoImpl() {
		super(PersonaDatos.class);
		// TODO Auto-generated constructor stub
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<PersonaDatos> getPersonaByDNI(String dni) {
		Query query=getCurrentSession().createQuery("FROM PersonaDatos p where p.numerodocidentidad LIKE :dni");
		query.setParameter("dni", "%"+dni+"%");
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<PersonaDatos> getPersonaByNomApe(String nomApe) {
		Query query=getCurrentSession().createQuery("FROM PersonaDatos p where lower(p.nombres) LIKE lower(:nomApe) OR lower(p.apemat) LIKE lower(:nomApe) OR lower(p.apepat) LIKE lower(:nomApe)");
		query.setParameter("nomApe", "%"+nomApe+"%");
		return query.list();
	}

}
