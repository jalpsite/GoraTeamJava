package com.gora.daoImpl;

import java.util.List;

import com.gora.dao.PersonaDatosDao;
import com.gora.dominio.Persona;
import com.gora.dominio.PersonaDatos;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by IntelliJ IDEA. Author : Jose Alpiste . Date : 3/12/14 , Time :
 * 6:32 PM com.gora.dominio
 */

@Repository
public class PersonaDatosDaoImpl extends GenericDaoImpl<PersonaDatos> implements
		PersonaDatosDao {

	    
	protected PersonaDatosDaoImpl() {
		super(PersonaDatos.class);
		// TODO Auto-generated constructor stub
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Persona> getPersonaByDNI(String dni) {
		Query query=getCurrentSession().createQuery("select p from Persona p where p.numerodocidentidad LIKE :dni");
		query.setParameter("dni", "%"+dni+"%");
		query.setMaxResults(20);
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Persona> getPersonaByNomApe(String nomApe) {
		Query query=getCurrentSession().createQuery("select p FROM Persona p where lower(p.nombres) LIKE lower(:nomApe) OR lower(p.apemat) LIKE lower(:nomApe) OR lower(p.apepat) LIKE lower(:nomApe)");
		query.setParameter("nomApe", "%"+nomApe+"%");
		query.setMaxResults(20);
		return query.list();
	}

}
