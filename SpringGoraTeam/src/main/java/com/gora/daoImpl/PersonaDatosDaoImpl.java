package com.gora.daoImpl;

import java.util.List;

import com.gora.dao.PersonaDatosDao;
import com.gora.dominio.Persona;
import com.gora.dominio.PersonaDatos;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by IntelliJ IDEA. Author : Jose Alpiste . Date : 3/12/14 , Time :
 * 6:32 PM com.gora.dominio
 */

@Repository
public class PersonaDatosDaoImpl extends GenericDaoImpl<PersonaDatos> implements
		PersonaDatosDao {

	    
	protected PersonaDatosDaoImpl() {
		super(PersonaDatos.class);
		// TODO Auto-generated constructor stub
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Persona> getPersonaByDNI(String dni) {
		Query query=getCurrentSession().createQuery("select p from Persona p where p.estado='A' and p.numerodocidentidad LIKE :dni");
		query.setParameter("dni", dni+"%");
		query.setMaxResults(20);
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Persona> getPersonaByNomApe(String nomApe) {
		Query query=getCurrentSession().createQuery("select p FROM Persona p where p.estado='A' and lower(p.nombres) LIKE lower(:nomApe) OR lower(p.apemat) LIKE lower(:nomApe) OR lower(p.apepat) LIKE lower(:nomApe)");
		//Query query=getCurrentSession().createQuery("select p FROM Persona p where p.estado='A' and lower(p.nombres || p.apepat|| p.apemat ) LIKE lower(:nomApe)");
		query.setParameter("nomApe", "%"+nomApe+"%");
		query.setMaxResults(20);
		return query.list();
	}

	@Override
	public Object getDatosPrincipales(Long idProyecto, Long idPersona) {
		Query query=getCurrentSession().createSQLQuery("select (select telefono from persona_telefono where idpersona=:id order by tipo desc limit 1) ,"
														+"(select email from persona_email where idpersona=:id order by tipo asc limit 1),"
															+"(select direccion from persona_direccion where idpersona=:id order by tipo asc limit 1),"
														+"(select er.descripcion as rol from persona_equipo pe inner join equipo_rol er on pe.idequiporol= er.idequiporol where er.idproyecto=:idP and pe.idpersona=:id);");
		query.setParameter("id", idPersona);		
		query.setParameter("idP", idProyecto);
		return query.list();
	}

}
