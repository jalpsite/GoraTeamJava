package com.gora.dao;

import java.io.InputStream;

import com.gora.dominio.Archivo;

/**
 * Created by IntelliJ IDEA.
 * Author : Jose Alpiste  .
 * Date : 3/12/14 ,
 * Time : 6:32 PM 
 * com.gora.dominio
 */

public interface ArchivoDao{
	public void subirArchivo(Archivo objArchivo,InputStream arch);
	public void actualizarArchivo(Archivo objArchivo,InputStream arch);
	public Archivo getArchivo(Long idPersona, String tipo);
	
}
