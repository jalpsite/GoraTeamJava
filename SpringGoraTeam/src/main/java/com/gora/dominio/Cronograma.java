package com.gora.dominio;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;


/**
 * The persistent class for the cronograma database table.
 * 
 */
@Entity
@NamedQuery(name="Cronograma.findAll", query="SELECT c FROM Cronograma c")
public class Cronograma implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="cronograma_seq")
	@SequenceGenerator(
		name="cronograma_seq",
		sequenceName="cronograma_sequence",
		allocationSize=1
	) 
	private Long idcronograma;

	private String descripcion;

	private String estado;

	private BigDecimal linea;

	//@JsonIgnore
	//bi-directional many-to-one association to Etapa
	@ManyToOne
	@JoinColumn(name="idetapa")
	private Etapa etapa;

	@JsonIgnore
	//bi-directional many-to-one association to Proyecto
	@ManyToOne
	@JoinColumn(name="idproyecto")
	private Proyecto proyecto;

	@JsonIgnore
	//bi-directional many-to-one association to Tarea
	@ManyToOne
	@JoinColumn(name="idtarea")
	private Tarea tarea;

	public Cronograma() {
	}

	public Long getIdcronograma() {
		return this.idcronograma;
	}

	public void setIdcronograma(Long idcronograma) {
		this.idcronograma = idcronograma;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public BigDecimal getLinea() {
		return this.linea;
	}

	public void setLinea(BigDecimal linea) {
		this.linea = linea;
	}

	public Etapa getEtapa() {
		return this.etapa;
	}

	public void setEtapa(Etapa etapa) {
		this.etapa = etapa;
	}

	public Proyecto getProyecto() {
		return this.proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

	public Tarea getTarea() {
		return this.tarea;
	}

	public void setTarea(Tarea tarea) {
		this.tarea = tarea;
	}

}