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

public class SendMailTest {

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
		BodyPart messageBodyPart = new MimeBodyPart();
		String text = "https://www.flightradar24.com/EJU48RD";
    //messageBodyPart.setContent(text, "text/html");
		//message..setContent(messageBodyPart,"text/html");
		message.setContent(text,"text/html");
		Transport.send(message);
	}

}
