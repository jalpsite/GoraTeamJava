package com.gora.web.uri;

public class AtributosRestURIConstant {
	public static final String DUMMY_ATRIBUTOS = "/dummy";
    public static final String GET_ATRIBUTOS = "/{id}";
    public static final String GET_ALL_ATRIBUTOS = "/lista";
    public static final String CREATE_ATRIBUTOS = "/create/{idHabilidad}/{idAtributo}";
    public static final String UPDATE_ATRIBUTOS = "/update/{idAtributo}";
    //public static final String DELETE_ATRIBUTO = "/delete/{id}";
    
    public static final String GET_ATRIBUTOS_EXTRACTO = "/extracto/{idPersona}/{idHabilidad}/atributos";
}
