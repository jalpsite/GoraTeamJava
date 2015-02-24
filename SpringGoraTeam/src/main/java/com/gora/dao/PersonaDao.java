package com.gora.dao;

import com.gora.dominio.Persona;

import java.util.List;

import com.gora.dominio.Atributo;
import com.gora.dominio.Competencia;
import com.gora.dominio.Habilidades;
import com.gora.dominio.PersonaDireccion;
import com.gora.dominio.PersonaEmail;
import com.gora.dominio.PersonaTelefono;

/**
 * Created by IntelliJ IDEA.
 * Author : Jose Alpiste  .
 * Date : 3/12/14 ,
 * Time : 6:32 PM
 * com.gora.dominio
 */

public interface PersonaDao extends GenericDao<Persona> {
	
	//DIRECCIONES
	public void agregarDireccion(PersonaDireccion perDir);
	public void actualizarDireccion(PersonaDireccion perDir);
	public List<PersonaDireccion> getDireccion(Long id);
	public void estadoDireccion(Long idDireccion,String estado);
	
	//EMAILS
	public void agregarEmail(PersonaEmail perEmail);
	public void actualizarEmail(PersonaEmail perEmail);
	public List<PersonaEmail> getEmail(Long id);
	public void estadoEmail(Long idEmail,String estado );
	
	//TELEFONOS
	public void agregarTelefono(PersonaTelefono perTelf);
	public void actualizarTelefono(PersonaTelefono perTelf);		
	public List<PersonaTelefono> getTelefono(Long id);			
	public void estadoTelefono(Long idTelefono,String estado);
	
	//EXTRACCION DE DATOS	
	public Long getIDJefe(Long idPersona);
	public List<Competencia> getCompetencias(Long id);	
	public List<Habilidades> getHabilidades(Long id);
	public List<Atributo> getAtributos(Long id);	
	public List<Habilidades> getHabilidadesXCompetencia(Long idPersona, Long idCompetencia);
	public List<Atributo> getAtributosXHabilidad(Long idPersona, Long idCompetencia, Long idHabilidad);
	
	//ACTUALIZACION DE DATOS	
	public Persona updateDatos(int opcion, Persona per);
		
	//FILTRO DE PERSONAS POR CAPACIDADES
	public List<Persona> filtroPersonas(String[] competencias,String[] habilidades, String[] atributos, int pagina);
	
	//VALIDACIONES
	public int validarDNI(String doc);	
		
}
