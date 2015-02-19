package com.gora.dominio;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;




/**
 * The persistent class for the atributo database table.
 * 
 */
@Entity
@NamedQuery(name="Usuario.findAll", query="SELECT p FROM Usuario p")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="usuario_seq")
	@SequenceGenerator(
		name="usuario_seq",
		sequenceName="usuario_sequence",
		allocationSize=1
	) 
	private Long id;
	private String estado;
	@JsonIgnore
	private String pass;
	private String usuario;
		
	
	
	@JsonIgnore
	@OneToOne(fetch = FetchType.EAGER)
	@PrimaryKeyJoinColumn
	private Persona per;
	
	@JsonIgnore
	@OneToMany(mappedBy="usuario", cascade = CascadeType.ALL)
	private List<UsuarioRol> usuarioRoles;
	
	public Usuario(){
		
	}
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}



	public String getEstado() {
		return estado;
	}



	public void setEstado(String estado) {
		this.estado = estado;
	}



	public String getPass() {
		return pass;
	}



	public void setPass(String pass) {
		this.pass = pass;
	}



	public String getUsuario() {
		return usuario;
	}



	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


	
	public Persona getPersona() {
		return per;
	}



	public void setPersona(Persona persona) {
		this.per = persona;
	}
	
	
	public List<UsuarioRol> getUsuarioRoles() {
		return usuarioRoles;
	}

	public void setUsuarioRoles(List<UsuarioRol> usuarioRoles) {
		this.usuarioRoles = usuarioRoles;
	}

	
}