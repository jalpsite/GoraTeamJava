package com.gora.servicesImpl;


import com.gora.dao.EquipoRolDao;
import com.gora.dominio.EquipoRol;
import com.gora.dominio.Persona;
import com.gora.services.EquipoRolService;





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
public class EquipoRolServiceImpl implements EquipoRolService {

    @Inject
    private EquipoRolDao equipoRolDao;

	@Override
	public void save(EquipoRol equiporol) {
		equipoRolDao.save(equiporol);
	}

	@Override
	public void update(EquipoRol equiporol) {
		equipoRolDao.update(equiporol);
	}

	@Override
	public EquipoRol findById(Long id) {
		return equipoRolDao.findById(id);
	}

	@Override
	public List<EquipoRol> findAll() {
		return equipoRolDao.findAll();
	}

	@Override
	public List<EquipoRol> equipoRolesXProyecto(Long idProyecto) {
		return equipoRolDao.equipoRolesXProyecto(idProyecto);
	}

	@Override
	public List<Persona> getPersonasEquipoRol(Long idEquipoRol) {
		return equipoRolDao.getPersonasEquipoRol(idEquipoRol);
	}

	@Override
	public int eliminarEquipoRol(Long idEquipoRol) {
		return equipoRolDao.eliminarEquipoRol(idEquipoRol);
	}

    
}
