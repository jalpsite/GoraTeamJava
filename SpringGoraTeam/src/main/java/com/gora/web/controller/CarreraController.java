package com.gora.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gora.dominio.Carrera;
import com.gora.services.CarreraService;
import com.gora.web.uri.CarreraRestURIConstant;


@RestController
@RequestMapping("/carrera") 
public class CarreraController {
	
	@Autowired
	CarreraService carreras;


	@RequestMapping(value = CarreraRestURIConstant.CREATE_CARRERA, method = RequestMethod.POST)	
	public int Agregar(@ModelAttribute Carrera carr){		
		this.carreras.save(carr);
		return Integer.parseInt((carr.getIdcarrera()).toString());
	}
	
	@RequestMapping(value = CarreraRestURIConstant.UPDATE_CARRERA, method = RequestMethod.POST)	
	public void Actualizar(@ModelAttribute Carrera carr){		
		this.carreras.update(carr);		
	}
		
	@RequestMapping(value=CarreraRestURIConstant.GET_CARRERA,method = RequestMethod.GET,headers="Accept=application/json")
	public Carrera GetCarrera(@PathVariable Long id){
		return this.carreras.findById(id);				
	}
	
	@RequestMapping(value=CarreraRestURIConstant.GET_ALL_CARRERA,method = RequestMethod.GET,headers="Accept=application/json")
	public List<Carrera> getAll(){
		return this.carreras.findAll();		
	}
}
