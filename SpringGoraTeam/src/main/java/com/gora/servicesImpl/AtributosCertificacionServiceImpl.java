package com.gora.servicesImpl;

import com.gora.dao.AtributosCertificacionDao;
import com.gora.dao.AtributosDao;
import com.gora.dominio.Atributos;
import com.gora.dominio.AtributosCertificacion;
import com.gora.services.AtributosCertificacionService;
import com.gora.services.AtributosService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
public class AtributosCertificacionServiceImpl implements AtributosCertificacionService {

    @Autowired
    private AtributosCertificacionDao atributoCertDao;

	@Override
	public void save(AtributosCertificacion cert) {
		atributoCertDao.save(cert);
	}

	@Override
	public void update(AtributosCertificacion cert) {
		atributoCertDao.update(cert);
	}

	@Override
	public AtributosCertificacion findById(Long id) {
		return atributoCertDao.findById(id);
	}

	@Override
	public List<AtributosCertificacion> findAll() {
		return atributoCertDao.findAll();
	}

	@Override
	public List<AtributosCertificacion> getCertificacionesXAtributos(
			Long idAtributos) {
		return atributoCertDao.getCertificacionesXAtributos(idAtributos);
	}

	@Override
	public int eliminarCertificacion(Long idCert) {
		return atributoCertDao.eliminarCertificacion(idCert);
	}

	@Override
	public int eliminarCertificacionXHabilidad(Long idHabilidad) {
		return atributoCertDao.eliminarCertificacionXHabilidad(idHabilidad);
	}

    

}