package com.gora.dominio;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the universidad database table.
 * 
 */
@Entity
@NamedQuery(name="Universidad.findAll", query="SELECT u FROM Universidad u")
public class Universidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="universidad_seq")
	@SequenceGenerator(
		name="universidad_seq",
		sequenceName="universidad_sequence",
		allocationSize=1
	) 
	private Long iduniversidad;

	private String estado;

	private String nombre;

	private String pais;

	private BigDecimal rank;

	@JsonIgnore
	//bi-directional many-to-one association to Formacion
	@OneToMany(mappedBy="universidad",fetch=FetchType.EAGER)
	private List<Formacion> formacions;

	public Universidad() {
	}

	public Long getIduniversidad() {
		return this.iduniversidad;
	}

	public void setIduniversidad(Long iduniversidad) {
		this.iduniversidad = iduniversidad;
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

	public String getPais() {
		return this.pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public BigDecimal getRank() {
		return this.rank;
	}

	public void setRank(BigDecimal rank) {
		this.rank = rank;
	}

	public List<Formacion> getFormacions() {
		return this.formacions;
	}

	public void setFormacions(List<Formacion> formacions) {
		this.formacions = formacions;
	}

	public Formacion addFormacion(Formacion formacion) {
		getFormacions().add(formacion);
		formacion.setUniversidad(this);

		return formacion;
	}

	public Formacion removeFormacion(Formacion formacion) {
		getFormacions().remove(formacion);
		formacion.setUniversidad(null);

		return formacion;
	}

}