package com.gora.web.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gora.dominio.AtributosCertificacion;
import com.gora.services.AtributosCertificacionService;
import com.gora.services.AtributosService;
import com.gora.web.uri.AtributosCertificacionRestURIConstant;


@RestController
@RequestMapping("/atributoscertificacion") 
public class AtributosCertificacionController {
		
	@Autowired
	private AtributosService atribService;
	@Autowired
	private AtributosCertificacionService atribCertService;
	
	@RequestMapping(value = AtributosCertificacionRestURIConstant.CREATE_ATRIBUTOS_CERT, method = RequestMethod.POST)				
	public Long Agregar(@ModelAttribute AtributosCertificacion cert, @PathVariable Long idAtributos){
		cert.setAtributos(atribService.findById(idAtributos));
		atribCertService.save(cert);
		if(cert.getIdatributocertificacion()!=null)
			return cert.getIdatributocertificacion();
		else
			return new Long("0");
	}
	
	@RequestMapping(value = AtributosCertificacionRestURIConstant.UPDATE_ATRIBUTOS_CERT, method = RequestMethod.POST)				
	public void Actualizar(@ModelAttribute AtributosCertificacion cert, @PathVariable Long idAtributos){
		cert.setAtributos(atribService.findById(idAtributos));
		atribCertService.update(cert);
	}
	
	@RequestMapping(value = AtributosCertificacionRestURIConstant.DELETE_ATRIBUTOS_CERT, method = RequestMethod.POST)				
	public int delete(@PathVariable Long id){
		return atribCertService.eliminarCertificacion(id);
	}
	
	@RequestMapping(value = AtributosCertificacionRestURIConstant.GET_CERT_ATRIBUTOS, method = RequestMethod.GET)				
	public List<AtributosCertificacion> getCertAtributos(@PathVariable Long idAtributos){
		return atribCertService.getCertificacionesXAtributos(idAtributos);
	}
		
					
	
}
