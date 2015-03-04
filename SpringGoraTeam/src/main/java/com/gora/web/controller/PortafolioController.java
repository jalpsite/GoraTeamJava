package com.gora.web.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.gora.dominio.Portafolio;
import com.gora.services.PortafolioService;
import com.gora.web.uri.PortafolioRestURIConstant;

@RestController
@RequestMapping("/portafolio") 
public class PortafolioController {
	
	@Autowired
	PortafolioService portafolioService;
	
	
	@RequestMapping(value = PortafolioRestURIConstant.CREATE_PORTAFOLIO, method = RequestMethod.POST)
	public int agregarPortafolio(@ModelAttribute Portafolio portafolio) {
		this.portafolioService.save(portafolio);
		return Integer.parseInt((portafolio.getIdportafolio()).toString());
	}
	
	@RequestMapping(value = PortafolioRestURIConstant.UPDATE_PORTAFOLIO, method = RequestMethod.POST)
	public void actualizarPortafolio(@ModelAttribute Portafolio portafolio) {
		this.portafolioService.update(portafolio);		
	}	
		
	@RequestMapping(value=PortafolioRestURIConstant.GET_PORTAFOLIO,method = RequestMethod.GET,headers="Accept=application/json")
	public Portafolio buscar(@PathVariable Long id){
		return this.portafolioService.findById(id);				
	}
	
	@RequestMapping(value=PortafolioRestURIConstant.GET_ALL_PORTAFOLIO,method = RequestMethod.GET,headers="Accept=application/json")
	public List<Portafolio> getAll(){
		return portafolioService.findAll();		
	}
		
	
}
