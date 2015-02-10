package com.gora.dominio;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the etapa database table.
 * 
 */
@Entity
@NamedQuery(name="Etapa.findAll", query="SELECT e FROM Etapa e")
public class Etapa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="etapa_seq")
	@SequenceGenerator(
		name="etapa_seq",
		sequenceName="etapa_sequence",
		allocationSize=1
	) 
	private long idetapa;

	private String descripcion;

	private String estado;

	//bi-directional many-to-one association to Cronograma
	@OneToMany(mappedBy="etapa",fetch=FetchType.EAGER)
	private List<Cronograma> cronogramas;

	public Etapa() {
	}

	public long getIdetapa() {
		return this.idetapa;
	}

	public void setIdetapa(long idetapa) {
		this.idetapa = idetapa;
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

	public List<Cronograma> getCronogramas() {
		return this.cronogramas;
	}

	public void setCronogramas(List<Cronograma> cronogramas) {
		this.cronogramas = cronogramas;
	}

	public Cronograma addCronograma(Cronograma cronograma) {
		getCronogramas().add(cronograma);
		cronograma.setEtapa(this);

		return cronograma;
	}

	public Cronograma removeCronograma(Cronograma cronograma) {
		getCronogramas().remove(cronograma);
		cronograma.setEtapa(null);

		return cronograma;
	}

}