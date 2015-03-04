package com.gora.dominio;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the tipoiniciativa database table.
 * 
 */
@Entity
@NamedQuery(name="Tipoiniciativa.findAll", query="SELECT t FROM Tipoiniciativa t")
public class Tipoiniciativa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="tipoini_seq")
	@SequenceGenerator(
		name="tipoini_seq",
		sequenceName="tipoini_sequence",
		allocationSize=1
	) 
	private Long idtipoiniciativa;

	private String descripcion;

	private String estado;

	//bi-directional many-to-one association to Iniciativa
	@OneToMany(mappedBy="tipoiniciativa",fetch=FetchType.EAGER)
	private List<Iniciativa> iniciativas;

	public Tipoiniciativa() {
	}

	public Long getIdtipoiniciativa() {
		return this.idtipoiniciativa;
	}

	public void setIdtipoiniciativa(Long idtipoiniciativa) {
		this.idtipoiniciativa = idtipoiniciativa;
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

	public List<Iniciativa> getIniciativas() {
		return this.iniciativas;
	}

	public void setIniciativas(List<Iniciativa> iniciativas) {
		this.iniciativas = iniciativas;
	}

	public Iniciativa addIniciativa(Iniciativa iniciativa) {
		getIniciativas().add(iniciativa);
		iniciativa.setTipoiniciativa(this);

		return iniciativa;
	}

	public Iniciativa removeIniciativa(Iniciativa iniciativa) {
		getIniciativas().remove(iniciativa);
		iniciativa.setTipoiniciativa(null);

		return iniciativa;
	}

}