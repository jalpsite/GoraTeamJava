package com.gora.daoImpl;

import java.util.List;

import com.gora.dao.UsuarioDao;
import com.gora.dominio.Usuario;
import com.gora.dominio.UsuarioRol;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by IntelliJ IDEA.
 * Author : Jose Alpiste  .
 * Date : 3/12/14 ,
 * Time : 6:32 PM
 * com.gora.dominio
 */

@Repository
public class UsuarioDaoImpl extends GenericDaoImpl<Usuario> implements UsuarioDao {
	   
	protected UsuarioDaoImpl() {
		super(Usuario.class);
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object login(String correo,String dni) {		
		Query query=getCurrentSession().createQuery("Select a.idpersona, a.sexo, a.apemat, a.apepat, a.nombres, a.perfil, a.usuario.id from Persona a where a.usuario.pass= :dni and upper(a.usuario.usuario)=:ema and a.usuario.estado='A'");
		
		query.setParameter("dni", dni);
		query.setParameter("ema", correo.toUpperCase());
		Object per=null;
		List<Object> lst=query.list();
		if(lst.size()>0){
			per=lst.get(0);
		}		
		return per;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UsuarioRol> rolesUsuario(Long idUsuario) {
		Query query=getCurrentSession().createQuery("select a from UsuarioRol a where a.usuario.id=:id");
		query.setParameter("id", idUsuario);
		return query.list();
	}
	
	@Override
	public int validarUsuario(String usuario) {
		Query query=getCurrentSession().createQuery("Select a from Usuario a where a.usuario=:us");
		query.setParameter("us", usuario);
		if(query.list().size()>0){
			return 1; //existe
		}else{
			return 0; //no existe
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Usuario buscarXPersona(Long id) {	
		Usuario us=null;
		Query query=getCurrentSession().createQuery("select a.usuario from Persona a where a.idpersona=:id");
		query.setParameter("id", id);
		List<Usuario> lst=query.list();
		if(lst.size()>0){
			us=lst.get(0);
		}
		return us;
	}

	@Override
	public int cambiarContraseña(Long idUsuario, String oldPass, String newPass) {		
		Query query=getCurrentSession().createQuery("update Usuario a set a.pass=:newPass where a.id=:id and a.pass=:oldPass");
		query.setParameter("id", idUsuario);
		query.setParameter("newPass", newPass);
		query.setParameter("oldPass", oldPass);
		return query.executeUpdate();					
	}

}

