package com.gora.dominio;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the rol_operacion database table.
 * 
 */
@Entity
@Table(name="rol_operacion")
@NamedQuery(name="RolOperacion.findAll", query="SELECT r FROM RolOperacion r")
public class RolOperacion implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idroloperacion;
	private String estado;
	private Integer idoperacion;
	private Integer idrol;

	public RolOperacion() {
	}


	@Id
	@SequenceGenerator(name="ROL_OPERACION_IDROLOPERACION_GENERATOR", sequenceName="ROL_OPERACION_SEQUENCE",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ROL_OPERACION_IDROLOPERACION_GENERATOR")
	public Integer getIdroloperacion() {
		return this.idroloperacion;
	}

	public void setIdroloperacion(Integer idroloperacion) {
		this.idroloperacion = idroloperacion;
	}


	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}


	public Integer getIdoperacion() {
		return this.idoperacion;
	}

	public void setIdoperacion(Integer idoperacion) {
		this.idoperacion = idoperacion;
	}


	public Integer getIdrol() {
		return this.idrol;
	}

	public void setIdrol(Integer idrol) {
		this.idrol = idrol;
	}

}