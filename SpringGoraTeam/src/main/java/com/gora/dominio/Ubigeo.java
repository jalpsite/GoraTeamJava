package com.gora.dominio;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


/**
 * The persistent class for the ubigeo database table.
 * 
 */
@Entity
@NamedQuery(name="Ubigeo.findAll", query="SELECT u FROM Ubigeo u")
@JsonIgnoreProperties(ignoreUnknown=true)
public class Ubigeo implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idubigeo;
	private String departamento;
	private String distrito;
	private String provincia;
	private String codigo;

	public String getCodigo() {
		return codigo;
	}


	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	public Ubigeo() {
	}


	@Id
	@SequenceGenerator(name="UBIGEO_IDUBIGEO_GENERATOR", sequenceName="UBIGEO_SEQUENCE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="UBIGEO_IDUBIGEO_GENERATOR")
	public Long getIdubigeo() {
		return this.idubigeo;
	}

	public void setIdubigeo(Long idubigeo) {
		this.idubigeo = idubigeo;
	}


	public String getDepartamento() {
		return this.departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}


	public String getDistrito() {
		return this.distrito;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}


	public String getProvincia() {
		return this.provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

}