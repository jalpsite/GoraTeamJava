package com.gora.dominio;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the operacion database table.
 * 
 */
@Entity
@NamedQuery(name="Operacion.findAll", query="SELECT o FROM Operacion o")
public class Operacion implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idoperacion;
	private String estado;
	private String nomoper;

	public Operacion() {
	}


	@Id
	@SequenceGenerator(name="OPERACION_IDOPERACION_GENERATOR", sequenceName="OPERACION_SEQUENCE",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="OPERACION_IDOPERACION_GENERATOR")	
	public Integer getIdoperacion() {
		return this.idoperacion;
	}

	public void setIdoperacion(Integer idoperacion) {
		this.idoperacion = idoperacion;
	}


	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}


	public String getNomoper() {
		return this.nomoper;
	}

	public void setNomoper(String nomoper) {
		this.nomoper = nomoper;
	}

}