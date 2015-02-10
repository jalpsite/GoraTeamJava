package com.gora.dominio;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the grado database table.
 * 
 */
@Entity
@NamedQuery(name="Grado.findAll", query="SELECT g FROM Grado g")
public class Grado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="grado_seq")
	@SequenceGenerator(
		name="grado_seq",
		sequenceName="grado_sequence",
		allocationSize=1
	) 
	private Long idgrado;

	private String descripcion;

	private String estado;

	@JsonIgnore
	//bi-directional many-to-one association to Formacion
	@OneToMany(mappedBy="grado",fetch=FetchType.EAGER)
	private List<Formacion> formacions;

	public Grado() {
	}

	public Long getIdgrado() {
		return this.idgrado;
	}

	public void setIdgrado(Long idgrado) {
		this.idgrado = idgrado;
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

	public List<Formacion> getFormacions() {
		return this.formacions;
	}

	public void setFormacions(List<Formacion> formacions) {
		this.formacions = formacions;
	}

	public Formacion addFormacion(Formacion formacion) {
		getFormacions().add(formacion);
		formacion.setGrado(this);

		return formacion;
	}

	public Formacion removeFormacion(Formacion formacion) {
		getFormacions().remove(formacion);
		formacion.setGrado(null);

		return formacion;
	}

}