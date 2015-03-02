package com.gora.dao;

import java.util.List;
import com.gora.dominio.Usuario;
import com.gora.dominio.UsuarioRol;

/**
 * Created by IntelliJ IDEA.
 * Author : Jose Alpiste  .
 * Date : 3/12/14 ,
 * Time : 6:32 PM
 * com.gora.dominio
 */

public interface UsuarioDao extends GenericDao<Usuario> {
	public Object login(String correo,String dni);	
	public List<UsuarioRol> rolesUsuario(Long idUsuario);
	public int validarUsuario(String usuario);
	public Usuario buscarXPersona(Long id);
	public int cambiarContrase�a(Long idUsuario, String oldPass, String newPass);
	public Usuario getUsuario(String correo);
	public int enviaTokenContrase�a(Usuario us);
	public boolean verificarToken(Long idUsuario,String token);
	public int resetContrase�a(Long idUsuario,String token, String newpass);
	
}
