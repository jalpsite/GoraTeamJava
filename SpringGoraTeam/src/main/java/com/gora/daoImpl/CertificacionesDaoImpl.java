package com.gora.daoImpl;

import java.util.List;

import com.gora.dao.CertificacionesDao;
import com.gora.dao.ClienteDao;
import com.gora.dominio.Certificaciones;
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
public class CertificacionesDaoImpl extends GenericDaoImpl<Certificaciones> implements CertificacionesDao {

	protected CertificacionesDaoImpl() {
		super(Certificaciones.class);
		// TODO Auto-generated constructor stub
	}	

	@SuppressWarnings("unchecked")
	@Override
	public List<Certificaciones> getCertificacionXHabilidad(Long idHabilidad) {
		Query query=getCurrentSession().createQuery("select a from Certificaciones a where a.idhabilidades=:id");
		query.setParameter("id", idHabilidad);
		return query.list();
	}
	
		

}

