package com.gora.daoImpl;

import java.util.List;

import com.gora.dao.UsuarioDao;
import com.gora.dominio.Rol;
import com.gora.dominio.Usuario;
import com.gora.dominio.UsuarioRol;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

	@Autowired
    private SessionFactory sessionFactory;
 
    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
    
	protected UsuarioDaoImpl() {
		super(Usuario.class);
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object login(String correo,String dni) {		
		Query query=getCurrentSession().createQuery("Select a.idpersona, a.sexo, a.apemat, a.apepat, a.nombres, a.perfil from Persona a where a.usuario.pass= :dni and upper(a.usuario.usuario)=:ema and a.usuario.estado='A'");
		//Query query=getCurrentSession().createQuery("Select a from Persona a where a.usuario.id=1");
		//Query query=getCurrentSession().createQuery("Select a from Usuario a where a.pass= :dni and upper(a.usuario)=:ema and a.estado='A'");
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
		Query query=sessionFactory.getCurrentSession().createQuery("select a from UsuarioRol a where a.usuario.id=:id");
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

	@Override
	public Usuario buscarXPersona(Long id) {	
		Usuario us=null;
		Query query=sessionFactory.getCurrentSession().createQuery("select a.usuario from Persona a where a.idpersona=:id");
		query.setParameter("id", id);
		List<Usuario> lst=query.list();
		if(lst.size()>0){
			us=lst.get(0);
		}
		return us;
	}

}

