package com.example.demo.service;

import java.io.Console;

import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.entity.HR;
import com.example.demo.repository.HRLoginRepository;

import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;

@Service
public class HRLoginService 
{
	@Autowired
	private HRLoginRepository repo;
	

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	private JavaMailSender javaMailSender;	
	@Autowired
	public HRLoginService(HRLoginRepository repo, BCryptPasswordEncoder bCryptPasswordEncoder,
			JavaMailSender javaMailSender) {
		super();
		this.repo = repo;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
		this.javaMailSender=javaMailSender;
	}
	
	
	public HR createHR(HR hr) {
		String bpass = bCryptPasswordEncoder.encode(hr.getUserPassword());
		hr.setBcryptPass(bpass);
		System.out.println(hr.getBcryptPass());
    	return repo.save(hr);
	}

public HR verifyUser(String email, String pass ) {
	
	HR hr = repo.findByUserEmail(email);
	if(hr!=null) {
		    if(hr.getUserEmail().equals(email) && hr.getUserPassword().equals(pass))
		    {
			return hr;
		    }
		  else
		  {
			return null;
		  }
		}
	else {
		return null;
		}
}
	

	public Iterable<HR> getAllHR() 
	{
		return repo.findAll();
	}

	public void updateHR(HR hr) {
	    String bpass = bCryptPasswordEncoder.encode(hr.getUserPassword());
		hr.setBcryptPass(bpass);
		System.out.println(hr.getBcryptPass());
    	repo.save(hr);
	}

	public HR getByName(String name) {
		// TODO Auto-generated method stub
		
		return repo.findByUserEmail(name);
	}

	
	
}
