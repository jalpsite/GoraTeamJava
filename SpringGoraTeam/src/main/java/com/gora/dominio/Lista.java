package com.gora.dominio;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the atributo database table.
 * 
 */
@Entity
@Table(name="lista")
public class Lista implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="lista_seq")
	@SequenceGenerator(
		name="lista_seq",
		sequenceName="lista_sequence",
		allocationSize=1
	) 
	private Long idlista;

	private Long idbloque;
	
	private long idparametro;
	
	private String codigo;
	
	private String descripcion;
	
	private String estado;

	public Lista(){
		
	}

	public Long getIdlista() {
		return idlista;
	}

	public void setIdlista(Long idlista) {
		this.idlista = idlista;
	}

	public Long getIdbloque() {
		return idbloque;
	}

	public void setIdbloque(Long idbloque) {
		this.idbloque = idbloque;
	}

	public long getIdparametro() {
		return idparametro;
	}

	public void setIdparametro(long idparametro) {
		this.idparametro = idparametro;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	

	

}