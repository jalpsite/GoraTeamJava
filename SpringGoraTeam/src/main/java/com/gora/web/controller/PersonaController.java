package com.gora.web.controller;

import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.servlet.http.HttpServletResponse;

import org.aspectj.runtime.internal.PerObjectMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gora.services.ArchivoService;
import com.gora.services.ExperienciaService;
import com.gora.services.FormacionService;
import com.gora.services.PersonaDatosService;
import com.gora.services.PersonaService;
import com.gora.services.UbigeoService;
import com.gora.services.UsuarioService;
import com.gora.dominio.Archivo;
import com.gora.dominio.Atributo;
import com.gora.dominio.Competencia;
import com.gora.dominio.Experiencia;
import com.gora.dominio.Formacion;
import com.gora.dominio.Habilidades;
import com.gora.dominio.Persona;
import com.gora.dominio.PersonaDireccion;
import com.gora.dominio.PersonaEmail;
import com.gora.dominio.PersonaTelefono;
import com.gora.dominio.Ubigeo;
import com.gora.web.uri.PersonaRestURIConstant;
import com.itextpdf.awt.geom.Rectangle;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;

@RestController
@RequestMapping("/persona")
public class PersonaController {

	@Autowired
	PersonaService perService;

	@Autowired
	PersonaDatosService perDatosService;

	@Autowired
	ExperienciaService expeServices;

	@Autowired
	FormacionService formaServices;
	
	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	ArchivoService archivoService;
	
	@Autowired
	UbigeoService ubigeoService;

	/*
	 * PERSONA
	 */

	@RequestMapping(value = PersonaRestURIConstant.CREATE_PERSONA, method = RequestMethod.POST)
	public int savePersona(@ModelAttribute Persona per) {
		this.perService.save(per);
		return Integer.parseInt((per.getIdpersona()).toString());
	}

	@RequestMapping(value = PersonaRestURIConstant.UPDATE_PERSONA, method = RequestMethod.POST)
	public int updatePersona(@ModelAttribute Persona per, @PathVariable Long idUsuario) {
		per.setUsuario(usuarioService.findById(idUsuario));
		this.perService.update(per);
		return Integer.parseInt((per.getIdpersona()).toString());
	}

	@RequestMapping(value = PersonaRestURIConstant.GET_PERSONA, method = RequestMethod.GET, headers = "Accept=application/json")
	public Persona GetPersona(@PathVariable Long id) {
		Persona p = this.perService.findById(id);
		return p;
	}

	@RequestMapping(value = PersonaRestURIConstant.GET_ALL_PERSONA, method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Persona> LstPersona() {
		return this.perService.findAll();
	}

	/*
	@RequestMapping(value = PersonaRestURIConstant.PERSONA_LOGIN, method = RequestMethod.POST)
	public Object login(@RequestParam String correo, @RequestParam String dni) {
		return perService.login(correo, dni);
	}
	*/

	/*
	 * VALIDACION LA EXISTENCIA DEL DOCUMENTO
	 */

	@RequestMapping(value = PersonaRestURIConstant.PERSONA_VALIDA_DOCUMENTO, method = RequestMethod.GET, headers = "Accept=application/json")
	public int valDocumento(@PathVariable String doc) {
		return perService.validarDNI(doc);
	}

	/*
	 * EXTRACCION DE DATOS POR PERSONA
	 */

	@RequestMapping(value = PersonaRestURIConstant.GET_PERSONA_JEFE, method = RequestMethod.GET, headers = "Accept=application/json")
	public Persona getJefe(@PathVariable Long id) {
		Long idPer = perService.getIDJefe(id);
		if (idPer != 0) {
			return GetPersona(idPer);
		} else {
			return null;

		}
	}

	@RequestMapping(value = PersonaRestURIConstant.GET_PERSONA_COMPETENCIAS, method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Competencia> getCompetencias(@PathVariable Long id) {
		return perService.getCompetencias(id);
	}

	@RequestMapping(value = PersonaRestURIConstant.GET_PERSONA_HABILIDADES, method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Habilidades> getHabilidades(@PathVariable Long id) {
		return perService.getHabilidades(id);
	}

	@RequestMapping(value = PersonaRestURIConstant.GET_PERSONA_ATRIBUTOS, method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Atributo> getAtributos(@PathVariable Long id) {
		return perService.getAtributos(id);
	}

	@RequestMapping(value = PersonaRestURIConstant.GET_PERSONA_HABILIDADES_X_COMPETENCIA, method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Habilidades> getHabilidadesXCompetencia(
			@PathVariable Long idPersona, @PathVariable Long idCompetencia) {
		return perService.getHabilidadesXCompetencia(idPersona, idCompetencia);
	}

	@RequestMapping(value = PersonaRestURIConstant.GET_PERSONA_ATRIBUTOS_X_HABIILIDAD, method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Atributo> getAtributosXHabilidad(@PathVariable Long idPersona,
			@PathVariable Long idCompetencia, @PathVariable Long idHabilidad) {

		return perService.getAtributosXHabilidad(idPersona, idCompetencia,
				idHabilidad);
	}

	/*
	 * PERSONA BUSQUEDAS Y FILTROS
	 */

	@RequestMapping(value = PersonaRestURIConstant.GET_PERSONA_DNI, method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Persona> getPersonaByDNI(@PathVariable String dniPersona) {
		return this.perDatosService.getPersonaByDNI(dniPersona);
	}

	@RequestMapping(value = PersonaRestURIConstant.GET_PERSONA_NOMBRE_APELLIDO, method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Persona> getPersonaByNomApe(
			@PathVariable String nomApePersona) {
		return this.perDatosService.getPersonaByNomApe(nomApePersona);
	}
	
	@RequestMapping(value = PersonaRestURIConstant.PERSONA_FILTRO, method = RequestMethod.POST)
	public List<Persona> filtroPersona(
			@RequestParam(required = false, defaultValue = "") String[] competencias,
			@RequestParam(required = false, defaultValue = "") String[] habilidades,
			@RequestParam(required = false, defaultValue = "") String[] atributos,@PathVariable int pagina) {
		return perService.filtroPersonas(competencias, habilidades, atributos,pagina);

	}		

	/*
	 * UPDATE PERSONA PARTICIONADO
	 */
	@RequestMapping(value = PersonaRestURIConstant.UPDATE_PERSONA_PART, method = RequestMethod.POST)
	public Persona updatePersonaPart(@PathVariable int opcion,
			@ModelAttribute Persona per) {
		return perService.updateDatos(opcion, per);
	}

	/*
	 * EMAILS
	 */

	/*
	 * //ACTUALIZADO SINGULAR
	 */
	@RequestMapping(value = PersonaRestURIConstant.UPDATESINGLE_EMAIL, method = RequestMethod.POST)
	public PersonaEmail upEmail(@ModelAttribute PersonaEmail perEmail,
			@PathVariable Long idPersona) {
		perEmail.setPersona(this.GetPersona(idPersona));
		this.perService.actualizarEmail(perEmail);
		System.out.println(perEmail.getIdpersonaemail());
		return perEmail;
	}

	// GUARDADO DE ARREGLO
	@RequestMapping(value = PersonaRestURIConstant.CREATE_EMAIL, method = RequestMethod.POST)
	public void saveEmailArreglo(@RequestBody PersonaEmail[] perEmail,
			@PathVariable Long idPersona) {
		Persona per = this.GetPersona(idPersona);
		for (PersonaEmail em : perEmail) {
			em.setPersona(per);
			this.perService.agregarEmail(em);
		}
	}

	@RequestMapping(value = PersonaRestURIConstant.UPDATE_EMAIL, method = RequestMethod.POST)
	public void updateEmail(@RequestBody PersonaEmail[] perEmail,
			@PathVariable Long idPersona) {
		Persona per = this.GetPersona(idPersona);
		for (PersonaEmail em : perEmail) {
			em.setPersona(per);
			this.perService.actualizarEmail(em);
		}
	}

	@RequestMapping(value = PersonaRestURIConstant.GET_PERSONA_EMAIL, method = RequestMethod.GET, headers = "Accept=application/json")
	public List<PersonaEmail> getPersonaCorreo(@PathVariable Long id) {
		return perService.getEmail(id);
	}

	/*
	 * TELEFONO
	 */

	/*
	 * // ACTUALIZADO SINGULAR
	 */
	@RequestMapping(value = PersonaRestURIConstant.UPDATESINGLE_PHONE, method = RequestMethod.POST)
	public PersonaTelefono upTelefono(@ModelAttribute PersonaTelefono perTel,
			@PathVariable Long idPersona) {
		System.out.println(perTel.getIdpersonatelefono());
		System.out.println(perTel.getEstado());
		System.out.println(perTel.getTelefono());
		perTel.setPersona(this.GetPersona(idPersona));
		this.perService.actualizarTelefono(perTel);
		return perTel;
	}

	// GUARDADO DE ARREGLO
	@RequestMapping(value = PersonaRestURIConstant.CREATE_PHONE, method = RequestMethod.POST)
	public void saveTelefonoArreglo(@RequestBody PersonaTelefono[] perTel,
			@PathVariable Long idPersona) {
		Persona per = this.GetPersona(idPersona);
		for (PersonaTelefono tel : perTel) {
			tel.setPersona(per);
			this.perService.agregarTelefono(tel);
		}
	}

	@RequestMapping(value = PersonaRestURIConstant.UPDATE_PHONE, method = RequestMethod.POST)
	public void updateTelefono(@RequestBody PersonaTelefono[] perTel,
			@PathVariable Long idPersona) {
		Persona per = this.GetPersona(idPersona);
		for (PersonaTelefono tel : perTel) {
			tel.setPersona(per);
			this.perService.actualizarTelefono(tel);
		}
	}

	@RequestMapping(value = PersonaRestURIConstant.GET_PERSONA_PHONE, method = RequestMethod.GET, headers = "Accept=application/json")
	public List<PersonaTelefono> getPersonaTelefono(@PathVariable Long id) {
		return perService.getTelefono(id);
	}

	/*
	 * DIRECCION
	 */

	// ACTUALIZAR SINGULAR
	@RequestMapping(value = PersonaRestURIConstant.UPDATESINGLE_ADDRESS, method = RequestMethod.POST)
	public PersonaDireccion upDireccion(
			@ModelAttribute PersonaDireccion perDir,
			@PathVariable Long idPersona) {
		
		perDir.setPersona(this.GetPersona(idPersona));
		this.perService.actualizarDireccion(perDir);
		return perDir;
	}

	// GUARDADO DE ARREGLO
	@RequestMapping(value = PersonaRestURIConstant.CREATE_ADDRESS, method = RequestMethod.POST)
	public void saveDireccionArreglo(@RequestBody PersonaDireccion[] perDir,
			@PathVariable Long idPersona) {
		Persona per = this.GetPersona(idPersona);
		for (PersonaDireccion dir : perDir) {
			dir.setPersona(per);
			this.perService.agregarDireccion(dir);
		}
	}

	@RequestMapping(value = PersonaRestURIConstant.UPDATE_ADDRESS, method = RequestMethod.POST)
	public void updateDireccion(@RequestBody PersonaDireccion[] perDir,
			@PathVariable Long idPersona) {
		Persona per = this.GetPersona(idPersona);
		for (PersonaDireccion dir : perDir) {
			dir.setPersona(per);
			this.perService.actualizarDireccion(dir);
		}
	}

	@RequestMapping(value = PersonaRestURIConstant.GET_PERSONA_ADDRESS, method = RequestMethod.GET, headers = "Accept=application/json")
	public List<PersonaDireccion> getPersonaDireccion(@PathVariable Long id) {
		return perService.getDireccion(id);
	}

	/* EXPERIENCIA */
	@RequestMapping(value = PersonaRestURIConstant.GET_PERSONA_EXPERIENCIAS, method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Experiencia> getPersonaExperiencias(@PathVariable Long id) {
		return expeServices.getExperienciasPersona(id);
	}

	/* FORMACION */
	@RequestMapping(value = PersonaRestURIConstant.GET_PERSONA_FORMACION, method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Formacion> getPersonaFormacion(@PathVariable Long id) {
		return formaServices.getFormacionPersona(id);
	}
	
	
	
	@RequestMapping(value = PersonaRestURIConstant.DESACTIVAR_ADDRESS, method = RequestMethod.POST)
	public void desactivarDireccion(@PathVariable Long idDireccion) {
		perService.estadoDireccion(idDireccion, "D");
	}
	
	@RequestMapping(value = PersonaRestURIConstant.DESACTIVAR_EMAIL, method = RequestMethod.POST)
	public void desactivarEmail(@PathVariable Long idEmail) {
		perService.estadoEmail(idEmail, "D");
	}
	
	@RequestMapping(value = PersonaRestURIConstant.DESACTIVAR_PHONE, method = RequestMethod.POST)
	public void desactivarTelefono(@PathVariable Long idTelefono) {
		perService.estadoTelefono(idTelefono, "D");
	}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@RequestMapping(value = PersonaRestURIConstant.GET_CV_PERSONA, method = RequestMethod.GET)
	public void getCVPersona(@PathVariable Long idPersona, HttpServletResponse response) {
		Persona per=new Persona();
		Persona p=perService.findById(idPersona);
		if(p!=null)
			per=p;
		//System.out.println(validaCampo(per.getApepat()+" "+per.getApepat()+" "+per.getApemat()));
		Archivo archivo = archivoService.getArchivo(idPersona, "PF");		
		if (archivo == null) {			
			archivo = archivoService.getArchivo(Long.parseLong("0"), "ANONIMO");							
		}
		Image foto=null;
		try {
			foto=Image.getInstance(archivo.getArchivo());
		} catch (Exception e) {
			// TODO: handle exception
		}
		foto.scaleAbsolute(100, 100);
		
		        
		
		Document documento = new Document();
		try{
			
			Font titulo = FontFactory.getFont(FontFactory.COURIER, 16, Font.BOLD, BaseColor.BLACK);	
				
		    Font subtit = FontFactory.getFont(FontFactory.TIMES, 11, Font.NORMAL, BaseColor.BLACK);	
		    response.setContentType("application/pdf");		    
			PdfWriter.getInstance(documento, response.getOutputStream());
			documento.open();											
			//Detalles de Documento
	        documento.addAuthor("Nombre de la persona"); // incluir nombre
	        documento.addCreationDate();
	        documento.addCreator("Gora SAC");
	        documento.addTitle("CV de: "); //incluir nombre			
				    			        	     
		    // Tabla general
		    PdfPTable tabla = new PdfPTable(1); // 3 columns.
		    tabla.setWidthPercentage(100); //Width 100%
		    tabla.setSpacingBefore(10f); //Space before table
		    tabla.setSpacingAfter(10f); //Space after table
		    float[] columnWidths = {1f};
			tabla.setWidths(columnWidths);
			
			
			
			
			
		    //Tabla Cabecera
		    PdfPTable nombresFoto = new PdfPTable(2); // 
		    nombresFoto.setWidthPercentage(100); 
		    nombresFoto.setSpacingBefore(10f); 
		    nombresFoto.setSpacingAfter(10f); 
		    float[] col = {1.5f,0.5f};
		    nombresFoto.setWidths(col);		    
		    	  		  
		    PdfPCell cellDatos = new PdfPCell();
		    cellDatos.setBorderColor(BaseColor.WHITE);		    
		    cellDatos.setHorizontalAlignment(Element.ALIGN_LEFT);
		    cellDatos.setVerticalAlignment(Element.ALIGN_TOP);
		    		    		    
		    Paragraph nombres = new Paragraph(new Paragraph(per.getApepat()+" "+per.getApepat()+" "+per.getApemat(),titulo));		   		    		    		    		   		   
		    Paragraph edad = new Paragraph(new Paragraph("Edad: "+edad(per.getFechanacimiento())+" años",subtit));	
		    Paragraph nacionalidad = new Paragraph(new Paragraph("Nacionalidad: "+per.getNacionalidad(),subtit));
		    String gen="Masculino"; if(per.getSexo().equals("F"))gen="Femenino";		    		
		    Paragraph genero = new Paragraph(new Paragraph("Genero: "+gen,subtit));		    
		    cellDatos.addElement(nombres);
		    cellDatos.addElement(edad);
		    cellDatos.addElement(nacionalidad);
		    cellDatos.addElement(genero);
		    
		    PdfPCell cellFoto = new PdfPCell(foto);
		    cellFoto.setBorderColor(BaseColor.WHITE);
		    cellFoto.setHorizontalAlignment(Element.ALIGN_RIGHT);
		    cellFoto.setVerticalAlignment(Element.ALIGN_MIDDLE);	
		    
		    
		    nombresFoto.addCell(cellDatos);
		    nombresFoto.addCell(cellFoto);
			
		    
		    
		    
		    
		    
		    
		    
		    
		    
		  //Tabla Datos Personales
		    PdfPTable tablaDatos = new PdfPTable(1); // 
		    tablaDatos.setWidthPercentage(100); 		    
		    tablaDatos.setSpacingAfter(10f);
		    
		    float[] colt = {1f};
		    tablaDatos.setWidths(colt);
		    
		    PdfPCell cellTituloDatos = cabeceraColumna("Datos Personales");		   
		    PdfPCell cellDatosPersonales = new PdfPCell();		    
		    cellDatosPersonales.setHorizontalAlignment(Element.ALIGN_LEFT);
		    cellDatosPersonales.setVerticalAlignment(Element.ALIGN_MIDDLE);	
		    cellDatosPersonales.setPaddingLeft(10f);
		    cellDatosPersonales.setPaddingRight(10f);
		    cellDatosPersonales.setPaddingBottom(10f);
		    	
		    Paragraph nroDocumento = new Paragraph(new Paragraph("Documento de Identidad: "+per.getNumerodocidentidad(),subtit));
		    Paragraph tipoDocumento = new Paragraph(new Paragraph("Tipo de Documento de Identidad: "+per.getTipodocidentidad(),subtit));
		    Paragraph fecha_nac = new Paragraph(new Paragraph("Fecha de Nacimiento: "+per.getFechanacimiento(),subtit));
		    String estado_c="SOLTERO"; 
		    if(per.getEstadocivil().equals("C"))
		    	estado_c="CASADO";
		    else if(per.getEstadocivil().equals("V"))
		    	estado_c="VIUDO";
		    else
		    	estado_c="DIVORCIADO";
		    Paragraph estado_civil = new Paragraph(new Paragraph("Estado Civil: "+estado_c,subtit));
		    cellDatosPersonales.addElement(nroDocumento);
		    cellDatosPersonales.addElement(tipoDocumento);
		    cellDatosPersonales.addElement(fecha_nac);
		    cellDatosPersonales.addElement(estado_civil);
		    
		    tablaDatos.addCell(cellTituloDatos);
		    tablaDatos.addCell(cellDatosPersonales);

		    
		    
		    
		    
		    
		    PdfPTable tablaTelefonos = new PdfPTable(2);
		    tablaTelefonos.setWidthPercentage(100); 		    
		    tablaTelefonos.setSpacingAfter(10f);
		    
		    float[] coltl = {1f,1f};
		    tablaTelefonos.setWidths(coltl);
		    
		    PdfPCell cellTituloTelefonos = cabeceraColumna("TELEFONOS");		    
		    cellTituloTelefonos.setColspan(2);
		    		  	   
		    		    
		    tablaTelefonos.addCell(cellTituloTelefonos);
		    tablaTelefonos.addCell(cabeceraColumna("TIPO"));
		    tablaTelefonos.addCell(cabeceraColumna("TELEFONO"));
		    
		   for(int i=0;i<per.getPersonaTelefonos().size();i++){
			   
			   PersonaTelefono pt=per.getPersonaTelefonos().get(i);
			   if(pt.getEstado().equals("A")){
				   tablaTelefonos.addCell(estiloCelda(pt.getTipo()));
				   tablaTelefonos.addCell(estiloCelda(pt.getTelefono()));
			   }
		   }
		   
		   
		   
		   
		   PdfPTable tablaDirecciones = new PdfPTable(3);
		   tablaDirecciones.setWidthPercentage(100); 		    
		   tablaDirecciones.setSpacingAfter(10f);
		    
		    float[] colt2 = {1f,1f,1f};
		    tablaDirecciones.setWidths(colt2);
		    
		    PdfPCell cellTituloDirecciones = cabeceraColumna("DIRECCIONES");		    
		    cellTituloDirecciones.setColspan(5);
		    		  	   
		    		    
		    tablaDirecciones.addCell(cellTituloDirecciones);
		    tablaDirecciones.addCell(cabeceraColumna("TIPO"));
		    tablaDirecciones.addCell(cabeceraColumna("DIRECCION"));
		    //tablaDirecciones.addCell(cabeceraColumna("DEPARTAMENTO"));
		    //tablaDirecciones.addCell(cabeceraColumna("PROVINCIA"));
		    tablaDirecciones.addCell(cabeceraColumna("DISTRITO"));
		    
		   for(int i=0;i<per.getPersonaDireccions().size();i++){
			   PersonaDireccion pt=per.getPersonaDireccions().get(i);
			   if(pt.getEstado().equals("A")){
				   Ubigeo ub=ubigeoService.findById(pt.getIdubigeo());
				   tablaDirecciones.addCell(estiloCelda(pt.getTipo()));
				   tablaDirecciones.addCell(estiloCelda(pt.getDireccion()));			   
				   tablaDirecciones.addCell(estiloCelda(ub.getDistrito()));
			   }
		   }
		   
		   
		   
		   
		   
		    
		    
			PdfPCell cabecera = new PdfPCell(nombresFoto);
			cabecera.setBorderColor(BaseColor.WHITE);
			cabecera.setPaddingLeft(10);
			cabecera.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cabecera.setVerticalAlignment(Element.ALIGN_MIDDLE);			
			cabecera.setBorderColorBottom(BaseColor.GRAY);									    		   			     
			cabecera.setBorderWidthBottom(2f);
			cabecera.setPaddingBottom(5f);
			
			PdfPCell datosPersonales = new PdfPCell(tablaDatos);
			datosPersonales.setBorderColor(BaseColor.WHITE);
			datosPersonales.setPaddingLeft(10);
			datosPersonales.setHorizontalAlignment(Element.ALIGN_CENTER);
			datosPersonales.setVerticalAlignment(Element.ALIGN_MIDDLE);			
			//datosPersonales.setBorderColorBottom(BaseColor.GRAY);									    		   			     
			//datosPersonales.setBorderWidthBottom(2f);  
			datosPersonales.setPaddingBottom(5f);
			
			
			PdfPCell telefonos = new PdfPCell(tablaTelefonos);
			telefonos.setBorderColor(BaseColor.WHITE);
			telefonos.setPaddingLeft(10);
			telefonos.setHorizontalAlignment(Element.ALIGN_CENTER);
			telefonos.setVerticalAlignment(Element.ALIGN_MIDDLE);			
			//telefonos.setBorderColorBottom(BaseColor.GRAY);									    		   			     
			//telefonos.setBorderWidthBottom(2f);  
			telefonos.setPaddingBottom(5f);
			
			PdfPCell direcciones = new PdfPCell(tablaDirecciones);
			direcciones.setBorderColor(BaseColor.WHITE);
			direcciones.setPaddingLeft(10);
			direcciones.setHorizontalAlignment(Element.ALIGN_CENTER);
			direcciones.setVerticalAlignment(Element.ALIGN_MIDDLE);			
			//direcciones.setBorderColorBottom(BaseColor.GRAY);									    		   			     
			//direcciones.setBorderWidthBottom(2f);  
			direcciones.setPaddingBottom(5f);
			
			
			
			PdfPCell cellEspacio = new PdfPCell();
		    cellEspacio.setBorderColor(BaseColor.WHITE);
		    cellEspacio.setFixedHeight(15f);
		    
		    
		    
		    
		    
		    
			tabla.addCell(cabecera);
			tabla.addCell(cellEspacio);
			tabla.addCell(datosPersonales);
			tabla.addCell(cellEspacio);
			tabla.addCell(telefonos);
			tabla.addCell(cellEspacio);
			tabla.addCell(direcciones);
			documento.add(tabla);			
			
		}catch(Exception e){
		    e.printStackTrace();
		}
		
			documento.close();		    
		}
	
	
	private String edad(Date fecha_nac) {     //fecha_nac debe tener el formato dd/MM/yyyy
		String resp="";
		int anios;
		if(fecha_nac!=null){   
		    Date fechaActual = new Date();
		    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		    String fecha=formato.format(fecha_nac);
		    String hoy = formato.format(fechaActual);
		    String[] dat1 = fecha.split("/");
		    String[] dat2 = hoy.split("/");
		    anios = Integer.parseInt(dat2[2]) - Integer.parseInt(dat1[2]);
		    int mes = Integer.parseInt(dat2[1]) - Integer.parseInt(dat1[1]);
		    if (mes < 0) {
		      anios = anios - 1;
		    } else if (mes == 0) {
		      int dia = Integer.parseInt(dat2[0]) - Integer.parseInt(dat1[0]);
		      if (dia > 0) {
		        anios = anios - 1;
		      }
		    }
		    resp=anios+"";
		}else{
			resp="Indefinido";
		}
	    return resp;
	}
	
	private PdfPCell estiloCelda(String cad){
		Font estilo = FontFactory.getFont(FontFactory.TIMES, 11, Font.NORMAL, BaseColor.BLACK);
		PdfPCell celda = new PdfPCell(new Paragraph(cad,estilo));
		celda.setBorderColor(BaseColor.DARK_GRAY);
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_MIDDLE);	
		celda.setPadding(5f);		
		return celda;
	}
	private PdfPCell cabeceraColumna(String cad){
		Font tituloblanco = FontFactory.getFont(FontFactory.COURIER, 10, Font.BOLD, BaseColor.WHITE);
		PdfPCell celda = new PdfPCell(new Paragraph(cad,tituloblanco));
		celda.setBorderColor(BaseColor.DARK_GRAY);		   
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_MIDDLE);	
		celda.setPadding(5f);
		celda.setBackgroundColor(BaseColor.GRAY);
		return celda;
	}
	

}


