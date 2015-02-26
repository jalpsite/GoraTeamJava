package com.gora.dao;

import java.io.InputStream;
import java.util.List;

import com.gora.dominio.Archivo;

/**
 * Created by IntelliJ IDEA.
 * Author : Jose Alpiste  .
 * Date : 3/12/14 ,
 * Time : 6:32 PM 
 * com.gora.dominio
 */

public interface ArchivoDao{
	public void gestionArchivo(Archivo objArchivo,InputStream arch);	
	public Archivo getArchivo(Long idPersona, String tipo);	
	public Archivo getArchivoID(Long idArchivo);	
	public List<Archivo> getArchivosLista(Long idPersona, String tipo, Long idMatriz);	
}