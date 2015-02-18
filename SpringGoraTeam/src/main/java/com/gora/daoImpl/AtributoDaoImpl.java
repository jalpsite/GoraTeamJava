package com.gora.daoImpl;

import java.util.List;

import com.gora.dao.AtributoDao;
import com.gora.dominio.Atributo;

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
public class AtributoDaoImpl extends GenericDaoImpl<Atributo> implements AtributoDao {

	@Autowired
    private SessionFactory sessionFactory;
 
    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
    
	protected AtributoDaoImpl() {
		super(Atributo.class);
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Atributo> getAtributosExtracto(Long idPersona, Long idHabilidad) {
		List<Atributo> listaAtributos=null;
    	Query q=getCurrentSession().createQuery("select distinct a.atributo.idatributo from Atributos a where a.atributo.habilidades.idhabilidades= :id and a.habilidad.persona.idpersona=:per");
    	q.setParameter("id", idHabilidad);
    	q.setParameter("per", idPersona);
    	List<Long> listaAtributosPersona=(List<Long>)q.list();    
    	if(listaAtributosPersona.size()>0){
    		Query query=getCurrentSession().createQuery("select a.idatributo, a.descripcion from Atributo a where a.habilidades.idhabilidades= :id and a.idatributo not in("+concatenador(listaAtributosPersona)+")");
    		query.setParameter("id", idHabilidad);
    		listaAtributos=query.list();
    	}    			
		return listaAtributos;
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

