package com.gora.daoImpl;
import java.util.ArrayList;

import java.util.List;
import com.gora.dao.PersonaDao;
import com.gora.dominio.Atributo;
import com.gora.dominio.Competencia;
import com.gora.dominio.Habilidades;
import com.gora.dominio.Persona;
import com.gora.dominio.PersonaDireccion;
import com.gora.dominio.PersonaEmail;
import com.gora.dominio.PersonaTelefono;


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
public class PersonaDaoImpl extends GenericDaoImpl<Persona> implements PersonaDao 
{			
	protected PersonaDaoImpl() {
		super(Persona.class);
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public void agregarDireccion(PersonaDireccion perDir) {
		getCurrentSession().save(perDir);	
	}

	@Override
	public void agregarEmail(PersonaEmail perEmail) {
		getCurrentSession().save(perEmail);				
	}

	@Override
	public void agregarTelefono(PersonaTelefono perTelf) {
		getCurrentSession().save(perTelf);				
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PersonaDireccion> getDireccion(Long id) {
		Query query=getCurrentSession().createQuery("Select a from PersonaDireccion a where a.persona.idpersona= :id and a.estado='A'");
		query.setParameter("id", id);
		return  query.list();	
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PersonaEmail> getEmail(Long id) {
		Query query=getCurrentSession().createQuery("Select a from PersonaEmail a where a.persona.idpersona= :id and a.estado='A'");
		query.setParameter("id", id);
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PersonaTelefono> getTelefono(Long id) {
		Query query=getCurrentSession().createQuery("Select a from PersonaTelefono a where a.persona.idpersona= :id and a.estado='A'");
		query.setParameter("id", id);
		return query.list();
	}

	@Override
	public void actualizarDireccion(PersonaDireccion perDir) {
		getCurrentSession().saveOrUpdate(perDir);	
	}

	@Override
	public void actualizarEmail(PersonaEmail perEmail) {
		getCurrentSession().saveOrUpdate(perEmail);	
		
	}
	@Override
	public void actualizarTelefono(PersonaTelefono perTelf) {
		getCurrentSession().saveOrUpdate(perTelf);			
	}	
	
	@Override
	public Persona updateDatos(int opcion, Persona per) {
		Query query=null;
		switch(opcion){		
		case 1: //Actualizar nombres y apellidos
			query=getCurrentSession().createQuery("update Persona a set a.apepat=:apepat, a.apemat=:apemat, a. nombres=:nom where a.idpersona=:id");
			query.setParameter("apepat", per.getApepat().toUpperCase());
			query.setParameter("apemat", per.getApemat().toUpperCase());
			query.setParameter("nom", per.getNombres().toUpperCase());			
			break;
		case 2: // Actualizar Estado Civil
			query=getCurrentSession().createQuery("update Persona a set a.estadocivil=:est_civil where a.idpersona=:id");
			query.setParameter("est_civil", per.getEstadocivil().toUpperCase());			
			break;
		
		case 3: // Actualizar Fecha Nacimiento
			query=getCurrentSession().createQuery("update Persona a set a.fechanacimiento=:fecha where a.idpersona=:id");
			query.setParameter("fecha", per.getFechanacimiento());
			break;
			
		case 4: // Actualizar Nacionalidad
			query=getCurrentSession().createQuery("update Persona a set a.nacionalidad=:pais where a.idpersona=:id");
			query.setParameter("pais", per.getNacionalidad().toUpperCase());
			break;
		
		case 5: // Actualizar Tipo documento y numero de documento
			query=getCurrentSession().createQuery("update Persona a set a.tipodocidentidad=:tipo, a.numerodocidentidad=:num where a.idpersona=:id");
			query.setParameter("tipo", per.getTipodocidentidad().toUpperCase());
			query.setParameter("num", per.getNumerodocidentidad());
			break;
			
		case 6: // Actualizar Sexo
			query=getCurrentSession().createQuery("update Persona a set a.sexo=:sexo where a.idpersona=:id");
			query.setParameter("sexo", per.getSexo().toUpperCase());			
			break;
			
		case 7: // Actualizar presentacion
			query=getCurrentSession().createQuery("update Persona a set a.presentacion=:pres where a.idpersona=:id");
			query.setParameter("pres", per.getPresentacion());			
			break;
		}
		
		query.setParameter("id", per.getIdpersona());
		if(query.executeUpdate()>0)			
			return per;
		else
			return null;
	}	

	@Override
	public Long getIDJefe(Long idPersona) {
		Query query=getCurrentSession().createQuery("Select a.persona.idpersona from Persona a where a.idpersona=:idPer");
		query.setParameter("idPer", idPersona);
		Long g=(Long)query.uniqueResult();
		if(g!=null){			
			System.out.println(g);
			return g;
		}else{
			return Long.parseLong("0");
		}				
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Competencia> getCompetencias(Long id) {
		Query query=getCurrentSession().createQuery("Select a.idmatriz, a.competencia.idcompetencia, a.competencia.descripcion from Matriz a where a.persona.idpersona=:id and upper(a.estado)='A' order by a.competencia.descripcion");		
		query.setParameter("id", id);
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Habilidades> getHabilidades(Long id) {
		Query query=getCurrentSession().createQuery("Select a.habilidades.idhabilidades, a.habilidades.descripcion from Habilidad a where a.persona.idpersona=:id and upper(a.matriz.estado)='A' order by a.habilidades.descripcion");		
		query.setParameter("id", id);
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Atributo> getAtributos(Long id) {
		Query query=getCurrentSession().createQuery("Select a.atributo.idatributo, a.atributo.descripcion from Atributos a where a.habilidad.persona.idpersona=:id and upper(a.habilidad.matriz.estado)='A' order by a.atributo.descripcion");		
		query.setParameter("id", id);
		return query.list();
	}

	@Override
	public int validarDNI(String doc) {
		Query query=getCurrentSession().createQuery("Select a from PersonaDatos a where a.numerodocidentidad=:doc");
		query.setParameter("doc", doc);
		if(query.list().size()>0){
			return 1; //existe
		}else{
			return 0; //no existe
		}
	}
	

	@SuppressWarnings("unchecked")
	@Override
	public List<Habilidades> getHabilidadesXCompetencia(Long idPersona, Long idCompetencia) {
		Query query=getCurrentSession().createQuery("Select a.idhabilidad, a.habilidades.idhabilidades, a.habilidades.descripcion from Habilidad a where a.persona.idpersona=:id and a.matriz.competencia.idcompetencia=:comp and upper(a.matriz.estado)='A' order by a.habilidades.descripcion");
		
		query.setParameter("id", idPersona);
		query.setParameter("comp", idCompetencia);
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Atributo> getAtributosXHabilidad(Long idPersona, Long idCompetencia, Long idHabilidad) {
		Query query=getCurrentSession().createQuery("Select a.idatributos, a.atributo.idatributo, a.atributo.descripcion from Atributos a where a.habilidad.persona.idpersona=:id and a.habilidad.habilidades.idhabilidades=:hab and a.habilidad.matriz.competencia.idcompetencia=:comp and upper(a.habilidad.matriz.estado)='A'");
		query.setParameter("id", idPersona);
		query.setParameter("hab", idHabilidad);
		query.setParameter("comp", idCompetencia);
		return query.list();
	}

	@Override
	public void estadoDireccion(Long idDireccion, String estado) {		
		Query query=getCurrentSession().createQuery("update PersonaDireccion a set a.estado=:estado where a.idpersonadireccion=:id");
		query.setParameter("estado", estado);
		query.setParameter("id", idDireccion);
		query.executeUpdate();
	}

	@Override
	public void estadoEmail(Long idEmail, String estado) {
		Query query=getCurrentSession().createQuery("update PersonaEmail a set a.estado=:estado where a.idpersonaemail=:id");
		query.setParameter("estado", estado);
		query.setParameter("id", idEmail);
		query.executeUpdate();
	}

	@Override
	public void estadoTelefono(Long idTelefono, String estado) {
		Query query=getCurrentSession().createQuery("update PersonaTelefono a set a.estado=:estado where a.idpersonatelefono=:id");
		query.setParameter("estado", estado);
		query.setParameter("id", idTelefono);
		query.executeUpdate();
	}

	/*	
	@SuppressWarnings("unchecked")
	@Override
	public List<Persona> filtroPersonas(String[] lstCompetencias,String[] lstHabilidades, String[] lstAtributos, int pagina) {
		int cantidad=10;		
		List<Persona> listaPersonas=null;
		List<Long> idPersonas=consultaFiltro(lstCompetencias,lstHabilidades,lstAtributos);
		if(idPersonas.size()>0){
			Query query2=getCurrentSession().createQuery("select a from Persona a where a.idpersona in("+concatenadorLista(idPersonas)+")");
			query2.setFirstResult((pagina-1)*cantidad).setMaxResults(cantidad);
			listaPersonas= query2.list();
			
			if(cantidad>0){	    	
		    	int division=idPersonas.size()/cantidad;	    	    
		    	Persona p=new Persona();
		    	if(idPersonas.size()%10>0){
		    		division++;
		    	}
		    	p.setCodigo(division+"");
		    	p.setNumerodocidentidad(idPersonas.size()+"");
		    	listaPersonas.add(p);
		    }			
		}	
		
		return listaPersonas;
	}
		
	@SuppressWarnings("unchecked")
	private List<Long> consultaFiltro(String[] lstCompetencias,String[] lstHabilidades, String[] lstAtributos){
		String consulta="";
		int contador=0;
		if(lstCompetencias.length==0 && lstHabilidades.length==0 && lstAtributos.length==0){
			consulta="select a.idpersona from Persona a";
		}else{
			consulta="select a.habilidad.persona.idpersona from Atributos a where ";
			String subconsulta="";
			
			if(lstCompetencias.length!=0){
				if(contador>0)
					subconsulta="or "+subconsulta;
				subconsulta="a.habilidad.matriz.competencia.idcompetencia in("+concatenador(lstCompetencias)+")";												
				contador++;
			}						

			if(lstHabilidades.length!=0){
				if(contador>0)
					subconsulta="or "+subconsulta;
				subconsulta="a.habilidad.habilidades.idhabilidades in("+concatenador(lstHabilidades)+")";								
				contador++;
			}
			
			if(lstAtributos.length!=0){	
				if(contador>0)
					subconsulta="or "+subconsulta;
				subconsulta="a.atributo.descripcion in("+concatenadorCaracter(lstAtributos)+")";								
				contador++;
			}
			consulta+=subconsulta;			
		}		
		Query query=getCurrentSession().createQuery(consulta);		
		return query.list();
	}
	*/
	
	private String concatenadorLista(List<Long> arr){		
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
	/*
	private String concatenador(String[] arr){		
		String res="";
		for(int i=0;i<arr.length;i++){
			if(i==arr.length-1){
				res+=(arr[i]);				
			}else{
				res+=(arr[i]+",");
			}			
		}			
		return res;
	}	
	
	private String concatenadorCaracter(String[] arr){		
		String res="";
		for(int i=0;i<arr.length;i++){
			if(i==arr.length-1){
				res+="'"+(arr[i])+"'";				
			}else{
				res+=("'"+arr[i]+"',");
			}			
		}			
		return res;
	}
*/

	@SuppressWarnings("unchecked")
	@Override
	public List<Persona> getPersonaXRol(String busqueda, String rol) {
		Query idUs=getCurrentSession().createQuery("select a.usuario.id from UsuarioRol a where upper(a.rol.nomrol)=:rol");
		idUs.setParameter("rol", rol.toUpperCase());
		List<Long> ids=idUs.list();
		List<Persona> lst=new ArrayList<Persona>();
		if(ids.size()>0){
			Query query=getCurrentSession().createQuery("select p from Persona p where p.usuario.id in("+concatenadorLista(ids)+") and (upper(p.apepat) like :cad or upper(p.apemat) like :cad or upper(p.nombres) like:cad)");
			query.setParameter("cad", "%"+busqueda.toUpperCase()+"%");
			lst=query.list();
		}
		return lst;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Persona getPersona(Long id) {
		Query query=getCurrentSession().createQuery("select a from Persona a where a.idpersona=:id");
		query.setParameter("id", id);
		List<Persona> lst=query.list();
		Persona p=null;
		if(lst.size()>0){
			p=lst.get(0);
		}
		return p;				
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object filtroPersonas(String competencias, String habilidades, String atributos) {		
		List<Object> listaPersonas=null;						
		
		String consulta="select distinct p.idpersona, p.apepat, p.apemat, p.nombres,ha.idhabilidades,ha.descripcion as habilidades,ot.idatributo,ot.descripcion as atributo,t.certificado, c.idcompetencia from persona p "		
		+"inner join matriz m on m.idpersona=p.idpersona "
		+"inner join competencia c on c.idcompetencia=m.idcompetencia "
		+"inner join habilidad h on h.idmatriz=m.idmatriz "
		+"inner join habilidades ha on ha.idhabilidades=h.idhabilidades "
		+"inner join atributos t on t.idhabilidad=h.idhabilidad "
		+"inner join atributo ot on ot.idatributo=t.idatributo "	
		+"where m.estado='A' ";
		

			if(!competencias.isEmpty()){				
				consulta+="and c.idcompetencia="+competencias+" ";																
			}						

			if(!habilidades.isEmpty()){				
				consulta+="and ha.idhabilidades="+habilidades+" ";												
			}
			
			if(!atributos.isEmpty()){				
				consulta+="and ot.idatributo="+atributos+" ";												
			}	
			consulta+=" order by p.idpersona";
			
		Query query=getCurrentSession().createSQLQuery(consulta);				
		listaPersonas= query.list();							
								
		return listaPersonas;
	}


	@Override
	public void eliminarDireccion(Long idDireccion) {
		Query query=getCurrentSession().createSQLQuery("delete from persona_direccion where idpersonadireccion=:id");
		query.setParameter("id", idDireccion);
		query.executeUpdate();
	}


	@Override
	public void eliminarEmail(Long idEmail) {
		Query query=getCurrentSession().createSQLQuery("delete from persona_email where idpersonaemail=:id");
		query.setParameter("id", idEmail);
		query.executeUpdate();
	}


	@Override
	public void eliminarTelefono(Long idTelefono) {
		Query query=getCurrentSession().createSQLQuery("delete from persona_telefono where idpersonatelefono=:id");
		query.setParameter("id", idTelefono);
		query.executeUpdate();
	}


	@Override
	public void actualizarJefe(Long idPersona, Long idJefe) {
		Query query=getCurrentSession().createSQLQuery("update persona set idpermanager=:idjefe where idpersona=:idpersona");
		query.setParameter("idjefe", idJefe);
		query.setParameter("idpersona", idPersona);
		query.executeUpdate();		
	}


	
	
	
}

