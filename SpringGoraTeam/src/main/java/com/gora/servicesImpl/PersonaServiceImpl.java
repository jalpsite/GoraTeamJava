package com.gora.servicesImpl;

import com.gora.dao.PersonaDao;
import com.gora.dominio.Atributo;
import com.gora.dominio.Competencia;
import com.gora.dominio.Habilidades;
import com.gora.dominio.Persona;
import com.gora.dominio.PersonaDireccion;
import com.gora.dominio.PersonaEmail;
import com.gora.dominio.PersonaTelefono;
import com.gora.dominio.Usuario;
import com.gora.dominio.UsuarioRol;
import com.gora.services.PersonaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Author : Taras Lehinevych  .
 * Date : 3/12/14 ,
 * Time : 7:10 PM
 * com.gora.dominio
 */


@Service
@Transactional
public class PersonaServiceImpl implements PersonaService {

	@Autowired
    private PersonaDao personaDao;

    @Override
    public void save(Persona persona) {
        personaDao.save(persona);
    }

    @Override
    public void update(Persona persona) {
        personaDao.update(persona);
    }

    @Override
    public List<Persona> findAll() {
        List<Persona> tmp = personaDao.findAll();
        //for (Client order : tmp) {
        //    Hibernate.initialize(order.getOrders());
        //}
        return tmp;
    }

    @Override
    public Persona findById(Long id) {
        Persona tmp = personaDao.findById(id);
        //Hibernate.initialize(tmp.getOrders());
        return tmp;
    }
    
    
    /*
     *	26/01 
     */
    
	@Override
	public void agregarDireccion(PersonaDireccion perDir) {
		personaDao.agregarDireccion(perDir);		
	}

	@Override
	public void agregarEmail(PersonaEmail perEmail) {
		personaDao.agregarEmail(perEmail);		
	}

	@Override
	public void agregarTelefono(PersonaTelefono perTelf) {
		personaDao.agregarTelefono(perTelf);		
	}
	/*
     *	27/01 
     */
	@Override
	public List<PersonaDireccion> getDireccion(Long id) {
		return personaDao.getDireccion(id);
	}

	@Override
	public List<PersonaEmail> getEmail(Long id) {
		return personaDao.getEmail(id);
	}

	@Override
	public List<PersonaTelefono> getTelefono(Long id) {
		return personaDao.getTelefono(id);
	}

	@Override
	public void actualizarDireccion(PersonaDireccion perDir) {
		personaDao.actualizarDireccion(perDir);		
	}

	@Override
	public void actualizarEmail(PersonaEmail perEmail) {
		personaDao.actualizarEmail(perEmail);
	}

	@Override
	public void actualizarTelefono(PersonaTelefono perTelf) {
		personaDao.actualizarTelefono(perTelf);
	}

	/*
	@Override
	public Object login(String correo,String dni) {
		return personaDao.login(correo,dni);
	}
	*/
	
	@Override
	public Persona updateDatos(int opcion, Persona per) {
		return personaDao.updateDatos(opcion, per);
	}

	@Override
	public Long getIDJefe(Long idPersona) {
		return personaDao.getIDJefe(idPersona);
	}

	@Override
	public List<Competencia> getCompetencias(Long id) {
		return personaDao.getCompetencias(id);
	}

	@Override
	public List<Habilidades> getHabilidades(Long id) {
		return personaDao.getHabilidades(id);
	}

	@Override
	public List<Atributo> getAtributos(Long id) {
		return personaDao.getAtributos(id);
	}

	@Override
	public int validarDNI(String doc) {
		return personaDao.validarDNI(doc);
	}

	@Override
	public List<Habilidades> getHabilidadesXCompetencia(Long idPersona, Long idCompetencia) {
		return personaDao.getHabilidadesXCompetencia(idPersona, idCompetencia);
	}

	@Override
	public List<Atributo> getAtributosXHabilidad(Long idPersona, Long idCompetencia, Long idHabilidad) {
		return personaDao.getAtributosXHabilidad(idPersona, idCompetencia, idHabilidad);
	}

	@Override
	public void estadoDireccion(Long idDireccion, String estado) {
		personaDao.estadoDireccion(idDireccion, estado);
	}

	@Override
	public void estadoEmail(Long idEmail, String estado) {
		personaDao.estadoEmail(idEmail, estado);
	}

	@Override
	public void estadoTelefono(Long idTelefono, String estado) {
		personaDao.estadoTelefono(idTelefono, estado);
	}
/*
	@Override
	public List<Persona> filtroPersonas(String[] lstCompetencias,
			String[] lstHabilidades, String[] lstAtributos, int pagina) {
		return personaDao.filtroPersonas(lstCompetencias, lstHabilidades, lstAtributos, pagina);
	}
*/
	@Override
	public List<Persona> getPersonaXRol(String busqueda, String rol) {
		return personaDao.getPersonaXRol(busqueda, rol);
	}

	@Override
	public Persona getPersona(Long id) {
		return personaDao.getPersona(id);
	}

	@Override
	public Object filtroPersonas(String competencias,
			String habilidades, String atributos, int pagina) {
		return personaDao.filtroPersonas(competencias, habilidades, atributos, pagina);
	}	

}
