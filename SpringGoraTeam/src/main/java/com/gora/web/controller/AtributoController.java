package com.gora.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gora.dominio.Atributo;
import com.gora.dominio.Habilidades;
import com.gora.services.AtributoService;
import com.gora.services.HabilidadesService;
import com.gora.web.uri.AtributoRestURIConstant;



@RestController
@RequestMapping("/atributo") 
public class AtributoController {
	
	@Autowired
	AtributoService atributo;
	
	@Autowired
	HabilidadesService habService;
	

	@RequestMapping(value = AtributoRestURIConstant.CREATE_ATRIBUTO, method = RequestMethod.POST)	
	public int Agregar(@ModelAttribute Atributo attr, @PathVariable Long idHabilidades){
		Habilidades hab=habService.findById(idHabilidades);
		attr.setHabilidades(hab);
		this.atributo.save(attr);
		return Integer.parseInt((attr.getIdatributo()).toString());
	}
	
	@RequestMapping(value = AtributoRestURIConstant.UPDATE_ATRIBUTO, method = RequestMethod.POST)	
	public void Actualizar(@ModelAttribute Atributo attr, @PathVariable Long idHabilidades){
		Habilidades hab=habService.findById(idHabilidades);
		attr.setHabilidades(hab);
		this.atributo.update(attr);		
	}
	
	@RequestMapping(value=AtributoRestURIConstant.GET_ATRIBUTO,method = RequestMethod.GET,headers="Accept=application/json")
	public Atributo GetAtributo(@PathVariable Long id){
		return this.atributo.findById(id);				
	}
	
	@RequestMapping(value=AtributoRestURIConstant.GET_ALL_ATRIBUTO,method = RequestMethod.GET,headers="Accept=application/json")
	public List<Atributo> getAll(){
		return this.atributo.findAll();		
	}
}
