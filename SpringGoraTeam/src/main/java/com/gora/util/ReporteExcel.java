package com.gora.util;

import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.PrintSetup;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;




import com.gora.dominio.Atributos;
import com.gora.dominio.Habilidad;
import com.gora.dominio.Matriz;
import com.gora.dominio.Persona;

public class ReporteExcel {
	private List<Persona> listaPersonas;	
	private List<Habilidad> listaHabilidad;
	private List<Atributos> listaAtributos;
	private List<Matriz> listaMatriz;
	
	public ReporteExcel(List<Persona> p,List<Matriz> listam,List<Habilidad> lista,List<Atributos> lista2){
		this.listaPersonas=p;		
		this.listaHabilidad=lista;
		this.listaAtributos=lista2;
		this.listaMatriz=listam;
	}
	
	public ReporteExcel(){
		
	}
	
	public void generarExcel(HttpServletResponse response) throws IOException{
		
		String[] tit_DatosPersonales = { "ID", "APELLIDO PATERNO", "APELLIDO MATERNO", "NOMBRES", "EST. CIVIL", "F. NACIMIENTO", "TIPO", "DOCUMENTO","GENERO","NACIONALIDAD"};
		String[] tit_Competencias = { "ID", "COMPETENCIA"};
		String[] tit_Habilidades = { "ID", "COMPETENCIA", "HABILIDAD"};
		String[] tit_Atributos = { "ID", "COMPETENCIA", "COMPETENCIA", "ATRIBUTO", "EXPERIENCIA", "CERTIFICACION"};

		SimpleDateFormat fmt = new SimpleDateFormat("dd-MM-YYYY");
		Workbook libro = new HSSFWorkbook();
                
		Map<String, CellStyle> styles = crearEstilos(libro);		
		
		Sheet hoja = libro.createSheet("Datos Personales");                
        //hoja.setFitToPage(true);
        hoja.setHorizontallyCenter(true);
        PrintSetup printSetup = hoja.getPrintSetup();
        printSetup.setLandscape(true);
        
        hoja.setAutobreaks(true);
        //printSetup.setFitHeight((short)1);
        //printSetup.setFitWidth((short)1);
        
        Row headerRow = hoja.createRow(0);
        //headerRow.setHeightInPoints(12.75f);
        for (int i = 0; i < tit_DatosPersonales.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(tit_DatosPersonales[i]); 
            cell.setCellStyle(styles.get("header"));
        }
        hoja.setColumnWidth(0, 256*10);
        hoja.setColumnWidth(1, 256*25);
        hoja.setColumnWidth(2, 256*25); 
        hoja.setColumnWidth(3, 256*25);
        hoja.setColumnWidth(4, 256*15);  
        hoja.setColumnWidth(5, 256*15);
        hoja.setColumnWidth(6, 256*15);
        hoja.setColumnWidth(7, 256*15);
        hoja.setColumnWidth(8, 256*15);
        hoja.setColumnWidth(9, 256*40);
                
        
        for(int i=0;i<listaPersonas.size();i++){        	
        	Persona per=listaPersonas.get(i);
        	Row fila = hoja.createRow(i+1);
        	//fila.setHeightInPoints(12.75f);
            Cell cell_ID = fila.createCell(0);            
            Cell cell_ApePat = fila.createCell(1);
            Cell cell_ApeMat = fila.createCell(2);
            Cell cell_Nombres = fila.createCell(3);
            Cell cell_Est_Civil = fila.createCell(4);
            Cell cell_f_nac = fila.createCell(5);
            Cell cell_tipo_doc = fila.createCell(6);
            Cell cell_num_doc = fila.createCell(7);
            Cell cell_genero = fila.createCell(8);
            Cell cell_nacionalidad = fila.createCell(9);
            
            cell_ID.setCellStyle(styles.get("left"));
            cell_ApePat.setCellStyle(styles.get("left"));
            cell_ApeMat.setCellStyle(styles.get("left"));
            cell_Nombres.setCellStyle(styles.get("left"));
            cell_Est_Civil.setCellStyle(styles.get("left"));
            cell_f_nac.setCellStyle(styles.get("centrado"));
            cell_tipo_doc.setCellStyle(styles.get("centrado"));
            cell_num_doc.setCellStyle(styles.get("left"));
            cell_genero.setCellStyle(styles.get("left"));
            cell_nacionalidad.setCellStyle(styles.get("left"));
            
            String fecha="";
            String estadoC="";
            if(per.getFechanacimiento()!=null) fecha=fmt.format(per.getFechanacimiento());
            if(per.getEstadocivil()!=null){
	            if(per.getEstadocivil().equals("S"))
	            	estadoC="SOLTERO";
	            else if(per.getEstadocivil().equals("C"))
	            	estadoC="CASADO";
	            else if(per.getEstadocivil().equals("V"))
	            	estadoC="VIUDO";
	            else estadoC="DIVORCIADO";
            }
            String genero="";
            if(per.getSexo()!=null){
            	if(per.getSexo().equals("M")) genero="MASCULINO";
            	else genero="FEMENINO";
            }
            cell_ID.setCellValue(per.getIdpersona().toString());            
            cell_ApePat.setCellValue(per.getApepat());
            String ape="";
            if(per.getApemat()!=null) ape=per.getApemat();
            cell_ApeMat.setCellValue(ape);
            cell_Nombres.setCellValue(per.getNombres());            
            cell_Est_Civil.setCellValue(estadoC);            
            cell_f_nac.setCellValue(fecha);
            cell_tipo_doc.setCellValue(per.getTipodocidentidad());
            cell_num_doc.setCellValue(per.getNumerodocidentidad());
            cell_genero.setCellValue(genero);
            cell_nacionalidad.setCellValue(per.getNacionalidad());                       
        }
        
        /*
        //hoja.groupRow(4, 6);
        hoja.addMergedRegion(new CellRangeAddress(
                1, //first row (0-based)
                2, //last row  (0-based)
                0, //first column (0-based)
                0  //last column  (0-based)
        ));
        */
        
        
        
        
        
        
        Sheet hoja2 = libro.createSheet("Competencias");                
        //hoja.setFitToPage(true);
        hoja2.setHorizontallyCenter(true);
        PrintSetup printSetup2 = hoja2.getPrintSetup();
        printSetup2.setLandscape(true);
        
        hoja2.setAutobreaks(true);
        //printSetup.setFitHeight((short)1);
        //printSetup.setFitWidth((short)1);
        
        Row headerRow2 = hoja2.createRow(0);
        //headerRow.setHeightInPoints(12.75f);
        for (int i = 0; i < tit_Competencias.length; i++) {
            Cell cell = headerRow2.createCell(i);
            cell.setCellValue(tit_Competencias[i]); 
            cell.setCellStyle(styles.get("header"));
        }
        
        hoja2.setColumnWidth(0, 256*10);
        hoja2.setColumnWidth(1, 256*35);
      
        
        int cont=1;
        for(int i=0;i<listaMatriz.size();i++){   
        	Matriz m=listaMatriz.get(i);        	
        	if(m.getEstado().equals("A")){
        		Row fila = hoja2.createRow(cont);
            	//fila.setHeightInPoints(12.75f);
                Cell cell_ID = fila.createCell(0);                
                Cell cell_Comp = fila.createCell(1);
                
                cell_ID.setCellStyle(styles.get("left"));
                cell_Comp.setCellStyle(styles.get("left"));
                
                cell_ID.setCellValue(m.getPersona().getIdpersona().toString());            
                cell_Comp.setCellValue(m.getCompetencia().getDescripcion());
                cont++;
        	}
        }
        
        
        
        
        Sheet hoja3 = libro.createSheet("Habilidades");                
        //hoja.setFitToPage(true);
        hoja3.setHorizontallyCenter(true);
        PrintSetup printSetup3 = hoja3.getPrintSetup();
        printSetup3.setLandscape(true);
        
        hoja3.setAutobreaks(true);
        //printSetup.setFitHeight((short)1);
        //printSetup.setFitWidth((short)1);
        
        Row headerRow3 = hoja3.createRow(0);
        //headerRow.setHeightInPoints(12.75f);
        for (int i = 0; i < tit_Habilidades.length; i++) {
            Cell cell = headerRow3.createCell(i);
            cell.setCellValue(tit_Habilidades[i]);  
            cell.setCellStyle(styles.get("header"));
        }        
        
        hoja3.setColumnWidth(0, 256*10);
        hoja3.setColumnWidth(1, 256*35);
        hoja3.setColumnWidth(2, 256*35);
        
        
        
        for(int i=0;i<listaHabilidad.size();i++){   
        	Habilidad h=listaHabilidad.get(i);        	        	
        	Row fila = hoja3.createRow(i+1);
            //fila.setHeightInPoints(12.75f);
            Cell cell_ID = fila.createCell(0);            
            Cell cell_Comp = fila.createCell(1);     
            Cell cell_Hab = fila.createCell(2);
            
            cell_ID.setCellStyle(styles.get("left"));
            cell_Comp.setCellStyle(styles.get("left"));
            cell_Hab.setCellStyle(styles.get("left"));
            
            cell_ID.setCellValue(h.getMatriz().getPersona().getIdpersona().toString()); 
            cell_Comp.setCellValue(h.getMatriz().getCompetencia().getDescripcion());   
            cell_Hab.setCellValue(h.getHabilidades().getDescripcion());                    
        }
        
       
        
        Sheet hoja4 = libro.createSheet("Atributos");                
        //hoja.setFitToPage(true);
        hoja4.setHorizontallyCenter(true);
        PrintSetup printSetup4 = hoja4.getPrintSetup();
        printSetup4.setLandscape(true);
        
        hoja4.setAutobreaks(true);
        //printSetup.setFitHeight((short)1);
        //printSetup.setFitWidth((short)1);
        
        Row headerRow4 = hoja4.createRow(0);
        //headerRow.setHeightInPoints(12.75f);
        for (int i = 0; i < tit_Atributos.length; i++) {
            Cell cell = headerRow4.createCell(i);
            cell.setCellValue(tit_Atributos[i]);  
            cell.setCellStyle(styles.get("header"));
        }        
        
        hoja4.setColumnWidth(0, 256*10);
        hoja4.setColumnWidth(1, 256*35);
        hoja4.setColumnWidth(2, 256*35);
        hoja4.setColumnWidth(3, 256*35);
        hoja4.setColumnWidth(4, 256*15);
        hoja4.setColumnWidth(5, 256*100);
        
        System.out.println("antes del for");
        for(int i=0;i<listaAtributos.size();i++){   
        	Atributos a=listaAtributos.get(i);        	        	
        	Row fila = hoja4.createRow(i+1);
            //fila.setHeightInPoints(12.75f);
            Cell cell_ID = fila.createCell(0);            
            Cell cell_Comp = fila.createCell(1);
            Cell cell_Hab = fila.createCell(2);
            Cell cell_Atri = fila.createCell(3);    
            Cell cell_Anios = fila.createCell(4);    
            Cell cell_Certi = fila.createCell(5); 
            
            cell_ID.setCellStyle(styles.get("left"));
            cell_Comp.setCellStyle(styles.get("left"));
            cell_Hab.setCellStyle(styles.get("left"));
            cell_Atri.setCellStyle(styles.get("left"));
            cell_Anios.setCellStyle(styles.get("left"));
            cell_Certi.setCellStyle(styles.get("left"));
            
            String cad=" Años";
            if(a.getExperiencia()==1) cad=" Año";
            cell_ID.setCellValue(a.getHabilidad().getPersona().getIdpersona().toString());
            cell_Comp.setCellValue(a.getHabilidad().getMatriz().getCompetencia().getDescripcion());  
            cell_Hab.setCellValue(a.getHabilidad().getHabilidades().getDescripcion());  
            cell_Atri.setCellValue(a.getAtributo().getDescripcion());  
            cell_Anios.setCellValue(a.getExperiencia().toString()+cad);  
            cell_Certi.setCellValue(a.getNom_certificacion());  
        }
        
        System.out.println("despues del for");
        
        
        
        response.reset();			
		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-Disposition", "attachment; filename=reporte.xls");														
		
             
	     OutputStream out = response.getOutputStream();
	     try {
	        libro.write(out);
	     }       
	     catch (IOException ioe) { 
	       System.out.println("error");       
	     }
                      
        
	}
	
	
	
	private Map<String, CellStyle> crearEstilos(Workbook wb){
		Map<String, CellStyle> styles = new HashMap<String, CellStyle>();
		CellStyle style;
        Font headerFont = wb.createFont();
        headerFont.setBoldweight(Font.BOLDWEIGHT_BOLD);
        headerFont.setColor(IndexedColors.WHITE.getIndex());
        headerFont.setFontHeight(new Short("180"));
        
        
        Font fontContenido = wb.createFont();
        fontContenido.setFontHeight(new Short("180"));
        style = createBorderedStyle(wb);
        style.setAlignment(CellStyle.ALIGN_CENTER);
        style.setFillForegroundColor(IndexedColors.DARK_BLUE.getIndex());
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        style.setFont(headerFont);
        styles.put("header", style);
        
        style = createBorderedStyle(wb);
        style.setAlignment(CellStyle.ALIGN_CENTER);
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);  
        //style.setWrapText(true);
        style.setFont(fontContenido);
        styles.put("centrado", style);
        
        style = createBorderedStyle(wb);
        style.setAlignment(CellStyle.ALIGN_LEFT);
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);  
        //style.setWrapText(true);
        style.setFont(fontContenido);
        styles.put("left", style);
        
        return styles;
	}
	
	private static CellStyle createBorderedStyle(Workbook wb){
        CellStyle style = wb.createCellStyle();
        style.setBorderRight(CellStyle.BORDER_THIN);
        style.setRightBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderBottom(CellStyle.BORDER_THIN);
        style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderLeft(CellStyle.BORDER_THIN);
        style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderTop(CellStyle.BORDER_THIN);
        style.setTopBorderColor(IndexedColors.BLACK.getIndex());
        return style;
    }
}
