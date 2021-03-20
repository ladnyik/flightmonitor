package com.flightmonitor.application.test;

import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class SendMailTest2 {

	private static String mailUsername = "ladnyik@gmail.com";
	private static String mailPassword = "tqpjppqrhfbjhatz";
	private static Session session;
	private static Properties prop = new Properties();

	public static void main(String[] args) throws AddressException, MessagingException {
		
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "587");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true"); // TLS
		session = Session.getInstance(prop, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(mailUsername, mailPassword);
			}
		});
		javax.mail.Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress("ladnyik@gmail.com"));
		message.setRecipients(javax.mail.Message.RecipientType.TO, InternetAddress.parse("ladnyik@gmail.com"));
		message.setSubject(String.format("csa"));
		
		Document doc = Jsoup.parse("<html></html>");
		Element h1 = doc.body().appendElement("h1");
		h1.text("csá");
		Element img = doc.body().appendElement("img");
		Double  R = 6378.1;
		Double  d = 50.0;
		Double fromLat = 47.67940, fromLon= 19.5035;
		Double toLat , toLon;
		Double brng = 135.0;
		
		Double lat1 = Math.toRadians(fromLat); 
	    Double lon1= Math.toRadians(fromLon);
	    
	    toLat = Math.asin( Math.sin(lat1)*Math.cos(d/R) +Math.cos(lat1)*Math.sin(d/R)*Math.cos(Math.toRadians(brng)));
	    toLon = lon1 + Math.atan2(Math.sin(Math.toRadians(brng))*Math.sin(d/R)*Math.cos(lat1),Math.cos(d/R)-Math.sin(lat1)*Math.sin(toLat));
	    
	    System.out.println(Math.toDegrees(toLat));
	    System.out.println(Math.toDegrees(toLon));
		
		img.attr("src", "https://www.mapquestapi.com/staticmap/v5/map?locations="
				+ fromLat +","+ fromLon + "&size=@2x&key=nE8z6qn6QaCTVfrAxkPKeCaHJY9Zofkq&zoom=8&banner=callsign meg ilyenek lesznek ideirva nezzük már|sm-top-A0021B-000000&shape="
				+ fromLat +","+ fromLon + 
				"|"+ Math.toDegrees(toLat) +","+ Math.toDegrees(toLon));
		img.attr("width", "400");
		img.attr("height", "400");
		message.setContent(doc.toString() ,"text/html; charset=utf-8");		
		Transport.send(message);
		System.out.println(img.attr("src"));
	}

}
