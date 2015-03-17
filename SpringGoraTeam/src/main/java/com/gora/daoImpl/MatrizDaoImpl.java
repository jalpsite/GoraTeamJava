package com.gora.daoImpl;

import java.util.List;

import com.gora.dao.MatrizDao;
import com.gora.dominio.Competencia;
import com.gora.dominio.Matriz;

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
public class MatrizDaoImpl extends GenericDaoImpl<Matriz> implements MatrizDao {
	  	   
	protected MatrizDaoImpl() {
		super(Matriz.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean deshabilitarMatriz(Long idMatriz) {
		Query query=getCurrentSession().createQuery("update Matriz a set a.estado='D' where a.idmatriz=:id");
		query.setParameter("id", idMatriz);		
		int x=query.executeUpdate();			
		if(x>0)
			return true;
		else
			return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Matriz> getMatricesXPersona(Long idPersona) {
		Query query=getCurrentSession().createQuery("SELECT m FROM Matriz m where m.persona.idpersona=:id and m.estado='A'");
		query.setParameter("id", idPersona);
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Matriz getMatrizXPersona(Long idComp, Long idPersona) {
		Query query=getCurrentSession().createQuery("Select a from Matriz a where a.persona.idpersona=:idPer and a.competencia.idcompetencia=:idComp and upper(a.estado)='A'");
		query.setParameter("idComp", idComp);
		query.setParameter("idPer", idPersona);
		List<Matriz> lst=query.list();
		Matriz m=null;
		if(lst.size()>0){
			m=lst.get(0);
		}
		return m;	
	}
		

}

