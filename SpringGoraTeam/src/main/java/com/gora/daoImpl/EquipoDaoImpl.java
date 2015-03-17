package com.gora.daoImpl;

import java.util.List;

import com.gora.dao.EquipoDao;
import com.gora.dominio.Equipo;
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
public class EquipoDaoImpl extends GenericDaoImpl<Equipo> implements EquipoDao {

	protected EquipoDaoImpl() {
		super(Equipo.class);
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Persona> getPersonasEquipo(Long idEquipo) {
		Query query=getCurrentSession().createQuery("select a.persona from PersonaEquipo a where a.equipo.idequipo=:id");					
		query.setParameter("id", idEquipo);
		return query.list();
	}

}

