package com.gora.dominio;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.junit.Ignore;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="idhabilidad")
	private Habilidad habilidad;
	private String certificado;	
	private Integer experiencia;
	
	@JsonIgnore
	@OneToMany(mappedBy="atributos")
	private List<AtributosCertificacion> certificaciones;
	
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


	public Integer getExperiencia() {
		return experiencia;
	}



	public void setExperiencia(Integer experiencia) {
		this.experiencia = experiencia;
	}



	public String getCertificado() {
		return certificado;
	}



	public void setCertificado(String certificado) {
		this.certificado = certificado;
	}

}