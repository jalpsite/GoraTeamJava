package com.gora.web.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gora.dominio.Atributos;
import com.gora.dominio.Competencia;
import com.gora.dominio.Habilidad;
import com.gora.dominio.Matriz;
import com.gora.dominio.Persona;
import com.gora.services.AtributoService;
import com.gora.services.AtributosService;
import com.gora.services.CompetenciaService;
import com.gora.services.HabilidadService;
import com.gora.services.MatrizService;
import com.gora.services.PersonaService;
import com.gora.web.uri.MatrizRestURIConstant;



@RestController
@RequestMapping("/matriz") 
public class MatrizController {
	
	@Autowired
	MatrizService matriz;
	
	@Autowired
	HabilidadService habilidadService;
	
	@Autowired
	AtributosService atributosService;
	
	@Autowired
	AtributoService atributoService;
	
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
	public void Actualizar(@ModelAttribute Matriz matr, @PathVariable Long idCompetencia){
		List<Habilidad> lstHabilidades=habilidadService.getHabilidadXMatriz(matr.getIdmatriz());
		
		//Eliminacion de atributos de todas las habilidades
		boolean delAtributos=true;		
		for(Habilidad h:lstHabilidades){
			if(!atributosService.eliminarXHabilidad(h.getIdhabilidad())){
				delAtributos=false;
				break;
			}
		}	
		
		//Eliminacion de todas las habilidades		
		if(delAtributos){			
			if(habilidadService.eliminarXMatriz(matr.getIdmatriz())){
				//Actualiza la Competencia segun el ID de Matriz 
				Matriz objMatriz=matriz.findById(matr.getIdmatriz());
				Competencia comp=compService.findById(idCompetencia);		
				objMatriz.setCompetencia(comp);
				this.matriz.update(objMatriz);		
			}			
		}							
		
	}
	
	
	@RequestMapping(value=MatrizRestURIConstant.GET_MATRIZ,method = RequestMethod.GET,headers="Accept=application/json")
	public Matriz GetMatriz(@PathVariable Long id){
		return this.matriz.findById(id);				
	}
	
	@RequestMapping(value=MatrizRestURIConstant.GET_ALL_MATRIZ,method = RequestMethod.GET,headers="Accept=application/json")
	public List<Matriz> getAll(){
		return this.matriz.findAll();		
	}
	
	@RequestMapping(value=MatrizRestURIConstant.DESHABILITAR_MATRIZ,method = RequestMethod.POST)
	public String deshabilitarMatriz(@PathVariable Long idMatriz){
		String res="No se pudo deshabilitar Matriz";
		List<Habilidad> lst=habilidadService.getHabilidadXMatriz(idMatriz);
		
		for(Habilidad h:lst){			
			List<Atributos> l=habilidadService.getAtributosXHabilidad(h.getIdhabilidad());
			for(Atributos a:l){
				atributosService.eliminar(a.getIdatributos());
			}
			habilidadService.eliminar(h.getIdhabilidad());
		}
		
		if(matriz.deshabilitarMatriz(idMatriz)){			
			res="Matriz deshabilitada";						
		}
		return res;
	}
	
	@RequestMapping(value=MatrizRestURIConstant.GET_MATRIZ_DETALLES,method = RequestMethod.GET,headers="Accept=application/json")
	public Object getMatriz(@PathVariable Long idPersona){
		return this.matriz.getMatriz(idPersona);		
	}
	
}
