package com.gora.dominio;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;


/**
 * The persistent class for the persona database table.
 * 
 */
@Entity
@NamedQuery(name="Persona.findAll", query="SELECT p FROM Persona p")
@JsonIgnoreProperties(ignoreUnknown=true)
public class Persona implements Serializable {
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
	
	private String perfil;
		
	//@JsonIgnore
	private Usuario usuario;
	
	
	private Persona persona;
		
	@JsonIgnore
	private List<Persona> personas;
    
	//@JsonIgnore
	private List<PersonaDireccion> personaDireccions;
	
	//@JsonIgnore
	private List<PersonaEmail> personaEmails;
	
	//@JsonIgnore
	private List<PersonaTelefono> personaTelefonos;
	
	@JsonIgnore
	private List<Experiencia> experiencias;
	
	@JsonIgnore
	private List<Formacion> formacions;
	
	@JsonIgnore
	private List<Matriz> matrices;
	
	@JsonIgnore
	private List<PersonaEquipo> personasequipo;
	
	public Persona() {
	}


	@Id
	@SequenceGenerator(name="PERSONA_IDPERSONA_GENERATOR", sequenceName="PERSONA_SEQUENCE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PERSONA_IDPERSONA_GENERATOR")
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


	public String getPerfil() {
		return perfil;
	}


	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}


	public void setPresentacion(String presentacion) {
		this.presentacion = presentacion;
	}


	public void setTipodocidentidad(String tipodocidentidad) {
		this.tipodocidentidad = tipodocidentidad;
	}


	//bi-directional many-to-one association to PersonaDireccion
	@OneToMany(mappedBy="persona", fetch=FetchType.EAGER)
	public List<PersonaDireccion> getPersonaDireccions() {
		return this.personaDireccions;
	}

	public void setPersonaDireccions(List<PersonaDireccion> personaDireccions) {
		this.personaDireccions = personaDireccions;
	}

	public PersonaDireccion addPersonaDireccion(PersonaDireccion personaDireccion) {
		getPersonaDireccions().add(personaDireccion);
		personaDireccion.setPersona(this);

		return personaDireccion;
	}

	public PersonaDireccion removePersonaDireccion(PersonaDireccion personaDireccion) {
		getPersonaDireccions().remove(personaDireccion);
		personaDireccion.setPersona(null);

		return personaDireccion;
	}


	//bi-directional many-to-one association to PersonaEmail
	@OneToMany(mappedBy="persona" , fetch=FetchType.EAGER)
	public List<PersonaEmail> getPersonaEmails() {
		return this.personaEmails;
	}

	public void setPersonaEmails(List<PersonaEmail> personaEmails) {
		this.personaEmails = personaEmails;
	}

	public PersonaEmail addPersonaEmail(PersonaEmail personaEmail) {
		getPersonaEmails().add(personaEmail);
		personaEmail.setPersona(this);

		return personaEmail;
	}

	public PersonaEmail removePersonaEmail(PersonaEmail personaEmail) {
		getPersonaEmails().remove(personaEmail);
		personaEmail.setPersona(null);

		return personaEmail;
	}



	//bi-directional many-to-one association to PersonaEmail
	@OneToMany(mappedBy="persona", fetch=FetchType.EAGER)
	public List<PersonaTelefono> getPersonaTelefonos() {
		return this.personaTelefonos;
	}

	public void setPersonaTelefonos(List<PersonaTelefono> personaTelefonos) {
		this.personaTelefonos = personaTelefonos;
	}


	public PersonaTelefono addPersonaTelefono(PersonaTelefono personaTelefono) {
		getPersonaTelefonos().add(personaTelefono);
		personaTelefono.setPersona(this);

		return personaTelefono;
	}

	public PersonaTelefono removePersonaTelefono(PersonaTelefono personaTelefono) {
		getPersonaTelefonos().remove(personaTelefono);
		personaTelefono.setPersona(null);

		return personaTelefono;
	}


	//bi-directional many-to-one association to Persona
		@ManyToOne
		@JoinColumn(name="idpermanager")
		@JsonBackReference
		public Persona getPersona() {
			return this.persona;
		}

		public void setPersona(Persona persona) {
			this.persona = persona;
		}


		//bi-directional many-to-one association to Persona
		@OneToMany(mappedBy="persona", fetch=FetchType.EAGER)
		@JsonManagedReference 
		public List<Persona> getPersonas() {
			return this.personas;
		}

		public void setPersonas(List<Persona> personas) {
			this.personas = personas;
		}

		public Persona addPersona(Persona persona) {
			getPersonas().add(persona);
			persona.setPersona(this);

			return persona;
		}

		public Persona removePersona(Persona persona) {
			getPersonas().remove(persona);
			persona.setPersona(null);

			return persona;
		}

		
		//bi-directional many-to-one association to Formacion
		@OneToMany(mappedBy="persona", fetch=FetchType.EAGER)
		public List<Formacion> getFormacions() {
			return this.formacions;
		}

		public void setFormacions(List<Formacion> formacions) {
			this.formacions = formacions;
		}


		public Formacion addFormacion(Formacion formacion) {
			getFormacions().add(formacion);
			formacion.setPersona(this);

			return formacion;
		}

		public Formacion removeFormacion(Formacion formacion) {
			getFormacions().remove(formacion);
			formacion.setPersona(null);

			return formacion;
		}

		//bi-directional many-to-one association to Experiencia
		@OneToMany(mappedBy="persona", fetch=FetchType.EAGER)
		public List<Experiencia> getExperiencias() {
			return this.experiencias;
		}

		public void setExperiencias(List<Experiencia> experiencias) {
			this.experiencias = experiencias;
		}


		public Experiencia addExperiencia(Experiencia experiencia) {
			getExperiencias().add(experiencia);
			experiencia.setPersona(this);

			return experiencia;
		}

		public Experiencia removeExperiencia(Experiencia experiencia) {
			getExperiencias().remove(experiencia);
			experiencia.setPersona(null);

			return experiencia;
		}

		
		//bi-directional many-to-one association to Matriz
		@OneToMany(mappedBy="persona", fetch=FetchType.EAGER)
		public List<Matriz> getMatrices() {
			return this.matrices;
		}

		public void setMatrices(List<Matriz> matrices) {
			this.matrices = matrices;
		}


		public Matriz addMatriz(Matriz matriz) {
			getMatrices().add(matriz);
			matriz.setPersona(this);

			return matriz;
		}

		public Matriz removeMatriz(Matriz matriz) {
			getMatrices().remove(matriz);
			matriz.setPersona(null);

			return matriz;
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

			
		@OneToOne
		@JoinColumn(name="idusuario")			
		public Usuario getUsuario() {
			return usuario;
		}

		
		public void setUsuario(Usuario usuario) {
			this.usuario = usuario;
		}
		
		@OneToMany(mappedBy="persona",cascade = CascadeType.ALL,fetch=FetchType.LAZY)		
		public List<PersonaEquipo> getPersonasequipo() {
			return personasequipo;
		}


		public void setPersonasequipo(List<PersonaEquipo> personasequipo) {
			this.personasequipo = personasequipo;
		}
		
		
		public PersonaEquipo addPersonaEquipo(PersonaEquipo matriz) {
			getPersonasequipo().add(matriz);
			matriz.setPersona(this);

			return matriz;
		}

		public PersonaEquipo removePersonaEquipo(PersonaEquipo matriz) {
			getPersonasequipo().remove(matriz);
			matriz.setPersona(null);

			return matriz;
		}
		

 



		



		
	


	
			
		

}