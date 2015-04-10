package com.gora.services;

import com.gora.dominio.Archivo;

import java.io.InputStream;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Author : Taras Lehinevych  .
 * Date : 3/12/14 ,
 * Time : 7:02 PM
 * com.gora.dominio
 */

public interface ArchivoService {
	public void gestionArchivo(Archivo objArchivo, InputStream arch);	
	public Archivo getArchivo(Long idPersona, String tipo);	
	public List<Archivo> getArchivosLista(Long idPersona, String tipo, Long idMatriz);
	public Archivo getArchivoID(Long idArchivo);
	public void eliminarArchivo(Long idArchivo);
	public List<Archivo> getFotos();
}