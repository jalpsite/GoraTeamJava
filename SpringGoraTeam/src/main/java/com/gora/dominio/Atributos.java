package com.gora.dominio;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


/**
 * The persistent class for the atributo database table.
 * 
 */
@Entity
@NamedQuery(name="Atributos.findAll", query="SELECT a FROM Atributos a")
@JsonIgnoreProperties(ignoreUnknown=true)
public class Atributos implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="atributos_seq")
	@SequenceGenerator(
		name="atributos_seq",
		sequenceName="atributos_sequence",
		allocationSize=1
	) 
	private Long idatributos;

	
	
	@ManyToOne
	@JoinColumn(name="idatributo")
	private Atributo atributo;

	@ManyToOne
	@JoinColumn(name="idhabilidad")
	private Habilidad habilidad;
	
	
	
	public Atributos() {
	}



	public Long getIdatributos() {
		return idatributos;
	}



	public void setIdatributos(Long idatributos) {
		this.idatributos = idatributos;
	}



	public Atributo getAtributo() {
		return atributo;
	}



	public void setAtributo(Atributo atributo) {
		this.atributo = atributo;
	}



	public Habilidad getHabilidad() {
		return habilidad;
	}



	public void setHabilidad(Habilidad habilidad) {
		this.habilidad = habilidad;
	}

	

}