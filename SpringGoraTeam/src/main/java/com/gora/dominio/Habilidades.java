package com.gora.dominio;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@NamedQuery(name = "Habilidades.findAll", query = "SELECT h FROM Habilidades h")
@JsonIgnoreProperties(ignoreUnknown=true)
public class Habilidades implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "habilidades_seq")
	@SequenceGenerator(name = "habilidades_seq", sequenceName = "habilidades_sequence", allocationSize = 1)
	private Long idhabilidades;
	private String descripcion;
	private BigDecimal calificacion;

	@Temporal(TemporalType.DATE)
	private Date fechaactualizacion;
	
	@JsonIgnore
	@OneToMany(mappedBy="habilidades",fetch=FetchType.EAGER)
	private List<Habilidad> habilidades;
	
	@JsonIgnore
	@OneToMany(mappedBy="habilidades",fetch=FetchType.EAGER)
	private List<Atributo> atributos;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="idcompetencia")
	private Competencia competencia;
	
	public Habilidades() {
	}

	public BigDecimal getCalificacion() {
		return this.calificacion;
	}

	public void setCalificacion(BigDecimal calificacion) {
		this.calificacion = calificacion;
	}

	public Date getFechaactualizacion() {
		return this.fechaactualizacion;
	}

	public void setFechaactualizacion(Date fechaactualizacion) {
		this.fechaactualizacion = fechaactualizacion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Long getIdhabilidades() {
		return idhabilidades;
	}

	public void setIdhabilidades(Long idhabilidades) {
		this.idhabilidades = idhabilidades;
	}

	public List<Habilidad> getHabilidades() {
		return habilidades;
	}

	public void setHabilidades(List<Habilidad> habilidades) {
		this.habilidades = habilidades;
	}

	public Competencia getCompetencia() {
		return competencia;
	}

	public void setCompetencia(Competencia competencia) {
		this.competencia = competencia;
	}

	public List<Atributo> getAtributos() {
		return atributos;
	}

	public void setAtributos(List<Atributo> atributos) {
		this.atributos = atributos;
	}
}
