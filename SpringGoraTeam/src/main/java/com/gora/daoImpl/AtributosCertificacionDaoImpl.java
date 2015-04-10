package com.gora.daoImpl;



import java.util.List;

import com.gora.dao.AtributosCertificacionDao;
import com.gora.dominio.AtributosCertificacion;

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
public class AtributosCertificacionDaoImpl extends GenericDaoImpl<AtributosCertificacion> implements AtributosCertificacionDao {
	
	protected AtributosCertificacionDaoImpl() {
		super(AtributosCertificacion.class);
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AtributosCertificacion> getCertificacionesXAtributos(Long idAtributos) {
		Query query=getCurrentSession().createQuery("select a from AtributosCertificacion a where atributos.idatributos=:id");		
		query.setParameter("id", idAtributos);
		return query.list();
	}

	@Override
	public int eliminarCertificacion(Long idCert) {
		Query query=getCurrentSession().createSQLQuery("delete from atributos_certificaciones where idatributocertificacion=:id");
		query.setParameter("id", idCert);
		return query.executeUpdate();
	}

	@Override
	public int eliminarCertificacionXHabilidad(Long idHabilidad) {
		Query query=getCurrentSession().createSQLQuery("delete from atributos_certificaciones where idatributos=(select idatributos from atributos where idhabilidad=:id)");
		query.setParameter("id", idHabilidad);
		return query.executeUpdate();
	}

	

}

