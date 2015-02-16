package com.gora.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gora.dominio.Atributo;
import com.gora.dominio.Habilidad;
import com.gora.dominio.Habilidades;
import com.gora.dominio.Matriz;
import com.gora.dominio.Persona;
import com.gora.services.AtributosService;
import com.gora.services.HabilidadService;
import com.gora.services.HabilidadesService;
import com.gora.services.MatrizService;
import com.gora.services.PersonaService;
import com.gora.web.uri.HabilidadRestURIConstant;



@RestController
@RequestMapping("/habilidad") 
public class HabilidadController {
	
	@Autowired
	HabilidadService habilidadService;
	
	@Autowired
	AtributosService atributosService;
	
	@Autowired
	PersonaService perService;
	
	@Autowired
	MatrizService matrizService;
	
	@Autowired
	HabilidadesService habiliService;
	
	@RequestMapping(value = HabilidadRestURIConstant.CREATE_HABILIDAD, method = RequestMethod.POST)	
	public int Agregar(@ModelAttribute Habilidad hab,@PathVariable Long idPersona, @PathVariable Long idMatriz,@PathVariable Long idHabilidades){
		Persona per =perService.findById(idPersona);
		Habilidades habili=habiliService.findById(idHabilidades);
		Matriz matr=matrizService.findById(idMatriz);
		hab.setPersona(per);
		hab.setHabilidades(habili);
		hab.setMatriz(matr);
		this.habilidadService.save(hab);
		return Integer.parseInt((hab.getIdhabilidad()).toString());
	}
	
	@RequestMapping(value = HabilidadRestURIConstant.UPDATE_HABILIDAD, method = RequestMethod.POST)	
	public void Actualizar(@ModelAttribute Habilidad hab, @PathVariable Long idHabilidades){
		Habilidad objHabilidad=habilidadService.findById(hab.getIdhabilidad());
		//eliminar atributos
		if(atributosService.eliminarXHabilidad(objHabilidad.getIdhabilidad())){
			Habilidades habili=habiliService.findById(idHabilidades);
			objHabilidad.setHabilidades(habili);						
			this.habilidadService.update(objHabilidad);
		}			
	}
	
	
	@RequestMapping(value=HabilidadRestURIConstant.GET_HABILIDAD,method = RequestMethod.GET,headers="Accept=application/json")
	public Habilidad GetHabilidad(@PathVariable Long id){
		return this.habilidadService.findById(id);				
	}
	
	@RequestMapping(value=HabilidadRestURIConstant.GET_ALL_HABILIDAD,method = RequestMethod.GET,headers="Accept=application/json")
	public List<Habilidad> getAll(){
		return this.habilidadService.findAll();		
	}
	
	@RequestMapping(value=HabilidadRestURIConstant.GET_ATRIBUTOS,method = RequestMethod.GET,headers="Accept=application/json")
	public List<Atributo> GetAtributos(@PathVariable Long id){
		return this.habilidadService.getAtributos(id);		
	}
			
	@RequestMapping(value=HabilidadRestURIConstant.GET_HABILIDADES_EXTRACTO,method = RequestMethod.GET,headers="Accept=application/json")
	public List<Habilidades> GetAtributosExtracto(@PathVariable Long idPersona, @PathVariable Long idCompetencia){
		return this.habilidadService.getHabilidadesExtracto(idPersona, idCompetencia);
	}
}
