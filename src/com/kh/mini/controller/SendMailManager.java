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

import com.kh.mini.model.vo.Code;
import com.kh.mini.view.ResultPrinter;

public class SendMailManager {
	final String user = "during14days@gmail.com";
	final String password = "during1414";
	String key = "";
	public void gmailSend(String temail) {
		//메일을 보낼 사람의 메일 주소와, 메일 비밀번호 입력
		//바꾸지 않을 거라서 final. 접근 제한은 default로 함.
		//계정 새로 팠음.
		//메일에서 팝업 모두 설정, IMAP 사용 설정.
		//보안에서 알수 없는 앱 허용 개방

			//Property에 SMTP 서버 정보를 설정
			//Map계열 구현 클래스
			Properties prop = new Properties();
			//이메일 발송을 처리해줄 STMP서버
			prop.put("mail.smtp.host", "smtp.gmail.com");

			//SMTP서버와 통신하는 포트 gmail은 465
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
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(temail));
			message.setSubject("During14days 회원 가입 인증 메일");
			Code code = new Code();
			key = code.generate(); //join에서 인증번호 대조할 때, 가져다 쓸 것.
			message.setText("인증번호 : " + key);
			
			Transport.send(message);
			new ResultPrinter().emailSuccess();
			
			
		} catch(AddressException e) {
			e.printStackTrace();
		}
		catch (MessagingException e) {
			e.printStackTrace();
		}
	}
	public String getKey() {
		//join 메소드에서 키값 대조하려면 필요해서 getter 만듦.
		return key;
	}

	
	
	
}
