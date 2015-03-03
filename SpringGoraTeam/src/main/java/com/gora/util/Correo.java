package com.gora.util;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class Correo {
		
	private String host="smtp.gmail.com";
	private String usuario="gorasac20@gmail.com";	
	private String clave="gora123456";
	private String destino;	
	private String asunto;
	
	public Correo(String destino, String asunto){
		this.destino=destino;		
		this.asunto=asunto;
	}
	
	public String enviarCorreo(String token,String nombres,String idUsuario){
		Properties propiedades = System.getProperties();
		propiedades.setProperty("mail.smtp.auth", "true");
		propiedades.setProperty("mail.smtp.starttls.enable", "true");
		propiedades.setProperty("mail.smtp.host", host);
		propiedades.setProperty("mail.smtp.port", "587");
					
		String cabecera = "<HTML><BODY>";
        String pie = "</BODY></HTML>";
        
        String url="http://localhost/goraAngular123/resetPassword.html?usuario="+idUsuario+"&token="+token;                
        
        String contenido="<center> <table align='center' border='0' cellpadding='0' cellspacing='0' id='ecxbodyTable' width='100%' style='border-collapse:collapse;padding:0;background-color:#F4F4F4;height:100%;width:100%;'> <tbody> <tr> <td align='center' id='ecxbodyCell' valign='top' style='border-collapse:collapse;padding-top:50px;padding-left:20px;padding-bottom:20px;padding-right:20px;border-top:0;height:100%;width:100%;'><table border='0' cellpadding='0' cellspacing='0' id='ecxtemplateContainer' width='600' style='border-collapse:collapse;border:1px solid #DADADA;background-color:#FFF;'> <tbody> <tr> <td id='ecxtemplateContainerInner' style='border-collapse:collapse;padding:0;'><table border='0' cellpadding='0' cellspacing='0' width='100%' style='border-collapse:collapse;'> <tbody><tr> <td align='center' valign='top' style='border-collapse:collapse;'><table border='0' cellpadding='0' cellspacing='0' class='ecxtemplateRow' width='100%' style='border-collapse:collapse;'> <tbody> <tr> <td class='ecxrowContainer ecxkmFloatLeft' valign='top' style='border-collapse:collapse;'><table border='0' cellpadding='0' cellspacing='0' class='ecxkmImageBlock' width='100%' style='border-collapse:collapse;'> <tbody class='ecxkmImageBlockOuter'> <tr> <td class='ecxkmImageBlockInner' style='border-collapse:collapse;padding:9px;padding-top:30px;' valign='top'> <table align='left' border='0' cellpadding='0' cellspacing='0' class='ecxkmImageContentContainer' width='100%' style='border-collapse:collapse;'> <tbody> <tr> <td class='ecxkmImageContent' valign='top' style='border-collapse:collapse;padding:0;padding-top:0px;padding-bottom:0;padding-left:9px;padding-right:9px;text-align:center;'><img src='http://www.gorasac.com/wp-content/uploads/2013/10/gora-logo1.png' alt='ClickBank' class='ecxkmImage' style='border:0;height:auto;line-height:100%;text-decoration:none;padding-bottom:0;display:inline;vertical-align:bottom;max-width:150px;' align='center'></td></tr></tbody> </table></td></tr></tbody> </table> <table border='0' cellpadding='0' cellspacing='0' width='100%' class='ecxkmDividerBlock' style='border-collapse:collapse;'> <tbody class='ecxkmDividerBlockOuter'> <tr> <td class='ecxkmDividerBlockInner' style='border-collapse:collapse;padding-top:10px;padding-bottom:10px;padding-left:30px;padding-right:30px;'><table class='ecxkmDividerContent' border='0' cellpadding='0' cellspacing='0' width='100%' style='border-collapse:collapse;border-top-width:1px;border-top-style:solid;border-top-color:#DADADA;'> <tbody> <tr> <td style='border-collapse:collapse;'><span></span></td></tr></tbody> </table></td></tr></tbody> </table> </td></tr></tbody> </table></td></tr><tr> <td align='center' valign='top' style='border-collapse:collapse;'><table border='0' cellpadding='0' cellspacing='0' class='ecxtemplateRow' width='100%' style='border-collapse:collapse;'> <tbody> <tr> <td class='ecxrowContainer ecxkmFloatLeft' valign='top' style='border-collapse:collapse;'><table border='0' cellpadding='0' cellspacing='0' class='ecxkmTextBlock' width='100%' style='border-collapse:collapse;'> <tbody class='ecxkmTextBlockOuter'> <tr> <td class='ecxkmTextBlockInner' valign='top' style='border-collapse:collapse;'><table align='left' border='0' cellpadding='0' cellspacing='0' class='ecxkmTextContentContainer' width='100%' style='border-collapse:collapse;'> <tbody> <tr> <td class='ecxkmTextContent' valign='top' style='border-collapse:collapse;color:#696969;font-family:Arial;font-size:16px;line-height:150%;text-align:left;padding-top:0px;padding-bottom:9px;padding-left:30px;padding-right:30px;'> <br><span style='line-height:1.6em;'>Estimado "+ nombres +",</span><br><br><span style='line-height:1.6em;'>Haz solicitado restablecer de tu clave por perdida u olvido. </span><br><span style='line-height:1.6em;'>El siguiente Link te permitira registrar una nueva clave</span><br><br></td></tr></tbody> </table></td></tr><tr><td> <table border='0' cellpadding='0' cellspacing='0' class='ecxkmImageBlock' width='100%' style='border-collapse:collapse;'> <tbody class='ecxkmImageBlockOuter'> <tr style='background-color:#6C6262;height:130px'> <td class='ecxkmImageContent' valign='top' style='border-collapse:collapse;padding:0;padding-top:0px;padding-bottom:0;padding-left:9px;padding-right:9px;text-align:center;'><a href='"+ url +"' style='word-wrap:break-word;color:#EEF5EC;font-weight:bold;text-decoration:none;line-height: 130px;font-size: 25px;' target='_blank'> Restablecer Acceso</a></td></tr></tbody> </table> </td></tr></tbody> </table></td></tr></tbody> </table></td></tr><tr> <td align='center' valign='top' style='border-collapse:collapse;'><table border='0' cellpadding='0' cellspacing='0' class='ecxtemplateRow' width='100%' style='border-collapse:collapse;'> <tbody> <tr> <td class='ecxrowContainer ecxkmFloatLeft' valign='top' style='border-collapse:collapse;'><table border='0' cellpadding='0' cellspacing='0' class='ecxkmTextBlock' width='100%' style='border-collapse:collapse;'> <tbody class='ecxkmTextBlockOuter'> <tr> <td class='ecxkmTextBlockInner' valign='top' style='border-collapse:collapse;'><table align='left' border='0' cellpadding='0' cellspacing='0' class='ecxkmTextContentContainer' width='100%' style='border-collapse:collapse;'> <tbody> <tr> <td class='ecxkmTextContent' valign='top' style='border-collapse:collapse;color:#696969;font-family:Arial;font-size:16px;line-height:150%;text-align:left;padding-top:9px;padding-bottom:9px;padding-left:30px;padding-right:30px;'> <br/><span style='line-height:1.6em;'>Si su navegador no puede abrir el link; copie y pegue en su navegador la siguiente URL:</span><br/> <span style='line-height:1.6em;'>"+ url +"</span><br></td></tr></tbody> </table></td></tr></tbody> </table></td></tr></tbody> </table></td></tr><tr> <td align='center' valign='top' style='border-collapse:collapse;'><table border='0' cellpadding='0' cellspacing='0' class='ecxtemplateRow' width='100%' style='border-collapse:collapse;'> <tbody> <tr> <td class='ecxrowContainer ecxkmFloatLeft' valign='top' style='border-collapse:collapse;'> <table border='0' cellpadding='0' cellspacing='0' width='100%' class='ecxkmDividerBlock' style='border-collapse:collapse;'> <tbody class='ecxkmDividerBlockOuter'> <tr> <td class='ecxkmDividerBlockInner' style='border-collapse:collapse;padding-top:30px;padding-bottom:20px;padding-left:30px;padding-right:30px;'><table class='ecxkmDividerContent' border='0' cellpadding='0' cellspacing='0' width='100%' style='border-collapse:collapse;border-top-width:1px;border-top-style:solid;border-top-color:#DADADA;'> <tbody> <tr> <td height='2' style='border-collapse:collapse;'><span></span></td></tr></tbody> </table></td></tr></tbody> </table> <table border='0' cellpadding='0' cellspacing='0' class='ecxkmTextBlock' width='100%' style='border-collapse:collapse;'> <tbody class='ecxkmTextBlockOuter'> <tr> <td class='ecxkmTextBlockInner' valign='top' style='border-collapse:collapse;'><table align='left' border='0' cellpadding='0' cellspacing='0' class='ecxkmTextContentContainer' width='100%' style='border-collapse:collapse;'> <tbody> <tr> <td class='ecxkmTextContent' valign='top' style='border-collapse:collapse;font-size:16px;line-height:150%;font-size:12px;font-weight:normal;color:#a9a9a9;padding-bottom:30px;text-align:center;padding-right:18px;padding-left:18px;padding-top:10px;line-height:150%;font-family:Arial;'><p style='padding-bottom:1em;text-align:center;'><span class='ecxappleLinks' style='font-size:12px;color:#a9a9a9;font-family:Helvetica, Arial;line-height:14.3000001907349px;text-align:center;'>GoraSAC Consulting,<br>Av. Antequera 470,<br>San Isidro Lima 27,<br>Peru</span></p><p style='padding-bottom:1em;text-align:center;font-size:12px;color:#a9a9a9;'>Recibiste este email automaticamente, por favor no responder.</p></tr></tbody> </table></td></tr></tbody> </table></td></tr></tbody> </table></td></tr></tbody></table></td></tr></tbody> </table> <br></td></tr></tbody> </table></center>";
        
        String hmtl = cabecera+ contenido+ pie;
        
		Session sesion = Session.getInstance(propiedades,
				  new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(usuario,clave);
					}
				  });
		String res="ok";
		try{		      
		      MimeMessage mensaje = new MimeMessage(sesion);		   
		      mensaje.setFrom(new InternetAddress(usuario));		      
		      mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(destino));		      
		      mensaje.setSubject(asunto);		     
		      mensaje.setContent(hmtl,"text/html" );		      
		      Transport.send(mensaje);
		      System.out.println("Mensaje enviado");
		    } catch (MessagingException e) {
		      e.printStackTrace();
		      return e.getMessage();
		    }
		
		return res;
	}
	
	
}
