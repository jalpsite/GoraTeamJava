package com.gora.web.uri;

public class UsuarioRestURIConstant {

	
		public static final String DUMMY_USUARIO = "/dummy";
	    public static final String GET_USUARIO = "/{id}";
	    public static final String GET_ALL_USUARIO = "/lista";
	    public static final String CREATE_USUARIO = "/create";
	    public static final String UPDATE_USUARIO = "/update";
	    public static final String DELETE_USUARIO = "/delete/{id}";
	    public static final String GET_AUTH = "/lista";
	    	    
	    public static final String LOGIN_USUARIO = "/login";
	    
	    public static final String ASIGNA_ROL_USUARIO = "/asignarrol/{idPersona}/{idRol}";
	    public static final String GET_ROLES_USUARIO = "/{idUsuario}/roles";
}
