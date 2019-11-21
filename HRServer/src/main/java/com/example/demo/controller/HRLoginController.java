package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.component.User;
import com.example.demo.entity.HR;
import com.example.demo.service.HRLoginService;
import com.example.demo.service.MailService;

@RestController
public class HRLoginController
{
	@Autowired
	HRLoginService service;
	
	
	@Autowired
	private MailService notificationService;

	

	@RequestMapping("/send-mail")
	public String send(@RequestBody HR hr) 
	{
		System.out.println("controller called");
		//user.setEmailAddress(hr.getUseremail());  //Receiver's email address
		try {
			notificationService.sendEmail(hr);
		} catch (MailException mailException) {
			System.out.println(mailException);
		}
		return "Congratulations! Mail has been send to the given mail id to reset password.";
	}
	
	
	@RequestMapping("/send-mail-user")
	public String sendToUser(@RequestBody User user)
	{
		try {
			notificationService.sendEmailTo(user.getEmailAddress());
		}catch (MailException mailException) {
			System.out.println(mailException);
		}
		return "Congratulations! Your mail has been send to the user.";
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/login")
	HR verifyUser(@RequestBody HR hr) {
			return service.verifyUser(hr.getUserEmail(),hr.getUserPassword());
	}
	
	@GetMapping(path="/hrDetails/all")
	public @ResponseBody Iterable<HR> getAllHR() {
		System.out.println("url hit for all");
		return service.getAllHR();
	}
	
		
	@RequestMapping(method = RequestMethod.PUT, value = "/updateHR")
	void updateHR(@RequestBody HR hr) 
	{
		System.out.println(hr);
		 
		service.updateHR(hr);
	}
}

