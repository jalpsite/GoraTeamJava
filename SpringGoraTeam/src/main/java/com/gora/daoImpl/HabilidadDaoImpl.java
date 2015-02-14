package com.gora.daoImpl;

import java.util.List;

import com.gora.dao.HabilidadDao;
import com.gora.dominio.Atributo;
import com.gora.dominio.Competencia;
import com.gora.dominio.Habilidad;
import com.gora.dominio.Habilidades;

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
public class HabilidadDaoImpl extends GenericDaoImpl<Habilidad> implements HabilidadDao {

	protected HabilidadDaoImpl() {
		super(Habilidad.class);
		// TODO Auto-generated constructor stub
	}	
	@Autowired
    private SessionFactory sessionFactory;
 
    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @SuppressWarnings("unchecked")
	@Override
	public List<Atributo> getAtributos(Long id) {
		Query query=getCurrentSession().createQuery("select a.idatributo, a.descripcion from Atributo a where a.habilidades.idhabilidades= :id");
		query.setParameter("id", id);		
    	
		return query.list();
	}

    @SuppressWarnings("unchecked")
	@Override
	public List<Atributo> getAtributosExtracto(Long idPersona, Long idHabilidad) {
    	Query q=getCurrentSession().createQuery("select distinct a.atributo.idatributo from Atributos a where a.atributo.habilidades.idhabilidades= :id and a.habilidad.persona.idpersona=:per");
    	q.setParameter("id", idHabilidad);
    	q.setParameter("per", idPersona);
    	List<Long> listaAtributosPersona=(List<Long>)q.list();    	
		Query query=getCurrentSession().createQuery("select a.idatributo, a.descripcion from Atributo a where a.habilidades.idhabilidades= :id and a.idatributo not in("+concatenador(listaAtributosPersona)+")");
		query.setParameter("id", idHabilidad);
		return query.list();
	}
    
    private String concatenador(List<Long> arr){		
		String res="";
		for(int i=0;i<arr.size();i++){
			if(i==arr.size()-1){
				res+=(arr.get(i));				
			}else{
				res+=(arr.get(i)+",");
			}				
		}			
		return res;
	}
    
    
    @SuppressWarnings("unchecked")
	@Override
	public List<Habilidades> getHabilidadesExtracto(Long idPersona, Long idCompetencia) {
    	Query q=getCurrentSession().createQuery("Select distinct a.habilidades.idhabilidades from Habilidad a where a.persona.idpersona= :id and a.habilidades.competencia.idcompetencia=:comp and upper(a.matriz.estado)='A'");    	
    	q.setParameter("comp", idCompetencia);
    	q.setParameter("id", idPersona);    	
    	List<Long> listaHabilidadesPersona=(List<Long>)q.list();     	    
		Query query=getCurrentSession().createQuery("Select distinct a.habilidades.idhabilidades, a.habilidades.descripcion from Habilidad a where a.habilidades.competencia.idcompetencia=:comp and a.habilidades.idhabilidades not in("+concatenador(listaHabilidadesPersona)+")");
		query.setParameter("comp", idCompetencia);
		return query.list();    	    
	}

    @SuppressWarnings("unchecked")
	@Override
	public List<Competencia> getCompetenciasExtracto(Long idPersona) {
		Query q=getCurrentSession().createQuery("Select distinct a.competencia.idcompetencia from Matriz a where a.persona.idpersona= :id and upper(a.estado)='A'");    	    	
    	q.setParameter("id", idPersona);    	    	
    	List<Long> listaCompetenciasPersona=(List<Long>)q.list();     	    	
    	Query query=getCurrentSession().createQuery("Select distinct a.competencia.idcompetencia, a.competencia.descripcion from Matriz a where a.competencia.idcompetencia not in("+concatenador(listaCompetenciasPersona)+")");		
		return query.list();
	}

	@Override
	public boolean eliminarXMatriz(Long idMatriz) {
		Query query=sessionFactory.getCurrentSession().createQuery("delete from Habilidad a where a.idmatriz=:id");
		query.setParameter("id",idMatriz);
		try {
			query.executeUpdate();
		} catch (Exception e) {
			return false;
		}
		return true;
	}
        

}

