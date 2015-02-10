package com.gora.daoImpl;

import java.util.List;

import com.gora.dao.HabilidadDao;
import com.gora.dominio.Atributo;
import com.gora.dominio.Habilidad;

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
public class HabilidadDaoImpl extends GenericDaoImpl<Habilidad> implements HabilidadDao {

	protected HabilidadDaoImpl() {
		super(Habilidad.class);
		// TODO Auto-generated constructor stub
	}	
	@Autowired
    private SessionFactory sessionFactory;
 
    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @SuppressWarnings("unchecked")
	@Override
	public List<Atributo> getAtributos(Long id) {
		Query query=getCurrentSession().createQuery("select a.idatributo, a.descripcion from Atributo a where a.habilidades.idhabilidades= :id");
		query.setParameter("id", id);
		return query.list();
	}

}

