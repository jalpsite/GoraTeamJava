package com.gora.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gora.services.ArchivoService;
import com.gora.services.AtributosService;
import com.gora.services.CargoService;
import com.gora.services.CompetenciaService;
import com.gora.services.ExperienciaService;
import com.gora.services.FormacionService;
import com.gora.services.HabilidadService;
import com.gora.services.MatrizService;
import com.gora.services.PersonaDatosService;
import com.gora.services.PersonaService;
import com.gora.services.UbigeoService;
import com.gora.services.UsuarioService;
import com.gora.util.PdfCV;
import com.gora.dominio.Archivo;
import com.gora.dominio.Atributo;
import com.gora.dominio.Atributos;
import com.gora.dominio.Competencia;
import com.gora.dominio.Experiencia;
import com.gora.dominio.Formacion;
import com.gora.dominio.Habilidad;
import com.gora.dominio.Habilidades;
import com.gora.dominio.Matriz;
import com.gora.dominio.Persona;
import com.gora.dominio.PersonaDireccion;
import com.gora.dominio.PersonaEmail;
import com.gora.dominio.PersonaTelefono;
import com.gora.dominio.Usuario;
import com.gora.dominio.UsuarioRol;
import com.gora.web.uri.PersonaRestURIConstant;

@RestController
@RequestMapping("/persona")
public class PersonaController {

	@Autowired
	PersonaService perService;

	@Autowired
	PersonaDatosService perDatosService;

	@Autowired
	ExperienciaService expeServices;

	@Autowired
	FormacionService formaServices;
	
	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	ArchivoService archivoService;
	
	@Autowired
	UbigeoService ubigeoService;
	
	@Autowired
	CargoService cargoService;
	
	@Autowired
	HabilidadService habilidadService;
	
	@Autowired
	AtributosService atributosService;
	
	@Autowired
	MatrizService matrizService;
	
	@Autowired
	CompetenciaService compService;
	/*
	 * PERSONA
	 */

	@RequestMapping(value = PersonaRestURIConstant.CREATE_PERSONA, method = RequestMethod.POST)
	public int savePersona(@ModelAttribute Persona per) {
		this.perService.save(per);
		return Integer.parseInt((per.getIdpersona()).toString());
	}

	@RequestMapping(value = PersonaRestURIConstant.UPDATE_PERSONA, method = RequestMethod.POST)
	public int updatePersona(@ModelAttribute Persona per, @PathVariable Long idUsuario) {
		per.setUsuario(usuarioService.findById(idUsuario));
		this.perService.update(per);
		return Integer.parseInt((per.getIdpersona()).toString());
	}

	@RequestMapping(value = PersonaRestURIConstant.GET_PERSONA, method = RequestMethod.GET, headers = "Accept=application/json")
	public Persona GetPersona(@PathVariable Long id) {
		//Persona p = this.perService.findById(id);
		Persona p = this.perService.getPersona(id);
		return p;
	}

	@RequestMapping(value = PersonaRestURIConstant.GET_ALL_PERSONA, method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Persona> LstPersona() {
		return this.perService.findAll();
	}

	/*
	@RequestMapping(value = PersonaRestURIConstant.PERSONA_LOGIN, method = RequestMethod.POST)
	public Object login(@RequestParam String correo, @RequestParam String dni) {
		return perService.login(correo, dni);
	}
	*/

	/*
	 * VALIDACION LA EXISTENCIA DEL DOCUMENTO
	 */

	@RequestMapping(value = PersonaRestURIConstant.PERSONA_VALIDA_DOCUMENTO, method = RequestMethod.GET, headers = "Accept=application/json")
	public int valDocumento(@PathVariable String doc) {
		return perService.validarDNI(doc);
	}

	/*
	 * EXTRACCION DE DATOS POR PERSONA
	 */

	@RequestMapping(value = PersonaRestURIConstant.GET_PERSONA_JEFE, method = RequestMethod.GET, headers = "Accept=application/json")
	public Persona getJefe(@PathVariable Long id) {
		Long idPer = perService.getIDJefe(id);
		if (idPer != 0) {
			return GetPersona(idPer);
		} else {
			return null;

		}
	}

	@RequestMapping(value = PersonaRestURIConstant.GET_PERSONA_COMPETENCIAS, method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Competencia> getCompetencias(@PathVariable Long id) {
		return perService.getCompetencias(id);
	}

	@RequestMapping(value = PersonaRestURIConstant.GET_PERSONA_HABILIDADES, method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Habilidades> getHabilidades(@PathVariable Long id) {
		return perService.getHabilidades(id);
	}

	@RequestMapping(value = PersonaRestURIConstant.GET_PERSONA_ATRIBUTOS, method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Atributo> getAtributos(@PathVariable Long id) {
		return perService.getAtributos(id);
	}

	@RequestMapping(value = PersonaRestURIConstant.GET_PERSONA_HABILIDADES_X_COMPETENCIA, method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Habilidades> getHabilidadesXCompetencia(
			@PathVariable Long idPersona, @PathVariable Long idCompetencia) {
		return perService.getHabilidadesXCompetencia(idPersona, idCompetencia);
	}

	@RequestMapping(value = PersonaRestURIConstant.GET_PERSONA_ATRIBUTOS_X_HABIILIDAD, method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Atributo> getAtributosXHabilidad(@PathVariable Long idPersona,
			@PathVariable Long idCompetencia, @PathVariable Long idHabilidad) {

		return perService.getAtributosXHabilidad(idPersona, idCompetencia,
				idHabilidad);
	}

	/*
	 * PERSONA BUSQUEDAS Y FILTROS
	 */

	@RequestMapping(value = PersonaRestURIConstant.GET_PERSONA_DNI, method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Persona> getPersonaByDNI(@PathVariable String dniPersona) {
		return this.perDatosService.getPersonaByDNI(dniPersona);
	}

	@RequestMapping(value = PersonaRestURIConstant.GET_PERSONA_NOMBRE_APELLIDO, method = RequestMethod.POST, headers = "Accept=application/json")
	public List<Persona> getPersonaByNomApe(
			@RequestParam String nombres) {
		return this.perDatosService.getPersonaByNomApe(nombres);
	}
	/*
	@RequestMapping(value = PersonaRestURIConstant.PERSONA_FILTRO, method = RequestMethod.POST)
	public List<Persona> filtroPersona(
			@RequestParam(required = false, defaultValue = "") String[] competencias,
			@RequestParam(required = false, defaultValue = "") String[] habilidades,
			@RequestParam(required = false, defaultValue = "") String[] atributos,@PathVariable int pagina) {
		return perService.filtroPersonas(competencias, habilidades, atributos,pagina);

	}
	*/		

	/*
	 * UPDATE PERSONA PARTICIONADO
	 */
	@RequestMapping(value = PersonaRestURIConstant.UPDATE_PERSONA_PART, method = RequestMethod.POST)
	public Persona updatePersonaPart(@PathVariable int opcion,
			@ModelAttribute Persona per) {
		return perService.updateDatos(opcion, per);
	}

	/*
	 * EMAILS
	 */

	/*
	 * //ACTUALIZADO SINGULAR
	 */
	@RequestMapping(value = PersonaRestURIConstant.UPDATESINGLE_EMAIL, method = RequestMethod.POST)
	public PersonaEmail upEmail(@ModelAttribute PersonaEmail perEmail,
			@PathVariable Long idPersona) {
		perEmail.setPersona(this.GetPersona(idPersona));
		this.perService.actualizarEmail(perEmail);
		System.out.println(perEmail.getIdpersonaemail());
		return perEmail;
	}

	// GUARDADO DE ARREGLO
	@RequestMapping(value = PersonaRestURIConstant.CREATE_EMAIL, method = RequestMethod.POST)
	public void saveEmailArreglo(@RequestBody PersonaEmail[] perEmail,
			@PathVariable Long idPersona) {
		Persona per = this.GetPersona(idPersona);
		for (PersonaEmail em : perEmail) {
			em.setPersona(per);
			this.perService.agregarEmail(em);
		}
	}

	@RequestMapping(value = PersonaRestURIConstant.UPDATE_EMAIL, method = RequestMethod.POST)
	public void updateEmail(@RequestBody PersonaEmail[] perEmail,
			@PathVariable Long idPersona) {
		Persona per = this.GetPersona(idPersona);
		for (PersonaEmail em : perEmail) {
			em.setPersona(per);
			this.perService.actualizarEmail(em);
		}
	}

	@RequestMapping(value = PersonaRestURIConstant.GET_PERSONA_EMAIL, method = RequestMethod.GET, headers = "Accept=application/json")
	public List<PersonaEmail> getPersonaCorreo(@PathVariable Long id) {
		return perService.getEmail(id);
	}

	/*
	 * TELEFONO
	 */

	/*
	 * // ACTUALIZADO SINGULAR
	 */
	@RequestMapping(value = PersonaRestURIConstant.UPDATESINGLE_PHONE, method = RequestMethod.POST)
	public PersonaTelefono upTelefono(@ModelAttribute PersonaTelefono perTel,
			@PathVariable Long idPersona) {
		System.out.println(perTel.getIdpersonatelefono());
		System.out.println(perTel.getEstado());
		System.out.println(perTel.getTelefono());
		perTel.setPersona(this.GetPersona(idPersona));
		this.perService.actualizarTelefono(perTel);
		return perTel;
	}

	// GUARDADO DE ARREGLO
	@RequestMapping(value = PersonaRestURIConstant.CREATE_PHONE, method = RequestMethod.POST)
	public void saveTelefonoArreglo(@RequestBody PersonaTelefono[] perTel,
			@PathVariable Long idPersona) {
		Persona per = this.GetPersona(idPersona);
		for (PersonaTelefono tel : perTel) {
			tel.setPersona(per);
			this.perService.agregarTelefono(tel);
		}
	}

	@RequestMapping(value = PersonaRestURIConstant.UPDATE_PHONE, method = RequestMethod.POST)
	public void updateTelefono(@RequestBody PersonaTelefono[] perTel,
			@PathVariable Long idPersona) {
		Persona per = this.GetPersona(idPersona);
		for (PersonaTelefono tel : perTel) {
			tel.setPersona(per);
			this.perService.actualizarTelefono(tel);
		}
	}

	@RequestMapping(value = PersonaRestURIConstant.GET_PERSONA_PHONE, method = RequestMethod.GET, headers = "Accept=application/json")
	public List<PersonaTelefono> getPersonaTelefono(@PathVariable Long id) {
		return perService.getTelefono(id);
	}

	/*
	 * DIRECCION
	 */

	// ACTUALIZAR SINGULAR
	@RequestMapping(value = PersonaRestURIConstant.UPDATESINGLE_ADDRESS, method = RequestMethod.POST)
	public PersonaDireccion upDireccion(
			@ModelAttribute PersonaDireccion perDir,
			@PathVariable Long idPersona) {
		
		perDir.setPersona(this.GetPersona(idPersona));
		this.perService.actualizarDireccion(perDir);
		return perDir;
	}

	// GUARDADO DE ARREGLO
	@RequestMapping(value = PersonaRestURIConstant.CREATE_ADDRESS, method = RequestMethod.POST)
	public void saveDireccionArreglo(@RequestBody PersonaDireccion[] perDir,
			@PathVariable Long idPersona) {
		Persona per = this.GetPersona(idPersona);
		for (PersonaDireccion dir : perDir) {
			dir.setPersona(per);
			this.perService.agregarDireccion(dir);
		}
	}

	@RequestMapping(value = PersonaRestURIConstant.UPDATE_ADDRESS, method = RequestMethod.POST)
	public void updateDireccion(@RequestBody PersonaDireccion[] perDir,
			@PathVariable Long idPersona) {
		Persona per = this.GetPersona(idPersona);
		for (PersonaDireccion dir : perDir) {
			dir.setPersona(per);
			this.perService.actualizarDireccion(dir);
		}
	}

	@RequestMapping(value = PersonaRestURIConstant.GET_PERSONA_ADDRESS, method = RequestMethod.GET, headers = "Accept=application/json")
	public List<PersonaDireccion> getPersonaDireccion(@PathVariable Long id) {
		return perService.getDireccion(id);
	}

	/* EXPERIENCIA */
	@RequestMapping(value = PersonaRestURIConstant.GET_PERSONA_EXPERIENCIAS, method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Experiencia> getPersonaExperiencias(@PathVariable Long id) {
		return expeServices.getExperienciasPersona(id);
	}

	/* FORMACION */
	@RequestMapping(value = PersonaRestURIConstant.GET_PERSONA_FORMACION, method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Formacion> getPersonaFormacion(@PathVariable Long id) {
		return formaServices.getFormacionPersona(id);
	}
	
	
	
	@RequestMapping(value = PersonaRestURIConstant.DESACTIVAR_ADDRESS, method = RequestMethod.POST)
	public void desactivarDireccion(@PathVariable Long idDireccion) {
		perService.estadoDireccion(idDireccion, "D");
	}
	
	@RequestMapping(value = PersonaRestURIConstant.DESACTIVAR_EMAIL, method = RequestMethod.POST)
	public void desactivarEmail(@PathVariable Long idEmail) {
		perService.estadoEmail(idEmail, "D");
	}
	
	@RequestMapping(value = PersonaRestURIConstant.DESACTIVAR_PHONE, method = RequestMethod.POST)
	public void desactivarTelefono(@PathVariable Long idTelefono) {
		perService.estadoTelefono(idTelefono, "D");
	}	
		
	
	@RequestMapping(value = PersonaRestURIConstant.GET_CV_PERSONA, method = RequestMethod.GET)
	public void getCVPersona(@PathVariable Long idPersona, HttpServletResponse response) {		
		Persona per=perService.findById(idPersona);			
		Archivo archivo = archivoService.getArchivo(idPersona, "PF");		
		if (archivo == null) {			
			archivo = archivoService.getArchivo(Long.parseLong("0"), "ANONIMO");							
		}
		
		
		per.setPersonaTelefonos(perService.getTelefono(per.getIdpersona()));
		per.setPersonaEmails(perService.getEmail(per.getIdpersona()));
		List<PersonaDireccion> listaDirecciones=perService.getDireccion(per.getIdpersona());
		for(PersonaDireccion pd: listaDirecciones){
			pd.ubigeo=ubigeoService.findById(pd.getIdubigeo());
		}
		
		List<Experiencia> listaExperiencia=expeServices.getExperienciasPersona(per.getIdpersona());
		for(Experiencia ex:listaExperiencia){
			ex.oCargo=cargoService.findById(Long.parseLong(ex.getCargo()));					
		}		
		
		per.setPersonaDireccions(listaDirecciones);
		per.setExperiencias(listaExperiencia);
		per.setFormacions(formaServices.getFormacionPersona(per.getIdpersona()));
		List<Habilidad> listaHabilidad=habilidadService.getHabilidadXPersona(per.getIdpersona());
		List<Atributos> listaAtributos=atributosService.getAtributosXPersona(per.getIdpersona());		
		per.setMatrices(matrizService.getMatricesXPersona(per.getIdpersona()));
		
		PdfCV pdf=new PdfCV(per,listaHabilidad,listaAtributos,archivo);
		pdf.generarCV(response);
			   
	}
	
	@RequestMapping(value = PersonaRestURIConstant.GET_PERSONA_JEFE_PROYECTO, method = RequestMethod.POST)
	public List<Persona> getJefesProyecto(@RequestParam String nombres){
		return perService.getPersonaXRol(nombres,"ROLE_OPER_PROY");
	}
	
	

	
	@RequestMapping(value = PersonaRestURIConstant.PERSONA_FILTRO, method = RequestMethod.POST)
	public Object filtroPersona(
			@RequestParam(required = false, defaultValue = "") String competencias,
			@RequestParam(required = false, defaultValue = "") String habilidades,
			@RequestParam(required = false, defaultValue = "") String atributos,@PathVariable int pagina) {
		return perService.filtroPersonas(competencias, habilidades, atributos,pagina);

	}	
	
	
}


