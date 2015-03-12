package com.gora.dominio;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the cargo database table.
 * 
 */
@Entity
@NamedQuery(name="Entregable.findAll", query="SELECT c FROM Entregable c")
public class Entregable implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="entregable_seq")
	@SequenceGenerator(
		name="entregable_seq",
		sequenceName="entregable_sequence",
		allocationSize=1
	) 
	private Long identregable;
	
	@ManyToOne
	@JoinColumn(name="idproyecto")
	private Proyecto proyecto;

	private String nombre;
	
	@JsonIgnore
	@OneToMany(mappedBy="entregable",fetch=FetchType.EAGER)
	private List<Tarea> tareas;
	
	public Entregable() {
	}

	public Long getIdentregable() {
		return identregable;
	}

	public void setIdentregable(Long identregable) {
		this.identregable = identregable;
	}

	public Proyecto getProyecto() {
		return proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Tarea> getTareas() {
		return tareas;
	}

	public void setTareas(List<Tarea> tareas) {
		this.tareas = tareas;
	}

	
}