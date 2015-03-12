package com.gora.dominio;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


/**
 * The persistent class for the persona_telefono database table.
 * 
 */
@Entity
@Table(name="persona_telefono")
@NamedQuery(name="PersonaTelefono.findAll", query="SELECT p FROM PersonaTelefono p")
@JsonIgnoreProperties(ignoreUnknown=true)
public class PersonaTelefono implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idpersonatelefono;
	private String estado;
	private String telefono;
	private String tipo;
	@JsonIgnore
	private Persona persona;

	public PersonaTelefono() {
	}


	@Id
	@SequenceGenerator(name="PERSONA_TELEFONO_IDPERSONATELEFONO_GENERATOR", sequenceName="PERSONA_TELEFONO_SEQUENCE",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PERSONA_TELEFONO_IDPERSONATELEFONO_GENERATOR")
	public Long getIdpersonatelefono() {
		return this.idpersonatelefono;
	}

	public void setIdpersonatelefono(Long idpersonatelefono) {
		this.idpersonatelefono = idpersonatelefono;
	}


	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}


	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
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
		return persona;
	}


	public void setPersona(Persona persona) {
		this.persona = persona;
	}


	}