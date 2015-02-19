package com.gora.servicesImpl;

import com.gora.dao.RolDao;
import com.gora.dominio.Rol;
import com.gora.services.RolService;

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
public class RolServiceImpl implements RolService {

    @Inject
    private RolDao rolDao;

	@Override
	public void save(Rol rol) {
		rolDao.save(rol);		
	}

	@Override
	public void update(Rol rol) {
		rolDao.update(rol);	
	}

	@Override
	public Rol findById(Long id) {
		return rolDao.findById(id);
	}

	@Override
	public List<Rol> findAll() {
		return rolDao.findAll();
	}

    

}
