package com.gora.servicesImpl;

import com.gora.dao.ArchivoDao;
import com.gora.dominio.Archivo;
import com.gora.services.ArchivoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.InputStream;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Author : Taras Lehinevych  .
 * Date : 3/12/14 ,
 * Time : 7:10 PM
 * com.gora.dominio
 */


@Service
@Transactional
public class ArchivoServiceImpl implements ArchivoService {

	@Autowired
	private ArchivoDao archivoDao;
	 
	@Override
	public void gestionArchivo(Archivo objArchivo, InputStream arch) {		
		archivoDao.gestionArchivo(objArchivo, arch);
	}
	

	@Override
	public Archivo getArchivo(Long idPersona, String tipo) {
		return archivoDao.getArchivo(idPersona, tipo);
	}


	@Override
	public List<Archivo> getArchivosLista(Long idPersona, String tipo,
			Long idMatriz) {
		return archivoDao.getArchivosLista(idPersona, tipo, idMatriz);
	}


	@Override
	public Archivo getArchivoID(Long idArchivo) {
		return archivoDao.getArchivoID(idArchivo);
	}
	
    

}