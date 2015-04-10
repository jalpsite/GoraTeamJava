package com.gora.web.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gora.dominio.EquipoRol;
import com.gora.services.EquipoRolService;
import com.gora.services.ProyectoService;
import com.gora.web.uri.EquipoRolRestURIConstant;



@RestController
@RequestMapping("/equiporol") 
public class EquipoRolController {
	
	@Autowired
	EquipoRolService equiporolService;
	
	@Autowired
	ProyectoService proyectoService;
				
	@RequestMapping(value = EquipoRolRestURIConstant.GET_ALL_EQUIPO_ROL, method = RequestMethod.GET,  headers = "Accept=application/json")	
	public List<EquipoRol> AllEquipoRoles(@PathVariable Long idProyecto){	
		return equiporolService.equipoRolesXProyecto(idProyecto);
	}	
	
	@RequestMapping(value = EquipoRolRestURIConstant.SAVE_ROL, method = RequestMethod.POST,  headers = "Accept=application/json")	
	public Long agregarEquipoRol(@ModelAttribute EquipoRol eq,@PathVariable Long idProyecto){	
		eq.setProyecto(proyectoService.findById(idProyecto));
		equiporolService.save(eq);
		if(eq.getIdequiporol()!=null)
			return eq.getIdequiporol();
		else
			return new Long("0");
	}
	
	@RequestMapping(value = EquipoRolRestURIConstant.UPDATE_ROL, method = RequestMethod.POST,  headers = "Accept=application/json")	
	public void updateEquipoRol(@ModelAttribute EquipoRol eq,@PathVariable Long idProyecto){	
		eq.setProyecto(proyectoService.findById(idProyecto));
		equiporolService.update(eq);
	}
	
	@RequestMapping(value = EquipoRolRestURIConstant.DELETE_ROL, method = RequestMethod.POST,  headers = "Accept=application/json")	
	public int deleteEquipoRol(@PathVariable Long idEquipoRol){		
		if(equiporolService.getPersonasEquipoRol(idEquipoRol).size()==0){
			return equiporolService.eliminarEquipoRol(idEquipoRol);
		}else{
			return 0;
		}
		
	}
	
		
}
