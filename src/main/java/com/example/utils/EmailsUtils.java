package com.example.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import jakarta.mail.internet.MimeMessage;

@Component
public class EmailsUtils {

	@Autowired
	private JavaMailSender mailSender;
	public boolean emailSender(String to, String subject, String body) {
		boolean isSent=false;
		
		
		try {
			
			MimeMessage mimeMessage=mailSender.createMimeMessage();
			MimeMessageHelper helper= new MimeMessageHelper(mimeMessage);
			helper.setSubject(subject);
			helper.setText(body, true);
			helper.setTo(to);
			mailSender.send(mimeMessage);
			isSent=true;
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		

		return isSent;
	}
}
