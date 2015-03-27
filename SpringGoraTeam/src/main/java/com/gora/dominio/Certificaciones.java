package com.gora.dominio;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnore;




/**
 * The persistent class for the atributo database table.
 * 
 */
@Entity
@Table(name="certificaciones")
@NamedQuery(name="Certificaciones.findAll", query="SELECT c FROM Certificaciones c")
public class Certificaciones implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="certi_seq")
	@SequenceGenerator(
		name="certi_seq",
		sequenceName="certificaciones_sequence",
		allocationSize=1
	) 
	private Long idcertificacion;
	private Long idhabilidades;
	private String descripcion;	
	private String estado;
	
	
	
	public Certificaciones(){
		
	}



	public Long getIdcertificacion() {
		return idcertificacion;
	}



	public void setIdcertificacion(Long idcertificacion) {
		this.idcertificacion = idcertificacion;
	}



	public Long getIdhabilidades() {
		return idhabilidades;
	}



	public void setIdhabilidades(Long idhabilidades) {
		this.idhabilidades = idhabilidades;
	}



	public String getDescripcion() {
		return descripcion;
	}



	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



	public String getEstado() {
		return estado;
	}



	public void setEstado(String estado) {
		this.estado = estado;
	}

	


}