package com.gora.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.gora.dominio.Cargo;
import com.gora.services.CargoService;
import com.gora.web.uri.CargoRestURIConstant;
@RestController
@RequestMapping("/cargo") 
public class CargoController {
	
	@Autowired
	CargoService cargoService;
		
	@RequestMapping(value=CargoRestURIConstant.GET_CARGO,method = RequestMethod.GET,headers="Accept=application/json")
	public Cargo GetCargo(@PathVariable Long id){
		return this.cargoService.findById(id);		
	}
		
}
