package com.gora.daoImpl;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.gora.dao.GenericDao;

import java.io.Serializable;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Author : Taras Lehinevych  .
 * Date : 3/12/14 ,
 * Time : 6:37 PM
 * com.gora.dominio
 */

public class GenericDaoImpl<E extends Serializable> implements GenericDao<E> {

	private Class<E> entityClass;
	 
    protected GenericDaoImpl(Class<E> entityClass) {
        this.entityClass = entityClass;
    }
 
    @Autowired
    private SessionFactory sessionFactory;
 
    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
 
    @SuppressWarnings("unchecked")
	@Override
    public List<E> findAll() {
        return (List<E>) getCurrentSession().createQuery("from " + entityClass.getSimpleName()).list();
    }
     
    @SuppressWarnings("unchecked")
	@Override
    public E findById(Long id) {
        return (E) getCurrentSession().get(entityClass, id);
    }
 
   
 
    @Override
    public void delete(E e) {
        getCurrentSession().delete(e);
    }

	@Override
	public void save(E e) {
		getCurrentSession().save(e);
		
	}

	@Override
	public void update(E e) {
		getCurrentSession().saveOrUpdate(e);
		
	}
}
