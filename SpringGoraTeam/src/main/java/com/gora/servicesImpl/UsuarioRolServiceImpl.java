package com.gora.servicesImpl;

import com.gora.dao.UsuarioRolDao;
import com.gora.dominio.UsuarioRol;
import com.gora.services.UsuarioRolService;

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
public class UsuarioRolServiceImpl implements UsuarioRolService {

    @Inject
    private UsuarioRolDao usuarioRolDao;

	@Override
	public void save(UsuarioRol us) {
		usuarioRolDao.save(us);
	}

	@Override
	public void update(UsuarioRol us) {
		usuarioRolDao.update(us);
	}

	@Override
	public UsuarioRol findById(Long id) {
		return usuarioRolDao.findById(id);
	}

	@Override
	public List<UsuarioRol> findAll() {
		return usuarioRolDao.findAll();
	}



}