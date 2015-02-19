package com.gora.dominio;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the rol_operacion database table.
 * 
 */
@Entity
@Table(name="rol")
@NamedQuery(name="Rol.findAll", query="SELECT r FROM Rol r")
public class Rol implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name="ROL_IDROL_GENERATOR", sequenceName="ROL_SEQUENCE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ROL_IDROL_GENERATOR")
	private Long idrol;
	private String estado;
	private String nomrol;	
	
	@JsonIgnore
	@OneToMany(mappedBy="rol", cascade = CascadeType.ALL)
	private List<UsuarioRol> usuarioRoles;
	
	public Rol() {
	}
	
	
	public Long getIdrol() {
		return idrol;
	}

	public void setIdrol(Long idrol) {
		this.idrol = idrol;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getNomrol() {
		return nomrol;
	}

	public void setNomrol(String nomrol) {
		this.nomrol = nomrol;
	}
	
	public List<UsuarioRol> getUsuarioRoles() {
		return usuarioRoles;
	}

	public void setUsuarioRoles(List<UsuarioRol> usuarioRoles) {
		this.usuarioRoles = usuarioRoles;
	}
	
	
	


	

}