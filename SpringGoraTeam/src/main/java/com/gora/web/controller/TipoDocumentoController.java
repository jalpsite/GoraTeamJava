package com.gora.web.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;

import com.gora.dominio.Tipodocumento;
import com.gora.services.TipodocumentoService;

import com.gora.web.uri.TipoDocumentoRestURIConstant;

@RestController
@RequestMapping("/tipodocumento") 
public class TipoDocumentoController {
	
	@Autowired
	TipodocumentoService tipoDocumento;
	
	
	@RequestMapping(value = TipoDocumentoRestURIConstant.CREATE_TIPODOCUMENTO, method = RequestMethod.POST)
	public int agregarTipoDocumento(@ModelAttribute Tipodocumento doc) {
		this.tipoDocumento.save(doc);
		return Integer.parseInt((doc.getIdtipodocumento()).toString());
	}
	
	@RequestMapping(value = TipoDocumentoRestURIConstant.UPDATE_TIPODOCUMENTO, method = RequestMethod.POST)
	public void actualizarTipoDocumento(@ModelAttribute Tipodocumento doc) {
		this.tipoDocumento.update(doc);		
	}
	
		
	@RequestMapping(value=TipoDocumentoRestURIConstant.GET_TIPODOCUMENTO,method = RequestMethod.GET,headers="Accept=application/json")
	public Tipodocumento buscar(@PathVariable Long id){
		return this.tipoDocumento.findById(id);				
	}
	
	@RequestMapping(value=TipoDocumentoRestURIConstant.GET_ALL_TIPODOCUMENTO,method = RequestMethod.GET,headers="Accept=application/json")
	public List<Tipodocumento> getAll(){
		return tipoDocumento.findAll();		
	}
	
	
	
}
