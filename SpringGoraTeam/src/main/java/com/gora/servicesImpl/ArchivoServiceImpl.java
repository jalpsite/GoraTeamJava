package com.gora.servicesImpl;

import com.gora.dao.ArchivoDao;
import com.gora.dominio.Archivo;
import com.gora.services.ArchivoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.InputStream;

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
	public void subirArchivo(Archivo objArchivo, InputStream arch) {		
		archivoDao.subirArchivo(objArchivo, arch);
	}

	@Override
	public void actualizarArchivo(Archivo objArchivo, InputStream arch) {
		archivoDao.actualizarArchivo(objArchivo, arch);
	}

	@Override
	public Archivo getArchivo(Long idPersona, String tipo) {
		return archivoDao.getArchivo(idPersona, tipo);
	}
    

}