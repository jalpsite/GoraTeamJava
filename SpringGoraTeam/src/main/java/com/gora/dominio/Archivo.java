package com.gora.dominio;

import java.io.Serializable;
import java.sql.Blob;
import java.sql.Types;

import javax.persistence.*;

import org.hibernate.annotations.Type;




/**
 * The persistent class for the atributo database table.
 * 
 */
@Entity
@Table(name="archivo")
public class Archivo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="archivo_seq")
	@SequenceGenerator(
		name="archivo_seq",
		sequenceName="archivo_sequence",
		allocationSize=1
	) 
	private Long idarchivo;
	private Long idpersona;
	private String tipo;
	
	@Lob
	@Type(type="org.hibernate.type.PrimitiveByteArrayBlobType")    
	private byte[] archivo;
	
	public Archivo(){
		
	}

	public Long getIdarchivo() {
		return idarchivo;
	}

	public void setIdarchivo(Long idarchivo) {
		this.idarchivo = idarchivo;
	}

	public Long getIdpersona() {
		return idpersona;
	}

	public void setIdpersona(Long idpersona) {
		this.idpersona = idpersona;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public byte[] getArchivo() {
		return archivo;
	}

	public void setArchivo(byte[] archivo) {
		this.archivo = archivo;
	}
	

	


}