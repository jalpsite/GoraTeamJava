package com.gora.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gora.dominio.Etapa;
import com.gora.services.EtapaService;
import com.gora.web.uri.EtapaRestURIConstant;

@RestController
@RequestMapping("/etapa") 
public class EtapaController {
	
	@Autowired
	EtapaService etapaService;
		
		
	@RequestMapping(value = EtapaRestURIConstant.CREATE_ETAPA, method = RequestMethod.POST)	
	public Long Agregar(@ModelAttribute Etapa eta){
		etapaService.save(eta);
		if(eta.getIdetapa()!=null)
			return eta.getIdetapa();
		else
			return new Long("0"); 
	}
	
	
}
