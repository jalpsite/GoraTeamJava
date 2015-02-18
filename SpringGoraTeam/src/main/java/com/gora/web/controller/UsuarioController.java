package com.gora.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gora.dominio.Carrera;
import com.gora.dominio.Formacion;
import com.gora.dominio.Grado;
import com.gora.dominio.Persona;
import com.gora.dominio.PersonaEmail;
import com.gora.dominio.PersonaTelefono;
import com.gora.dominio.Universidad;
import com.gora.dominio.Usuario;
import com.gora.services.PersonaService;
import com.gora.services.UniversidadService;
import com.gora.services.UsuarioService;
import com.gora.web.uri.FormacionRestURIConstant;
import com.gora.web.uri.PersonaRestURIConstant;
import com.gora.web.uri.UniversidadRestURIConstant;
import com.gora.web.uri.UsuarioRestURIConstant;


@RestController
@RequestMapping("/usuario") 
public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	PersonaService personaService;
	
	

	@RequestMapping(value = UsuarioRestURIConstant.LOGIN_USUARIO, method = RequestMethod.POST)
	public Object login(@RequestParam String correo, @RequestParam String dni) {
		return usuarioService.login(correo, dni);
	}
	
	@RequestMapping(value = UsuarioRestURIConstant.CREATE_USUARIO, method = RequestMethod.POST)	
	public int Agregar(@ModelAttribute Usuario us){			
		usuarioService.save(us);	
		
		Persona per=new Persona();
		per.setNumerodocidentidad(us.getPass());
		//per.setIdusuario(us);
		per.setEstado("A");
		per.setPerfil("INCOMPLETO");
		
		personaService.save(per);
		
		PersonaEmail perEmail=new PersonaEmail();
		perEmail.setPersona(per);
		perEmail.setEstado("A");
		perEmail.setEmail(us.getUsuario());
		
		personaService.agregarEmail(perEmail);
		
		return Integer.parseInt((us.getId()).toString());
	}
	
}
