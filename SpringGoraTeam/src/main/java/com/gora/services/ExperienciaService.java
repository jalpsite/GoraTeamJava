package com.gora.services;

import com.gora.dominio.Experiencia;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Author : Taras Lehinevych  .
 * Date : 3/12/14 ,
 * Time : 7:02 PM
 * com.gora.dominio
 */

public interface ExperienciaService {

    public void save(Experiencia experiencia);

    public void update(Experiencia experiencia);

    public Experiencia findById(Long id);

    public List<Experiencia> findAll();
    
    public List<Experiencia> getExperienciasPersona(Long idPersona);
    
    public void eliminarExperiencia(Long idExperiencia);

}
