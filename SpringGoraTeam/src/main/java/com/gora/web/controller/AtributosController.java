package com.gora.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gora.dominio.Atributo;
import com.gora.dominio.Atributos;
import com.gora.dominio.Habilidad;
import com.gora.dominio.Matriz;
import com.gora.dominio.Persona;
import com.gora.services.AtributoService;
import com.gora.services.AtributosService;
import com.gora.services.CompetenciaService;
import com.gora.services.HabilidadService;
import com.gora.services.HabilidadesService;
import com.gora.services.MatrizService;
import com.gora.services.PersonaService;
import com.gora.web.uri.AtributosRestURIConstant;


@RestController
@RequestMapping("/atributos") 
public class AtributosController {
	
	@Autowired
	AtributosService atributosService;
	
	@Autowired
	HabilidadService habiliService;
	
	@Autowired
	AtributoService atributService;
	
	@Autowired
	PersonaService personaService;
	
	@Autowired
	CompetenciaService compService;
	
	@Autowired
	MatrizService matrizService;
	
	@Autowired
	HabilidadesService habilidadesService;
		
	

	@RequestMapping(value = AtributosRestURIConstant.CREATE_ATRIBUTOS, method = RequestMethod.POST)	
	//public int Agregar(@ModelAttribute Atributos attr, @PathVariable Long idHabilidad, @PathVariable Long idAtributo){			
	public int Agregar(@ModelAttribute Atributos attr, @PathVariable Long idPersona, @PathVariable Long idCompetencia, @PathVariable Long idHabilidades, @PathVariable Long idAtributo){
		
		Atributos a=atributosService.getAtributosXPersonaXCompXHab(idPersona, idHabilidades, idAtributo);
		if(a==null){
			Matriz m=matrizService.getMatrizXPersona(idCompetencia, idPersona);
			Persona p=personaService.findById(idPersona);
			if(m==null){
				m=new Matriz();
				m.setPersona(p);
				m.setCompetencia(compService.findById(idCompetencia));
				m.setEstado("A");
				matrizService.save(m);
			}
			
			Habilidad h=habiliService.getHabilidadXPersonaXComp(idPersona, idCompetencia, idHabilidades);
			
			if(h==null){
				h=new Habilidad();
				h.setHabilidades(habilidadesService.findById(idHabilidades));
				h.setMatriz(m);
				h.setPersona(p);
				habiliService.save(h);
			}
			
			attr.setHabilidad(h);
			attr.setAtributo(atributService.findById(idAtributo));
			this.atributosService.save(attr);
			return Integer.parseInt((m.getIdmatriz()).toString());
		}else{
			return 0;
		}					
	}
		
	@RequestMapping(value = AtributosRestURIConstant.UPDATE_ATRIBUTOS, method = RequestMethod.POST)	
	public void Actualizar(@ModelAttribute Atributos attr, @PathVariable Long idAtributo){
		Atributos atributos=atributosService.findById(attr.getIdatributos());				
		Atributo atri=atributService.findById(idAtributo);				
		atributos.setAtributo(atri);
		this.atributosService.update(atributos);		
	}
	
	@RequestMapping(value=AtributosRestURIConstant.GET_ATRIBUTOS,method = RequestMethod.GET,headers="Accept=application/json")
	public Atributos GetAtributo(@PathVariable Long id){
		return this.atributosService.findById(id);				
	}
	
	@RequestMapping(value=AtributosRestURIConstant.GET_ALL_ATRIBUTOS,method = RequestMethod.GET,headers="Accept=application/json")
	public List<Atributos> getAll(){
		return this.atributosService.findAll();		
	}
	
	@RequestMapping(value=AtributosRestURIConstant.GET_ATRIBUTOS_EXTRACTO,method = RequestMethod.GET,headers="Accept=application/json")
	public List<Atributo> GetAtributosExtracto(@PathVariable Long idPersona, @PathVariable Long idHabilidad){
		return this.atributService.getAtributosExtracto(idPersona, idHabilidad);	
	}
	
	@RequestMapping(value = AtributosRestURIConstant.DELETE_ATRIBUTOS, method = RequestMethod.POST)	
	public void delete(@PathVariable Long idAtributos){		
		this.atributosService.eliminar(idAtributos);		
	}
		
	
}
