package com.gora.web.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.gora.dominio.Evaluacion;
import com.gora.services.EvaluacionService;
import com.gora.services.MatrizService;
import com.gora.services.PersonaService;
import com.gora.services.ProyectoService;
import com.gora.web.uri.EvaluacionRestURIConstant;


@RestController
@RequestMapping("/evaluacion") 
public class EvaluacionController {
	
	@Autowired
	EvaluacionService evaluacionService;
	
	@Autowired
	MatrizService matrizService;
	
	@Autowired
	PersonaService personaService;
	
	@Autowired
	ProyectoService proyectoService;
	
		
	@RequestMapping(value = EvaluacionRestURIConstant.CREATE_EVALUACION, method = RequestMethod.POST)	
	public int Agregar(@ModelAttribute Evaluacion eval, @PathVariable Long idMatriz, @PathVariable Long idPersona, @PathVariable Long idProyecto){	
		eval.setMatriz(matrizService.findById(idMatriz));
		eval.setPersona(personaService.findById(idPersona));
		eval.setProyecto(proyectoService.findById(idProyecto));
		evaluacionService.save(eval);
		return Integer.parseInt((eval.getIdevaluacion()).toString());
	}
	
	@RequestMapping(value = EvaluacionRestURIConstant.UPDATE_EVALUACION, method = RequestMethod.POST)	
	public void Actualizar(@ModelAttribute Evaluacion eval, @PathVariable Long idMatriz, @PathVariable Long idPersona, @PathVariable Long idProyecto){	
		eval.setMatriz(matrizService.findById(idMatriz));
		eval.setPersona(personaService.findById(idPersona));
		eval.setProyecto(proyectoService.findById(idProyecto));
		evaluacionService.update(eval);		
	}
			
	@RequestMapping(value = EvaluacionRestURIConstant.GET_EVALUACION, method = RequestMethod.GET,  headers = "Accept=application/json")	
	public Evaluacion getEvaluacion(@PathVariable Long id){	
		return evaluacionService.findById(id);
	}
	
	@RequestMapping(value = EvaluacionRestURIConstant.GET_ALL_EVALUCAIONES, method = RequestMethod.GET,  headers = "Accept=application/json")	
	public List<Evaluacion> AllEvaluaciones(){	
		return evaluacionService.findAll();
	}	
		
}
