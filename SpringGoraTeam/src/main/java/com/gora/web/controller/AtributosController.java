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
import com.gora.services.AtributoService;
import com.gora.services.AtributosService;
import com.gora.services.HabilidadService;
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
	

	@RequestMapping(value = AtributosRestURIConstant.CREATE_ATRIBUTOS, method = RequestMethod.POST)	
	public int Agregar(@ModelAttribute Atributos attr, @PathVariable Long idHabilidad, @PathVariable Long idAtributo){
		Habilidad hab=habiliService.findById(idHabilidad);
		Atributo atri=atributService.findById(idAtributo);		
		attr.setHabilidad(hab);
		attr.setAtributo(atri);
		this.atributosService.save(attr);
		return Integer.parseInt((attr.getIdatributos()).toString());
	}
		
	@RequestMapping(value = AtributosRestURIConstant.UPDATE_ATRIBUTOS, method = RequestMethod.POST)	
	public void Actualizar(@ModelAttribute Atributos attr, @PathVariable Long idHabilidad, @PathVariable Long idAtributo){
		Habilidad hab=habiliService.findById(idHabilidad);
		Atributo atri=atributService.findById(idAtributo);
		System.out.println(attr.getIdatributos());
		attr.setHabilidad(hab);
		attr.setAtributo(atri);
		this.atributosService.update(attr);		
	}
	
	@RequestMapping(value=AtributosRestURIConstant.GET_ATRIBUTOS,method = RequestMethod.GET,headers="Accept=application/json")
	public Atributos GetAtributo(@PathVariable Long id){
		return this.atributosService.findById(id);				
	}
	
	@RequestMapping(value=AtributosRestURIConstant.GET_ALL_ATRIBUTOS,method = RequestMethod.GET,headers="Accept=application/json")
	public List<Atributos> getAll(){
		return this.atributosService.findAll();		
	}
}
