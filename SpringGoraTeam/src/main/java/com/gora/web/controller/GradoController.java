package com.gora.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



import com.gora.dominio.Grado;
import com.gora.services.GradoService;
import com.gora.web.uri.GradoRestURIConstant;


@RestController
@RequestMapping("/grado") 
public class GradoController {
	
	@Autowired
	GradoService grados;
	

	@RequestMapping(value = GradoRestURIConstant.CREATE_GRADO, method = RequestMethod.POST)	
	public int Agregar(@ModelAttribute Grado grado){		
		this.grados.save(grado);
		return Integer.parseInt((grado.getIdgrado()).toString());
	}
	
	@RequestMapping(value = GradoRestURIConstant.UPDATE_GRADO, method = RequestMethod.POST)	
	public void Actualizar(@ModelAttribute Grado grado){		
		this.grados.update(grado);		
	}
	
	
	@RequestMapping(value=GradoRestURIConstant.GET_GRADO,method = RequestMethod.GET,headers="Accept=application/json")
	public Grado GetGrado(@PathVariable Long id){
		return this.grados.findById(id);				
	}
	
	@RequestMapping(value=GradoRestURIConstant.GET_ALL_GRADO,method = RequestMethod.GET,headers="Accept=application/json")
	public List<Grado> getAll(){
		return this.grados.findAll();		
	}
}
