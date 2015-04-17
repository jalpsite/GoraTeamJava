package com.gora.web.uri;

public class HabilidadRestURIConstant {	
    public static final String GET_HABILIDAD = "/{id}";
    public static final String GET_ALL_HABILIDAD = "/lista";
    public static final String CREATE_HABILIDAD = "/create/{idPersona}/{idMatriz}/{idHabilidades}";
    public static final String UPDATE_HABILIDAD = "/update/{idHabilidades}";        
    public static final String GET_ATRIBUTOS = "/{id}/atributos";    
    public static final String GET_HABILIDADES_EXTRACTO = "/extracto/{idPersona}/{idCompetencia}/habilidades";
    public static final String DELETE_HABILIDAD = "/delete/{idHabilidad}";
}
