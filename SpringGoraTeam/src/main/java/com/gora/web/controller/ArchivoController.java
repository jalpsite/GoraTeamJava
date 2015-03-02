package com.gora.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.gora.dominio.Archivo;
import com.gora.services.ArchivoService;
import com.gora.web.uri.ArchivoRestURIConstant;

@RestController
@RequestMapping("/archivo")
public class ArchivoController {

	@Autowired
	ArchivoService archivoService;

	@RequestMapping(value = ArchivoRestURIConstant.SUBIR_ARCHIVO, method = RequestMethod.POST)
	public void Agregar(@PathVariable Long idPersona,
			@PathVariable String tipo, @RequestParam("file") MultipartFile file,
			@RequestParam(required=false,defaultValue="-1")Long idmatriz,
			@RequestParam(required=false,defaultValue="")String descripcion,
			@RequestParam(required=false,defaultValue="")String clase)
			throws IOException {
		Archivo archivo=null;
		if(tipo.equalsIgnoreCase("PF")){			
			archivo = archivoService.getArchivo(idPersona, tipo);
			if (archivo == null) {
				archivo = new Archivo();
				archivo.setIdpersona(idPersona);
				archivo.setTipo(tipo.toUpperCase());
			}
		}else{
			archivo = new Archivo();
			if(idmatriz!=-1){
				archivo.setIdmatriz(idmatriz);
			}
			if(descripcion!=""){
				archivo.setDescripcion(descripcion);
			}
			if(clase!=""){
				archivo.setClase(clase);
			}
			archivo.setIdpersona(idPersona);
			archivo.setTipo(tipo.toUpperCase());
		}				
		
		archivoService.gestionArchivo(archivo, file.getInputStream());
	}

	@RequestMapping(value = ArchivoRestURIConstant.GET_ARCHIVO, method = RequestMethod.GET, headers = "Accept=application/json")
	public void GetFoto(@PathVariable Long idPersona,
			@PathVariable String tipo, HttpServletResponse response) {
		Archivo arch = archivoService.getArchivo(idPersona, tipo);

		if (arch == null) {
			if (tipo.equalsIgnoreCase("PF")) {
				arch = archivoService.getArchivo(Long.parseLong("0"), "ANONIMO");				
			}
		}
			try {
				byte[] archivo = arch.getArchivo();
				String tipoArchivo = "";
				
				if (archivo.length > 0) {
					String tipoA=arch.getTipo();
					if (tipoA.equalsIgnoreCase("PF") || tipoA.equalsIgnoreCase("IMG")) { //TIPO PERFIL
						tipoArchivo = "image/jpeg";
					}else if (tipoA.equalsIgnoreCase("DOC")) { //TIPO WS WORD 
						tipoArchivo = "application/msword";
					}else if (tipoA.equalsIgnoreCase("PDF")) { //TIPO PDF 
						tipoArchivo = "application/pdf";
					}
					response.reset();
					response.setContentType(tipoArchivo);
					response.getOutputStream().write(archivo);
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}						
	}	
	
	@RequestMapping(value = ArchivoRestURIConstant.GET_ARCHIVOS_SUSTENTO, method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Archivo> getArchivosLista(@PathVariable Long idPersona, @PathVariable String tipo, @PathVariable Long idmatriz){
		return archivoService.getArchivosLista(idPersona, tipo, idmatriz);
	}
	
	@RequestMapping(value = ArchivoRestURIConstant.GET_ARCHIVO_ID, method = RequestMethod.GET, headers = "Accept=application/json")
	public void GetArchivoID(@PathVariable Long idArchivo, HttpServletResponse response){
		Archivo arch = archivoService.getArchivoID(idArchivo);
		if (arch != null){
			try {
				byte[] archivo = arch.getArchivo();
				String tipoArchivo = "";
				
				if (archivo.length > 0) {
					String tipoA=arch.getTipo();
					if (tipoA.equalsIgnoreCase("PF") || tipoA.equalsIgnoreCase("IMG")) { //TIPO PERFIL
						tipoArchivo = "image/jpeg";
					}else if (tipoA.equalsIgnoreCase("DOC")) { //TIPO WS WORD 
						tipoArchivo = "application/msword";
					}else if (tipoA.equalsIgnoreCase("PDF")) { //TIPO PDF 
						tipoArchivo = "application/pdf";
					}else if (tipoA.equalsIgnoreCase("SUSTENTO")) { 
						if(arch.getClase().equalsIgnoreCase("IMG"))
							tipoArchivo = "image/jpeg";
						else if (arch.getClase().equalsIgnoreCase("DOC"))
							tipoArchivo = "application/msword";
						else if (arch.getClase().equalsIgnoreCase("PDF"))
							tipoArchivo = "application/pdf";
						else
							tipoArchivo = "application/vnd.ms-excel";
					}
					response.reset();
					response.setContentType(tipoArchivo);
					response.getOutputStream().write(archivo);
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}			
		}	

	}
	
	@RequestMapping(value = ArchivoRestURIConstant.DELETE_ARCHIVO, method = RequestMethod.POST)
	public void eliminarArchivo(@PathVariable Long idArchivo){
		archivoService.eliminarArchivo(idArchivo);
	}
}