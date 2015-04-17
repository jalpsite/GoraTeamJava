package com.gora.servicesImpl;

import com.gora.dao.PersonaEquipoDao;
import com.gora.dominio.PersonaEquipo;
import com.gora.services.PersonaEquipoService;

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
public class PersonaEquipoServiceImpl implements PersonaEquipoService {

    @Inject
    private PersonaEquipoDao personaEquipoDao;

	@Override
	public void save(PersonaEquipo per_e) {
		personaEquipoDao.save(per_e);
	}

	@Override
	public void update(PersonaEquipo per_e) {
		personaEquipoDao.update(per_e);
	}

	@Override
	public PersonaEquipo findById(Long id) {
		return personaEquipoDao.findById(id);
	}

	@Override
	public List<PersonaEquipo> findAll() {
		return personaEquipoDao.findAll();
	}

	@Override
	public int quitarPersonaEquipo(Long idProyecto, Long idPersona) {
		return personaEquipoDao.quitarPersonaEquipo(idProyecto, idPersona);
	}

	@Override
	public int cambiarRol(Long idProyecto, Long idPersona, Long idEquipoRol) {
		return personaEquipoDao.cambiarRol(idProyecto, idPersona, idEquipoRol);
	}

    

}
