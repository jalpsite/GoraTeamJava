package com.gora.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gora.dominio.Universidad;
import com.gora.services.UniversidadService;
import com.gora.web.uri.UniversidadRestURIConstant;


@RestController
@RequestMapping("/universidad") 
public class UniversidadController {
	
	@Autowired
	UniversidadService universidad;
	

	@RequestMapping(value = UniversidadRestURIConstant.CREATE_UNIVERSIDAD, method = RequestMethod.POST)	
	public int Agregar(@ModelAttribute Universidad uni){		
		this.universidad.save(uni);
		return Integer.parseInt((uni.getIduniversidad()).toString());
	}
	
	@RequestMapping(value = UniversidadRestURIConstant.UPDATE_UNIVERSIDAD, method = RequestMethod.POST)	
	public void Actualizar(@ModelAttribute Universidad uni){		
		this.universidad.update(uni);		
	}
	
	
	@RequestMapping(value=UniversidadRestURIConstant.GET_UNIVERSIDAD,method = RequestMethod.GET,headers="Accept=application/json")
	public Universidad GetUniversidad(@PathVariable Long id){
		return this.universidad.findById(id);				
	}
	
	@RequestMapping(value=UniversidadRestURIConstant.GET_ALL_UNIVERSIDADES,method = RequestMethod.GET,headers="Accept=application/json")
	public List<Universidad> getAll(){
		return this.universidad.findAll();		
	}
	
}
