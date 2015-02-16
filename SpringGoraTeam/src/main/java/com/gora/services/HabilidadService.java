package com.gora.services;

import com.gora.dominio.Atributo;
import com.gora.dominio.Habilidad;
import com.gora.dominio.Habilidades;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Author : Taras Lehinevych  .
 * Date : 3/12/14 ,
 * Time : 7:02 PM
 * com.gora.dominio
 */

public interface HabilidadService {

    public void save(Habilidad tarea);

    public void update(Habilidad tarea);

    public Habilidad findById(Long id);

    public List<Habilidad> findAll();
       
    public List<Atributo> getAtributos(Long id);
        
    public List<Habilidades> getHabilidadesExtracto(Long idPersona, Long idCompetencia);
    
    public List<Habilidad> getHabilidadXMatriz(Long idMatriz);
    
    public boolean eliminarXMatriz(Long idMatriz);
    
}