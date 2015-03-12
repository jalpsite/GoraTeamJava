package com.gora.web.controller;

//import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gora.services.ListasService;
import com.gora.services.RolService;
import com.gora.web.uri.ListasRestURIConstant;
import com.gora.dominio.Atributo;
import com.gora.dominio.Cargo;
import com.gora.dominio.Carrera;
import com.gora.dominio.Competencia;
import com.gora.dominio.Grado;
import com.gora.dominio.Habilidades;
import com.gora.dominio.Lista;
import com.gora.dominio.Rol;
import com.gora.dominio.Tipodocumento;
import com.gora.dominio.Tipoproyecto;
import com.gora.dominio.Ubigeo;
import com.gora.dominio.Universidad;
 
@RestController
@RequestMapping("/listas") 
public class ListasController {

	@Autowired
    ListasService listasService; 
	
	@Autowired
	RolService rolService;	
	 
	 public ListasService getListas() {
		return listasService;
	}		
	
	@RequestMapping(value = ListasRestURIConstant.GET_DEPARTAMENTOS, method = RequestMethod.GET,headers="Accept=application/json")
	public List<Ubigeo> getDepartamentos() {
		return listasService.getDepartamentos();		 				
	 }
	
	@RequestMapping(value = ListasRestURIConstant.GET_PROVINCIAS, method = RequestMethod.GET,headers="Accept=application/json")
	public List<Ubigeo> getProvincias(@PathVariable String dep) {
		return listasService.getProvincias(dep);	 			 			 				
	 }
    
	@RequestMapping(value = ListasRestURIConstant.GET_DISTRITOS, method = RequestMethod.GET,headers="Accept=application/json")
	public List<Ubigeo> getDistritos(@PathVariable String dep,@PathVariable String prov) {
		return listasService.getDistritos(dep, prov);		 				
	 }
	
	@RequestMapping(value = ListasRestURIConstant.GET_UNIVERSIDADES, method = RequestMethod.GET,headers="Accept=application/json")
	public List<Universidad> getUniversidades() {
		return listasService.getUniversidades();		 				
	 }
	
	@RequestMapping(value = ListasRestURIConstant.GET_CARRERAS, method = RequestMethod.GET,headers="Accept=application/json")
	public List<Carrera> getCarreras() {
		return listasService.getCarreras();	 				
	 }
	
	@RequestMapping(value = ListasRestURIConstant.GET_GRADOS, method = RequestMethod.GET,headers="Accept=application/json")
	public List<Grado> getGrados() {
		return listasService.getGrados();			
	 }
	
	@RequestMapping(value = ListasRestURIConstant.GET_COMPETENCIAS, method = RequestMethod.GET,headers="Accept=application/json")
	public List<Competencia> getCompetencias() {
		return listasService.getCompetencias();
	}
	
	@RequestMapping(value = ListasRestURIConstant.GET_ATRIBUTOS, method = RequestMethod.GET,headers="Accept=application/json")
	public List<Atributo> getAtributos() {
		return listasService.getAtributos();
	}
	
	@RequestMapping(value = ListasRestURIConstant.GET_HABILIDADES, method = RequestMethod.GET,headers="Accept=application/json")
	public List<Habilidades> getHabilidades() {
		return listasService.getHabilidades();
	}
	
	
	@RequestMapping(value = ListasRestURIConstant.GET_TIPO_DOCUMENTOS, method = RequestMethod.GET,headers="Accept=application/json")
	public List<Tipodocumento> getTipoDocumentos() {
		return listasService.getTipoDocumentos();
	}
	
	@RequestMapping(value = ListasRestURIConstant.GET_CARGOS, method = RequestMethod.GET,headers="Accept=application/json")
	public List<Cargo> getCargos() {
		return listasService.getCargos();
	}
	
	/*
	 * LISTAS DESDE LA BD
	 * */
	
	@RequestMapping(value = ListasRestURIConstant.GET_NACIONALIDAD, method = RequestMethod.GET,headers="Accept=application/json")
	public List<Lista> getNacionalidad() {
		return listasService.getLista(Long.parseLong("1"));
	}
	
	@RequestMapping(value = ListasRestURIConstant.GET_TIPO_EMAIL, method = RequestMethod.GET,headers="Accept=application/json")
	public List<Lista> getTipoEmail() {
		return listasService.getLista(Long.parseLong("2"));
	}
	
	@RequestMapping(value = ListasRestURIConstant.GET_TIPO_TELEFONO, method = RequestMethod.GET,headers="Accept=application/json")
	public List<Lista> getTipoTelefono() {
		return listasService.getLista(Long.parseLong("3"));
	}
	
	@RequestMapping(value = ListasRestURIConstant.GET_TIPO_DIRECCION, method = RequestMethod.GET,headers="Accept=application/json")
	public List<Lista> getTipoDireccion() {
		return listasService.getLista(Long.parseLong("4"));
	}
	
	@RequestMapping(value = ListasRestURIConstant.GET_ESTADO_CIVIL, method = RequestMethod.GET,headers="Accept=application/json")
	public List<Lista> getEstadoCivil() {
		return listasService.getLista(Long.parseLong("5"));
	}
	
	@RequestMapping(value = ListasRestURIConstant.GET_NIVEL_ESTUDIO, method = RequestMethod.GET,headers="Accept=application/json")
	public List<Lista> getNivelEstudio() {
		return listasService.getLista(Long.parseLong("6"));
	}
	
	@RequestMapping(value = ListasRestURIConstant.GET_TIPO_ARCHIVO, method = RequestMethod.GET,headers="Accept=application/json")
	public List<Lista> getTipoArchivo() {
		return listasService.getLista(Long.parseLong("7"));
	}
	
	@RequestMapping(value = ListasRestURIConstant.GET_TIPO_PROYECTO, method = RequestMethod.GET,headers="Accept=application/json")
	public List<Tipoproyecto> getTipoProyecto() {
		return listasService.getTipoProyecto();
	}
			
	@RequestMapping(value = ListasRestURIConstant.GET_UBIGEO, method = RequestMethod.GET,headers="Accept=application/json")
	public List<Ubigeo> getUbigeo(@PathVariable Long idUbigeo) {
		return listasService.getUbigeo(idUbigeo);
	}
	
	@RequestMapping(value = ListasRestURIConstant.GET_ROLES, method = RequestMethod.GET,headers="Accept=application/json")
	public List<Rol> getRoles() {
		return rolService.findAll();
	}
	
	
}
