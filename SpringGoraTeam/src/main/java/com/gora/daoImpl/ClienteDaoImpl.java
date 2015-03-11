package com.gora.daoImpl;

import java.util.List;

import com.gora.dao.ClienteDao;
import com.gora.dominio.Cliente;

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
public class ClienteDaoImpl extends GenericDaoImpl<Cliente> implements ClienteDao {

	protected ClienteDaoImpl() {
		super(Cliente.class);
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> buscarXEmpresa(String empresa) {
		Query query=getCurrentSession().createQuery("select c from Cliente c where c.nombre like :emp");
		query.setParameter("emp", "%"+empresa+"%");
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> buscarXContacto(String contacto) {
		Query query=getCurrentSession().createQuery("select c from Cliente c where c.contacto like :con");
		query.setParameter("con", "%"+contacto+"%");
		return query.list();
	}

}

