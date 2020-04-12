package com.kh.mini.controller;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
 
public class SendMailManager {
	
	public static void gamilSend() {
		final String user = "hjh9406@gmail.com";
		final String password = "wlsgml12#$";

		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", 465);
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.ssl.enable", "true");
		prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");

		Session session = Session.getDefaultInstance(prop, new Authenticator(){
			
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, password);
			}
		});
		
		MimeMessage message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress(user));
			//수신자 메일주소
			message.addRecipient(Message.RecipientType.TO, new InternetAddress("lsd0017@naver.com"));
			
			message.setSubject("인증번호를 테스트한다.");
			
			message.setText("인증번호: " + Math.random()*100);
			
			Transport.send(message);
			System.out.println("메세지 전송 성공");
		} catch(AddressException e) {
			e.printStackTrace();
		}
		catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		gamilSend();
	}
}
