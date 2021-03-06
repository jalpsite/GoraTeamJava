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
	public void agregarDireccion(PersonaDireccion perDir);
	public void agregarEmail(PersonaEmail perEmail);
	public void agregarTelefono(PersonaTelefono perTelf);
	public void actualizarDireccion(PersonaDireccion perDir);
	public void actualizarEmail(PersonaEmail perEmail);
	public void actualizarTelefono(PersonaTelefono perTelf);	
	public List<PersonaDireccion> getDireccion(Long id);
	public List<PersonaEmail> getEmail(Long id);
	public List<PersonaTelefono> getTelefono(Long id);	
	public Object login(String correo,String dni);
	
	public Long getIDJefe(Long idPersona);
	public List<Competencia> getCompetencias(Long id);	
	public List<Habilidades> getHabilidades(Long id);
	public List<Atributo> getAtributos(Long id);
	
	
	public Persona updateDatos(int opcion, Persona per);
	
	public List<Persona> filtroPersonas(String[] competencias,String[] habilidades, String[] atributos);
	
	public int validarDNI(String doc);
	
	//public List<PersonaDatos> filtroPersonas2(List<String> competencias,List<String> habilidades, List<String> atributos);
}
