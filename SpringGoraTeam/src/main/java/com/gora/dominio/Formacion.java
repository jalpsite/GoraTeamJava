package com.gora.dominio;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;


/**
 * The persistent class for the formacion database table.
 * 
 */
@Entity
@NamedQuery(name="Formacion.findAll", query="SELECT f FROM Formacion f")
@JsonIgnoreProperties(ignoreUnknown=true)
public class Formacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="formacion_seq")
	@SequenceGenerator(
		name="formacion_seq",
		sequenceName="formacion_sequence",
		allocationSize=1
	) 
	private Long idformacion;

	@Temporal(TemporalType.DATE)	
	private Date anhofin;

	@Temporal(TemporalType.DATE)
	private Date anhoinicio;

	private String descripcion;
	
	private String nivelestudio;

	//bi-directional many-to-one association to Carrera
	
	//@JsonIgnore
	@ManyToOne
	@JoinColumn(name="idcarrera")
	private Carrera carrera;

	//bi-directional many-to-one association to Grado
	
	//@JsonIgnore
	@ManyToOne
	@JoinColumn(name="idgrado")
	private Grado grado;

	
	//bi-directional many-to-one association to Persona
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="idpersona")
	private Persona persona;

	//bi-directional many-to-one association to Universidad
	//@JsonIgnore
	@ManyToOne
	@JoinColumn(name="iduniversidad")
	private Universidad universidad;

	private String encurso;
	
	private String otrogrado;
	
	private String otrauniversidad;
	
	public Formacion() {
	}

	public Long getIdformacion() {
		return this.idformacion;
	}

	public void setIdformacion(Long idformacion) {
		this.idformacion = idformacion;
	}

	public Date getAnhofin() {
		return this.anhofin;
	}

	public void setAnhofin(Date añofin) {
		this.anhofin = añofin;
	}

	public Date getAnhoinicio() {
		return this.anhoinicio;
	}

	public void setAnhoinicio(Date añoinicio) {
		this.anhoinicio = añoinicio;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Carrera getCarrera() {
		return this.carrera;
	}

	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}

	public Grado getGrado() {
		return this.grado;
	}

	public void setGrado(Grado grado) {
		this.grado = grado;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Universidad getUniversidad() {
		return this.universidad;
	}

	public void setUniversidad(Universidad universidad) {
		this.universidad = universidad;
	}

	public String getNivelestudio() {
		return nivelestudio;
	}

	public void setNivelestudio(String nivelestudio) {
		this.nivelestudio = nivelestudio;
	}

	public String getEncurso() {
		return encurso;
	}

	public void setEncurso(String encurso) {
		this.encurso = encurso;
	}

	public String getOtrogrado() {
		return otrogrado;
	}

	public void setOtrogrado(String otrogrado) {
		this.otrogrado = otrogrado;
	}

	public String getOtrauniversidad() {
		return otrauniversidad;
	}

	public void setOtrauniversidad(String otrauniversidad) {
		this.otrauniversidad = otrauniversidad;
	}

	

}