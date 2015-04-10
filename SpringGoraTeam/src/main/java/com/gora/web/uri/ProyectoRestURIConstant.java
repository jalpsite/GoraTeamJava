package com.gora.web.uri;

public class ProyectoRestURIConstant {
			
	    public static final String GET_PROYECTO = "/{id}";
	    public static final String GET_ALL_PROYECTOS = "/lista";
	    //public static final String CREATE_PROYECTO = "/create/{idCliente}/{idIniciativa}/{idPersona}/{idPortafolio}/{idTipoProyecto}";
	    public static final String CREATE_PROYECTO = "/create/{idCliente}/{idPersona}/{idTipoProyecto}";
	    public static final String UPDATE_PROYECTO = "/update/{idCliente}/{idPersona}/{idTipoProyecto}";
	    public static final String DELETE_PROYECTO = "/delete/{id}";	
	    
	    public static final String GET_PROYECTO_EQUIPO = "/{idProyecto}/equipo";
	    public static final String ADD_PERSONA_PROYECTO = "/{idProyecto}/agregar/{idPersona}/{idRol}";
	    public static final String CHANGE_ROL_PERSONA_PROYECTO = "/{idProyecto}/cambiarol";
	    public static final String DELETE_PERSONA_PROYECTO = "/{idProyecto}/quitar/{idPersona}";
	    
	    public static final String GET_ALL_PROYECTO_BUSQUEDA = "/buscar";
	    
	    public static final String IMPORT_PROYECTO = "/{idProyecto}/importar";
	    public static final String GET_PROYECTO_MPP = "/importar";
	    
	    public static final String ADD_RECURSO = "/{idProyecto}/recurso/agregar";
	    public static final String ADD_CRONOGRAMA = "/{idProyecto}/cronograma/agregar/{idEtapa}";
	   	   
	    
}
