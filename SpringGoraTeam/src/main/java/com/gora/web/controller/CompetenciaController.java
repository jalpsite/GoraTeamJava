package com.gora.web.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gora.dominio.Competencia;
import com.gora.dominio.Habilidad;
import com.gora.services.CompetenciaService;
import com.gora.web.uri.CompetenciaRestURIConstant;


@RestController
@RequestMapping("/competencia") 
public class CompetenciaController {
	
	@Autowired
	CompetenciaService competencia;	
		

	@RequestMapping(value = CompetenciaRestURIConstant.CREATE_COMPETENCIA, method = RequestMethod.POST)	
	public int Agregar(@ModelAttribute Competencia comp){				
		this.competencia.save(comp);
		return Integer.parseInt((comp.getIdcompetencia()).toString());
	}
	
	@RequestMapping(value = CompetenciaRestURIConstant.UPDATE_COMPETENCIA, method = RequestMethod.POST)	
	public void Actualizar(@ModelAttribute Competencia comp){				
		this.competencia.update(comp);		
	}	
	
	@RequestMapping(value=CompetenciaRestURIConstant.GET_COMPETENCIA,method = RequestMethod.GET,headers="Accept=application/json")
	public Competencia GetCompetencia(@PathVariable Long id){
		return this.competencia.findById(id);			
	}
	
	@RequestMapping(value=CompetenciaRestURIConstant.GET_ALL_COMPETENCIA,method = RequestMethod.GET,headers="Accept=application/json")
	public List<Competencia> getAll(){
		return this.competencia.findAll();		
	}
	
	@RequestMapping(value=CompetenciaRestURIConstant.GET_HABILIDADES,method = RequestMethod.GET,headers="Accept=application/json")
	public List<Habilidad> GetHabilidades(@PathVariable Long id){
		return this.competencia.getHabilidades(id);			
	}
}
