package com.gora.dominio;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


/**
 * The persistent class for the persona_direccion database table.
 * 
 */
@Entity
@Table(name="persona_direccion")
@NamedQuery(name="PersonaDireccion.findAll", query="SELECT p FROM PersonaDireccion p")
@JsonIgnoreProperties(ignoreUnknown=true)
public class PersonaDireccion implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idpersonadireccion;
	private String direccion;
	private String estado;
	private Long idubigeo;
	private String tipo;
	@JsonIgnore
	private Persona persona;
	@Transient
	public Ubigeo ubigeo;
	public PersonaDireccion() {
	}


	@Id
	@SequenceGenerator(name="PERSONA_DIRECCION_IDPERSONADIRECCION_GENERATOR", sequenceName="PERSONA_DIRECCION_SEQUENCE",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PERSONA_DIRECCION_IDPERSONADIRECCION_GENERATOR")	
	public Long getIdpersonadireccion() {
		return this.idpersonadireccion;
	}

	public void setIdpersonadireccion(Long idpersonadireccion) {
		this.idpersonadireccion = idpersonadireccion;
	}


	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}


	public Long getIdubigeo() {
		return this.idubigeo;
	}

	public void setIdubigeo(Long idubigeo) {
		this.idubigeo = idubigeo;
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

/*
	public Ubigeo getUbigeo() {
		return ubigeo;
	}


	public void setUbigeo(Ubigeo ubigeo) {
		this.ubigeo = ubigeo;
	}
	*/

}