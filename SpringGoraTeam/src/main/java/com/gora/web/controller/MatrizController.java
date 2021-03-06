package com.gora.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gora.dominio.Competencia;
import com.gora.dominio.Matriz;
import com.gora.dominio.Persona;
import com.gora.services.CompetenciaService;
import com.gora.services.MatrizService;
import com.gora.services.PersonaService;
import com.gora.web.uri.MatrizRestURIConstant;



@RestController
@RequestMapping("/matriz") 
public class MatrizController {
	
	@Autowired
	MatrizService matriz;
	
	@Autowired
	PersonaService perService;
	
	@Autowired
	CompetenciaService compService;
	

	@RequestMapping(value = MatrizRestURIConstant.CREATE_MATRIZ, method = RequestMethod.POST)	
	public int Agregar(@ModelAttribute Matriz matr, @PathVariable Long idPersona, @PathVariable Long idCompetencia){
		Persona per=perService.findById(idPersona);
		Competencia comp=compService.findById(idCompetencia);
		matr.setPersona(per);
		matr.setCompetencia(comp);
		this.matriz.save(matr);
		return Integer.parseInt((matr.getIdmatriz()).toString());
	}
	
	@RequestMapping(value = MatrizRestURIConstant.UPDATE_MATRIZ, method = RequestMethod.POST)	
	public void Actualizar(@ModelAttribute Matriz matr, @PathVariable Long idPersona, @PathVariable Long idCompetencia){	
		Persona per=perService.findById(idPersona);
		Competencia comp=compService.findById(idCompetencia);
		matr.setPersona(per);
		matr.setCompetencia(comp);
		this.matriz.update(matr);
	}
	
	
	@RequestMapping(value=MatrizRestURIConstant.GET_MATRIZ,method = RequestMethod.GET,headers="Accept=application/json")
	public Matriz GetMatriz(@PathVariable Long id){
		return this.matriz.findById(id);				
	}
	
	@RequestMapping(value=MatrizRestURIConstant.GET_ALL_MATRIZ,method = RequestMethod.GET,headers="Accept=application/json")
	public List<Matriz> getAll(){
		return this.matriz.findAll();		
	}
	
	
}
