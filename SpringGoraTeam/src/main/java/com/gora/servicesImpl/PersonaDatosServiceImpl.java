package com.gora.servicesImpl;

import com.gora.dao.PersonaDatosDao;
import com.gora.dominio.Persona;
import com.gora.dominio.PersonaDatos;
import com.gora.services.PersonaDatosService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by IntelliJ IDEA. Author : Taras Lehinevych . Date : 3/12/14 , Time :
 * 7:10 PM com.gora.dominio
 */

@Service
@Transactional
public class PersonaDatosServiceImpl implements PersonaDatosService {

	@Autowired
	private PersonaDatosDao personaDao;

	@Override
	public void save(PersonaDatos persona) {
		personaDao.save(persona);
	}

	@Override
	public void update(PersonaDatos persona) {
		personaDao.update(persona);
	}

	@Override
	public List<PersonaDatos> findAll() {
		List<PersonaDatos> tmp = personaDao.findAll();
		// for (Client order : tmp) {
		// Hibernate.initialize(order.getOrders());
		// }
		return tmp;
	}

	@Override
	public PersonaDatos findById(Long id) {
		PersonaDatos tmp = personaDao.findById(id);
		// Hibernate.initialize(tmp.getOrders());
		return tmp;
	}

	@Override
	public List<Persona> getPersonaByDNI(String dni) {
		return personaDao.getPersonaByDNI(dni);
	}

	@Override
	public List<Persona> getPersonaByNomApe(String nomApe) {
		return personaDao.getPersonaByNomApe(nomApe);
	}

}
