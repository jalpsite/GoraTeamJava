package com.gora.web.uri;

public class UsuarioRestURIConstant {
	
		public static final String DUMMY_USUARIO = "/dummy";
	    public static final String GET_USUARIO = "/{id}";
	    public static final String GET_ALL_USUARIO = "/lista";
	    public static final String CREATE_USUARIO = "/create";
	    public static final String UPDATE_USUARIO = "/update";
	    public static final String DELETE_USUARIO = "/delete/{id}";
	    public static final String GET_AUTH = "/lista";
	    	    
	    //AUTENTICACION
	    public static final String LOGIN_USUARIO = "/login";
	    
	    //ROLES
	    public static final String ASIGNA_ROL_USUARIO = "/asignarrol/{idPersona}/{idRol}";
	    public static final String GET_ROLES_USUARIO = "/{idUsuario}/roles";
	    
	    //VALIDACIONES
	    public static final String USUARIO_VALIDA_USUARIO = "/validausuario";
	    	    
	    //ACTUALIZACIONES
	    public static final String UPDATE_USUARIO_ROL = "/{idUsuarioRol}/rol/update/{idRol}";	    
	    public static final String UPDATE_USUARIO_PASS = "/{idUsuario}/updatepass";
	    
	    //RESET CONTRASEÑA
	    public static final String LOSTPASSWORD_USUARIO = "/lostpassword";
	    public static final String VERIFICA_TOKEN_USUARIO_PASS = "/token/{idUsuario}/{token}";
	    public static final String RESET_USUARIO_PASS = "/reset/{idUsuario}/{token}";
	    public static final String VERIFICA_USUARIO = "/verifica";
	    public static final String GET_USUARIO_PERSONA = "/persona/{idPersona}";
}
