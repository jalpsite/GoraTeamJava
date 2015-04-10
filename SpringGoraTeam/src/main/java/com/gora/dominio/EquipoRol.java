package com.gora.dominio;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


/**
 * The persistent class for the atributo database table.
 * 
 */
@Entity
@Table(name="equipo_rol")
@NamedQuery(name="EquipoRol.findAll", query="SELECT e FROM EquipoRol e")
@JsonIgnoreProperties(ignoreUnknown=true)
public class EquipoRol implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="equiporol_seq")
	@SequenceGenerator(
		name="equiporol_seq",
		sequenceName="equiporol_sequence",
		allocationSize=1
	) 
	private Long idequiporol;

	private String descripcion;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="idproyecto")
	private Proyecto proyecto;
		
	private BigDecimal costo;
	
	@JsonIgnore
	@OneToMany(mappedBy="equipoRol")
	private List<PersonaEquipo> personasEquipo;
	
	
	public EquipoRol() {
	}
	public Long getIdequiporol() {
		return idequiporol;
	}
	public void setIdequiporol(Long idequiporol) {
		this.idequiporol = idequiporol;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Proyecto getProyecto() {
		return proyecto;
	}
	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}
	public BigDecimal getCosto() {
		return costo;
	}
	public void setCosto(BigDecimal costo) {
		this.costo = costo;
	}
	public List<PersonaEquipo> getPersonasEquipo() {
		return personasEquipo;
	}
	public void setPersonasEquipo(List<PersonaEquipo> personasEquipo) {
		this.personasEquipo = personasEquipo;
	}
	
	
	
	

}