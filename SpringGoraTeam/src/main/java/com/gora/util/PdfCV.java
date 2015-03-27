package com.gora.util;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletResponse;

import com.gora.dominio.Archivo;
import com.gora.dominio.Atributos;
import com.gora.dominio.Experiencia;
import com.gora.dominio.Formacion;
import com.gora.dominio.Habilidad;
import com.gora.dominio.Matriz;
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
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class PdfCV {
		
	private Persona per;
	private Archivo archivo;
	private java.util.List<Habilidad> listaHabilidad;
	private java.util.List<Atributos> listaAtributos;
	Font titulo = FontFactory.getFont(FontFactory.HELVETICA, 16, Font.BOLD, BaseColor.BLACK);					
    Font subtit = FontFactory.getFont(FontFactory.HELVETICA , 11, Font.NORMAL, BaseColor.BLACK);	
	
	public PdfCV(Persona p,java.util.List<Habilidad> lista,java.util.List<Atributos> lista2, Archivo ar){
		this.per=p;
		this.archivo=ar;
		this.listaHabilidad=lista;
		this.listaAtributos=lista2;
	}
	
	public PdfCV(){
		
	}
		
	public void generarCV(HttpServletResponse response){

		Image foto=null;
		Image logo=null;
		try {
			foto=Image.getInstance(archivo.getArchivo());
			String ruta="http://www.gorasac.com/wp-content/uploads/2013/10/gora-logo1.png";
			logo=Image.getInstance(new URL(ruta));
		} catch (Exception e) {			
		}
				
		foto.scaleAbsolute(80, 80);				      
		
		Document documento = new Document();
		try{						
		    response.setContentType("application/pdf");			    
		    response.setHeader("Content-Disposition", "attachment;"+"filename="+parseMayuscula(per.getApepat())+parseMayuscula(per.getApemat())+".pdf");
			PdfWriter.getInstance(documento, response.getOutputStream());
			documento.open();											
			
			/* TABLA GENERAL */
			PdfPTable tabla=tabla(1);			 			
			float[] columnWidths = {1f};
			tabla.setWidths(columnWidths);
			
			PdfPTable tablaHorizontal=tabla(1);			 			
			float[] columnWidths_H = {1f};
			tablaHorizontal.setWidths(columnWidths_H);
			
		    /* DATOS CABECERA */
		    PdfPTable nombresFoto = tabla(3); 		    		    		    
		    float[] col = {0.3f,1.0f,0.5f};
		    nombresFoto.setWidths(col);		    		    	  	
		    datosCabecera(nombresFoto,foto,logo);		    		    					    		    		    		    		    		    
		    
		    		    
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
		    		    		
		    /* COMPETENCIA PROFESIONAL */
		    PdfPTable tablaCompetencia = tabla(3); // 		     		   		    		   
		    float[] colsx = {1f, 1f, 1f};
		    tablaCompetencia.setWidths(colsx);			    
		    competenciaProfesional(tablaCompetencia);
		    
		    /* CERTIFICACIONES PROFESIONALES */
		    PdfPTable tablaCertificaciones = tabla(3); // 		     		   		    		   
		    float[] colsc = {2.0f, 0.5f, 0.5f};
		    tablaCertificaciones.setWidths(colsc);			    
		    certificacionProfesional(tablaCertificaciones);
		    
			PdfPCell cabecera = new PdfPCell(nombresFoto);
			cabecera.setBorderColor(BaseColor.WHITE);			
			cabecera.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cabecera.setVerticalAlignment(Element.ALIGN_MIDDLE);			
			cabecera.setBorderColorBottom(BaseColor.GRAY);									    		   			     
			cabecera.setBorderWidthBottom(2f);
			cabecera.setPaddingBottom(5f);
			
			PdfPCell datosPersonales = cellMaestra(tablaDatos);			
			PdfPCell formaciones = cellMaestra(tablaFormacion);							
			PdfPCell experiencias = cellMaestra(tablaExperiencia);			
			PdfPCell competencias = cellMaestra(tablaCompetencia);
			PdfPCell certificaciones = cellMaestra(tablaCertificaciones);
			
			tabla.addCell(cabecera);
			tabla.addCell(celdaEspacio());
			tabla.addCell(datosPersonales);			
			tabla.addCell(formaciones);
			tabla.addCell(experiencias);
			tablaHorizontal.addCell(competencias);
			/*int cont=0;
			for(Atributos a:listaAtributos){if (a.getCertificado().equals("S")) cont++;}
			if(cont>0) tabla.addCell(certificaciones);
			*/
			
			documento.setPageSize(PageSize.A4);
			documento.newPage();			
			
			documento.add(tabla);	
			
			documento.setPageSize(PageSize.A4.rotate());
			documento.newPage();
			
			documento.add(tablaHorizontal);
			
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
	
	private void datosCabecera(PdfPTable nombresFoto, Image foto, Image log){
		PdfPCell cellDatos = new PdfPCell();
	    cellDatos.setBorderColor(BaseColor.WHITE);		    
	    cellDatos.setHorizontalAlignment(Element.ALIGN_LEFT);
	    cellDatos.setVerticalAlignment(Element.ALIGN_TOP);	    
	    
	    Paragraph nombres = new Paragraph(per.getNombres()+" "+per.getApepat()+" "+per.getApemat(),titulo);		   		    		    		    		   		   
	    Paragraph edad = new Paragraph("Edad: "+edad(per.getFechanacimiento())+" años",subtit);	
	    Paragraph nacionalidad = new Paragraph("Nacionalidad: "+parseMayuscula(per.getNacionalidad()),subtit);
	    String gen="Masculino"; if(per.getSexo().equals("F"))gen="Femenino";		    		
	    Paragraph genero = new Paragraph("Genero: "+gen,subtit);		    
	    cellDatos.addElement(nombres);
	    cellDatos.addElement(edad);
	    cellDatos.addElement(nacionalidad);
	    cellDatos.addElement(genero);
	    
	    PdfPCell cellFoto = new PdfPCell(foto);
	    cellFoto.setBorderColor(BaseColor.WHITE);
	    cellFoto.setHorizontalAlignment(Element.ALIGN_LEFT);
	    cellFoto.setVerticalAlignment(Element.ALIGN_MIDDLE);
	    
	    PdfPCell cellLogo = new PdfPCell(log);
	    cellLogo.setBorderColor(BaseColor.WHITE);
	    cellLogo.setHorizontalAlignment(Element.ALIGN_RIGHT);
	    cellLogo.setVerticalAlignment(Element.ALIGN_MIDDLE);
	    	    
	    
	    nombresFoto.addCell(cellFoto);
	    nombresFoto.addCell(cellDatos);
	    nombresFoto.addCell(cellLogo);
	}
	
	private void datosPersonales(PdfPTable tablaDatos){
		PdfPCell cellTituloDatos = cabeceraColumna("DATOS PERSONALES");	
		cellTituloDatos.setColspan(2);
		
	    PdfPCell cellDatosPersonales = estiloCelda(1,2);		    	    	      
	    Paragraph nroDocumento = new Paragraph("Documento de Identidad: "+per.getNumerodocidentidad(),subtit);
	    Paragraph tipoDocumento = new Paragraph("Tipo de Documento de Identidad: "+per.getTipodocidentidad(),subtit);
	    Paragraph fecha_nac = new Paragraph("Fecha de Nacimiento: "+per.getFechanacimiento(),subtit);
	    String estado_c="Soltero"; 
	    if(per.getEstadocivil().equals("C"))
	    	estado_c="Casado";
	    else if(per.getEstadocivil().equals("V"))
	    	estado_c="Viudo";
	    else
	    	estado_c="Divorciado";
	    Paragraph estado_civil = new Paragraph("Estado Civil: "+estado_c,subtit);	   
	    cellDatosPersonales.addElement(nroDocumento);
	    cellDatosPersonales.addElement(tipoDocumento);
	    cellDatosPersonales.addElement(fecha_nac);
	    cellDatosPersonales.addElement(estado_civil);		   
	    
	    PdfPCell cellCorreos = estiloCelda(1,1);	    
	    Paragraph tituloCorreos = new Paragraph("Correo(s): ",subtit);
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
	    
	    PdfPCell cellTelefonos = estiloCelda(1,1);		       
	    Paragraph tituloTelefonos = new Paragraph("Telefono(s): ",subtit);
	    List listaTelefonos = new List(List.UNORDERED);	    
	    if(per.getPersonaTelefonos().size()>0){
	    	for(PersonaTelefono perTel : per.getPersonaTelefonos() ){
	    		if(perTel.getEstado().equals("A"))
	    			listaTelefonos.add(new ListItem(parseMayuscula(perTel.getTelefono()+" ("+perTel.getTipo()+")"),subtit));
	    	}	    	
	    }else{
	    	listaTelefonos.add(new ListItem("No tiene Telefonos Registrados",subtit));
	    }	    	   	    
	    cellTelefonos.addElement(tituloTelefonos);	    
	    cellTelefonos.addElement(listaTelefonos);	    	   
	    
	    PdfPCell cellDirecciones = estiloCelda(1,1);	    
	    cellDirecciones.setColspan(2);	    
	    Paragraph tituloDirecciones = new Paragraph("Direccion(es): ",subtit);
	    List listaDirecciones = new List(List.UNORDERED);	    
	    if(per.getPersonaDireccions().size()>0){	    	
	    	for(PersonaDireccion perDir : per.getPersonaDireccions() ){
	    		if(perDir.getEstado().equals("A")){	    			
		    		listaDirecciones.add(new ListItem(parseMayuscula(perDir.getDireccion()+" ("+perDir.getTipo()+") - "+perDir.ubigeo.getDistrito()),subtit));
	    		}	    		
	    	}	    	
	    }else{
	    	listaDirecciones.add(new ListItem("No tiene Direcciones Registradas",subtit));
	    }	    
	    cellDirecciones.addElement(tituloDirecciones);	    
	    cellDirecciones.addElement(listaDirecciones);
	    
	    PdfPCell cellPresentacion = estiloCelda(2,1);		  
	    Paragraph tituPresentacion = new Paragraph("Presentacion:",subtit);
	    
	    Pattern Tags = Pattern.compile("<.+?>");
	    String pres=parseMayuscula(per.getPresentacion());
	    Matcher m = Tags.matcher(pres);
	    pres= m.replaceAll("").replaceAll("\\&.*?\\;", "");
	    
	    Paragraph presentacion = new Paragraph(pres,subtit);
	    cellPresentacion.addElement(tituPresentacion);
	    cellPresentacion.addElement(presentacion);
	    tablaDatos.addCell(cellTituloDatos);
	    tablaDatos.addCell(cellDatosPersonales);
	    tablaDatos.addCell(cellCorreos);
	    tablaDatos.addCell(cellTelefonos);
	    tablaDatos.addCell(cellDirecciones);
	    tablaDatos.addCell(cellPresentacion);
	    
	}
	
	private void formacionProfesional(PdfPTable tablaFormacion){
		PdfPCell cellTituloFormacion = cabeceraColumna("FORMACION PROFESIONAL");
		cellTituloFormacion.setColspan(2);			
		
		tablaFormacion.addCell(cellTituloFormacion);
		if(per.getFormacions().size()>0){			
			for(Formacion f:per.getFormacions()){
				PdfPCell columna1 = estiloCelda(1,1);
				PdfPCell columna2 = estiloCelda(1,1);
				//Fechas
				SimpleDateFormat formato = new SimpleDateFormat("yyyy");
				String anioInicio=formato.format(f.getAnhoinicio());
				String anioFin=formato.format(f.getAnhofin());
				String rangoFecha="";
				if(f.getEncurso().equalsIgnoreCase("1")){
					anioFin="Hasta la Actualidad";
					rangoFecha=anioInicio+" - "+anioFin;
				}else{
					rangoFecha=anioInicio+" - "+anioFin;
					if(anioInicio.equals(anioFin))
						rangoFecha=anioInicio;
				}				
				
				//Grado
				String grado=f.getGrado().getDescripcion();
				if(f.getGrado().getIdgrado()==0){
					grado=f.getOtrogrado();
				}
				Paragraph anios = new Paragraph(rangoFecha,subtit);
				Paragraph nivel = new Paragraph(parseMayuscula(f.getNivelestudio()+" - "+grado),subtit);
				Paragraph carrera = new Paragraph(f.getCarrera().getNombre(),subtit);
				Paragraph universidad = new Paragraph(parseMayuscula(f.getUniversidad().getNombre()),subtit);
				Paragraph descripcion = new Paragraph(parseMayuscula(f.getDescripcion()),subtit);
				columna1.addElement(anios);
				columna1.addElement(nivel);
				columna2.addElement(carrera);
				columna2.addElement(universidad);
				columna2.addElement(descripcion);
				tablaFormacion.addCell(columna1);
				tablaFormacion.addCell(columna2);
			}										
		}else{
			PdfPCell cellSinResultados = estiloCelda(2,1);
			Paragraph textoSinResultados=new Paragraph("No Tiene Formaciones Registradas",subtit);
			cellSinResultados.addElement(textoSinResultados);			
			tablaFormacion.addCell(new PdfPCell(cellSinResultados));
		}		
						    
	}
	
	private void experienciaProfesional(PdfPTable tablaExperiencia){
		PdfPCell cellTituloExperiencia = cabeceraColumna("EXPERIENCIA PROFESIONAL");
		cellTituloExperiencia.setColspan(2);					
		tablaExperiencia.addCell(cellTituloExperiencia);
		
		if(per.getExperiencias().size()>0){			
			for(Experiencia ex:per.getExperiencias()){
				PdfPCell columna1 = estiloCelda(1,1);
				PdfPCell columna2 = estiloCelda(1,1);
				//Fechas
				SimpleDateFormat formato = new SimpleDateFormat("yyyy");
				String anioInicio=formato.format(ex.getAnhoinicio());
				String anioFin=formato.format(ex.getAnhofin());
				if(ex.getEncurso().equalsIgnoreCase("1"))
					anioFin="Hasta la Actualidad";
				String rangoFecha=anioInicio+" - "+anioFin;
				if(anioInicio.equals(anioFin))
					rangoFecha=anioInicio;
				//Cargo
				String cargo=ex.oCargo.getDescripcion();
				if(ex.oCargo.getIdcargo()==0){
					cargo=ex.getOtros();
				}
				Paragraph anios = new Paragraph(rangoFecha,subtit);
				Paragraph pCargo = new Paragraph(parseMayuscula(cargo),subtit);
				Paragraph pais = new Paragraph(parseMayuscula(ex.getPais()),subtit);
				Paragraph empresa = new Paragraph(ex.getEmpresa(),subtit);
				Paragraph descripcion = new Paragraph(parseMayuscula(ex.getDescripcion()),subtit);
				
				columna1.addElement(anios);
				columna1.addElement(pCargo);
				columna2.addElement(empresa);
				columna2.addElement(pais);
				columna2.addElement(descripcion);					
				tablaExperiencia.addCell(columna1);
				tablaExperiencia.addCell(columna2);
			}										
		}else{
			PdfPCell cellSinResultados = estiloCelda(2,1);
			Paragraph textoSinResultados=new Paragraph("No Tiene Experiencias Registradas",subtit);
			cellSinResultados.addElement(textoSinResultados);			
			tablaExperiencia.addCell(new PdfPCell(cellSinResultados));
		}	
	}
	
	
	private void competenciaProfesional(PdfPTable tablaCompetencia){
		PdfPCell cellTituloCompetencia = cabeceraColumna("COMPETENCIAS PROFESIONALES");
		cellTituloCompetencia.setColspan(3);					
		tablaCompetencia.addCell(cellTituloCompetencia);
		
		tablaCompetencia.addCell(cabeceraColumna("COMPETENCIAS"));
		tablaCompetencia.addCell(cabeceraColumna("HABILIDADES"));	
		tablaCompetencia.addCell(cabeceraColumna("ATRIBUTOS"));
		
		if(per.getMatrices().size()>0){			
			for(Matriz matr:per.getMatrices()){				
				int contHabilidades=0;				
				for(Habilidad hab:listaHabilidad){if(hab.getMatriz().getIdmatriz().toString().equals(matr.getIdmatriz().toString())) contHabilidades++;}				
				PdfPCell colCompetencia = estiloCelda(1,contHabilidades);											
				Paragraph competencia = new Paragraph(matr.getCompetencia().getDescripcion(),subtit);
				colCompetencia.addElement(competencia);				
				tablaCompetencia.addCell(colCompetencia);
										
				for(Habilidad hab:listaHabilidad){					
					if(hab.getMatriz().getIdmatriz().toString().equals(matr.getIdmatriz().toString())){						
						PdfPCell colHabilidad = estiloCelda(1,1);
						PdfPCell colAtributo = estiloCelda(1,1);
						List lstAtributos = new List(List.UNORDERED);
						
						for(Atributos attr:listaAtributos){	
							
							if(attr.getHabilidad().getIdhabilidad().toString().equals(hab.getIdhabilidad().toString())){								
								lstAtributos.add(new ListItem(attr.getAtributo().getDescripcion(),subtit));
								colAtributo.addElement(lstAtributos);
								String t=" año";
								if(attr.getExperiencia()>1) t=" años";
								colAtributo.addElement(new Paragraph(parseMayuscula("Experiencia: "+attr.getExperiencia()+t),subtit));
							}							
						}						
						Paragraph habilidad = new Paragraph(hab.getHabilidades().getDescripcion(),subtit);
						colHabilidad.addElement(habilidad);			
						tablaCompetencia.addCell(colHabilidad);
						tablaCompetencia.addCell(colAtributo);						
					}					
				}																			
			}
			
		}else{
			PdfPCell cellSinResultados = estiloCelda(3,1);
			Paragraph textoSinResultados=new Paragraph("No Tiene Competencias Registradas",subtit);
			cellSinResultados.addElement(textoSinResultados);			
			tablaCompetencia.addCell(new PdfPCell(cellSinResultados));
		}			
		
	}
	
	private void certificacionProfesional(PdfPTable tablaCertificacion){
		PdfPCell cellTituloCertificacion = cabeceraColumna("CERTIFICACIONES PROFESIONALES");
		cellTituloCertificacion.setColspan(3);					
		tablaCertificacion.addCell(cellTituloCertificacion);
		
		tablaCertificacion.addCell(cabeceraColumna("CERTIFICACION"));
		tablaCertificacion.addCell(cabeceraColumna("FECHA DE INICIO"));	
		tablaCertificacion.addCell(cabeceraColumna("FECHA DE VENCIMIENTO"));
		for(Atributos attr:listaAtributos){
			if(attr.getCertificado().equals("S")){
				PdfPCell colCertificado = estiloCelda(1,1);
				PdfPCell colF_Inicio = estiloCelda(1,1);				
				PdfPCell colF_Fin = estiloCelda(1,1);
				colF_Inicio.setHorizontalAlignment(Element.ALIGN_CENTER);
				colF_Fin.setHorizontalAlignment(Element.ALIGN_CENTER);				
				colCertificado.addElement(new Paragraph(attr.getNom_certificacion(),subtit));
				colF_Inicio.addElement(new Paragraph(attr.getFecha_inicio().toString(),subtit));
				colF_Fin.addElement(new Paragraph(attr.getFecha_fin().toString(),subtit));
				tablaCertificacion.addCell(colCertificado);
				tablaCertificacion.addCell(colF_Inicio);
				tablaCertificacion.addCell(colF_Fin);
			}
		}
	}
	
	
	private PdfPCell celdaEspacio(){
		PdfPCell cellEspacio = new PdfPCell();
	    cellEspacio.setBorderColor(BaseColor.WHITE);
	    cellEspacio.setFixedHeight(15f);		    
	    return cellEspacio;
	}
	
	private PdfPCell estiloCelda(int colspan, int rowspan){
		PdfPCell cell = new PdfPCell();		    
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);	
		cell.setPaddingLeft(10f);
		cell.setPaddingRight(10f);
		cell.setPaddingBottom(10f);
		cell.setBorderColor(BaseColor.GRAY);
		cell.setColspan(colspan);
		cell.setRowspan(rowspan);		
		return cell;
	}
	
	private PdfPCell cellMaestra(PdfPTable tabla){
		PdfPCell cell=new PdfPCell(tabla);
		cell.setBorderColor(BaseColor.WHITE);			
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);						
		cell.setPaddingBottom(5f);
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
	
}
