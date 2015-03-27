package com.gora.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;

import com.gora.dominio.Certificaciones;

import com.gora.services.CertificacionesService;
import com.gora.web.uri.CertificacionesRestURIConstant;



@RestController
@RequestMapping("/certificaciones") 
public class CertificacionesController {
	
	@Autowired
	CertificacionesService certiService;
	
	
	@RequestMapping(value = CertificacionesRestURIConstant.GET_CERT_HABILIDADES, method = RequestMethod.GET)	
	public List<Certificaciones> getCertificacionXHabilidad(@PathVariable Long idHabilidades){	
		return certiService.getCertificacionXHabilidad(idHabilidades);
	}
	
	
	
}
