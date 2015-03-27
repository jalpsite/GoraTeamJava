package com.gora.daoImpl;

import java.util.List;

import com.gora.dao.TipoproyectoDao;
import com.gora.dominio.Tipoproyecto;

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
public class TipoproyectoDaoImpl extends GenericDaoImpl<Tipoproyecto> implements TipoproyectoDao {

	protected TipoproyectoDaoImpl() {
		super(Tipoproyecto.class);
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Tipoproyecto> buscarTipoProyecto(String cadena) {
		Query query =getCurrentSession().createQuery("select a from Tipoproyecto a where upper(a.descripcion) like :cad");
		query.setParameter("cad", "%"+cadena.toUpperCase()+"%");
		return query.list();
	}

}

