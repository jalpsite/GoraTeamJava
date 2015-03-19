package com.gora.dominio;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;


/**
 * The persistent class for the competencia database table.
 * 
 */
@Entity
@NamedQuery(name="Competencia.findAll", query="SELECT c FROM Competencia c")
@JsonIgnoreProperties(ignoreUnknown=true)
public class Competencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="competencia_seq")
	@SequenceGenerator(
		name="competencia_seq",
		sequenceName="competencia_sequence",
		allocationSize=1
	) 
	private Long idcompetencia;

	private String descripcion;

	private String estado;

	@JsonIgnore
	//bi-directional many-to-one association to Matriz
	@OneToMany(mappedBy="competencia")
	private List<Matriz> matrizs;
	
	@JsonIgnore
	//bi-directional many-to-one association to habilidades
	@OneToMany(mappedBy="competencia")
	private List<Habilidades> habilidades;

	public List<Habilidades> getHabilidades() {
			return habilidades;
		}

		public void setHabilidades(List<Habilidades> habilidades) {
			this.habilidades = habilidades;
		}

	public Competencia() {
	}

	public Long getIdcompetencia() {
		return this.idcompetencia;
	}

	public void setIdcompetencia(Long idcompetencia) {
		this.idcompetencia = idcompetencia;
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
	
	@JsonIgnore
	public List<Matriz> getMatrizs() {
		return this.matrizs;
	}

	public void setMatrizs(List<Matriz> matrizs) {
		this.matrizs = matrizs;
	}

	public Matriz addMatriz(Matriz matriz) {
		getMatrizs().add(matriz);
		matriz.setCompetencia(this);

		return matriz;
	}

	public Matriz removeMatriz(Matriz matriz) {
		getMatrizs().remove(matriz);
		matriz.setCompetencia(null);

		return matriz;
	}

}