package com.gora.web.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.gora.dominio.Archivo;
import com.gora.dominio.Persona;
import com.gora.services.ArchivoService;
import com.gora.services.PersonaService;
import com.gora.web.uri.ArchivoRestURIConstant;

@RestController
@RequestMapping("/archivo")
public class ArchivoController {

	@Autowired
	ArchivoService archivoService;

	@RequestMapping(value = ArchivoRestURIConstant.SUBIR_ARCHIVO, method = RequestMethod.POST)
	public void Agregar(@PathVariable Long idPersona,
			@PathVariable String tipo, @RequestParam("file") MultipartFile file)
			throws IOException {
		Archivo archivo = archivoService.existenciaArchivo(idPersona, tipo);
		System.out.println(archivo);
		if (archivo == null) {
			archivo = new Archivo();
			archivo.setIdpersona(idPersona);
			archivo.setTipo(tipo.toUpperCase());
		}
		archivoService.gestionArchivo(archivo, file.getInputStream());
	}

	@RequestMapping(value = ArchivoRestURIConstant.GET_ARCHIVO, method = RequestMethod.GET, headers = "Accept=application/json")
	public void GetArchivo(@PathVariable Long idPersona,
			@PathVariable String tipo, HttpServletResponse response) {
		Archivo arch = archivoService.existenciaArchivo(idPersona, tipo);

		if (arch == null) {
			if (tipo.equalsIgnoreCase("PF")) {
				arch = archivoService.getArchivo(Long.parseLong("0"), "ANONIMO");
				System.out.println(arch);
			}
		} 
		
		try {
			byte[] archivo = arch.getArchivo();
			String tipoArchivo = "";
			if (arch.getTipo().equalsIgnoreCase("PF")) { //TIPO 
				tipoArchivo = "image/jpeg";
			}
			if (archivo != null && archivo.length > 0) {
				response.reset();
				response.setContentType(tipoArchivo);
				response.getOutputStream().write(archivo);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}