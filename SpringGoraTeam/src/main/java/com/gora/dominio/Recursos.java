package com.gora.dominio;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


/**
 * The persistent class for the atributo database table.
 * 
 */
@Entity
@NamedQuery(name="Recursos.findAll", query="SELECT e FROM Recursos e")
@JsonIgnoreProperties(ignoreUnknown=true)
public class Recursos implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private Long idrecurso;
	@JsonIgnore	
	private Proyecto proyecto;
	
	private String descripcion;
	private BigDecimal costo;		
	
	
	public Recursos() {
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="recurso_seq")
	@SequenceGenerator(
		name="recurso_seq",
		sequenceName="recursos_sequence",
		allocationSize=1
	) 
	public Long getIdrecurso() {
		return idrecurso;
	}

	public void setIdrecurso(Long idrecurso) {
		this.idrecurso = idrecurso;
	}

	@ManyToOne
	@JoinColumn(name="idproyecto")
	public Proyecto getProyecto() {
		return proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public BigDecimal getCosto() {
		return costo;
	}

	public void setCosto(BigDecimal costo) {
		this.costo = costo;
	}

	
	

}