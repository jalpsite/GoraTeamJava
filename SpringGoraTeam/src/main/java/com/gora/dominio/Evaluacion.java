package com.gora.dominio;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the evaluacion database table.
 * 
 */
@Entity
@NamedQuery(name="Evaluacion.findAll", query="SELECT e FROM Evaluacion e")
public class Evaluacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="evaluacion_seq")
	@SequenceGenerator(
		name="evaluacion_seq",
		sequenceName="evaluacion_sequence",
		allocationSize=1
	) 
	private long idevaluacion;

	private BigDecimal calificacion;

	private String estado;

	@Temporal(TemporalType.DATE)
	private Date fechaevaluacion;

	//bi-directional many-to-one association to Matriz
	@ManyToOne
	@JoinColumn(name="idmatriz")
	private Matriz matriz;

	//bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name="idperevaluador")
	private Persona persona;

	//bi-directional many-to-one association to Proyecto
	@ManyToOne
	@JoinColumn(name="idproyecto")
	private Proyecto proyecto;

	public Evaluacion() {
	}

	public long getIdevaluacion() {
		return this.idevaluacion;
	}

	public void setIdevaluacion(long idevaluacion) {
		this.idevaluacion = idevaluacion;
	}

	public BigDecimal getCalificacion() {
		return this.calificacion;
	}

	public void setCalificacion(BigDecimal calificacion) {
		this.calificacion = calificacion;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaevaluacion() {
		return this.fechaevaluacion;
	}

	public void setFechaevaluacion(Date fechaevaluacion) {
		this.fechaevaluacion = fechaevaluacion;
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

	public Proyecto getProyecto() {
		return this.proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

}