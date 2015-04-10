package com.gora.dao;

import java.util.List;

import com.gora.dominio.Atributos;
import com.gora.dominio.AtributosCertificacion;

/**
 * Created by IntelliJ IDEA.
 * Author : Jose Alpiste  .
 * Date : 3/12/14 ,
 * Time : 6:32 PM 
 * com.gora.dominio
 */

public interface AtributosCertificacionDao extends GenericDao<AtributosCertificacion> {
	public List<AtributosCertificacion> getCertificacionesXAtributos(Long idAtributos);
	public int eliminarCertificacion(Long idCert);
	public int eliminarCertificacionXHabilidad(Long idHabilidad);
}
