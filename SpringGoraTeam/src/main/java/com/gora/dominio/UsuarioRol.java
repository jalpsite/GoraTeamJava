package com.gora.dominio;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.Type;
import org.junit.Ignore;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;




/**
 * The persistent class for the atributo database table.
 * 
 */
@Entity
@Table(name="usuario_rol")
@NamedQuery(name="UsuarioRol.findAll", query="SELECT p FROM UsuarioRol p")
@JsonIgnoreProperties(ignoreUnknown=true)
public class UsuarioRol implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="usuario_rol_seq")
	@SequenceGenerator(
		name="usuario_rol_seq",
		sequenceName="usuario_rol_sequence",
		allocationSize=1
	) 
	private Long idusuariorol;
	private String estado;
	
	//@JsonIgnore
	@ManyToOne
	@JoinColumn(name="idrol")
	private Rol rol;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;
	
		
	public UsuarioRol(){
		
	}
	
	
	public Long getIdusuariorol() {
		return idusuariorol;
	}

	
	public void setIdusuariorol(Long idusuariorol) {
		this.idusuariorol = idusuariorol;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}

	
	public Rol getRol() {
		return rol;
	}


	public void setRol(Rol rol) {
		this.rol = rol;
	}

	
	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	


	

	
}