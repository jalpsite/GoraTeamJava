package com.gora.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.gora.dominio.Cliente;
import com.gora.services.ClientService;
import com.gora.services.UbigeoService;
import com.gora.web.uri.ClienteRestURIConstant;


@RestController
@RequestMapping("/cliente") 
public class ClienteController {
	
	@Autowired
	ClientService clienteService;
	
	@Autowired
	UbigeoService ubigeoService;
	

	@RequestMapping(value = ClienteRestURIConstant.CREATE_CLIENTE, method = RequestMethod.POST)	
	public int Agregar(@ModelAttribute Cliente cli,@PathVariable Long idUbigeo){	
		cli.setUbigeo(ubigeoService.findById(idUbigeo));
		this.clienteService.save(cli);
		return Integer.parseInt((cli.getIdcliente()).toString());
	}
	
	@RequestMapping(value = ClienteRestURIConstant.UPDATE_CLIENTE, method = RequestMethod.POST)	
	public void Actualizar(@ModelAttribute Cliente cli,@PathVariable Long idUbigeo){		
		cli.setUbigeo(ubigeoService.findById(idUbigeo));
		this.clienteService.update(cli);
	}
	
	
	@RequestMapping(value=ClienteRestURIConstant.GET_CLIENTE,method = RequestMethod.GET,headers="Accept=application/json")
	public Cliente GetCliente(@PathVariable Long id){
		return this.clienteService.findById(id);				
	}
	
	@RequestMapping(value=ClienteRestURIConstant.GET_ALL_CLIENTE,method = RequestMethod.GET,headers="Accept=application/json")
	public List<Cliente> getAll(){
		return this.clienteService.findAll();		
	}
}
