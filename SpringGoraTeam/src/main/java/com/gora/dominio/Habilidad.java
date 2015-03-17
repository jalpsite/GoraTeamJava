package com.gora.dominio;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


/**
 * The persistent class for the habilidad database table.
 * 
 */
@Entity
@NamedQuery(name="Habilidad.findAll", query="SELECT h FROM Habilidad h")
@JsonIgnoreProperties(ignoreUnknown=true)
public class Habilidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="habilidad_seq")
	@SequenceGenerator(
		name="habilidad_seq",
		sequenceName="habilidad_sequence",
		allocationSize=1
	) 
	private Long idhabilidad;

	
	//@JsonIgnore
	@OneToMany(mappedBy="habilidad",fetch=FetchType.EAGER)
	private List<Atributos> atributos;
	
	@JsonIgnore
	//bi-directional many-to-one association to Matriz
	@ManyToOne
	@JoinColumn(name="idmatriz")
	private Matriz matriz;

	@JsonIgnore
	//bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name="idpersona")
	private Persona persona;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="idhabilidades")
	private Habilidades habilidades;
	
	public Habilidad() {
	}

	public Long getIdhabilidad() {
		return this.idhabilidad;
	}

	public void setIdhabilidad(Long idhabilidad) {
		this.idhabilidad = idhabilidad;
	}

	
	public Matriz getMatriz() {
		return this.matriz;
	}

	public void setMatriz(Matriz matriz) {
		this.matriz = matriz;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	
	public Habilidades getHabilidades() {
		return habilidades;
	}

	public void setHabilidades(Habilidades habilidades) {
		this.habilidades = habilidades;
	}

	public List<Atributos> getAtributos() {
		return atributos;
	}

	public void setAtributos(List<Atributos> atributos) {
		this.atributos = atributos;
	}

	

}