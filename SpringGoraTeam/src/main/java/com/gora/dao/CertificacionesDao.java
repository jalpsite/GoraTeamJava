package com.gora.dao;

import java.util.List;

import com.gora.dominio.Certificaciones;


/**
 * Created by IntelliJ IDEA.
 * Author : Jose Alpiste  .
 * Date : 3/12/14 ,
 * Time : 6:32 PM
 * com.gora.dominio
 */

public interface CertificacionesDao extends GenericDao<Certificaciones> {	
	public List<Certificaciones> getCertificacionXHabilidad(Long idHabilidad);
}
