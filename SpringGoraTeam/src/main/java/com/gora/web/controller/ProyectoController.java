package com.gora.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gora.dominio.Atributo;
import com.gora.dominio.Habilidad;
import com.gora.dominio.Habilidades;
import com.gora.dominio.Matriz;
import com.gora.dominio.Persona;
import com.gora.dominio.Proyecto;
import com.gora.dominio.Tipoproyecto;
import com.gora.services.AtributosService;
import com.gora.services.ClientService;
import com.gora.services.HabilidadService;
import com.gora.services.HabilidadesService;
import com.gora.services.IniciativaService;
import com.gora.services.MatrizService;
import com.gora.services.PersonaService;
import com.gora.services.PortafolioService;
import com.gora.services.ProyectoService;
import com.gora.services.TipoproyectoService;
import com.gora.web.uri.HabilidadRestURIConstant;
import com.gora.web.uri.ProyectoRestURIConstant;



@RestController
@RequestMapping("/proyecto") 
public class ProyectoController {
	
	@Autowired
	ProyectoService proyectoService;
	
	@Autowired
	ClientService clienteService;
	
	@Autowired
	IniciativaService iniciativaService;
	
	@Autowired
	PersonaService PersonaService;
	
	@Autowired
	PortafolioService portafolioService;
	
	@Autowired
	TipoproyectoService tipoProyectoService;
		
	//{idCliente}/{idIniciativa}/{idPersona}/{idPortafolio}/{idTipoProyecto}
	@RequestMapping(value = ProyectoRestURIConstant.CREATE_PROYECTO, method = RequestMethod.POST)	
	public int Agregar(@ModelAttribute Proyecto proy,@PathVariable Long idCliente, @PathVariable Long idIniciativa,@PathVariable Long idPersona, @PathVariable Long idPortafolio,@PathVariable Long idTipoProyecto){
		proy.setCliente(clienteService.findById(idCliente));
		proy.setIniciativa(iniciativaService.findById(idIniciativa));
		proy.setPersona(PersonaService.findById(idPersona));
		proy.setPortafolio(portafolioService.findById(idPortafolio));
		proy.setTipoproyecto(tipoProyectoService.findById(idTipoProyecto));
		proyectoService.save(proy);
		return Integer.parseInt((proy.getIdproyecto()).toString());
	}
	
	@RequestMapping(value = ProyectoRestURIConstant.UPDATE_PROYECTO, method = RequestMethod.POST)	
	public void Actualizar(@ModelAttribute Proyecto proy,@PathVariable Long idCliente, @PathVariable Long idIniciativa,@PathVariable Long idPersona, @PathVariable Long idPortafolio,@PathVariable Long idTipoProyecto){
		proy.setCliente(clienteService.findById(idCliente));
		proy.setIniciativa(iniciativaService.findById(idIniciativa));
		proy.setPersona(PersonaService.findById(idPersona));
		proy.setPortafolio(portafolioService.findById(idPortafolio));
		proy.setTipoproyecto(tipoProyectoService.findById(idTipoProyecto));
		proyectoService.update(proy);
	}
	
	
	@RequestMapping(value=ProyectoRestURIConstant.GET_PROYECTO,method = RequestMethod.GET,headers="Accept=application/json")
	public Proyecto GetProyecto(@PathVariable Long id){
		return this.proyectoService.findById(id);				
	}
	
	@RequestMapping(value=ProyectoRestURIConstant.GET_ALL_PROYECTOS,method = RequestMethod.GET,headers="Accept=application/json")
	public List<Proyecto> getAll(){
		return this.proyectoService.findAll();		
	}
		
}
