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
		//������ ���� ����� ���� �ּҿ�, ���� ��й�ȣ �Է�
		//�ٲ��� ���� �Ŷ� final. ���� ������ default�� ��.
		//���� ���� ����.
		//���Ͽ��� �˾� ��� ����, IMAP ��� ����.
		//���ȿ��� �˼� ���� �� ��� ����

			//Property�� SMTP ���� ������ ����
			//Map�迭 ���� Ŭ����
			Properties prop = new Properties();
			//�̸��� �߼��� ó������ STMP����
			prop.put("mail.smtp.host", "smtp.gmail.com");

			//SMTP������ ����ϴ� ��Ʈ gmail�� 465
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
			
			//������ �����ּ�
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(temail));
			message.setSubject("During14days ȸ�� ���� ���� ����");
			Code code = new Code();
			key = code.generate(); //join���� ������ȣ ������ ��, ������ �� ��.
			message.setText("������ȣ : " + key);
			
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
		//join �޼ҵ忡�� Ű�� �����Ϸ��� �ʿ��ؼ� getter ����.
		return key;
	}

	
	
	
}
