package com.gora.dominio;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the tarea database table.
 * 
 */
@Entity
@NamedQuery(name="Tarea.findAll", query="SELECT t FROM Tarea t")
public class Tarea implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="tarea_seq")
	@SequenceGenerator(
		name="tarea_seq",
		sequenceName="tarea_sequence",
		allocationSize=1
	) 
	private long idtarea;

	private String codigoedt;

	private BigDecimal costo;

	private String descripcion;

	private String estado;

	@Temporal(TemporalType.DATE)
	private Date fecfin;

	@Temporal(TemporalType.DATE)
	private Date fecini;

	private BigDecimal horareales;

	private BigDecimal horas;

	private BigDecimal nivel;

	private String nombre;

	private String titulo;

	//bi-directional many-to-one association to Cronograma
	@OneToMany(mappedBy="tarea")
	private List<Cronograma> cronogramas;

	//bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name="idpersonaasig")
	private Persona persona;

	//bi-directional many-to-one association to Tarea
	@ManyToOne
	@JoinColumn(name="idtareapred")
	private Tarea tarea1;

	//bi-directional many-to-one association to Tarea
	@OneToMany(mappedBy="tarea1")
	private List<Tarea> tareas1;

	//bi-directional many-to-one association to Tarea
	@ManyToOne
	@JoinColumn(name="idtareasuce")
	private Tarea tarea2;

	//bi-directional many-to-one association to Tarea
	@OneToMany(mappedBy="tarea2")
	private List<Tarea> tareas2;

	@ManyToOne
	@JoinColumn(name="identregable")
	private Entregable entregable;
	
	public Tarea() {
	}

	public long getIdtarea() {
		return this.idtarea;
	}

	public void setIdtarea(long idtarea) {
		this.idtarea = idtarea;
	}

	public String getCodigoedt() {
		return this.codigoedt;
	}

	public void setCodigoedt(String codigoedt) {
		this.codigoedt = codigoedt;
	}

	public BigDecimal getCosto() {
		return this.costo;
	}

	public void setCosto(BigDecimal costo) {
		this.costo = costo;
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

	public Date getFecfin() {
		return this.fecfin;
	}

	public void setFecfin(Date fecfin) {
		this.fecfin = fecfin;
	}

	public Date getFecini() {
		return this.fecini;
	}

	public void setFecini(Date fecini) {
		this.fecini = fecini;
	}

	public BigDecimal getHorareales() {
		return this.horareales;
	}

	public void setHorareales(BigDecimal horareales) {
		this.horareales = horareales;
	}

	public BigDecimal getHoras() {
		return this.horas;
	}

	public void setHoras(BigDecimal horas) {
		this.horas = horas;
	}

	public BigDecimal getNivel() {
		return this.nivel;
	}

	public void setNivel(BigDecimal nivel) {
		this.nivel = nivel;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public List<Cronograma> getCronogramas() {
		return this.cronogramas;
	}

	public void setCronogramas(List<Cronograma> cronogramas) {
		this.cronogramas = cronogramas;
	}

	public Cronograma addCronograma(Cronograma cronograma) {
		getCronogramas().add(cronograma);
		cronograma.setTarea(this);

		return cronograma;
	}

	public Cronograma removeCronograma(Cronograma cronograma) {
		getCronogramas().remove(cronograma);
		cronograma.setTarea(null);

		return cronograma;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Tarea getTarea1() {
		return this.tarea1;
	}

	public void setTarea1(Tarea tarea1) {
		this.tarea1 = tarea1;
	}

	public List<Tarea> getTareas1() {
		return this.tareas1;
	}

	public void setTareas1(List<Tarea> tareas1) {
		this.tareas1 = tareas1;
	}

	public Tarea addTareas1(Tarea tareas1) {
		getTareas1().add(tareas1);
		tareas1.setTarea1(this);

		return tareas1;
	}

	public Tarea removeTareas1(Tarea tareas1) {
		getTareas1().remove(tareas1);
		tareas1.setTarea1(null);

		return tareas1;
	}

	public Tarea getTarea2() {
		return this.tarea2;
	}

	public void setTarea2(Tarea tarea2) {
		this.tarea2 = tarea2;
	}

	public List<Tarea> getTareas2() {
		return this.tareas2;
	}

	public void setTareas2(List<Tarea> tareas2) {
		this.tareas2 = tareas2;
	}

	public Tarea addTareas2(Tarea tareas2) {
		getTareas2().add(tareas2);
		tareas2.setTarea2(this);

		return tareas2;
	}

	public Tarea removeTareas2(Tarea tareas2) {
		getTareas2().remove(tareas2);
		tareas2.setTarea2(null);

		return tareas2;
	}

}