package com.gora.dominio;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


/**
 * The persistent class for the persona_email database table.
 * 
 */
@Entity
@Table(name="persona_email")
@NamedQuery(name="PersonaEmail.findAll", query="SELECT p FROM PersonaEmail p")
@JsonIgnoreProperties(ignoreUnknown=true)
public class PersonaEmail implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idpersonaemail;
	private String email;
	private String estado;
	private String tipo;
	@JsonIgnore
	private Persona persona;

	public PersonaEmail() {
		
	}


	@Id
	@SequenceGenerator(name="PERSONA_EMAIL_IDPERSONAEMAIL_GENERATOR", sequenceName="PERSONA_EMAIL_SEQUENCE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PERSONA_EMAIL_IDPERSONAEMAIL_GENERATOR")
	public Long getIdpersonaemail() {
		return this.idpersonaemail;
	}

	public void setIdpersonaemail(Long idpersonaemail) {
		this.idpersonaemail = idpersonaemail;
	}


	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}


	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	//bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name="idpersona")
	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

}