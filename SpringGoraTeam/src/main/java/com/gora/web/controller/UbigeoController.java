package com.gora.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.gora.dominio.Ubigeo;

import com.gora.services.UbigeoService;

import com.gora.web.uri.UbigeoRestURIConstant;



@RestController
@RequestMapping("/ubigeo") 
public class UbigeoController {
	
	@Autowired
	UbigeoService ubigeo;
	

	@RequestMapping(value = UbigeoRestURIConstant.CREATE_UBIGEO, method = RequestMethod.POST)	
	public int Agregar(@ModelAttribute Ubigeo ubi){		
		this.ubigeo.save(ubi);
		return Integer.parseInt((ubi.getIdubigeo()).toString());
	}
	
	@RequestMapping(value = UbigeoRestURIConstant.UPDATE_UBIGEO, method = RequestMethod.POST)	
	public void Actualizar(@ModelAttribute Ubigeo ubi){		
		this.ubigeo.update(ubi);
	}
	
	
	@RequestMapping(value=UbigeoRestURIConstant.GET_UBIGEO,method = RequestMethod.GET,headers="Accept=application/json")
	public Ubigeo GetUbigeo(@PathVariable Long id){
		return this.ubigeo.findById(id);				
	}
	
	@RequestMapping(value=UbigeoRestURIConstant.GET_ALL_UBIGEO,method = RequestMethod.GET,headers="Accept=application/json")
	public List<Ubigeo> getAll(){
		return this.ubigeo.findAll();		
	}
}
