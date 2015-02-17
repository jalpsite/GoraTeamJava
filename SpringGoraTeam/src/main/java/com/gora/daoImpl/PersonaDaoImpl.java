package com.gora.daoImpl;
import java.math.BigDecimal;
import java.math.RoundingMode;
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
public class PersonaDaoImpl extends GenericDaoImpl<Persona> implements PersonaDao 
{
	public static int paginas;
	@Autowired
    private SessionFactory sessionFactory;
 
    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
	
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

	@SuppressWarnings("unchecked")
	@Override
	public Object login(String correo,String dni) {		
		Query query=getCurrentSession().createQuery("Select a.persona.idpersona, a.persona.sexo, a.persona.apemat, a.persona.apepat, a.persona.nombres, a.persona.perfil from PersonaEmail a where a.persona.numerodocidentidad= :dni and upper(a.email)=:ema and a.tipo='LABORAL'");
		query.setParameter("dni", dni);
		query.setParameter("ema", correo.toUpperCase());
		Object per=null;
		List<Object> lst=query.list();
		if(lst.size()>0){
			per=lst.get(0);
		}		
		return per;
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

	@SuppressWarnings("unchecked")
	@Override
	public List<Persona> filtroPersonas(String[] lstCompetencias,String[] lstHabilidades, String[] lstAtributos) {
		List<Persona> lstPersonas=null;
		String consulta="";
		int contador=0;
		if(lstCompetencias.length==0 && lstHabilidades.length==0 && lstAtributos.length==0){
			consulta="select a from Persona a";
		}else{
			consulta="select DISTINCT a.habilidad.persona from Atributos a where ";
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
				subconsulta="a.atributo.idatributo in("+concatenador(lstAtributos)+")";								
				contador++;
			}
			consulta+=subconsulta;
			
		}
		consulta+="";
		Query query=getCurrentSession().createQuery(consulta);
		query.setMaxResults(10);
		lstPersonas=query.list();			
		return lstPersonas;
	}
	
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
		Query query=getCurrentSession().createQuery("Select distinct a.idmatriz, a.competencia.idcompetencia, a.competencia.descripcion from Matriz a where a.persona.idpersona=:id and upper(a.estado)='A'");		
		query.setParameter("id", id);
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Habilidades> getHabilidades(Long id) {
		Query query=getCurrentSession().createQuery("Select distinct a.habilidades.idhabilidades, a.habilidades.descripcion from Habilidad a where a.persona.idpersona=:id and upper(a.matriz.estado)='A'");		
		query.setParameter("id", id);
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Atributo> getAtributos(Long id) {
		Query query=getCurrentSession().createQuery("Select distinct a.atributo.idatributo, a.atributo.descripcion from Atributos a where a.habilidad.persona.idpersona=:id and upper(a.habilidad.matriz.estado)='A'");		
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
		Query query=getCurrentSession().createQuery("Select distinct a.idhabilidad, a.habilidades.idhabilidades, a.habilidades.descripcion from Habilidad a where a.persona.idpersona=:id and a.matriz.competencia.idcompetencia=:comp and upper(a.matriz.estado)='A'");
		
		query.setParameter("id", idPersona);
		query.setParameter("comp", idCompetencia);
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Atributo> getAtributosXHabilidad(Long idPersona, Long idCompetencia, Long idHabilidad) {
		Query query=getCurrentSession().createQuery("Select distinct a.idatributos, a.atributo.idatributo, a.atributo.descripcion from Atributos a where a.habilidad.persona.idpersona=:id and a.habilidad.habilidades.idhabilidades=:hab and a.habilidad.matriz.competencia.idcompetencia=:comp and upper(a.habilidad.matriz.estado)='A'");
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

	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public List<Persona> filtroPersonas2(String[] lstCompetencias,String[] lstHabilidades, String[] lstAtributos, int pagina) {
		List<Long> idPersonas=consultaFiltro(lstCompetencias,lstHabilidades,lstAtributos);
		int cantidad=10;
					    
	    List<Long> idsConsulta=new ArrayList<Long>();
		for(int i=(pagina*cantidad);i<(pagina*cantidad)+cantidad;i++){
			idsConsulta.add(idPersonas.get(i-1));
		}
		
		Query query2=getCurrentSession().createQuery("select a from Persona a where a.idpersona in("+concatenador2(idsConsulta)+")");
		List<Persona> listaPersonas= query2.list();
		
		if(cantidad>0){
	    	System.out.println("size: "+listaPersonas.size());
	    	int division=listaPersonas.size()/cantidad;
	    	System.out.println("division: "+division);
	    	paginas=division;	    				
	    }
		
		return listaPersonas;
	}
	
	
	
	
	
	
	private List<Long> consultaFiltro(String[] lstCompetencias,String[] lstHabilidades, String[] lstAtributos){
		String consulta="";
		int contador=0;
		if(lstCompetencias.length==0 && lstHabilidades.length==0 && lstAtributos.length==0){
			consulta="select DISTINCT a.idpersona from Persona a";
		}else{
			consulta="select DISTINCT a.habilidad.persona.idpersona from Atributos a where ";
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
				subconsulta="a.atributo.idatributo in("+concatenador(lstAtributos)+")";								
				contador++;
			}
			consulta+=subconsulta;
			
		}		
		Query query=getCurrentSession().createQuery(consulta);
		//query.setMaxResults(10);
		return query.list();
	}
	
	

	@Override
	public int numeroPaginas(String[] competencias,String[] habilidades, String[] atributos, int cantidad) {
		List<Long> idPersonas=consultaFiltro(competencias,habilidades,atributos);
		return idPersonas.size()/cantidad;		
	}
	

	private String concatenador2(List<Long> arr){		
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

