package com.gora.dominio;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


/**
 * The persistent class for the experiencia database table.
 * 
 */
@Entity
@NamedQuery(name="Experiencia.findAll", query="SELECT e FROM Experiencia e")
@JsonIgnoreProperties(ignoreUnknown=true)
public class Experiencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="experiencia_seq")
	@SequenceGenerator(
		name="experiencia_seq",
		sequenceName="experiencia_sequence",
		allocationSize=1
	) 
	private Long idexperiencia;
	

	private String cargo;

	private String descripcion;

	private String estado;
	
	private String empresa;
	
	private String pais;
	
	private String encurso;
	
	@Temporal(TemporalType.DATE)
	private Date anhoinicio;
	
	@Temporal(TemporalType.DATE)
	private Date anhofin;
	
	@JsonIgnore
	//bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name="idpersona")
	private Persona persona;

	public Experiencia() {
	}

	public Long getIdexperiencia() {
		return this.idexperiencia;
	}

	public void setIdexperiencia(Long idexperiencia) {
		this.idexperiencia = idexperiencia;
	}
/*
	public String getAño() {
		return this.año;
	}

	public void setAño(String año) {
		this.año = año;
	}
*/
	public String getCargo() {
		return this.cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
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

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public Date getAnhoinicio() {
		return anhoinicio;
	}

	public void setAnhoinicio(Date añoinicio) {
		this.anhoinicio = añoinicio;
	}

	public Date getAnhofin() {
		return anhofin;
	}

	public void setAnhofin(Date añofin) {
		this.anhofin = añofin;
	}

	public String getEncurso() {
		return encurso;
	}

	public void setEncurso(String encurso) {
		this.encurso = encurso;
	}

}