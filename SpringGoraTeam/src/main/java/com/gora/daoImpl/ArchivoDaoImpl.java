package com.gora.daoImpl;

import java.io.IOException;
import java.io.InputStream;
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

	@SuppressWarnings("unchecked")
	@Override
	public Archivo getArchivo(Long idPersona, String tipo) {
		Query query = sessionFactory.getCurrentSession().createQuery("select a from Archivo a where a.idpersona=:id and a.tipo=:tip");
		query.setParameter("id", idPersona);
		query.setParameter("tip", tipo.toUpperCase());
		List<Archivo> archivos=query.list();		
		if(archivos.size()>0){			
			return archivos.get(0);			
		}else{
			return null;
		}	
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Archivo> getArchivosLista(Long idPersona, String tipo,
			Long idMatriz) {
		Query query = sessionFactory.getCurrentSession().createQuery("select a from Archivo a where a.idpersona=:id and a.tipo=:tip and a.idmatriz=:matr");
		query.setParameter("id", idPersona);
		query.setParameter("tip", tipo.toUpperCase());
		query.setParameter("matr", idMatriz);
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Archivo getArchivoID(Long idArchivo) {
		Query query = sessionFactory.getCurrentSession().createQuery("select a from Archivo a where a.idarchivo=:id");
		query.setParameter("id", idArchivo);		
		List<Archivo> archivos=query.list();		
		if(archivos.size()>0){			
			return archivos.get(0);			
		}else{
			return null;
		}	
	}

	@Override
	public void eliminarArchivo(Long idArchivo) {
		Query query = sessionFactory.getCurrentSession().createQuery("delete Archivo a where a.idarchivo=:id");	
		query.setParameter("id", idArchivo);
		query.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Archivo> getFotos() {
		Query query = sessionFactory.getCurrentSession().createQuery("select a from Archivo a where a.tipo='PF' or a.tipo='ANONIMO'");
		return query.list();
			
	}
	

}