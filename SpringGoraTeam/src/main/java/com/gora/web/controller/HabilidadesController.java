package com.gora.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gora.dominio.Competencia;
import com.gora.dominio.Habilidades;
import com.gora.services.CompetenciaService;
import com.gora.services.HabilidadesService;
import com.gora.web.uri.HabilidadesRestURIConstant;

@RestController
@RequestMapping("/habilidades")
public class HabilidadesController {

	@Autowired
	HabilidadesService habilidad;
	
	@Autowired
	CompetenciaService compService;

	@RequestMapping(value = HabilidadesRestURIConstant.CREATE_HABILIDADES, method = RequestMethod.POST)
	public int Agregar(@ModelAttribute Habilidades hab, @PathVariable Long idCompetencia) {	
		Competencia comp=compService.findById(idCompetencia);
		hab.setCompetencia(comp);
		this.habilidad.save(hab);		
		return Integer.parseInt((hab.getIdhabilidades()).toString());
	}

	@RequestMapping(value = HabilidadesRestURIConstant.UPDATE_HABILIDADES, method = RequestMethod.POST)
	public void Actualizar(@ModelAttribute Habilidades hab, @PathVariable Long idCompetencia) {
		Competencia comp=compService.findById(idCompetencia);
		hab.setCompetencia(comp);
		this.habilidad.update(hab);	
	}
	

	@RequestMapping(value = HabilidadesRestURIConstant.GET_HABILIDADES, method = RequestMethod.GET, headers = "Accept=application/json")
	public Habilidades GetHabilidad(@PathVariable Long id) {
		return this.habilidad.findById(id);
	}

	@RequestMapping(value = HabilidadesRestURIConstant.GET_ALL_HABILIDADES, method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Habilidades> getAll() {
		return this.habilidad.findAll();
	}

}
