package com.gora.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gora.dominio.Carrera;
import com.gora.dominio.Formacion;
import com.gora.dominio.Grado;
import com.gora.dominio.Persona;
import com.gora.dominio.Universidad;
import com.gora.services.CarreraService;
import com.gora.services.FormacionService;
import com.gora.services.GradoService;
import com.gora.services.PersonaService;
import com.gora.services.UniversidadService;
import com.gora.web.uri.FormacionRestURIConstant;


@RestController
@RequestMapping("/formacion") 
public class FormacionController {
	
	@Autowired
	FormacionService formacion;
	
	@Autowired
	PersonaService perService;	
	
	@Autowired
	CarreraService carreraService;
	
	@Autowired
	GradoService gradoService;
	
	@Autowired
	UniversidadService uniService;	
		
	@RequestMapping(value = FormacionRestURIConstant.CREATE_FORMACION, method = RequestMethod.POST)	
	public int Agregar(@ModelAttribute Formacion form, @PathVariable Long idPersona, @PathVariable Long idUniversidad, @PathVariable Long idCarrera, @PathVariable Long idGrado){			
		Persona per=perService.findById(idPersona);		
		Carrera carr=carreraService.findById(idCarrera);
		Grado grado=gradoService.findById(idGrado);
		Universidad uni=uniService.findById(idUniversidad);
		form.setPersona(per);
		form.setCarrera(carr);
		form.setGrado(grado);
		form.setUniversidad(uni);
		if(idGrado>0){
			form.setOtrogrado(null);
		}
		if(idUniversidad>0){
			form.setOtrauniversidad(null);
		}
		//System.out.println(form.getAnhofin()+" "+form.getAnhoinicio());								
		this.formacion.save(form);		
		return Integer.parseInt((form.getIdformacion()).toString());
	}
	
	@RequestMapping(value = FormacionRestURIConstant.UPDATE_FORMACION, method = RequestMethod.POST)	
	public Formacion Actualizar(@ModelAttribute Formacion form, @PathVariable Long idPersona, @PathVariable Long idUniversidad, @PathVariable Long idCarrera, @PathVariable Long idGrado){		
		Persona per=perService.findById(idPersona);		
		Carrera carr=carreraService.findById(idCarrera);
		Grado grado=gradoService.findById(idGrado);
		Universidad uni=uniService.findById(idUniversidad);
		form.setPersona(per);
		form.setCarrera(carr);
		form.setGrado(grado);
		form.setUniversidad(uni);
		if(idGrado>0){
			form.setOtrogrado(null);
		}
		if(idUniversidad>0){
			form.setOtrauniversidad(null);
		}
		this.formacion.update(form);
		return form;
	}
	
	
	
	@RequestMapping(value=FormacionRestURIConstant.GET_FORMACION,method = RequestMethod.GET,headers="Accept=application/json")
	public Formacion buscar(@PathVariable Long id){
		return this.formacion.findById(id);				
	}
	
	@RequestMapping(value=FormacionRestURIConstant.GET_ALL_FORMACION,method = RequestMethod.GET,headers="Accept=application/json")
	public List<Formacion> getAll(){
		return formacion.findAll();		
	}
	
	@RequestMapping(value = FormacionRestURIConstant.DELETE_FORMACION, method = RequestMethod.POST)	
	public void Agregar(@PathVariable Long id){	
		formacion.eliminarFormacion(id);
	}
}
