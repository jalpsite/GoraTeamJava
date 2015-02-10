package com.gora.dominio;

import java.io.Serializable;
import java.util.Date;


import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



/**
 * The persistent class for the persona database table.
 * 
 */
@Entity
@Table(name = "persona")
public class PersonaDatos implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idpersona;
	private String apemat;
	private String apepat;
	private String estado;
	private String estadocivil;
	private Date fechanacimiento;
	private String nacionalidad;
	private String nombres;
	private String numerodocidentidad;
	private String tipodocidentidad;
	private String sexo;
	private String codigo;

	private String presentacion;

	public PersonaDatos() {
	}

	@Id
	@SequenceGenerator(name = "PERSONADATOS_IDPERSONA_GENERATOR", sequenceName = "PERSONA_SEQUENCE")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PERSONADATOS_IDPERSONA_GENERATOR")
	public Long getIdpersona() {
		return this.idpersona;
	}

	public void setIdpersona(Long idpersona) {
		this.idpersona = idpersona;
	}

	public String getApemat() {
		return this.apemat;
	}

	public void setApemat(String apemat) {
		this.apemat = apemat;
	}

	public String getApepat() {
		return this.apepat;
	}

	public void setApepat(String apepat) {
		this.apepat = apepat;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getEstadocivil() {
		return this.estadocivil;
	}

	public void setEstadocivil(String estadocivil) {
		this.estadocivil = estadocivil;
	}

	@Temporal(TemporalType.DATE)
	public Date getFechanacimiento() {
		return this.fechanacimiento;
	}

	public void setFechanacimiento(Date fechanacimiento) {
		this.fechanacimiento = fechanacimiento;
	}

	public String getNacionalidad() {
		return this.nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getNumerodocidentidad() {
		return this.numerodocidentidad;
	}

	public void setNumerodocidentidad(String numerodocidentidad) {
		this.numerodocidentidad = numerodocidentidad;
	}

	public String getTipodocidentidad() {
		return this.tipodocidentidad;
	}

	public String getPresentacion() {
		return presentacion;
	}

	public void setPresentacion(String presentacion) {
		this.presentacion = presentacion;
	}

	public void setTipodocidentidad(String tipodocidentidad) {
		this.tipodocidentidad = tipodocidentidad;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

}