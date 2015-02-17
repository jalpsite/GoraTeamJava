package com.gora.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gora.dominio.Experiencia;
import com.gora.dominio.Persona;
import com.gora.services.ExperienciaService;
import com.gora.services.PersonaService;
import com.gora.web.uri.ExperienciaRestURIConstant;


@RestController
@RequestMapping("/experiencia") 
public class ExperienciaController {
	
	@Autowired
	ExperienciaService experiencia;
	@Autowired
	PersonaService personaService;
		

	@RequestMapping(value = ExperienciaRestURIConstant.CREATE_EXPERIENCIA, method = RequestMethod.POST)	
	public void Agregar(@RequestBody Experiencia[] exp, @PathVariable Long idPersona){	
		Persona per=personaService.findById(idPersona);
		for(Experiencia e:exp){
			e.setPersona(per);
			this.experiencia.save(e);			
		}			
	}
	
	@RequestMapping(value = ExperienciaRestURIConstant.UPDATE_EXPERIENCIA, method = RequestMethod.POST)	
	public void Actualizar(@RequestBody Experiencia[] exp, @PathVariable Long idPersona){	
		Persona per=personaService.findById(idPersona);
		for(Experiencia e:exp){
			e.setPersona(per);
			this.experiencia.update(e);			
		}	
	}	
	
	@RequestMapping(value = ExperienciaRestURIConstant.UPDATESINGLE_EXPERIENCIA, method = RequestMethod.POST)	
	public Experiencia ActualizarSingle(@ModelAttribute Experiencia exp, @PathVariable Long idPersona){	
		Persona per=personaService.findById(idPersona);
		exp.setPersona(per);
		this.experiencia.update(exp);			
		return exp;
	}
	
	@RequestMapping(value=ExperienciaRestURIConstant.GET_EXPERIENCIA,method = RequestMethod.GET,headers="Accept=application/json")
	public Experiencia GetExperiencia(@PathVariable Long id){
		return this.experiencia.findById(id);			
	}
	
	@RequestMapping(value=ExperienciaRestURIConstant.GET_ALL_EXPERIENCIA,method = RequestMethod.GET,headers="Accept=application/json")
	public List<Experiencia> getAll(){
		return this.experiencia.findAll();		
	}
	
	@RequestMapping(value = ExperienciaRestURIConstant.DELETE_EXPERIENCIA, method = RequestMethod.POST)	
	public void Agregar(@PathVariable Long id){	
		experiencia.eliminarExperiencia(id);
	}
}
