package com.gora.web.uri;

public class ListasRestURIConstant {
			   
		//UBIGEO
	    public static final String GET_DEPARTAMENTOS = "/departamentos";
	    public static final String GET_PROVINCIAS = "/departamento/{dep}/provincias";
	    public static final String GET_DISTRITOS = "/departamento/{dep}/provincia/{prov}/distritos";
	    public static final String GET_UBIGEO = "/ubigeo/{idUbigeo}";
	    
	    //FORMACION
	    public static final String GET_UNIVERSIDADES = "/universidades";	    
	    public static final String GET_CARRERAS = "/carreras";	    
	    public static final String GET_GRADOS = "/grados";	
	    public static final String GET_NIVEL_ESTUDIO = "/nivelestudio";
	    
	    //EXPERIENCIA
	    public static final String GET_CARGOS = "/cargos";
	    
	    //ATRIBUTOS PERSONA
	    public static final String GET_COMPETENCIAS = "/competencias";	    	   	    
	    public static final String GET_ATRIBUTOS = "/atributos";
	    public static final String GET_HABILIDADES = "/habilidades";
	    public static final String GET_ESTADO_CIVIL = "/estadocivil";
	    public static final String GET_NACIONALIDAD = "/nacionalidad";
	    
	    //TIPOS
	    public static final String GET_TIPO_DOCUMENTOS = "/tipodocumentos";
	    public static final String GET_TIPO_EMAIL = "/tipoemail";
	    public static final String GET_TIPO_TELEFONO = "/tipotelefono";
	    public static final String GET_TIPO_DIRECCION = "/tipodireccion";
	    public static final String GET_TIPO_ARCHIVO = "/tipoarchivo";
	    public static final String GET_TIPO_PROYECTO = "/tipoproyecto";
	    
	    //USUARIOS
	    public static final String GET_ROLES = "/roles";
	    	    
}
