package com.gora.dominio;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


/**
 * The persistent class for the atributo database table.
 * 
 */
@Entity
@Table(name="persona_equipo")
@NamedQuery(name="PersonaEquipo.findAll", query="SELECT pe FROM PersonaEquipo pe")
@JsonIgnoreProperties(ignoreUnknown=true)
public class PersonaEquipo implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private Long idpersonaequipo;

	@JsonIgnore
	
	private Equipo equipo;
	
	@JsonIgnore	
	
	private Persona persona;
	
	private String rol;
	
	public PersonaEquipo() {
	}
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="persona_equipo_seq")
	@SequenceGenerator(
		name="persona_equipo_seq",
		sequenceName="persona_equipo_sequence",
		allocationSize=1
	) 
	public Long getIdpersonaequipo() {
		return idpersonaequipo;
	}

	public void setIdpersonaequipo(Long idpersonaequipo) {
		this.idpersonaequipo = idpersonaequipo;
	}
	
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="idequipo")
	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}
	
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="idpersona")
	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

		


}