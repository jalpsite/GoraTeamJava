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
import com.gora.services.ArchivoService;
import com.gora.web.uri.ArchivoRestURIConstant;

@RestController
@RequestMapping("/archivo")
public class ArchivoController {

	@Autowired
	ArchivoService archivoService;

	@RequestMapping(value = ArchivoRestURIConstant.SUBIR_ARCHIVO, method = RequestMethod.POST)
	public void Agregar(@PathVariable Long idPersona, @PathVariable String tipo, @RequestParam MultipartFile file)
			throws IOException {
		Archivo arch = new Archivo();
		arch.setIdpersona(idPersona);		
		arch.setTipo(tipo.toUpperCase()); //PF o //CV
		archivoService.subirArchivo(arch, file.getInputStream());

	}

	@RequestMapping(value = ArchivoRestURIConstant.UPDATE_ARCHIVO, method = RequestMethod.POST)
	public void Actualizar(@PathVariable Long idPersona,
			@PathVariable Long idArchivo, @PathVariable String tipo,
			@RequestParam MultipartFile file) throws IOException {
		Archivo arch = new Archivo();
		arch.setIdarchivo(idArchivo);
		arch.setIdpersona(idPersona);
		arch.setTipo(tipo.toUpperCase()); //PF o //CV
		archivoService.subirArchivo(arch, file.getInputStream());
	}

	@RequestMapping(value = ArchivoRestURIConstant.GET_ARCHIVO, method = RequestMethod.GET, headers = "Accept=application/json")
	public void GetArchivo(@PathVariable Long idPersona, @PathVariable String tipo, HttpServletResponse response) {
		Archivo objArchivo = archivoService.getArchivo(idPersona, tipo);
		try {
			int tamanioarchivo = (int) objArchivo.getArchivo().length();
			byte[] archivo = objArchivo.getArchivo()
					.getBytes(1, tamanioarchivo);
			String tipoArchivo = "";
			if (tipoArchivo.equalsIgnoreCase("PF")) {
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