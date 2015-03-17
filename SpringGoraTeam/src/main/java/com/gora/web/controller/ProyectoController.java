package com.gora.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gora.dominio.Equipo;
import com.gora.dominio.Persona;
import com.gora.dominio.PersonaEquipo;
import com.gora.dominio.Proyecto;
import com.gora.dominio.Usuario;
import com.gora.services.ClientService;
import com.gora.services.EquipoService;
import com.gora.services.IniciativaService;
import com.gora.services.PersonaService;
import com.gora.services.PortafolioService;
import com.gora.services.ProyectoService;
import com.gora.services.TipoproyectoService;
import com.gora.web.uri.ProyectoRestURIConstant;



@RestController
@RequestMapping("/proyecto") 
public class ProyectoController {
	
	@Autowired
	ProyectoService proyectoService;
	
	@Autowired
	ClientService clienteService;
	
	@Autowired
	IniciativaService iniciativaService;
	
	@Autowired
	PersonaService PersonaService;
	
	@Autowired
	PortafolioService portafolioService;
	
	@Autowired
	TipoproyectoService tipoProyectoService;
	
	@Autowired
	EquipoService equipoService;
	
	
			
	@RequestMapping(value = ProyectoRestURIConstant.CREATE_PROYECTO, method = RequestMethod.POST)	
	public int Agregar(@ModelAttribute Proyecto proy,@PathVariable Long idCliente, /*@PathVariable Long idIniciativa, */@PathVariable Long idPersona /*@PathVariable Long idPortafolio*/,@PathVariable Long idTipoProyecto){
		proy.setCliente(clienteService.findById(idCliente));
		//proy.setIniciativa(iniciativaService.findById(idIniciativa));
		proy.setPersona(PersonaService.findById(idPersona));
		//proy.setPortafolio(portafolioService.findById(idPortafolio));
		proy.setTipoproyecto(tipoProyectoService.findById(idTipoProyecto));
		proyectoService.save(proy);
		Equipo eq=new Equipo();
		eq.setNombre(proy.getNombre());
		eq.setProyecto(proy);
		equipoService.save(eq);
		return Integer.parseInt((proy.getIdproyecto()).toString());
	}
	
	@RequestMapping(value = ProyectoRestURIConstant.UPDATE_PROYECTO, method = RequestMethod.POST)	
	public void Actualizar(@ModelAttribute Proyecto proy,@PathVariable Long idCliente, /*@PathVariable Long idIniciativa, */@PathVariable Long idPersona /*@PathVariable Long idPortafolio*/,@PathVariable Long idTipoProyecto){
		proy.setCliente(clienteService.findById(idCliente));
		//proy.setIniciativa(iniciativaService.findById(idIniciativa));
		proy.setPersona(PersonaService.findById(idPersona));
		//proy.setPortafolio(portafolioService.findById(idPortafolio));
		proy.setTipoproyecto(tipoProyectoService.findById(idTipoProyecto));
		proyectoService.update(proy);
	}
	
	
	@RequestMapping(value=ProyectoRestURIConstant.GET_PROYECTO,method = RequestMethod.GET,headers="Accept=application/json")
	public Proyecto GetProyecto(@PathVariable Long id){
		return this.proyectoService.findById(id);				
	}
	
	@RequestMapping(value=ProyectoRestURIConstant.GET_ALL_PROYECTOS,method = RequestMethod.GET,headers="Accept=application/json")
	public List<Proyecto> getAll(){
		return this.proyectoService.findAll();		
	}
	
	@RequestMapping(value=ProyectoRestURIConstant.GET_ALL_PROYECTO_BUSQUEDA,method = RequestMethod.POST,headers="Accept=application/json")
	public List<Proyecto> getAllProyectoBusqueda(@RequestParam String nombres){
		return this.proyectoService.buscarProyecto(nombres);
	}
	
	@RequestMapping(value=ProyectoRestURIConstant.GET_PROYECTO_EQUIPO,method = RequestMethod.GET,headers="Accept=application/json")
	public List<Persona> getProyectoEquipo(@PathVariable Long idProyecto){
		Equipo equipo=this.proyectoService.findById(idProyecto).getEquipo();				
		return equipoService.getPersonasEquipo(equipo.getIdequipo());
	}
	
	@RequestMapping(value = ProyectoRestURIConstant.IMPORT_PROYECTO, method = RequestMethod.POST,headers = "Accept=application/json")
	public String importarProyecto(@PathVariable Long idProyecto, @RequestBody  String cadena) {
		String cad="";
		//List<Usuario> res=new ArrayList<Usuario>();
		try {
			
			JSONObject json = XML.toJSONObject(cadena);						
			/*
			Iterator<?> mundo = json.keys();
			while(mundo.hasNext() ){
			    String mun = (String)mundo.next(); //mundo
			    Iterator<?> persona = json.getJSONObject(mun).keys();
			    while(persona.hasNext()){
			        String per = (String)persona.next();//persona			        
			        			        	
			        Iterator<?> usuario = json.getJSONObject(mun).getJSONObject(per).keys();			        
			        
				    while(usuario.hasNext()){				    					    	    				    					    
				        String us = (String)usuario.next();//usuario
				        			   
				        if( json.getJSONObject(mun).getJSONObject(per).get(us) instanceof JSONObject ){ 
				        	JSONObject obj= json.getJSONObject(mun).getJSONObject(per).getJSONObject(us);				        	
				        	res.add(cargarUsuario(obj));
				        }else{
				        	JSONArray arr= json.getJSONObject(mun).getJSONObject(per).getJSONArray(us);					        
					        for(int i=0;i<arr.length();i++){					        						        					        
					        	res.add(cargarUsuario(arr.getJSONObject(i)));
					        }
				        }				      
				        
				    }
			    }
			}			
			*/
			cad=json.toString();
			} catch (JSONException je) {
			
			System.out.println(je.toString());
			
			}
		return cad;
	}
	
	private Usuario cargarUsuario(JSONObject obj){
		Usuario u=new Usuario();
		try {
			u.setId(obj.getLong("id"));
	    	u.setUsuario(obj.getString("us"));
	    	u.setPass(obj.getString("pass"));
	    	u.setEstado(obj.getString("estado"));
		} catch (Exception e) {			
		}    	
    	return u;
	}
		
	/* RAW 
	 * 
<mundo>  
  <persona>    
    <usuario>
      <id>05</id>
      <estado>A</estado>
      <pass>123</pass>
      <us>admin</us>
    </usuario> 
	<usuario>
      <id>05</id>
      <estado>A</estado>
      <pass>123</pass>
      <us>admin</us>
    </usuario>     
  </persona>     
</mundo>
*/
		
		
}
