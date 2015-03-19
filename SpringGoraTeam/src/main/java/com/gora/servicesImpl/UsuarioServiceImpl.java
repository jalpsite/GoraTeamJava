package com.gora.servicesImpl;

import com.gora.dao.UsuarioDao;
import com.gora.dominio.Usuario;
import com.gora.dominio.UsuarioRol;
import com.gora.services.UsuarioService;

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
public class UsuarioServiceImpl implements UsuarioService {

    @Inject
    private UsuarioDao usuarioDao;

	@Override
	public void save(Usuario us) {		
		usuarioDao.save(us);
	}

	@Override
	public void update(Usuario us) {
		usuarioDao.update(us);
	}

	@Override
	public Usuario findById(Long id) {
		return usuarioDao.findById(id);
	}

	@Override
	public List<Usuario> findAll() {
		return usuarioDao.findAll();
	}

	@Override
	public Object login(String correo, String dni) {
		return usuarioDao.login(correo, dni);
	}

	@Override
	public List<UsuarioRol> rolesUsuario(Long idUsuario) {
		return usuarioDao.rolesUsuario(idUsuario);
	}

	@Override
	public int validarUsuario(String usuario) {
		return usuarioDao.validarUsuario(usuario);
	}

	@Override
	public Usuario buscarXPersona(Long id) {
		return usuarioDao.buscarXPersona(id);
	}

	@Override
	public int cambiarContrase�a(Long idUsuario, String oldPass, String newPass) {
		return usuarioDao.cambiarContrase�a(idUsuario, oldPass, newPass);
	}

	@Override
	public Usuario getUsuario(String correo) {
		return usuarioDao.getUsuario(correo);
	}

	@Override
	public int enviaTokenContrase�a(Usuario us) {
		return usuarioDao.enviaTokenContrase�a(us);
	}

	@Override
	public int resetContrase�a(Long idUsuario, String token, String newpass) {
		return usuarioDao.resetContrase�a(idUsuario, token, newpass);
	}

	@Override
	public boolean verificarToken(Long idUsuario, String token) {
		return usuarioDao.verificarToken(idUsuario, token);
	}

	@Override
	public Usuario getUsuarioXPersona(Long idPersona) {
		return usuarioDao.getUsuarioXPersona(idPersona);
	}
    

}