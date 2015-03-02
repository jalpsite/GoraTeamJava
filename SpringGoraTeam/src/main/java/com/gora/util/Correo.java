package com.gora.util;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class Correo {
	
	private String origen="gorasac20@gmail.com";	
	private String host="smtp.gmail.com";
	private String usuario="gorasac20@gmail.com";
	private String clave="gora123456";
	private String destino;
	private String contenido;
	private String asunto;
	
	public Correo(String destino,String contenido, String asunto){
		this.destino=destino;
		this.contenido=contenido;
		this.asunto=asunto;
	}
	
	public String enviarCorreo(){
		Properties propiedades = System.getProperties();
		propiedades.setProperty("mail.smtp.auth", "true");
		propiedades.setProperty("mail.smtp.starttls.enable", "true");
		propiedades.setProperty("mail.smtp.host", host);
		propiedades.setProperty("mail.smtp.port", "587");
		Session sesion = Session.getInstance(propiedades,
				  new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(usuario,clave);
					}
				  });
		String res="ok";
		try{		      
		      MimeMessage mensaje = new MimeMessage(sesion);		   
		      mensaje.setFrom(new InternetAddress(origen));		      
		      mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(destino));		      
		      mensaje.setSubject(asunto);		     
		      mensaje.setContent(contenido,"text/html" );		      
		      Transport.send(mensaje);
		      System.out.println("Mensaje enviado");
		    } catch (MessagingException e) {
		      e.printStackTrace();
		      return e.getMessage();
		    }
		return res;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}
	
	
}
