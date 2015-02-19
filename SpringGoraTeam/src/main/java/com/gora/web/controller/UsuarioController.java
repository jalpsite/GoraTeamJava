package com.gora.web.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gora.dominio.Persona;
import com.gora.dominio.PersonaEmail;
import com.gora.dominio.Rol;
import com.gora.dominio.Usuario;
import com.gora.dominio.UsuarioRol;
import com.gora.services.PersonaService;
import com.gora.services.RolService;
import com.gora.services.UsuarioRolService;
import com.gora.services.UsuarioService;
import com.gora.web.uri.UsuarioRestURIConstant;


@RestController
@RequestMapping("/usuario") 
public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	PersonaService personaService;
	
	@Autowired
	RolService rolService;
	
	@Autowired
	UsuarioRolService usuarioRolService;
	

	@RequestMapping(value = UsuarioRestURIConstant.LOGIN_USUARIO, method = RequestMethod.POST)
	public Object login(@RequestParam String correo, @RequestParam String dni) {
		return usuarioService.login(correo, dni);
	}
	
	@RequestMapping(value = UsuarioRestURIConstant.CREATE_USUARIO, method = RequestMethod.POST)	
	public int Agregar(@ModelAttribute Usuario us){	
		
		//Guardado de Usuario
		usuarioService.save(us);	
		
		//Guardado de Persona
		Persona per=new Persona();
		per.setNumerodocidentidad(us.getPass());
		System.out.println(us.getId());		
		per.setUsuario(us);
		per.setEstado("A");
		per.setPerfil("INCOMPLETO");		
		personaService.save(per);
		
		//Guardado de Email
		PersonaEmail perEmail=new PersonaEmail();
		perEmail.setPersona(per);
		perEmail.setEstado("A");
		perEmail.setTipo("LABORAL");
		perEmail.setEmail(us.getUsuario());		
		personaService.agregarEmail(perEmail);
		
		//Guardado de ROL
		Rol rol=rolService.findById(new Long("2"));
		UsuarioRol usuarioRol=new UsuarioRol();
		usuarioRol.setEstado("A");
		usuarioRol.setRol(rol);
		usuarioRol.setUsuario(us);
		usuarioRolService.save(usuarioRol);
		
		//Retorno de ID Usuario
		return Integer.parseInt((us.getId()).toString());
	}
	
	@RequestMapping(value = UsuarioRestURIConstant.ASIGNA_ROL_USUARIO, method = RequestMethod.POST)	
	public void asignarRol(@PathVariable Long idPersona, @PathVariable Long idRol){	
		Persona p=personaService.findById(idPersona);
		Rol rol=rolService.findById(idRol);
		UsuarioRol usRol=new UsuarioRol();
		usRol.setEstado("A");
		usRol.setRol(rol);
		usRol.setUsuario(p.getUsuario());
		usuarioRolService.save(usRol);
	}
	
	@RequestMapping(value = UsuarioRestURIConstant.GET_USUARIO, method = RequestMethod.GET)	
	public Usuario getUsuario(@PathVariable Long id){	
		return usuarioService.findById(id);
	}
	
	@RequestMapping(value = UsuarioRestURIConstant.GET_ALL_USUARIO, method = RequestMethod.GET)	
	public List<Usuario> AllUsuarios(){	
		return usuarioService.findAll();
	}
	
	@RequestMapping(value = UsuarioRestURIConstant.GET_ROLES_USUARIO, method = RequestMethod.GET)	
	public List<UsuarioRol> AllUsuarios(@PathVariable Long idUsuario){	
		return usuarioService.rolesUsuario(idUsuario);
	}
		
}
