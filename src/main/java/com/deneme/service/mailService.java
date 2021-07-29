package com.deneme.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class mailService {
	
	@Autowired
	private JavaMailSender mail;
	
	public void send (String to ,String password)  {
		SimpleMailMessage message = new SimpleMailMessage(); 
		message.setTo(to);
		message.setFrom("fatikko777@gmail.com");
		message.setSubject("Yeni Sifre");
		
		String content = "Merhaba, bu yeni şifreniz: " + password;
        content += "\nNot: güvenlik sebebiyle, "
                + "hesabınıza girdikten sonra şifrenizi değiştirmenizi öneriyoruz.";
		message.setText(content);
		
		mail.send(message);
	}
}
