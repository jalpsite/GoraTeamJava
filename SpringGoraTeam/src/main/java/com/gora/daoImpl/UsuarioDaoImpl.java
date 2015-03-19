package com.gora.daoImpl;

import java.util.Date;
import java.util.List;

import com.gora.dao.UsuarioDao;
import com.gora.dominio.Usuario;
import com.gora.dominio.UsuarioRol;
import com.gora.util.Correo;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

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

	@SuppressWarnings("unchecked")
	@Override
	public Usuario getUsuario(String correo) {
		Query query=getCurrentSession().createQuery("select a from Usuario a where upper(a.usuario)=:us");
		query.setParameter("us",correo);
		Usuario us=null;
		List<Usuario> lst=query.list();
		if(lst.size()>0)
			us=lst.get(0);
		return us;
	}

	@Override
	public int enviaTokenContraseña(Usuario us) {
		int res=0;
		String token = UUID.randomUUID().toString();				
		Query query=getCurrentSession().createQuery("update Usuario a set a.token=:token, a.fechatoken=:fecha where a.id=:id");
		query.setParameter("id",us.getId());
		query.setParameter("token",token);
		query.setParameter("fecha",new Date());
		int x=query.executeUpdate();
		if(x>0){			
			Correo obj=new Correo(us.getUsuario(),"Reestablecer Contraseña");	
			obj.enviarCorreo(token,"Usuario",us.getId().toString());	
			res=1;
		}
		return res;
	}

	@Override
	public int resetContraseña(Long idUsuario, String token, String newpass) {	
		int res=0;
		Query query1=getCurrentSession().createQuery("select a from Usuario a where a.id=:id and a.token=:token and (current_date-a.fechatoken)<1");
		query1.setParameter("id",idUsuario);
		query1.setParameter("token",token);		
		if(query1.list().size()>0){
			Query query2=getCurrentSession().createQuery("update Usuario a set a.pass=:newpass, a.token=:token, a.fechatoken=:fecha where a.id=:id");
			query2.setParameter("newpass",newpass);
			query2.setParameter("token",null);
			query2.setParameter("fecha",null);
			query2.setParameter("id",idUsuario);
			if(query2.executeUpdate()>0){
				res=1;
			}
		}
		return res;
		
		
	}

	@Override
	public boolean verificarToken(Long idUsuario, String token) {
		Query query=getCurrentSession().createQuery("select a from Usuario a where a.id=:id and a.token=:token and (current_date-a.fechatoken)<1");
		query.setParameter("id",idUsuario);
		query.setParameter("token",token);		
		if(query.list().size()>0){
			return true;
		}else{
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Usuario getUsuarioXPersona(Long idPersona) {
		Query query=getCurrentSession().createQuery("select a.usuario from Persona a where a.idpersona=:id");
		query.setParameter("id", idPersona);
		List<Usuario> lst=query.list();
		Usuario u=null;
		if(lst.size()>0)
			u=lst.get(0);
		return u;
	}

}

