

package com.gora.web.uri;

public class PersonaRestURIConstant {
	
	//public static final String DUMMY_PERSONA = "/dummy";	
    public static final String GET_PERSONA = "/{id}";  
    public static final String GET_ALL_PERSONA = "/lista";
    public static final String CREATE_PERSONA = "/create"; 
    
    //VALIDACIONES
    public static final String PERSONA_LOGIN = "/login";    
    public static final String PERSONA_VALIDA_DOCUMENTO = "/validadocumento/{doc}";
    
    //UPDATE 
    public static final String UPDATE_PERSONA = "/update/user/{idUsuario}";
    public static final String UPDATE_PERSONA_PART = "/update/{opcion}";
    
    // FILTROS
    public static final String PERSONA_FILTRO= "/filtro";
    
    //BUSQUEDAS
    public static final String GET_PERSONA_DNI = "/buscardni/{dniPersona}";
    public static final String GET_PERSONA_NOMBRE_APELLIDO = "/buscarnombres";
    
    //EXTRACCION DE DATOS
    public static final String GET_PERSONA_JEFE = "/{id}/jefe";    
    public static final String GET_PERSONA_COMPETENCIAS = "/{id}/competencias";
    public static final String GET_PERSONA_HABILIDADES = "/{id}/habilidades";
    public static final String GET_PERSONA_ATRIBUTOS = "/{id}/atributos"; 
    public static final String GET_PERSONA_EXPERIENCIAS = "/{id}/experiencias"; 
    public static final String GET_PERSONA_FORMACION = "/{id}/formacion";
    public static final String GET_PERSONA_HABILIDADES_X_COMPETENCIA = "/{idPersona}/{idCompetencia}/habilidades";
    public static final String GET_PERSONA_ATRIBUTOS_X_HABIILIDAD = "/{idPersona}/{idCompetencia}/{idHabilidad}/atributos";
    
    
    /*	DIRECCION */
    public static final String GET_PERSONA_ADDRESS = "/{id}/direccion";
    public static final String CREATE_ADDRESS = "/direccion/create/{idPersona}";
    public static final String UPDATE_ADDRESS = "/direccion/update/{idPersona}";
    public static final String UPDATESINGLE_ADDRESS = "/direccion/updatesingle/{idPersona}";
    public static final String DESACTIVAR_ADDRESS = "/direccion/desactivar/{idDireccion}";
    
    /*	EMAIL	*/
    public static final String GET_PERSONA_EMAIL = "/{id}/email";    
    public static final String CREATE_EMAIL = "/email/create/{idPersona}";    
    public static final String UPDATE_EMAIL = "/email/update/{idPersona}";
    public static final String UPDATESINGLE_EMAIL = "/email/updatesingle/{idPersona}";
    public static final String DESACTIVAR_EMAIL = "/email/desactivar/{idEmail}";
    
    /* 	TELEFONO	*/
    public static final String GET_PERSONA_PHONE = "/{id}/telefono";
    public static final String CREATE_PHONE = "/telefono/create/{idPersona}";
    public static final String UPDATE_PHONE = "/telefono/update/{idPersona}";
    public static final String UPDATESINGLE_PHONE = "/telefono/updatesingle/{idPersona}";
    public static final String DESACTIVAR_PHONE = "/telefono/desactivar/{idTelefono}";
       
    /*	IMPRESION DE CV	 */
    public static final String GET_CV_PERSONA = "/{idPersona}/cv";
    /*	PEDITCION DE DATOS	*/
    public static final String GET_PERSONA_JEFE_PROYECTO = "/jefeproyecto";
}

