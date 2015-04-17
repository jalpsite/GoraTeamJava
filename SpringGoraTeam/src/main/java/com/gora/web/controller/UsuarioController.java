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
import com.gora.util.Seguridad;
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
	
	@RequestMapping(value = UsuarioRestURIConstant.GET_USUARIO, method = RequestMethod.GET, headers = "Accept=application/json")	
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
	
	@RequestMapping(value = UsuarioRestURIConstant.USUARIO_VALIDA_USUARIO, method = RequestMethod.POST)
	public int valDocumento(@RequestParam String usuario) {
		return usuarioService.validarUsuario(usuario);
	}
	/*
	@RequestMapping(value = UsuarioRestURIConstant.GET_USUARIO_X_PERSONA, method = RequestMethod.GET)
	public Usuario getUsuarioPersona(@PathVariable Long idPersona) {
		return usuarioService.buscarXPersona(idPersona);
	}
	*/
	
	@RequestMapping(value = UsuarioRestURIConstant.UPDATE_USUARIO_ROL, method = RequestMethod.POST)	
	public void updateUsuarioRol(@RequestParam String estado, @PathVariable Long idUsuarioRol,@PathVariable Long idRol){	
		UsuarioRol usRol=usuarioRolService.findById(idUsuarioRol);
		Rol rol=rolService.findById(idRol);
		usRol.setRol(rol);
		usRol.setEstado(estado);
		usuarioRolService.update(usRol);
	}
	
	@RequestMapping(value = UsuarioRestURIConstant.UPDATE_USUARIO_PASS, method = RequestMethod.POST)	
	public int updateUsuarioContraseña(@PathVariable Long idUsuario, @RequestParam String oldpass, @RequestParam String newpass){	
		return usuarioService.cambiarContraseña(idUsuario, oldpass, newpass);
	}
	
	@RequestMapping(value = UsuarioRestURIConstant.LOSTPASSWORD_USUARIO, method = RequestMethod.POST)
	public int resetUsuarioPass(@RequestParam String usuario){
		Usuario us=usuarioService.getUsuario(usuario.toUpperCase());
		int res=0;
		if(us!=null){
			if(usuarioService.enviaTokenContraseña(us)==1){
				res=1;
			}
		}
		return res;
	}
	
	@RequestMapping(value = UsuarioRestURIConstant.VERIFICA_TOKEN_USUARIO_PASS, method = RequestMethod.POST)
	public int verificarToken(@PathVariable Long idUsuario,@PathVariable String token){
		int res=0;
		if(usuarioService.verificarToken(idUsuario, token)){
			res=1;
		}
		return res;
	}
	
	@RequestMapping(value = UsuarioRestURIConstant.RESET_USUARIO_PASS, method = RequestMethod.POST)
	public int resetPassword(@PathVariable Long idUsuario,@PathVariable String token,@RequestParam String newpass){				
		return usuarioService.resetContraseña(idUsuario, token, newpass);
	}
	
	@RequestMapping(value = UsuarioRestURIConstant.VERIFICA_USUARIO, method = RequestMethod.POST)
	public int verificaUsuario(@RequestParam String usuario){
		Usuario us=usuarioService.getUsuario(usuario.toUpperCase());
		if(us!=null)
			return 1;
		else
			return 0;
	}
	
	@RequestMapping(value = UsuarioRestURIConstant.GET_USUARIO_PERSONA, method = RequestMethod.GET)
	public Usuario getUsuarioPersona(@PathVariable Long idPersona){				
		return usuarioService.getUsuarioXPersona(idPersona);
	}
	
}
