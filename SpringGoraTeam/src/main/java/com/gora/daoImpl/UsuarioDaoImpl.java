package com.gora.daoImpl;

import java.util.List;

import com.gora.dao.UniversidadDao;
import com.gora.dao.UsuarioDao;
import com.gora.dominio.Universidad;
import com.gora.dominio.Usuario;

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
		//Query query=getCurrentSession().createQuery("Select a.persona.idpersona, a.persona.sexo, a.persona.apemat, a.persona.apepat, a.persona.nombres, a.persona.perfil from PersonaEmail a where a.persona.idusuario.pass= :dni and upper(a.persona.idusuario.usuario)=:ema and a.persona.idusuario.estado='A'");
		Query query=getCurrentSession().createQuery("Select a from Persona a where a.idusuario.id=1");
		//Query query=getCurrentSession().createQuery("Select a from Usuario a where a.pass= :dni and upper(a.usuario)=:ema and a.estado='A'");
		//query.setParameter("dni", dni);
		//query.setParameter("ema", correo.toUpperCase());
		Object per=null;
		List<Object> lst=query.list();
		if(lst.size()>0){
			per=lst.get(0);
		}		
		return per;
	}

}

