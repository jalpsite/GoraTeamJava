package com.gora.dominio;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the carrera database table.
 * 
 */
@Entity
@NamedQuery(name="Carrera.findAll", query="SELECT c FROM Carrera c")
public class Carrera implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="carrera_seq")
	@SequenceGenerator(
		name="carrera_seq",
		sequenceName="carrera_sequence",
		allocationSize=1
	) 
	private Long idcarrera;

	private String estado;

	private String nombre;

	@JsonIgnore
	//bi-directional many-to-one association to Formacion
	@OneToMany(mappedBy="carrera",fetch=FetchType.EAGER)
	private List<Formacion> formacions;

	public Carrera() {
	}

	public Long getIdcarrera() {
		return this.idcarrera;
	}

	public void setIdcarrera(Long idcarrera) {
		this.idcarrera = idcarrera;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Formacion> getFormacions() {
		return this.formacions;
	}

	public void setFormacions(List<Formacion> formacions) {
		this.formacions = formacions;
	}

	public Formacion addFormacion(Formacion formacion) {
		getFormacions().add(formacion);
		formacion.setCarrera(this);

		return formacion;
	}

	public Formacion removeFormacion(Formacion formacion) {
		getFormacions().remove(formacion);
		formacion.setCarrera(null);

		return formacion;
	}

}