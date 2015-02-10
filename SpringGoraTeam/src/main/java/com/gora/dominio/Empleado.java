package com.gora.dominio;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the empleado database table.
 * 
 */
@Entity
@NamedQuery(name="Empleado.findAll", query="SELECT e FROM Empleado e")
public class Empleado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="empleado_seq")
	@SequenceGenerator(
		name="empleado_seq",
		sequenceName="empleado_sequence",
		allocationSize=1
	) 
	private long idpersona;

	private String estado;

	@Temporal(TemporalType.DATE)
	private Date fechaingreso;

	private String nroafp;

	private String nroipss;

	//bi-directional many-to-one association to Cargo
	@ManyToOne
	@JoinColumn(name="idcargo")
	private Cargo cargo;

	//bi-directional one-to-one association to Persona
	@OneToOne
	@JoinColumn(name="idpersona")
	private Persona persona;

	public Empleado() {
	}

	public long getIdpersona() {
		return this.idpersona;
	}

	public void setIdpersona(long idpersona) {
		this.idpersona = idpersona;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaingreso() {
		return this.fechaingreso;
	}

	public void setFechaingreso(Date fechaingreso) {
		this.fechaingreso = fechaingreso;
	}

	public String getNroafp() {
		return this.nroafp;
	}

	public void setNroafp(String nroafp) {
		this.nroafp = nroafp;
	}

	public String getNroipss() {
		return this.nroipss;
	}

	public void setNroipss(String nroipss) {
		this.nroipss = nroipss;
	}

	public Cargo getCargo() {
		return this.cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

}