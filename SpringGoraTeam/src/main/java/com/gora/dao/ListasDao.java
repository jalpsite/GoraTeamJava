package com.gora.dao;

import java.util.List;

import com.gora.dominio.Atributo;
import com.gora.dominio.Cargo;
import com.gora.dominio.Carrera;
import com.gora.dominio.Competencia;
import com.gora.dominio.Grado;
import com.gora.dominio.Habilidades;
import com.gora.dominio.Lista;
import com.gora.dominio.Rol;
import com.gora.dominio.Tipodocumento;
import com.gora.dominio.Ubigeo;
import com.gora.dominio.Universidad;

/**
 * Created by IntelliJ IDEA.
 * Author : Jose Alpiste  .
 * Date : 3/12/14 ,
 * Time : 6:32 PM 
 * com.gora.dominio
 */

public interface ListasDao {
	public List<Ubigeo> getDepartamentos();
	public List<Ubigeo> getProvincias(String dep);
	public List<Ubigeo> getDistritos(String dep,String prov);
	
	public List<Universidad> getUniversidades();	
	public List<Carrera> getCarreras();	
	public List<Grado> getGrados();	
	public List<Competencia> getCompetencias();	
	public List<Habilidades> getHabilidades();	
	public List<Atributo> getAtributos();		
	public List<Tipodocumento> getTipoDocumentos();
	public List<Cargo> getCargos();
	
	
	/*	1 = PAISES
	 * 	2 = TIPOS DE EMAILS
	 * 	3 = TIPOS DE TELEFONO
	 * 	4 = TIPOS DE DIRECCIONES
	 * 	5 = ESTADO CIVIL
	 * 	6 = NIVELES DE ESTUDIO
	 *  7 = TIPO DE ARCHIVO
	 * */
	public List<Lista> getLista(Long idbloque);
	public List<Ubigeo> getUbigeo(Long idUbigeo);
		
}
