package com.gora.daoImpl;


import java.util.List;

import com.gora.dao.EquipoRolDao;
import com.gora.dominio.EquipoRol;
import com.gora.dominio.Persona;

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
public class EquipoRolDaoImpl extends GenericDaoImpl<EquipoRol> implements EquipoRolDao {

	protected EquipoRolDaoImpl() {
		super(EquipoRol.class);
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EquipoRol> equipoRolesXProyecto(Long idProyecto) {
		Query query=getCurrentSession().createSQLQuery("select * from equipo_rol where idproyecto=:id");
		query.setParameter("id", idProyecto);
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Persona> getPersonasEquipoRol(Long idEquipoRol) {
		Query query=getCurrentSession().createSQLQuery("select p.* from persona p "+ 
														"inner join persona_equipo pe on p.idpersona=pe.idpersona "+ 
														"inner join equipo_rol er on pe.idequiporol=er.idequiporol "+
														"where er.idequiporol=:id");
		query.setParameter("id", idEquipoRol);		
		return query.list();
	}

	@Override
	public int eliminarEquipoRol(Long idEquipoRol) {
		Query query=getCurrentSession().createSQLQuery("delete from equipo_rol where idequiporol=:id");
		query.setParameter("id", idEquipoRol);
		return query.executeUpdate();
	}
	

}

