package com.gora.dominio;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the cargo database table.
 * 
 */
@Entity
@NamedQuery(name="Cargo.findAll", query="SELECT c FROM Cargo c")
public class Cargo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="cargo_seq")
	@SequenceGenerator(
		name="cargo_seq",
		sequenceName="cargo_sequence",
		allocationSize=1
	) 
	private Long idcargo;

	private String descripcion;

	private String estado;

	@JsonIgnore
	//bi-directional many-to-one association to Empleado
	@OneToMany(mappedBy="cargo",fetch=FetchType.EAGER)
	private List<Empleado> empleados;

	public Cargo() {
	}

	public Long getIdcargo() {
		return this.idcargo;
	}

	public void setIdcargo(Long idcargo) {
		this.idcargo = idcargo;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public List<Empleado> getEmpleados() {
		return this.empleados;
	}

	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}

	public Empleado addEmpleado(Empleado empleado) {
		getEmpleados().add(empleado);
		empleado.setCargo(this);

		return empleado;
	}

	public Empleado removeEmpleado(Empleado empleado) {
		getEmpleados().remove(empleado);
		empleado.setCargo(null);

		return empleado;
	}

}