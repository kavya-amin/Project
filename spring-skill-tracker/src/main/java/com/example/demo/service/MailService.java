package com.example.demo.service;

import org.springframework.stereotype.Service;
import com.example.demo.entity.Message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@Service
public class MailService {
	
	private JavaMailSender javaMailSender;

	@Autowired
	public MailService(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}
	
	public void sendEmail(Message msg) throws MailException 
	{
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(msg.getMail());
		mail.setSubject("Welcome message");
		System.out.println(msg.getMessage());
		//mail.setText("Hi, Welcome to the Skill hunt Portal. You have to learn more skills to move higher in levels");
		mail.setText(msg.getMessage());
		javaMailSender.send(mail);
		System.out.println("mail sent");
	}
}