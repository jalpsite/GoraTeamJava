package com.gora.dominio;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the iniciativa database table.
 * 
 */
@Entity
@NamedQuery(name="Iniciativa.findAll", query="SELECT i FROM Iniciativa i")
public class Iniciativa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="iniciativa_seq")
	@SequenceGenerator(
		name="iniciativa_seq",
		sequenceName="iniciativa_sequence",
		allocationSize=1
	) 
	private long idiniciativa;

	private String descripcion;

	private String estado;

	@Temporal(TemporalType.DATE)
	private Date fechacontacto;

	@Temporal(TemporalType.DATE)
	private Date fechainicio;

	private BigDecimal montoiniciativa;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="idcliente")
	private Cliente cliente;

	//bi-directional many-to-one association to Tipoiniciativa
	@ManyToOne
	@JoinColumn(name="idtipoiniciativa")
	private Tipoiniciativa tipoiniciativa;

	//bi-directional many-to-one association to Proyecto
	@OneToMany(mappedBy="iniciativa",fetch=FetchType.EAGER)
	private List<Proyecto> proyectos;

	public Iniciativa() {
	}

	public long getIdiniciativa() {
		return this.idiniciativa;
	}

	public void setIdiniciativa(long idiniciativa) {
		this.idiniciativa = idiniciativa;
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

	public Date getFechacontacto() {
		return this.fechacontacto;
	}

	public void setFechacontacto(Date fechacontacto) {
		this.fechacontacto = fechacontacto;
	}

	public Date getFechainicio() {
		return this.fechainicio;
	}

	public void setFechainicio(Date fechainicio) {
		this.fechainicio = fechainicio;
	}

	public BigDecimal getMontoiniciativa() {
		return this.montoiniciativa;
	}

	public void setMontoiniciativa(BigDecimal montoiniciativa) {
		this.montoiniciativa = montoiniciativa;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Tipoiniciativa getTipoiniciativa() {
		return this.tipoiniciativa;
	}

	public void setTipoiniciativa(Tipoiniciativa tipoiniciativa) {
		this.tipoiniciativa = tipoiniciativa;
	}

	public List<Proyecto> getProyectos() {
		return this.proyectos;
	}

	public void setProyectos(List<Proyecto> proyectos) {
		this.proyectos = proyectos;
	}

	public Proyecto addProyecto(Proyecto proyecto) {
		getProyectos().add(proyecto);
		proyecto.setIniciativa(this);

		return proyecto;
	}

	public Proyecto removeProyecto(Proyecto proyecto) {
		getProyectos().remove(proyecto);
		proyecto.setIniciativa(null);

		return proyecto;
	}

}