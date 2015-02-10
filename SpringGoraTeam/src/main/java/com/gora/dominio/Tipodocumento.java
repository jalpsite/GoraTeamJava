package com.gora.dominio;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tipodocumento database table.
 * 
 */
@Entity
@NamedQuery(name="Tipodocumento.findAll", query="SELECT t FROM Tipodocumento t")
public class Tipodocumento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="tipodoc_seq")
	@SequenceGenerator(
		name="tipodoc_seq",
		sequenceName="tipodoc_sequence",
		allocationSize=1
	) 
	private Long idtipodocumento;

	private String descripcion;

	private String estado;

	public Tipodocumento() {
	}

	public Long getIdtipodocumento() {
		return this.idtipodocumento;
	}

	public void setIdtipodocumento(Long idtipodocumento) {
		this.idtipodocumento = idtipodocumento;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripciion) {
		this.descripcion = descripciion;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}