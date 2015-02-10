package com.gora.dominio;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


/**
 * The persistent class for the atributo database table.
 * 
 */
@Entity
@NamedQuery(name="Atributo.findAll", query="SELECT a FROM Atributo a")
@JsonIgnoreProperties(ignoreUnknown=true)
public class Atributo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="atributo_seq")
	@SequenceGenerator(
		name="atributo_seq",
		sequenceName="atributo_sequence",
		allocationSize=1
	) 
	private Long idatributo;

	private String descripcion;

	private String estado;
	
	@ManyToOne
	@JoinColumn(name="idhabilidades")
	private Habilidades habilidades;
	
	@JsonIgnore
	@OneToMany(mappedBy="atributo",fetch=FetchType.LAZY)
	private List<Atributos> atributos;
	
	public Atributo() {
	}

	public Long getIdatributo() {
		return this.idatributo;
	}

	public void setIdatributo(Long idatributo) {
		this.idatributo = idatributo;
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
	
	public List<Atributos> getAtributos() {
		return atributos;
	}

	public void setAtributos(List<Atributos> atributos) {
		this.atributos = atributos;
	}

	public Habilidades getHabilidades() {
		return habilidades;
	}

	public void setHabilidades(Habilidades habilidades) {
		this.habilidades = habilidades;
	}	


}