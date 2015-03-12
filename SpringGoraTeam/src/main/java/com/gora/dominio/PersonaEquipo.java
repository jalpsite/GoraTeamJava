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
@NamedQuery(name="PersonaEquipo.findAll", query="SELECT pe FROM PersonaEquipo pe")
@JsonIgnoreProperties(ignoreUnknown=true)
public class PersonaEquipo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="persona_equipo_seq")
	@SequenceGenerator(
		name="persona_equipo_seq",
		sequenceName="persona_equipo_sequence",
		allocationSize=1
	) 
	private Long idpersonaequipo;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="idequipo")
	private Equipo equipo;
	
	@JsonIgnore
	//bi-directional many-to-one association to Persona
	@ManyToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="idpersona")
	private Persona persona;
	
	private String rol;
	
	public PersonaEquipo() {
	}

	public Long getIdpersonaequipo() {
		return idpersonaequipo;
	}

	public void setIdpersonaequipo(Long idpersonaequipo) {
		this.idpersonaequipo = idpersonaequipo;
	}

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

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