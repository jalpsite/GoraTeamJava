package com.gora.dominio;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


/**
 * The persistent class for the atributo database table.
 * 
 */
@Entity
@NamedQuery(name="Equipo.findAll", query="SELECT e FROM Equipo e")
@JsonIgnoreProperties(ignoreUnknown=true)
public class Equipo implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private Long idequipo;

	private String nombre;
	
	@JsonIgnore	
	private Proyecto proyecto;
		
	@JsonIgnore	
	private List<PersonaEquipo> personasequipo;
	
	public Equipo() {
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="equipo_seq")
	@SequenceGenerator(
		name="equipo_seq",
		sequenceName="equipo_sequence",
		allocationSize=1
	) 
	public Long getIdequipo() {
		return idequipo;
	}

	public void setIdequipo(Long idequipo) {
		this.idequipo = idequipo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@OneToOne
	@JoinColumn(name="idproyecto")
	public Proyecto getProyecto() {
		return proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

	@OneToMany(mappedBy="equipo",cascade=CascadeType.ALL)
	public List<PersonaEquipo> getPersonasequipo() {
		return personasequipo;
	}

	public void setPersonasequipo(List<PersonaEquipo> personasequipo) {
		this.personasequipo = personasequipo;
	}
	
	public PersonaEquipo addPersonaEquipo(PersonaEquipo matriz) {
		getPersonasequipo().add(matriz);
		matriz.setEquipo(this);

		return matriz;
	}

	public PersonaEquipo removePersonaEquipo(PersonaEquipo matriz) {
		getPersonasequipo().remove(matriz);
		matriz.setEquipo(null);

		return matriz;
	}
	

}