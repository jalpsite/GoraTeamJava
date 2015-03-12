package com.gora.dominio;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the cliente database table.
 * 
 */
@Entity
@NamedQuery(name="Cliente.findAll", query="SELECT c FROM Cliente c")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="cliente_seq")
	@SequenceGenerator(
		name="cliente_seq",
		sequenceName="cliente_sequence",
		allocationSize=1
	) 
	private Long idcliente;

	private String contacto;

	private String direccion;

	private String emailcontacto;

	private String estado;

	private String nombre;

	private String telefono;

	private String telefonocontacto;

	//bi-directional many-to-one association to Ubigeo
	@ManyToOne
	@JoinColumn(name="idubigeo")
	private Ubigeo ubigeo;

	//bi-directional many-to-one association to Iniciativa
	@OneToMany(mappedBy="cliente",fetch=FetchType.EAGER)
	private List<Iniciativa> iniciativas;

	@JsonIgnore
	//bi-directional many-to-one association to Proyecto
	@OneToMany(mappedBy="cliente",fetch=FetchType.EAGER)
	private List<Proyecto> proyectos;

	public Cliente() {
	}

	public Long getIdcliente() {
		return this.idcliente;
	}

	public void setIdcliente(Long idcliente) {
		this.idcliente = idcliente;
	}

	public String getContacto() {
		return this.contacto;
	}

	public void setContacto(String contacto) {
		this.contacto = contacto;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmailcontacto() {
		return this.emailcontacto;
	}

	public void setEmailcontacto(String emailcontacto) {
		this.emailcontacto = emailcontacto;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getTelefonocontacto() {
		return this.telefonocontacto;
	}

	public void setTelefonocontacto(String telefonocontacto) {
		this.telefonocontacto = telefonocontacto;
	}

	public Ubigeo getUbigeo() {
		return this.ubigeo;
	}

	public void setUbigeo(Ubigeo ubigeo) {
		this.ubigeo = ubigeo;
	}

	public List<Iniciativa> getIniciativas() {
		return this.iniciativas;
	}

	public void setIniciativas(List<Iniciativa> iniciativas) {
		this.iniciativas = iniciativas;
	}

	public Iniciativa addIniciativa(Iniciativa iniciativa) {
		getIniciativas().add(iniciativa);
		iniciativa.setCliente(this);

		return iniciativa;
	}

	public Iniciativa removeIniciativa(Iniciativa iniciativa) {
		getIniciativas().remove(iniciativa);
		iniciativa.setCliente(null);

		return iniciativa;
	}

	public List<Proyecto> getProyectos() {
		return this.proyectos;
	}

	public void setProyectos(List<Proyecto> proyectos) {
		this.proyectos = proyectos;
	}

	public Proyecto addProyecto(Proyecto proyecto) {
		getProyectos().add(proyecto);
		proyecto.setCliente(this);

		return proyecto;
	}

	public Proyecto removeProyecto(Proyecto proyecto) {
		getProyectos().remove(proyecto);
		proyecto.setCliente(null);

		return proyecto;
	}

}