package com.gora.services;

import com.gora.dominio.Atributo;
import com.gora.dominio.Competencia;
import com.gora.dominio.Habilidades;
import com.gora.dominio.Persona;
import com.gora.dominio.PersonaDireccion;
import com.gora.dominio.PersonaEmail;
import com.gora.dominio.PersonaTelefono;



import com.gora.dominio.Usuario;
import com.gora.dominio.UsuarioRol;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Author : Taras Lehinevych  .
 * Date : 3/12/14 ,
 * Time : 7:02 PM
 * com.gora.dominio
 */

public interface PersonaService {

    public void save(Persona persona);

    public void update(Persona persona);

    public Persona findById(Long id);

    public List<Persona> findAll();
    
    public void agregarDireccion(PersonaDireccion perDir);
	public void agregarEmail(PersonaEmail perEmail);
	public void agregarTelefono(PersonaTelefono perTelf);
	public void actualizarDireccion(PersonaDireccion perDir);
	public void actualizarEmail(PersonaEmail perEmail);
	public void actualizarTelefono(PersonaTelefono perTelf);
	
	public List<PersonaDireccion> getDireccion(Long id);
	public List<PersonaEmail> getEmail(Long id);
	public List<PersonaTelefono> getTelefono(Long id);
	
	public void estadoDireccion(Long idDireccion,String estado);
	public void estadoEmail(Long idEmail,String estado );
	public void estadoTelefono(Long idTelefono,String estado);
	
	//public Object login(String correo,String dni);
	public Long getIDJefe(Long idPersona);
	public List<Competencia> getCompetencias(Long id);	
	public List<Habilidades> getHabilidades(Long id);
	public List<Atributo> getAtributos(Long id);
	
	public List<Habilidades> getHabilidadesXCompetencia(Long idPersona, Long idCompetencia);
	public List<Atributo> getAtributosXHabilidad(Long idPersona, Long idCompetencia, Long idHabilidad);
	
	public Persona updateDatos(int opcion, Persona per);
	
	public List<Persona> filtroPersonas(String[] lstCompetencias,String[] lstHabilidades, String[] lstAtributos, int pagina);
	
	public int validarDNI(String doc);
	
	public List<Persona> getPersonaXRol(String busqueda, String rol);
	
	public Persona getPersona(Long id) ;

}
