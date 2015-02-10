package com.gora.dominio;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the tipoproyecto database table.
 * 
 */
@Entity
@NamedQuery(name="Tipoproyecto.findAll", query="SELECT t FROM Tipoproyecto t")
public class Tipoproyecto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="tipoproy_seq")
	@SequenceGenerator(
		name="tipoproy_seq",
		sequenceName="tipoproy_sequence",
		allocationSize=1
	) 
	private long idtipoproyecto;

	private String descripcion;

	private String estado;

	//bi-directional many-to-one association to Proyecto
	@OneToMany(mappedBy="tipoproyecto",fetch=FetchType.EAGER)
	private List<Proyecto> proyectos;

	public Tipoproyecto() {
	}

	public long getIdtipoproyecto() {
		return this.idtipoproyecto;
	}

	public void setIdtipoproyecto(long idtipoproyecto) {
		this.idtipoproyecto = idtipoproyecto;
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
		proyecto.setTipoproyecto(this);

		return proyecto;
	}

	public Proyecto removeProyecto(Proyecto proyecto) {
		getProyectos().remove(proyecto);
		proyecto.setTipoproyecto(null);

		return proyecto;
	}

}