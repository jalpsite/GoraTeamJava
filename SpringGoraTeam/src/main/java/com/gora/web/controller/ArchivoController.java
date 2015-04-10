package com.gora.web.controller;

import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.ImagingOpException;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

import org.imgscalr.Scalr;
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
			Archivo thum=archivoService.getArchivo(idPersona, "THUMB");
			
			if (archivo == null) {
				archivo = new Archivo();
				archivo.setIdpersona(idPersona);
				archivo.setTipo(tipo.toUpperCase());				
			}
			
			if (thum == null) {
				thum=new Archivo();
				thum.setIdpersona(idPersona);
				thum.setTipo("T");
			}
			
			BufferedImage scaled = Scalr.resize(ImageIO.read(file.getInputStream()), Scalr.Method.QUALITY, Scalr.Mode.FIT_EXACT,
		               40, 40, Scalr.OP_ANTIALIAS);	
												
			ByteArrayOutputStream os = new ByteArrayOutputStream();
			ImageIO.write(scaled,"jpg",os);
			InputStream is = new ByteArrayInputStream(os.toByteArray());			
			archivoService.gestionArchivo(thum, is);
									
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
			if (tipo.equalsIgnoreCase("THUMB")) {
				arch = archivoService.getArchivo(Long.parseLong("0"), "ANONIMO-T");				
			}
		}
			try {
				byte[] archivo = arch.getArchivo();
				String tipoArchivo = "";
				
				if (archivo.length > 0) {
					String tipoA=arch.getTipo();
					if (tipoA.equalsIgnoreCase("PF") || tipoA.equalsIgnoreCase("IMG") || tipoA.equalsIgnoreCase("THUMB")) { //TIPO PERFIL
						tipoArchivo = "image/jpeg";
						
					}else if (tipoA.equalsIgnoreCase("DOC")) { //TIPO WS WORD 
						tipoArchivo = "application/msword";
					}else if (tipoA.equalsIgnoreCase("PDF")) { //TIPO PDF 
						tipoArchivo = "application/pdf";
					}
					else if (tipoA.equalsIgnoreCase("T")) { //TIPO PDF 
						tipoArchivo = "image/jpeg";
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
					if (tipoA.equalsIgnoreCase("PF") || tipoA.equalsIgnoreCase("IMG")|| tipoA.equalsIgnoreCase("THUMB")) { //TIPO PERFIL
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
	
	
	@RequestMapping(value ="/generar", method = RequestMethod.GET)
	public void generar() throws IllegalArgumentException, ImagingOpException, IOException{
		List<Archivo> lst=archivoService.getFotos();
			for(Archivo a:lst){
				InputStream img = new ByteArrayInputStream(a.getArchivo());						
				BufferedImage scaled = Scalr.resize(ImageIO.read(img), Scalr.Method.QUALITY, Scalr.Mode.FIT_EXACT, 40, 40, Scalr.OP_ANTIALIAS);							
				ByteArrayOutputStream os = new ByteArrayOutputStream();
				ImageIO.write(scaled,"jpg",os);
				InputStream is = new ByteArrayInputStream(os.toByteArray());
				a.setIdarchivo(null);
				a.setTipo("THUMB");
				archivoService.gestionArchivo(a, is);
				System.out.println("Archivo: "+a.getIdpersona());
			}

		
	}
		
		
}