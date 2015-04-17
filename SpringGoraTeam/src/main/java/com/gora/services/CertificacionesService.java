package com.gora.services;
import com.gora.dominio.Certificaciones;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Author : Taras Lehinevych  .
 * Date : 3/12/14 ,
 * Time : 7:02 PM
 * com.gora.dominio
 */

public interface CertificacionesService {

    public void save(Certificaciones cert);

    public void update(Certificaciones cert);

    public Certificaciones findById(Long id);

    public List<Certificaciones> findAll();
    
    public List<Certificaciones> getCertificacionXHabilidad(Long idHabilidad);

}
