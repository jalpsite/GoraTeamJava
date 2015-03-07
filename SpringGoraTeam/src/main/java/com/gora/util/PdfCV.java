package com.gora.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;



import com.gora.dominio.Archivo;
import com.gora.dominio.Experiencia;
import com.gora.dominio.Formacion;
import com.gora.dominio.Persona;
import com.gora.dominio.PersonaDireccion;
import com.gora.dominio.PersonaEmail;
import com.gora.dominio.PersonaTelefono;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.List;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class PdfCV {
		
	private Persona per;
	private Archivo archivo;
	Font titulo = FontFactory.getFont(FontFactory.HELVETICA, 16, Font.BOLD, BaseColor.BLACK);					
    Font subtit = FontFactory.getFont(FontFactory.HELVETICA , 11, Font.NORMAL, BaseColor.BLACK);	
	
	public PdfCV(Persona p, Archivo ar){
		this.per=p;
		this.archivo=ar;
	}
	
	public PdfCV(){
		
	}
	
	
	public void generarCV(HttpServletResponse response){

		Image foto=null;
		try {
			foto=Image.getInstance(archivo.getArchivo());
		} catch (Exception e) {			
		}
		foto.scaleAbsolute(100, 100);				      
		
		Document documento = new Document();
		try{						
		    response.setContentType("application/pdf");	
		    //response.setHeader("Content-Disposition", "attachment;"+"filename="+System.currentTimeMillis()+".pdf");
			PdfWriter.getInstance(documento, response.getOutputStream());
			documento.open();											
			
			/* TABLA GENERAL */
			PdfPTable tabla=tabla(1);			 			
			float[] columnWidths = {1f};
			tabla.setWidths(columnWidths);
			
			
		    /* DATOS CABECERA */
		    PdfPTable nombresFoto = tabla(2); 		    		    		    
		    float[] col = {1.5f,0.5f};
		    nombresFoto.setWidths(col);		    		    	  	
		    datosCabecera(nombresFoto,foto);		    		    					    		    		    		    		    		    
		    
		    
		    
		    /* DATOS PERSONALES */
		    PdfPTable tablaDatos = tabla(2); // 		     		   		    		   
		    float[] colt = {1f, 1f};
		    tablaDatos.setWidths(colt);			    
		    datosPersonales(tablaDatos);
		    
		    
		    /* FORMACION PROFESIONAL */
		    PdfPTable tablaFormacion = tabla(2); // 		     		   		    		   
		    float[] cole = {0.7f, 1.3f};
		    tablaFormacion.setWidths(cole);			    
		    formacionProfesional(tablaFormacion);
		    
		    /* EXPERIENCIA PROFESIONAL */
		    PdfPTable tablaExperiencia = tabla(2); // 		     		   		    		   
		    float[] cols = {0.7f, 1.3f};
		    tablaExperiencia.setWidths(cols);			    
		    experienciaProfesional(tablaExperiencia);
		    		    		
		    /* EXPERIENCIA PROFESIONAL */
		    PdfPTable tablaCompetencia = tabla(3); // 		     		   		    		   
		    float[] colsx = {1f, 1f, 1f};
		    tablaCompetencia.setWidths(colsx);			    
		    competenciaProfesional(tablaCompetencia);
		    
		    
			PdfPCell cabecera = new PdfPCell(nombresFoto);
			cabecera.setBorderColor(BaseColor.WHITE);			
			cabecera.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cabecera.setVerticalAlignment(Element.ALIGN_MIDDLE);			
			cabecera.setBorderColorBottom(BaseColor.GRAY);									    		   			     
			cabecera.setBorderWidthBottom(2f);
			cabecera.setPaddingBottom(5f);
			
			PdfPCell datosPersonales = new PdfPCell(tablaDatos);
			datosPersonales.setBorderColor(BaseColor.WHITE);			
			datosPersonales.setHorizontalAlignment(Element.ALIGN_CENTER);
			datosPersonales.setVerticalAlignment(Element.ALIGN_MIDDLE);						
			datosPersonales.setPaddingBottom(5f);
			
			PdfPCell formaciones = new PdfPCell(tablaFormacion);
			formaciones.setBorderColor(BaseColor.WHITE);			
			formaciones.setHorizontalAlignment(Element.ALIGN_CENTER);
			formaciones.setVerticalAlignment(Element.ALIGN_MIDDLE);						
			formaciones.setPaddingBottom(5f);
					
			PdfPCell experiencias = new PdfPCell(tablaExperiencia);
			experiencias.setBorderColor(BaseColor.WHITE);			
			experiencias.setHorizontalAlignment(Element.ALIGN_CENTER);
			experiencias.setVerticalAlignment(Element.ALIGN_MIDDLE);						
			experiencias.setPaddingBottom(5f);
			
			PdfPCell competencias = new PdfPCell(tablaCompetencia);
			competencias.setBorderColor(BaseColor.WHITE);			
			competencias.setHorizontalAlignment(Element.ALIGN_CENTER);
			competencias.setVerticalAlignment(Element.ALIGN_MIDDLE);						
			competencias.setPaddingBottom(5f);
		    
			tabla.addCell(cabecera);
			tabla.addCell(celdaEspacio());
			tabla.addCell(datosPersonales);			
			tabla.addCell(formaciones);
			tabla.addCell(experiencias);
			tabla.addCell(competencias);
			documento.add(tabla);			
			
		}catch(Exception e){
		    e.printStackTrace();
		}
		
		documento.close();
	}
	
	private String edad(Date fecha_nac) {  
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
	
	private PdfPCell cabeceraColumna(String cad){
		Font tituloblanco = FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD, BaseColor.WHITE);
		PdfPCell celda = new PdfPCell(new Paragraph(cad,tituloblanco));
		celda.setBorderColor(BaseColor.DARK_GRAY);		   
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_MIDDLE);	
		celda.setPadding(5f);
		celda.setBackgroundColor(BaseColor.GRAY);
		return celda;
	}
	
	private PdfPTable tabla(int col){
		 // Tabla general	
		PdfPTable tabla=new PdfPTable(col);
	    tabla.setWidthPercentage(100); 
	    tabla.setSpacingBefore(10f); 
	    tabla.setSpacingAfter(10f); 
		return tabla;
	}
	
	private void datosCabecera(PdfPTable nombresFoto, Image foto){
		PdfPCell cellDatos = new PdfPCell();
	    cellDatos.setBorderColor(BaseColor.WHITE);		    
	    cellDatos.setHorizontalAlignment(Element.ALIGN_LEFT);
	    cellDatos.setVerticalAlignment(Element.ALIGN_TOP);	    
	    
	    Paragraph nombres = new Paragraph(new Paragraph(per.getNombres()+" "+per.getApepat()+" "+per.getApemat(),titulo));		   		    		    		    		   		   
	    Paragraph edad = new Paragraph(new Paragraph("Edad: "+edad(per.getFechanacimiento())+" años",subtit));	
	    Paragraph nacionalidad = new Paragraph(new Paragraph("Nacionalidad: "+parseMayuscula(per.getNacionalidad()),subtit));
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
	}
	
	private void datosPersonales(PdfPTable tablaDatos){
		PdfPCell cellTituloDatos = cabeceraColumna("DATOS PERSONALES");	
		cellTituloDatos.setColspan(2);
		
	    PdfPCell cellDatosPersonales = estiloCelda();		    	    
	    cellDatosPersonales.setRowspan(2);	    
	    Paragraph nroDocumento = new Paragraph(new Paragraph("Documento de Identidad: "+per.getNumerodocidentidad(),subtit));
	    Paragraph tipoDocumento = new Paragraph(new Paragraph("Tipo de Documento de Identidad: "+per.getTipodocidentidad(),subtit));
	    Paragraph fecha_nac = new Paragraph(new Paragraph("Fecha de Nacimiento: "+per.getFechanacimiento(),subtit));
	    String estado_c="Soltero"; 
	    if(per.getEstadocivil().equals("C"))
	    	estado_c="Casado";
	    else if(per.getEstadocivil().equals("V"))
	    	estado_c="Viudo";
	    else
	    	estado_c="Divorciado";
	    Paragraph estado_civil = new Paragraph(new Paragraph("Estado Civil: "+estado_c,subtit));
	    cellDatosPersonales.addElement(nroDocumento);
	    cellDatosPersonales.addElement(tipoDocumento);
	    cellDatosPersonales.addElement(fecha_nac);
	    cellDatosPersonales.addElement(estado_civil);	 
	    
	    PdfPCell cellCorreos = estiloCelda();	    
	    Paragraph tituloCorreos = new Paragraph(new Paragraph("Correo(s): ",subtit));
	    List listaCorreos = new List(List.UNORDERED);	    
	    if(per.getPersonaEmails().size()>0){
	    	for(PersonaEmail perEmail : per.getPersonaEmails() ){
	    		if(perEmail.getEstado().equals("A"))
	    			listaCorreos.add(new ListItem(parseMayuscula(perEmail.getEmail()+" ("+perEmail.getTipo()+")"),subtit));
	    	}	    	
	    }else{
	    	listaCorreos.add(new ListItem("No tiene Correos Registrados",subtit));
	    }	    	   	    
	    cellCorreos.addElement(tituloCorreos);	    
	    cellCorreos.addElement(listaCorreos);
	    
	    PdfPCell cellTelefonos = estiloCelda();		       
	    Paragraph tituloTelefonos = new Paragraph(new Paragraph("Telefono(s): ",subtit));
	    List listaTelefonos = new List(List.UNORDERED);	    
	    if(per.getPersonaTelefonos().size()>0){
	    	for(PersonaTelefono perTel : per.getPersonaTelefonos() ){
	    		if(perTel.getEstado().equals("A"))
	    			listaTelefonos.add(new ListItem(parseMayuscula(perTel.getTelefono()+" ("+perTel.getTipo()+")"),subtit));
	    	}	    	
	    }else{
	    	listaCorreos.add(new ListItem("No tiene Telefonos Registrados",subtit));
	    }	    	   	    
	    cellTelefonos.addElement(tituloTelefonos);	    
	    cellTelefonos.addElement(listaTelefonos);
	    
	    
	    
	    PdfPCell cellDirecciones = estiloCelda();	    
	    cellDirecciones.setColspan(2);	    
	    Paragraph tituloDirecciones = new Paragraph(new Paragraph("Direccion(s): ",subtit));
	    List listaDirecciones = new List(List.UNORDERED);	    
	    if(per.getPersonaDireccions().size()>0){	    	
	    	for(PersonaDireccion perDir : per.getPersonaDireccions() ){
	    		if(perDir.getEstado().equals("A")){	    			
		    		listaDirecciones.add(new ListItem(parseMayuscula(perDir.getDireccion()+" ("+perDir.getTipo()+") - "+perDir.ubigeo.getDistrito()),subtit));
	    		}	    		
	    	}	    	
	    }else{
	    	listaCorreos.add(new ListItem("No tiene Direcciones Registradas",subtit));
	    }	    
	    cellDirecciones.addElement(tituloDirecciones);	    
	    cellDirecciones.addElement(listaDirecciones);
	    
	    PdfPCell cellTituloDatos2 = cabeceraColumna("DATOS PERSONALES");	
		cellTituloDatos.setColspan(2);
	    
	    
	    tablaDatos.addCell(cellTituloDatos);
	    tablaDatos.addCell(cellDatosPersonales);
	    tablaDatos.addCell(cellCorreos);
	    tablaDatos.addCell(cellTelefonos);
	    tablaDatos.addCell(cellDirecciones);
	    tablaDatos.addCell(cellTituloDatos2);
	    
	}
	
	private void formacionProfesional(PdfPTable tablaFormacion){
		PdfPCell cellTituloFormacion = cabeceraColumna("FORMACION PROFESIONAL");
		cellTituloFormacion.setColspan(2);
		
		
		tablaFormacion.addCell(cellTituloFormacion);
		if(per.getFormacions().size()>0){			
			for(Formacion f:per.getFormacions()){
				PdfPCell columna1 = estiloCelda();
				PdfPCell columna2 = estiloCelda();
				//Fechas
				SimpleDateFormat formato = new SimpleDateFormat("yyyy");
				String anioInicio=formato.format(f.getAnhoinicio());
				String anioFin=formato.format(f.getAnhofin());
				String rangoFecha=anioInicio+" - "+anioFin;
				if(anioInicio.equals(anioFin))
					rangoFecha=anioInicio;
				//Grado
				String grado=f.getGrado().getDescripcion();
				if(f.getGrado().getIdgrado()==0){
					grado=f.getOtrogrado();
				}
				Paragraph anios = new Paragraph(new Paragraph(rangoFecha,subtit));
				Paragraph nivel = new Paragraph(new Paragraph(parseMayuscula(f.getNivelestudio()+" - "+grado),subtit));
				Paragraph carrera = new Paragraph(new Paragraph(f.getCarrera().getNombre(),subtit));
				Paragraph universidad = new Paragraph(new Paragraph(parseMayuscula(f.getUniversidad().getNombre()),subtit));
				Paragraph descripcion = new Paragraph(new Paragraph(parseMayuscula(f.getDescripcion()),subtit));
				columna1.addElement(anios);
				columna1.addElement(nivel);
				columna2.addElement(carrera);
				columna2.addElement(universidad);
				columna2.addElement(descripcion);
				tablaFormacion.addCell(columna1);
				tablaFormacion.addCell(columna2);
			}										
		}else{
			Paragraph sinResultados = new Paragraph(new Paragraph("No Tiene Formaciones Registradas",subtit));
			tablaFormacion.addCell(new PdfPCell(sinResultados));
		}		
						    
	}
	
	private void experienciaProfesional(PdfPTable tablaExperiencia){
		PdfPCell cellTituloExperiencia = cabeceraColumna("EXPERIENCIA PROFESIONAL");
		cellTituloExperiencia.setColspan(2);					
		tablaExperiencia.addCell(cellTituloExperiencia);
		
		if(per.getExperiencias().size()>0){			
			for(Experiencia ex:per.getExperiencias()){
				PdfPCell columna1 = estiloCelda();
				PdfPCell columna2 = estiloCelda();
				//Fechas
				SimpleDateFormat formato = new SimpleDateFormat("yyyy");
				String anioInicio=formato.format(ex.getAnhoinicio());
				String anioFin=formato.format(ex.getAnhofin());
				String rangoFecha=anioInicio+" - "+anioFin;
				if(anioInicio.equals(anioFin))
					rangoFecha=anioInicio;
				//Cargo
				String cargo=ex.oCargo.getDescripcion();
				if(ex.oCargo.getIdcargo()==0){
					cargo=ex.getOtros();
				}
				Paragraph anios = new Paragraph(new Paragraph(rangoFecha,subtit));
				Paragraph pCargo = new Paragraph(new Paragraph(parseMayuscula(cargo),subtit));
				Paragraph pais = new Paragraph(new Paragraph(parseMayuscula(ex.getPais()),subtit));
				Paragraph empresa = new Paragraph(new Paragraph(ex.getEmpresa(),subtit));
				Paragraph descripcion = new Paragraph(new Paragraph(parseMayuscula(ex.getDescripcion()),subtit));
				
				columna1.addElement(anios);
				columna1.addElement(pCargo);
				columna2.addElement(empresa);
				columna2.addElement(pais);
				columna2.addElement(descripcion);					
				tablaExperiencia.addCell(columna1);
				tablaExperiencia.addCell(columna2);
			}										
		}else{
			Paragraph sinResultados = new Paragraph(new Paragraph("No Tiene Experiencias Registradas",subtit));
			tablaExperiencia.addCell(new PdfPCell(sinResultados));
		}	
	}
	
	
	private void competenciaProfesional(PdfPTable tablaCompetencia){
		PdfPCell cellTituloCompetencia = cabeceraColumna("COMPETENCIAS PROFESIONALES");
		cellTituloCompetencia.setColspan(3);					
		tablaCompetencia.addCell(cellTituloCompetencia);
		
					
		tablaCompetencia.addCell(cabeceraColumna("COMPETENCIAS"));
		tablaCompetencia.addCell(cabeceraColumna("HABILIDADES"));
		tablaCompetencia.addCell(cabeceraColumna("ATRIBUTOS"));
		
		/*
		if(per.getMatrices().size()>0){			
			for(Experiencia ex:per.getExperiencias()){
				PdfPCell columna1 = estiloCelda();
				PdfPCell columna2 = estiloCelda();
				//Fechas
				SimpleDateFormat formato = new SimpleDateFormat("yyyy");
				String anioInicio=formato.format(ex.getAnhoinicio());
				String anioFin=formato.format(ex.getAnhofin());
				String rangoFecha=anioInicio+" - "+anioFin;
				if(anioInicio.equals(anioFin))
					rangoFecha=anioInicio;
				//Cargo
				String cargo=ex.oCargo.getDescripcion();
				if(ex.oCargo.getIdcargo()==0){
					cargo=ex.getOtros();
				}
				Paragraph anios = new Paragraph(new Paragraph(rangoFecha,subtit));
				Paragraph pCargo = new Paragraph(new Paragraph(parseMayuscula(cargo),subtit));
				Paragraph pais = new Paragraph(new Paragraph(parseMayuscula(ex.getPais()),subtit));
				Paragraph empresa = new Paragraph(new Paragraph(ex.getEmpresa(),subtit));
				Paragraph descripcion = new Paragraph(new Paragraph(parseMayuscula(ex.getDescripcion()),subtit));
				
				columna1.addElement(anios);
				columna1.addElement(pCargo);
				columna2.addElement(empresa);
				columna2.addElement(pais);
				columna2.addElement(descripcion);					
				tablaCompetencia.addCell(columna1);
				tablaCompetencia.addCell(columna2);
			}										
		}else{
			Paragraph sinResultados = new Paragraph(new Paragraph("No Tiene Experiencias Registradas",subtit));
			tablaCompetencia.addCell(new PdfPCell(sinResultados));
		}	
		*/
	}
	
	
	private PdfPCell celdaEspacio(){
		PdfPCell cellEspacio = new PdfPCell();
	    cellEspacio.setBorderColor(BaseColor.WHITE);
	    cellEspacio.setFixedHeight(15f);		    
	    return cellEspacio;
	}
	
	private PdfPCell estiloCelda(){
		PdfPCell cell = new PdfPCell();		    
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);	
		cell.setPaddingLeft(10f);
		cell.setPaddingRight(10f);
		cell.setPaddingBottom(10f);
		cell.setBorderColor(BaseColor.GRAY);
		return cell;
	}
	
	private String parseMayuscula(String cad){
		cad=cad.toLowerCase();
		char[] caracteres = cad.toCharArray();
		caracteres[0] = Character.toUpperCase(caracteres[0]);
		for (int i = 0; i < cad.length()- 2; i++) 		   
		    if (caracteres[i] == '.' || caracteres[i] == ','|| caracteres[i] == '(')		      
		      caracteres[i + 1] = Character.toUpperCase(caracteres[i + 1]);
		return new String(caracteres);
	}
	//cellDirecciones.addElement(new LineSeparator(0.5f, 100, null, 0, -5));
	
}
