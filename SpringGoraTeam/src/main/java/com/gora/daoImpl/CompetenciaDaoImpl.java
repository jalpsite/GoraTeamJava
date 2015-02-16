package com.gora.daoImpl;

import java.util.List;

import com.gora.dao.CompetenciaDao;
import com.gora.dominio.Competencia;
import com.gora.dominio.Habilidad;

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
public class CompetenciaDaoImpl extends GenericDaoImpl<Competencia> implements CompetenciaDao {

	protected CompetenciaDaoImpl() {
		super(Competencia.class);
		// TODO Auto-generated constructor stub
	}

	@Autowired
    private SessionFactory sessionFactory;
 
    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
    
    @SuppressWarnings("unchecked")
	@Override
	public List<Habilidad> getHabilidades(Long id) {
		Query query=getCurrentSession().createQuery("select a.idhabilidades, a.descripcion from Habilidades a where a.competencia.idcompetencia= :id");
		query.setParameter("id", id);
		return query.list();
	}

    @SuppressWarnings("unchecked")
	@Override
	public List<Competencia> getCompetenciasExtracto(Long idPersona) {
		Query q=getCurrentSession().createQuery("Select distinct a.competencia.idcompetencia from Matriz a where a.persona.idpersona= :id and upper(a.estado)='A'");    	    	
    	q.setParameter("id", idPersona);    	    	
    	List<Long> listaCompetenciasPersona=(List<Long>)q.list();     	    	
    	Query query=getCurrentSession().createQuery("Select distinct a.idcompetencia, a.descripcion from Competencia a where a.idcompetencia not in("+concatenador(listaCompetenciasPersona)+")");		
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

}

