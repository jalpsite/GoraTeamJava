package com.gora.dominio;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the proyecto database table.
 * 
 */
@Entity
@NamedQuery(name="Proyecto.findAll", query="SELECT p FROM Proyecto p")
public class Proyecto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="proyecto_seq")
	@SequenceGenerator(
		name="proyecto_seq",
		sequenceName="proyecto_sequence",
		allocationSize=1
	) 
	private Long idproyecto;

	private String estado;

	@Temporal(TemporalType.DATE)
	private Date fechafin;

	@Temporal(TemporalType.DATE)
	private Date fechainicio;

	private BigDecimal monto;

	private String nombre;

	//bi-directional many-to-one association to Cronograma
	@OneToMany(mappedBy="proyecto",fetch=FetchType.EAGER)
	private List<Cronograma> cronogramas;

	//bi-directional many-to-one association to Evaluacion
	@OneToMany(mappedBy="proyecto",fetch=FetchType.EAGER)
	private List<Evaluacion> evaluacions;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="idcliente")
	private Cliente cliente;

	//bi-directional many-to-one association to Iniciativa
	@ManyToOne
	@JoinColumn(name="idiniciativa")
	private Iniciativa iniciativa;

	//bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name="idpergestor")
	private Persona persona;

	//bi-directional many-to-one association to Portafolio
	@ManyToOne
	@JoinColumn(name="idportafolio")
	private Portafolio portafolio;

	//bi-directional many-to-one association to Tipoproyecto
	@ManyToOne
	@JoinColumn(name="idtipoproyecto")
	private Tipoproyecto tipoproyecto;

	public Proyecto() {
	}

	public Long getIdproyecto() {
		return this.idproyecto;
	}

	public void setIdproyecto(Long idproyecto) {
		this.idproyecto = idproyecto;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechafin() {
		return this.fechafin;
	}

	public void setFechafin(Date fechafin) {
		this.fechafin = fechafin;
	}

	public Date getFechainicio() {
		return this.fechainicio;
	}

	public void setFechainicio(Date fechainicio) {
		this.fechainicio = fechainicio;
	}

	public BigDecimal getMonto() {
		return this.monto;
	}

	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Cronograma> getCronogramas() {
		return this.cronogramas;
	}

	public void setCronogramas(List<Cronograma> cronogramas) {
		this.cronogramas = cronogramas;
	}

	public Cronograma addCronograma(Cronograma cronograma) {
		getCronogramas().add(cronograma);
		cronograma.setProyecto(this);

		return cronograma;
	}

	public Cronograma removeCronograma(Cronograma cronograma) {
		getCronogramas().remove(cronograma);
		cronograma.setProyecto(null);

		return cronograma;
	}

	public List<Evaluacion> getEvaluacions() {
		return this.evaluacions;
	}

	public void setEvaluacions(List<Evaluacion> evaluacions) {
		this.evaluacions = evaluacions;
	}

	public Evaluacion addEvaluacion(Evaluacion evaluacion) {
		getEvaluacions().add(evaluacion);
		evaluacion.setProyecto(this);

		return evaluacion;
	}

	public Evaluacion removeEvaluacion(Evaluacion evaluacion) {
		getEvaluacions().remove(evaluacion);
		evaluacion.setProyecto(null);

		return evaluacion;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Iniciativa getIniciativa() {
		return this.iniciativa;
	}

	public void setIniciativa(Iniciativa iniciativa) {
		this.iniciativa = iniciativa;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Portafolio getPortafolio() {
		return this.portafolio;
	}

	public void setPortafolio(Portafolio portafolio) {
		this.portafolio = portafolio;
	}

	public Tipoproyecto getTipoproyecto() {
		return this.tipoproyecto;
	}

	public void setTipoproyecto(Tipoproyecto tipoproyecto) {
		this.tipoproyecto = tipoproyecto;
	}

}