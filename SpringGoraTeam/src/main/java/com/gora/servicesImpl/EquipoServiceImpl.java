package com.gora.servicesImpl;

import com.gora.dao.EquipoDao;
import com.gora.dominio.Equipo;
import com.gora.dominio.Persona;
import com.gora.services.EquipoService;

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
public class EquipoServiceImpl implements EquipoService {

    @Inject
    private EquipoDao equipoDao;

    @Override
    public void save(Equipo equipo) {
    	equipoDao.save(equipo);
    }

    @Override
    public void update(Equipo equipo) {
    	equipoDao.update(equipo);
    }

    @Override
    public List<Equipo> findAll() {
        List<Equipo> tmp = equipoDao.findAll();        
        return tmp;
    }

    @Override
    public Equipo findById(Long id) {
    	Equipo tmp = equipoDao.findById(id);        
        return tmp;
    }

	@Override
	public List<Persona> getPersonasEquipo(Long idEquipo) {
		return equipoDao.getPersonasEquipo(idEquipo);
	}

}
