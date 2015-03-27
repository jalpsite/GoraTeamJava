package com.gora.web.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import net.sf.mpxj.ProjectFile;
import net.sf.mpxj.Relation;
import net.sf.mpxj.Resource;
import net.sf.mpxj.ResourceAssignment;
import net.sf.mpxj.Task;
import net.sf.mpxj.mpp.MPPReader;
import net.sf.mpxj.planner.schema.Predecessor;
import net.sf.mpxj.planner.schema.Predecessors;
import net.sf.mpxj.reader.ProjectReader;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.gora.dominio.Cronograma;
import com.gora.dominio.Equipo;
import com.gora.dominio.Etapa;
import com.gora.dominio.Persona;
import com.gora.dominio.Proyecto;
import com.gora.dominio.Tarea;
import com.gora.services.ClientService;
import com.gora.services.CronogramaService;
import com.gora.services.EquipoService;
import com.gora.services.EtapaService;
import com.gora.services.IniciativaService;
import com.gora.services.PersonaService;
import com.gora.services.PortafolioService;
import com.gora.services.ProyectoService;
import com.gora.services.TareaService;
import com.gora.services.TipoproyectoService;
import com.gora.util.DojoGanttJSON;
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
	
	@Autowired
	EtapaService etapaService;
	
	@Autowired
	CronogramaService cronoService;
	
	@Autowired
	TareaService tareaService;
			
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
	
	/*
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
	*/
		
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
	
	
	@RequestMapping(value=ProyectoRestURIConstant.IMPORT_PROYECTO, method=RequestMethod.POST)
    public String handleFileUpload(@PathVariable Long idProyecto, @RequestParam("file") MultipartFile file){	
		String name="proyecto.mpp";
		 if (!file.isEmpty()) {
	            try {
	                byte[] bytes = file.getBytes();	               
	                String rootPath = System.getProperty("catalina.home");
	                File dir = new File(rootPath + File.separator + "tmpFiles");
	                if (!dir.exists())
	                    dir.mkdirs();	 	               
	                File serverFile = new File(dir.getAbsolutePath()
	                        + File.separator + name);
	                BufferedOutputStream stream = new BufferedOutputStream(
	                        new FileOutputStream(serverFile));
	                stream.write(bytes);
	                stream.close();	 
	                //System.out.println("Server File Location= "+ serverFile.getAbsolutePath());	                	 	                	                	                
	                ProjectReader reader = new MPPReader();
	                ProjectFile project = reader.read(serverFile);
	                	                
	                String res=DojoGanttJSON.toJSON(project);
	                serverFile.delete();
	                
	                
 Proyecto proy=proyectoService.findById(idProyecto);
	                
	                
	                Object[][] datos=new Object[100][100];
	                
	                SimpleDateFormat fmt=new SimpleDateFormat("dd/MM/YYYY");          
	                List<Task> fases=project.getTaskByID(0).getChildTasks();
	                Task proyecto=project.getTaskByID(0);
	                System.out.println("Proyecto: "+proyecto);
	                
	                int pos=0;
	                for(Task t:fases){
	                	Etapa eta=new Etapa();
	                	eta.setDescripcion(t.getName());
	                	eta.setEstado("A");
	                	etapaService.save(eta);
	                	
	                	System.out.println("Fase: "+t);
	                	
	                	List<Task> hijos=t.getChildTasks();
	                	for(Task h:hijos){
	                		//Long idPersona=new Long("0");
	                		if(h.getResourceAssignments()!=null){
	                			List<ResourceAssignment> reso=h.getResourceAssignments();
	                			for(ResourceAssignment r:reso){
	                				//idPersona=new Long(r.getResource().getName());	                			
	                			}
	                		}
	                		Tarea predece=null;
	                		if(h.getPredecessors()!=null){
	                			List<Relation> pred=h.getPredecessors();		                		
		                		for(Relation r:pred){
		                			for(int i=0;i<100;i++){
		                				if(datos[i][0]!=null){
		                					if(datos[i][0].equals(r.getTargetTask().getUniqueID())){
		                						predece=(Tarea)datos[i][1];
		                						break;
		                					}
		                				}else{break;}
		                			}
		                			//System.out.println("		Predecesores - Destino: "+r.getTargetTask());
		                		}
	                		}
	                		
	                		Tarea tarea=new Tarea();
	                		tarea.setCosto(new BigDecimal(h.getCost().toString()));
	                		tarea.setNombre(h.getName());
	                		tarea.setEstado("A");
	                		tarea.setFecfin(h.getFinish());
	                		tarea.setFecini(h.getStart());	                			                			                	
	                		tarea.setHoras(new BigDecimal(h.getDuration().getDuration()));	
	                		//if(idPersona!=0)
	                			//tarea.setPersona(PersonaService.findById(idPersona));
	                		if(predece!=null)
	                			tarea.setTarea1(predece);
	                		
	                		tareaService.save(tarea);
	                		datos[pos][0]=h.getUniqueID();
	                		datos[pos][1]=tarea;
	                		
	                		Cronograma cro=new Cronograma();
	                		cro.setDescripcion(h.getName());
	                		cro.setEstado("A");
	                		cro.setEtapa(eta);
	                		cro.setProyecto(proy);
	                		cro.setTarea(tarea);
	                		
	                		cronoService.save(cro);
	                		pos++;
	                		
	                		System.out.println("	hijo: nombre: "+h.getName());
	                		System.out.println("	hijo: costo: "+h.getCost());
	                		System.out.println("	hijo: fechaInicio: "+fmt.format(h.getStart()));
	                		System.out.println("	hijo: fechaFin: "+fmt.format(h.getFinish()));
	                		System.out.println("	hijo: Duracion: "+h.getDuration());
	                		
	                		if(h.getPredecessors()!=null){
	                			List<Relation> pred=h.getPredecessors();
		                		
		                		for(Relation r:pred){
		                			System.out.println("		Predecesores - Origen: "+r.getSourceTask());
		                			System.out.println("		Predecesores - Destino: "+r.getTargetTask());
		                		}
	                		}
	                			                		
	                		if(h.getResourceAssignments()!=null){
	                			List<ResourceAssignment> reso=h.getResourceAssignments();
	                			for(ResourceAssignment r:reso){
	                				System.out.println("		Recurso: "+r.getResource().getActualWork());	                			
	                			}
	                		}
	                		
	                		
	                	}
	                }	                
	                
	                return res;	                
	            } catch (Exception e) {
	                return "Falla al Subir archivo " + name + " => " + e.getMessage();
	            }
	        } else {
	            return "El archivo " + name +" esta vacio";
	        }		
	}		
}
