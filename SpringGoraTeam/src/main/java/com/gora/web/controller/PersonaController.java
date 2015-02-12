package com.gora.web.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.DefaultResourceLoader;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.gora.services.ExperienciaService;
import com.gora.services.FormacionService;
import com.gora.services.PersonaDatosService;
import com.gora.services.PersonaService;
import com.gora.dominio.Atributo;
import com.gora.dominio.Competencia;
import com.gora.dominio.Experiencia;
import com.gora.dominio.Formacion;
import com.gora.dominio.Habilidades;
import com.gora.dominio.Persona;
import com.gora.dominio.PersonaDatos;
import com.gora.dominio.PersonaDireccion;
import com.gora.dominio.PersonaEmail;
import com.gora.dominio.PersonaTelefono;
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
	/*
	 * PERSONA
	 */

	@RequestMapping(value = PersonaRestURIConstant.CREATE_PERSONA, method = RequestMethod.POST)
	public int savePersona(@ModelAttribute Persona per) {
		this.perService.save(per);
		return Integer.parseInt((per.getIdpersona()).toString());
	}

	@RequestMapping(value = PersonaRestURIConstant.UPDATE_PERSONA, method = RequestMethod.POST)
	public int updatePersona(@ModelAttribute Persona per) {
		this.perService.update(per);
		return Integer.parseInt((per.getIdpersona()).toString());
	}

	@RequestMapping(value = PersonaRestURIConstant.GET_PERSONA, method = RequestMethod.GET, headers = "Accept=application/json")
	public Persona GetPersona(@PathVariable Long id) {
		Persona p = this.perService.findById(id);
		return p;
	}

	@RequestMapping(value = PersonaRestURIConstant.GET_ALL_PERSONA, method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Persona> LstPersona() {
		return this.perService.findAll();
	}

	@RequestMapping(value = PersonaRestURIConstant.PERSONA_LOGIN, method = RequestMethod.POST)
	public Object login(@RequestParam String correo, @RequestParam String dni) {
		return perService.login(correo, dni);
	}

	final DefaultResourceLoader loader = new DefaultResourceLoader();

	/*
	 * PERSONA FOTO
	 */

	@RequestMapping(value = PersonaRestURIConstant.CREATE_FOTOPERSONA, method = RequestMethod.POST)
	public String saveFotoPersona(@RequestParam MultipartFile file,
			@PathVariable Long id, HttpServletRequest request) {

		InputStream inputStream = null;
		OutputStream outputStream = null;
		String fileName = file.getOriginalFilename();
		String retorno = "";
		try {
			inputStream = file.getInputStream();
			// String filePath =
			// request.getSession().getServletContext().getRealPath("/WEB-INF/files/");
			String filePath = request.getSession().getServletContext()
					.getRealPath("/");
			System.out.print(filePath);
			File newFile = new File(filePath + "\\" + fileName);
			if (!newFile.exists()) {
				newFile.createNewFile();
			}
			outputStream = new FileOutputStream(newFile);
			int read = 0;
			byte[] bytes = new byte[1024];

			while ((read = inputStream.read(bytes)) != -1) {
				outputStream.write(bytes, 0, read);
			}
			outputStream.close();
			inputStream.close();

			Persona per = GetPersona(id);
			retorno = filePath + fileName;
			per.setFoto(retorno);
			perService.update(per);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			return "0";

		}
		return retorno;

	}

	@RequestMapping(value = PersonaRestURIConstant.GET_FOTOPERSONA, method = RequestMethod.GET)
	public void getFoto(HttpServletResponse response) {
		Persona per = GetPersona(Long.parseLong("1"));
		File file = new File(per.getFoto());
		//File file = new File(
				//"C:\\imagenes\\Desert.jpg");

		 FileInputStream fis;
		try {
			fis = new FileInputStream(file);
		
	        response.reset();
	        response.setContentType("image/jpeg");

	        PrintWriter out = response.getWriter();
	        int c;
	        while ((c = fis.read()) != -1) {
	            out.write(c);
	        }
	        out.flush();
	        out.close();
	        fis.close();
	        
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
	
	
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
	public List<Habilidades> getHabilidadesXCompetencia(@PathVariable Long idPersona, @PathVariable Long idCompetencia) {
		return perService.getHabilidadesXCompetencia(idPersona, idCompetencia);
	}
	
	@RequestMapping(value = PersonaRestURIConstant.GET_PERSONA_ATRIBUTOS_X_HABIILIDAD, method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Atributo> getAtributosXHabilidad(@PathVariable Long idPersona, @PathVariable Long idCompetencia, @PathVariable Long idHabilidad) {
		return perService.getAtributosXHabilidad(idPersona, idCompetencia, idHabilidad);
	}

	/*
	 * PERSONA BUSQUEDAS Y FILTROS
	 */

	@RequestMapping(value = PersonaRestURIConstant.GET_PERSONA_DNI, method = RequestMethod.GET, headers = "Accept=application/json")
	public List<PersonaDatos> getPersonaByDNI(@PathVariable String dniPersona) {
		return this.perDatosService.getPersonaByDNI(dniPersona);
	}

	@RequestMapping(value = PersonaRestURIConstant.GET_PERSONA_NOMBRE_APELLIDO, method = RequestMethod.GET, headers = "Accept=application/json")
	public List<PersonaDatos> getPersonaByNomApe(
			@PathVariable String nomApePersona) {
		return this.perDatosService.getPersonaByNomApe(nomApePersona);
	}

	@RequestMapping(value = PersonaRestURIConstant.PERSONA_FILTRO, method = RequestMethod.POST)
	public List<Persona> filtroPersona(
			@RequestParam(required = false, defaultValue = "") String[] competencias,
			@RequestParam(required = false, defaultValue = "") String[] habilidades,
			@RequestParam(required = false, defaultValue = "") String[] atributos) {
		return perService.filtroPersonas(competencias, habilidades, atributos);

	}

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
	 * //GUARDADO SINGULAR
	 * 
	 * @RequestMapping(value = PersonaRestURIConstant.CREATE_EMAIL, method =
	 * RequestMethod.POST) public void saveEmail(@ModelAttribute PersonaEmail
	 * perEmail, @PathVariable Long idPersona) {
	 * perEmail.setPersona(this.GetPersona(idPersona));
	 * this.perService.agregarEmail(perEmail); }
	 */

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
	public PersonaEmail updateEmail(@ModelAttribute PersonaEmail perEmail,
			@PathVariable Long idPersona) {
		perEmail.setPersona(this.GetPersona(idPersona));
		this.perService.actualizarEmail(perEmail);
		return perEmail;
	}

	@RequestMapping(value = PersonaRestURIConstant.GET_PERSONA_EMAIL, method = RequestMethod.GET, headers = "Accept=application/json")
	public List<PersonaEmail> getPersonaCorreo(@PathVariable Long id) {
		return perService.getEmail(id);
	}

	/*
	 * TELEFONO
	 */

	/*
	 * // GUARDADO SINGULAR
	 * 
	 * @RequestMapping(value = PersonaRestURIConstant.CREATE_PHONE, method =
	 * RequestMethod.POST) public void saveTelefono(@ModelAttribute
	 * PersonaTelefono perTel, @PathVariable Long idPersona) {
	 * perTel.setPersona(this.GetPersona(idPersona));
	 * this.perService.agregarTelefono(perTel); }
	 */

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
	public PersonaTelefono updateTelefono(
			@ModelAttribute PersonaTelefono perTel, @PathVariable Long idPersona) {
		perTel.setPersona(this.GetPersona(idPersona));
		this.perService.actualizarTelefono(perTel);
		return perTel;
	}

	@RequestMapping(value = PersonaRestURIConstant.GET_PERSONA_PHONE, method = RequestMethod.GET, headers = "Accept=application/json")
	public List<PersonaTelefono> getPersonaTelefono(@PathVariable Long id) {
		return perService.getTelefono(id);
	}

	/*
	 * DIRECCION
	 */

	/*
	 * // GUARDADO SINGULAR
	 * 
	 * @RequestMapping(value = PersonaRestURIConstant.CREATE_ADDRESS, method =
	 * RequestMethod.POST) public void saveDireccion(@ModelAttribute
	 * PersonaDireccion perDir, @PathVariable Long idPersona) {
	 * perDir.setPersona(this.GetPersona(idPersona));
	 * this.perService.agregarDireccion(perDir); }
	 */

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
	public PersonaDireccion updateDireccion(@ModelAttribute PersonaDireccion perDir,
			@PathVariable Long idPersona) {
		perDir.setPersona(this.GetPersona(idPersona));
		this.perService.actualizarDireccion(perDir);
		return perDir;
	}

	@RequestMapping(value = PersonaRestURIConstant.GET_PERSONA_ADDRESS, method = RequestMethod.GET, headers = "Accept=application/json")
	public List<PersonaDireccion> getPersonaDireccion(@PathVariable Long id) {
		return perService.getDireccion(id);
	}
	
	
	/* 	EXPERIENCIA 	*/
	@RequestMapping(value = PersonaRestURIConstant.GET_PERSONA_EXPERIENCIAS, method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Experiencia> getPersonaExperiencias(@PathVariable Long id) {
		return expeServices.getExperienciasPersona(id);
	}
	
	/* 	FORMACION 	*/
	@RequestMapping(value = PersonaRestURIConstant.GET_PERSONA_FORMACION, method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Formacion> getPersonaFormacion(@PathVariable Long id) {
		return formaServices.getFormacionPersona(id);
	}

}
