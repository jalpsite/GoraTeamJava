package com.gora.services;

import com.gora.dominio.AtributosCertificacion;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Author : Taras Lehinevych  .
 * Date : 3/12/14 ,
 * Time : 7:02 PM
 * com.gora.dominio
 */

public interface AtributosCertificacionService {

    public void save(AtributosCertificacion cert);

    public void update(AtributosCertificacion cert);

    public AtributosCertificacion findById(Long id);

    public List<AtributosCertificacion> findAll();
    
    public List<AtributosCertificacion> getCertificacionesXAtributos(Long idAtributos);
    
    public int eliminarCertificacion(Long idCert);
    
    public int eliminarCertificacionXHabilidad(Long idHabilidad);

}
