package com.gora.servicesImpl;

import com.gora.dao.CertificacionesDao;

import com.gora.dominio.Certificaciones;

import com.gora.services.CertificacionesService;

import org.springframework.stereotype.Service;

import javax.inject.Inject;

import org.springframework.transaction.annotation.Transactional;

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
public class CertificacionesServiceImpl implements CertificacionesService {

    @Inject
    private CertificacionesDao certiDao;

	@Override
	public void save(Certificaciones cert) {
		certiDao.save(cert);
	}

	@Override
	public void update(Certificaciones cert) {
		certiDao.update(cert);
	}

	@Override
	public Certificaciones findById(Long id) {
		return certiDao.findById(id);
	}

	@Override
	public List<Certificaciones> findAll() {
		return certiDao.findAll();
	}

	@Override
	public List<Certificaciones> getCertificacionXHabilidad(Long idHabilidad) {
		return certiDao.getCertificacionXHabilidad(idHabilidad);
	}

    

}
