package com.gora.dominio;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the portafolio database table.
 * 
 */
@Entity
@NamedQuery(name="Portafolio.findAll", query="SELECT p FROM Portafolio p")
public class Portafolio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="portafolio_seq")
	@SequenceGenerator(
		name="portafolio_seq",
		sequenceName="portafolio_sequence",
		allocationSize=1
	) 
	private Long idportafolio;

	private String descripcion;

	private String estado;

	//bi-directional many-to-one association to Proyecto
	@OneToMany(mappedBy="portafolio",fetch=FetchType.EAGER)
	private List<Proyecto> proyectos;

	public Portafolio() {
	}

	public Long getIdportafolio() {
		return this.idportafolio;
	}

	public void setIdportafolio(Long idportafolio) {
		this.idportafolio = idportafolio;
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

	public List<Proyecto> getProyectos() {
		return this.proyectos;
	}

	public void setProyectos(List<Proyecto> proyectos) {
		this.proyectos = proyectos;
	}

	public Proyecto addProyecto(Proyecto proyecto) {
		getProyectos().add(proyecto);
		proyecto.setPortafolio(this);

		return proyecto;
	}

	public Proyecto removeProyecto(Proyecto proyecto) {
		getProyectos().remove(proyecto);
		proyecto.setPortafolio(null);

		return proyecto;
	}

}