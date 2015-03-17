package com.gora.dominio;

import java.io.Serializable;
import java.util.Date;

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
	private String nom_certificacion;
	@Temporal(TemporalType.DATE)	
	private Date fecha_inicio;
	@Temporal(TemporalType.DATE)	
	private Date fecha_fin;	
	private Integer experiencia;
	
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


	public Date getFecha_inicio() {
		return fecha_inicio;
	}



	public void setFecha_inicio(Date fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}



	public Date getFecha_fin() {
		return fecha_fin;
	}



	public void setFecha_fin(Date fecha_fin) {
		this.fecha_fin = fecha_fin;
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



	public String getNom_certificacion() {
		return nom_certificacion;
	}



	public void setNom_certificacion(String nom_certificacion) {
		this.nom_certificacion = nom_certificacion;
	}

	

}