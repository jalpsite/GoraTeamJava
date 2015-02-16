package com.gora.services;

import com.gora.dominio.Competencia;
import com.gora.dominio.Habilidad;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Author : Taras Lehinevych  .
 * Date : 3/12/14 ,
 * Time : 7:02 PM
 * com.gora.dominio
 */

public interface CompetenciaService {

    public void save(Competencia tarea);

    public void update(Competencia tarea);

    public Competencia findById(Long id);

    public List<Competencia> findAll();
    
    public List<Habilidad> getHabilidades(Long id);
    
    public List<Competencia> getCompetenciasExtracto(Long idPersona);

}
