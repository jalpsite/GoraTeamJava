package com.gora.daoImpl;

import java.util.List;

import com.gora.dao.HabilidadDao;
import com.gora.dominio.Atributo;
import com.gora.dominio.Habilidad;
import com.gora.dominio.Habilidades;

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
public class HabilidadDaoImpl extends GenericDaoImpl<Habilidad> implements HabilidadDao {

	protected HabilidadDaoImpl() {
		super(Habilidad.class);
		// TODO Auto-generated constructor stub
	}		

    @SuppressWarnings("unchecked")
	@Override
	public List<Atributo> getAtributos(Long id) {
		Query query=getCurrentSession().createQuery("select a.idatributo, a.descripcion from Atributo a where a.habilidades.idhabilidades= :id");
		query.setParameter("id", id);		
    	
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
    	List<Habilidades> listaHabilidades=null;
    	//Lista de IDs de habilidades por competencia que tiene la persona
    	Query q=getCurrentSession().createQuery("Select distinct a.habilidades.idhabilidades from Habilidad a where a.persona.idpersona= :id and a.matriz.competencia.idcompetencia=:comp and upper(a.matriz.estado)='A'");    	
    	q.setParameter("comp", idCompetencia);
    	q.setParameter("id", idPersona);     	
    	List<Long> listaHabilidadesPersona=(List<Long>)q.list();    	
    	if(listaHabilidadesPersona.size()>0){
    		//Lista de todas las habilidades por competencia
        	Query qu=getCurrentSession().createQuery("Select distinct a.idhabilidades from Habilidades a where a.competencia.idcompetencia=:comp");    	
        	qu.setParameter("comp", idCompetencia);    	    	
        	List<Long> listaHabilidadesAll=(List<Long>)qu.list(); 
        	//Filtrado
        	int cantidad=listaHabilidadesAll.size();
        	
        	for(Long i:listaHabilidadesPersona){
        		for(int j=0;j<cantidad;j++){
        			if(i==listaHabilidadesAll.get(j)){
        				listaHabilidadesAll.remove(j);
        				cantidad--;
        				break;
        			}
        		}
        	}    	   
        	if(listaHabilidadesAll.size()>0){
        		Query query=getCurrentSession().createQuery("Select distinct a.idhabilidades, a.descripcion from Habilidades a where idhabilidades in("+concatenador(listaHabilidadesAll)+")");
        		listaHabilidades=query.list();
        	}        	
    		
    	}    	
		
		return listaHabilidades;   	    
	}
    
	@Override
	public boolean eliminarXMatriz(Long idMatriz) {
		Query query=getCurrentSession().createQuery("delete from Habilidad a where a.matriz.idmatriz=:id");
		query.setParameter("id",idMatriz);
		try {
			query.executeUpdate();
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Habilidad> getHabilidadXMatriz(Long idMatriz) {
		Query query=getCurrentSession().createQuery("select a from Habilidad a where a.matriz.idmatriz=:id");
		query.setParameter("id",idMatriz);
		return query.list();
	}

	@Override
	public boolean eliminar(Long idHabilidad) {
		Query query=getCurrentSession().createQuery("delete from Habilidad a where a.idhabilidad=:id");
		query.setParameter("id",idHabilidad);
		try {
			query.executeUpdate();
		} catch (Exception e) {
			return false;
		}
		return true;
	}
        
}

