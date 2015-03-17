package com.gora.daoImpl;

import java.util.List;

import com.gora.dao.ProyectoDao;
import com.gora.dominio.Proyecto;

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
public class ProyectoDaoImpl extends GenericDaoImpl<Proyecto> implements ProyectoDao {

	protected ProyectoDaoImpl() {
		super(Proyecto.class);
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Proyecto> buscarProyecto(String busqueda) {
		Query query=getCurrentSession().createQuery("select a from Proyecto a where a.nombre like :cad or a.cliente.nombre like :cad");
		query.setParameter("cad", "%"+busqueda+"%");
		return query.list();
	}


}

