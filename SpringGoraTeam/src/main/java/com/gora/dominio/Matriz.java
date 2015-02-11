package com.gora.dominio;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;


/**
 * The persistent class for the matriz database table.
 * 
 */
@Entity
@NamedQuery(name="Matriz.findAll", query="SELECT m FROM Matriz m")
@JsonIgnoreProperties(ignoreUnknown=true)
public class Matriz implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="matriz_seq")
	@SequenceGenerator(
		name="matriz_seq",
		sequenceName="matriz_sequence",
		allocationSize=1
	) 
	private Long idmatriz;

	//bi-directional many-to-one association to Evaluacion
	@OneToMany(mappedBy="matriz")
	private List<Evaluacion> evaluacions;

	//bi-directional many-to-one association to Habilidad
	@JsonIgnore
	@OneToMany(mappedBy="matriz")
	private List<Habilidad> habilidads;

	//bi-directional many-to-one association to Competencia
	@ManyToOne
	@JoinColumn(name="idcompetencia")
	private Competencia competencia;

	//bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name="idpersona")
	private Persona persona;
	
	private String estado;

	public Matriz() {
	}

	public Long getIdmatriz() {
		return this.idmatriz;
	}

	public void setIdmatriz(Long idmatriz) {
		this.idmatriz = idmatriz;
	}

	public List<Evaluacion> getEvaluacions() {
		return this.evaluacions;
	}

	public void setEvaluacions(List<Evaluacion> evaluacions) {
		this.evaluacions = evaluacions;
	}

	public Evaluacion addEvaluacion(Evaluacion evaluacion) {
		getEvaluacions().add(evaluacion);
		evaluacion.setMatriz(this);

		return evaluacion;
	}

	public Evaluacion removeEvaluacion(Evaluacion evaluacion) {
		getEvaluacions().remove(evaluacion);
		evaluacion.setMatriz(null);

		return evaluacion;
	}

	public List<Habilidad> getHabilidads() {
		return this.habilidads;
	}

	public void setHabilidads(List<Habilidad> habilidads) {
		this.habilidads = habilidads;
	}

	public Habilidad addHabilidad(Habilidad habilidad) {
		getHabilidads().add(habilidad);
		habilidad.setMatriz(this);

		return habilidad;
	}

	public Habilidad removeHabilidad(Habilidad habilidad) {
		getHabilidads().remove(habilidad);
		habilidad.setMatriz(null);

		return habilidad;
	}

	public Competencia getCompetencia() {
		return this.competencia;
	}

	public void setCompetencia(Competencia competencia) {
		this.competencia = competencia;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}