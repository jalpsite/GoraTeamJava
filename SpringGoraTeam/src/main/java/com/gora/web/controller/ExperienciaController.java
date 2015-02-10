package com.gora.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
	public int Agregar(@ModelAttribute Experiencia exp, @PathVariable Long idPersona){	
		Persona per=personaService.findById(idPersona);
		exp.setPersona(per);
		this.experiencia.save(exp);
		
		return Integer.parseInt((exp.getIdexperiencia()).toString()); 
	}
	
	@RequestMapping(value = ExperienciaRestURIConstant.UPDATE_EXPERIENCIA, method = RequestMethod.POST)	
	public Experiencia Actualizar(@ModelAttribute Experiencia exp, @PathVariable Long idPersona){	
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
}
