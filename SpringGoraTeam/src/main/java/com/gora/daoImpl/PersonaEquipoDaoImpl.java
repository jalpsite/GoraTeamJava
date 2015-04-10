package com.gora.daoImpl;




import com.gora.dao.PersonaEquipoDao;
import com.gora.dominio.PersonaEquipo;





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
public class PersonaEquipoDaoImpl extends GenericDaoImpl<PersonaEquipo> implements PersonaEquipoDao {

	protected PersonaEquipoDaoImpl() {
		super(PersonaEquipo.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int quitarPersonaEquipo(Long idProyecto, Long idPersona) {
		Query query=getCurrentSession().createSQLQuery("delete from persona_equipo where idpersona=:idPer and idequipo=(select idequipo from equipo where idproyecto=:idPro)");
		query.setParameter("idPro", idProyecto);
		query.setParameter("idPer", idPersona);
		return query.executeUpdate();		
	}

	@Override
	public int cambiarRol(Long idProyecto, Long idPersona, Long idEquipoRol) {
		Query query=getCurrentSession().createSQLQuery("update persona_equipo set idequiporol=:idRol where idpersona=:idPer and idequipo=(select idequipo from equipo where idproyecto=:idPro)");		
		query.setParameter("idRol", idEquipoRol);
		query.setParameter("idPro", idProyecto);
		query.setParameter("idPer", idPersona);		
		return query.executeUpdate();
	}
	

}

