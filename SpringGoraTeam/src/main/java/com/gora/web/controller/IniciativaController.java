package com.gora.web.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.gora.dominio.Iniciativa;
import com.gora.services.ClientService;
import com.gora.services.IniciativaService;
import com.gora.services.TipoIniciativaService;
import com.gora.web.uri.IniciativaRestURIConstant;

@RestController
@RequestMapping("/iniciativa") 
public class IniciativaController {
	
	@Autowired
	IniciativaService iniciativaService;
	
	@Autowired
	ClientService clienteService;
	
	@Autowired
	TipoIniciativaService tipoIniciativaService;
		
	@RequestMapping(value = IniciativaRestURIConstant.CREATE_INICIATIVA, method = RequestMethod.POST)
	public int agregarIniciativa(@ModelAttribute Iniciativa iniciativa, @PathVariable Long idCliente, @PathVariable Long tipoIniciativa) {
		iniciativa.setCliente(clienteService.findById(idCliente));
		iniciativa.setTipoiniciativa(tipoIniciativaService.findById(tipoIniciativa));
		this.iniciativaService.save(iniciativa);
		return Integer.parseInt((iniciativa.getIdiniciativa()).toString());
	}
	
	@RequestMapping(value = IniciativaRestURIConstant.UPDATE_INICIATIVA, method = RequestMethod.POST)
	public void actualizarIniciativa(@ModelAttribute Iniciativa iniciativa, @PathVariable Long idCliente, @PathVariable Long tipoIniciativa) {
		iniciativa.setCliente(clienteService.findById(idCliente));
		iniciativa.setTipoiniciativa(tipoIniciativaService.findById(tipoIniciativa));
		this.iniciativaService.update(iniciativa);		
	}	
		
	@RequestMapping(value=IniciativaRestURIConstant.GET_INICIATIVA,method = RequestMethod.GET,headers="Accept=application/json")
	public Iniciativa buscar(@PathVariable Long id){
		return this.iniciativaService.findById(id);				
	}
	
	@RequestMapping(value=IniciativaRestURIConstant.GET_ALL_INICIATIVA,method = RequestMethod.GET,headers="Accept=application/json")
	public List<Iniciativa> getAll(){
		return iniciativaService.findAll();		
	}
		
	
}
