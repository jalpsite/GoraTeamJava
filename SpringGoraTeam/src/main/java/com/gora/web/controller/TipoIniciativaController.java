package com.gora.web.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.gora.dominio.Tipoiniciativa;
import com.gora.services.TipoIniciativaService;
import com.gora.web.uri.TipoIniciativaRestURIConstant;

@RestController
@RequestMapping("/tipoiniciativa") 
public class TipoIniciativaController {
	
	@Autowired
	TipoIniciativaService tipoIniciativa;
	
	
	@RequestMapping(value = TipoIniciativaRestURIConstant.CREATE_TIPO_INICIATIVA, method = RequestMethod.POST)
	public int agregarTipoIniciativa(@ModelAttribute Tipoiniciativa t_ini) {
		this.tipoIniciativa.save(t_ini);
		return Integer.parseInt((t_ini.getIdtipoiniciativa()).toString());
	}
	
	@RequestMapping(value = TipoIniciativaRestURIConstant.UPDATE_TIPO_INICIATIVA, method = RequestMethod.POST)
	public void actualizarTipoIniciativa(@ModelAttribute Tipoiniciativa t_ini) {
		this.tipoIniciativa.update(t_ini);		
	}
	
		
	@RequestMapping(value=TipoIniciativaRestURIConstant.GET_TIPO_INICIATIVA,method = RequestMethod.GET,headers="Accept=application/json")
	public Tipoiniciativa buscar(@PathVariable Long id){
		return this.tipoIniciativa.findById(id);				
	}
	
	@RequestMapping(value=TipoIniciativaRestURIConstant.GET_ALL_TIPO_INICIATIVA,method = RequestMethod.GET,headers="Accept=application/json")
	public List<Tipoiniciativa> getAll(){
		return tipoIniciativa.findAll();		
	}
	
	
	
}
