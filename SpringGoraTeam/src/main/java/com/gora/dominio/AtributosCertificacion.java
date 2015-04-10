package com.gora.dominio;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import org.junit.Ignore;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


/**
 * The persistent class for the atributo database table.
 * 
 */
@Entity
@Table(name="atributos_certificaciones")
@NamedQuery(name="AtributosCertificacion.findAll", query="SELECT a FROM AtributosCertificacion a")
@JsonIgnoreProperties(ignoreUnknown=true)
public class AtributosCertificacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="atributos_cert_seq")
	@SequenceGenerator(
		name="atributos_cert_seq",
		sequenceName="atributos_certificaciones_sequence",
		allocationSize=1
	) 
	private Long idatributocertificacion;

	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="idatributos")
	private Atributos atributos;

	private String nom_certificacion;	
	private String nro_certificacion;	
	@Temporal(TemporalType.DATE)	
	private Date fecha_inicio;
	@Temporal(TemporalType.DATE)	
	private Date fecha_fin;	
	
	
	public AtributosCertificacion() {
	}


	public Long getIdatributocertificacion() {
		return idatributocertificacion;
	}


	public void setIdatributocertificacion(Long idatributocertificacion) {
		this.idatributocertificacion = idatributocertificacion;
	}


	public Atributos getAtributos() {
		return atributos;
	}


	public void setAtributos(Atributos atributos) {
		this.atributos = atributos;
	}


	public String getNom_certificacion() {
		return nom_certificacion;
	}


	public void setNom_certificacion(String nom_certificacion) {
		this.nom_certificacion = nom_certificacion;
	}


	public String getNro_certificacion() {
		return nro_certificacion;
	}


	public void setNro_certificacion(String nro_certificacion) {
		this.nro_certificacion = nro_certificacion;
	}


	public Date getFecha_inicio() {
		return fecha_inicio;
	}


	public void setFecha_inicio(Date fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}


	public Date getFecha_fin() {
		return fecha_fin;
	}


	public void setFecha_fin(Date fecha_fin) {
		this.fecha_fin = fecha_fin;
	}



	
	

}