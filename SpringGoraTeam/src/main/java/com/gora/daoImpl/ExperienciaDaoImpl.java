package com.gora.daoImpl;

import java.util.List;

import com.gora.dao.ExperienciaDao;
import com.gora.dominio.Experiencia;

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
public class ExperienciaDaoImpl extends GenericDaoImpl<Experiencia> implements ExperienciaDao {
	
	@Autowired
    private SessionFactory sessionFactory;
 
    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
    
	protected ExperienciaDaoImpl() {
		super(Experiencia.class);
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Experiencia> getExperienciasPersona(Long idPersona) {
		Query query=sessionFactory.getCurrentSession().createQuery("select a from Experiencia a where a.persona.idpersona=:id");
		query.setParameter("id", idPersona);
		return query.list();
	}

	@Override
	public void eliminarExperiencia(Long idExperiencia) {
		Query query=sessionFactory.getCurrentSession().createQuery("delete from Experiencia a where a.idexperiencia=:id");
		query.setParameter("id", idExperiencia);
		query.executeUpdate();
	}

}

