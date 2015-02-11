package com.gora.daoImpl;

import java.io.InputStream;
import java.sql.Blob;

import com.gora.dao.ArchivoDao;
import com.gora.dominio.Archivo;

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
public class ArchivoDaoImpl implements ArchivoDao {
	
	@Autowired
    private SessionFactory sessionFactory;
 
    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

	@Override
	public void subirArchivo(Archivo objArchivo, InputStream arch) {
		Blob archivo=sessionFactory.getCurrentSession().getLobHelper().createBlob(arch,-1);
		objArchivo.setArchivo(archivo);
		sessionFactory.getCurrentSession().save(objArchivo);
	}

	@Override
	public void actualizarArchivo(Archivo objArchivo, InputStream arch) {
		if(arch!=null){
			Blob archivo=sessionFactory.getCurrentSession().getLobHelper().createBlob(arch,-1);
			objArchivo.setArchivo(archivo);
        }        
		sessionFactory.getCurrentSession().saveOrUpdate(objArchivo);        
	}

	@Override
	public Archivo getArchivo(Long idPersona, String tipo) {
		Query query=sessionFactory.getCurrentSession().createQuery("select a from Archivo a where idpersona=:id and tipo=:tip");
		query.setParameter("id", idPersona);
		query.setParameter("tip", tipo);
		return (Archivo)query.uniqueResult();
	}
    
		

}

