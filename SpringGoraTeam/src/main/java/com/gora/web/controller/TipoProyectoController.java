package com.gora.web.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.gora.dominio.Tipoproyecto;
import com.gora.services.TipoproyectoService;
import com.gora.web.uri.TipoProyectoRestURIConstant;

@RestController
@RequestMapping("/tipoproyecto") 
public class TipoProyectoController {
	
	@Autowired
	TipoproyectoService tipoProyecto;
	
	
	@RequestMapping(value = TipoProyectoRestURIConstant.CREATE_TIPO_PROYECTO, method = RequestMethod.POST)
	public int agregarTipoProyecto(@ModelAttribute Tipoproyecto t_proy) {
		this.tipoProyecto.save(t_proy);
		return Integer.parseInt((t_proy.getIdtipoproyecto()).toString());
	}
	
	@RequestMapping(value = TipoProyectoRestURIConstant.UPDATE_TIPO_PROYECTO, method = RequestMethod.POST)
	public void actualizarTipoProyecto(@ModelAttribute Tipoproyecto t_proy) {
		this.tipoProyecto.update(t_proy);		
	}	
		
	@RequestMapping(value=TipoProyectoRestURIConstant.GET_TIPO_PROYECTO,method = RequestMethod.GET,headers="Accept=application/json")
	public Tipoproyecto buscar(@PathVariable Long id){
		return this.tipoProyecto.findById(id);				
	}
	
	@RequestMapping(value=TipoProyectoRestURIConstant.GET_ALL_TIPO_PROYECTO,method = RequestMethod.GET,headers="Accept=application/json")
	public List<Tipoproyecto> getAll(){
		return tipoProyecto.findAll();		
	}
		
	
}
