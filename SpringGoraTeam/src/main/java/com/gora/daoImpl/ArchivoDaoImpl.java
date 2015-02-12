package com.gora.daoImpl;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.util.List;

import com.gora.dao.ArchivoDao;
import com.gora.dominio.Archivo;

import org.apache.commons.io.IOUtils;
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
public class ArchivoDaoImpl implements ArchivoDao {

	@Autowired
	private SessionFactory sessionFactory;

	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void gestionArchivo(Archivo objArchivo, InputStream arch) {

		byte[] bytes;
		try {
			bytes = IOUtils.toByteArray(arch);
			objArchivo.setArchivo(bytes);
		} catch (IOException e) {			
			e.printStackTrace();
		}
		
		sessionFactory.getCurrentSession().saveOrUpdate(objArchivo);
	}

	@Override
	public Archivo getArchivo(Long idPersona, String tipo) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"select a from Archivo a where idpersona=:id and tipo=:tip");
		query.setParameter("id", idPersona);
		query.setParameter("tip", tipo);
		return (Archivo) query.list().get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Archivo existenciaArchivo(Long idPersona, String tipo) {
		Query query=sessionFactory.getCurrentSession().createQuery("select a from Archivo a where a.idpersona=:id and a.tipo=:tipo");
		query.setParameter("id", idPersona);
		query.setParameter("tipo", tipo.toUpperCase());		
		Archivo ar=null;
		List<Archivo> lstArchivos=query.list();		
		if(lstArchivos.size()>0){
			ar=lstArchivos.get(0);
		}			
		return ar;
	}

}