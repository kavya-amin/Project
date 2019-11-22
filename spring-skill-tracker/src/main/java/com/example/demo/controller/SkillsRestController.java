package com.example.demo.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.AssociateInfo;
import com.example.demo.entity.AssociateSkills;
import com.example.demo.entity.Message;
import com.example.demo.entity.SkillsInfo;
import com.example.demo.service.FileService;
import com.example.demo.service.MailService;
import com.example.demo.service.SkillsService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class SkillsRestController 
{
	@Autowired
	SkillsService service;
	
	@Autowired
	FileService fileservice;
	
	@Autowired
	private MailService notificationService;

	
	@Autowired
	RestTemplate restTemplate;
	 
	 @PostMapping("/profile/uploadpicture")
	 public ResponseEntity < String > handleFileUpload(@RequestParam("file") MultipartFile file) 
	 {
	  String message = "";
	  try {
	   System.out.println("File uploaded: "+file);
	   fileservice.store(file);
	   message = "You successfully uploaded " + file.getOriginalFilename() + "!";
	   System.out.println(message);
	   return ResponseEntity.status(HttpStatus.OK).body(message);
	  } catch (Exception e) {
	   message = "Fail to upload Profile Picture" + file.getOriginalFilename() + "!";
	   return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
	  }
	 }	
	 
	
	 
	@RequestMapping("/associate/{id}")
	public Optional<AssociateInfo> getAssociate(@PathVariable("id") int id) {
		System.out.println("url hit");
		return service.getAssociate(id);
	}
	
	@RequestMapping("/name/{name}")
	public Optional<AssociateInfo> getAssociateName(@PathVariable("name") String name) {
		System.out.println("url hit");
		return service.getAssociateName(name);
	}
	
	@RequestMapping("/country/{country}/and/location/{location}")
	public List<AssociateInfo> getByCountryAndLocation(@PathVariable("country") String country,
			@PathVariable("location") String location){
		return service.findByCountryAndLocation(country, location);
	}
	
	@GetMapping(path="/associate/all")
	public @ResponseBody Iterable<AssociateInfo> getAllAssociates() {
		System.out.println("url hit for all");
		return service.getAllAssociates();
	}
	
	@GetMapping(path="/associateSkills/{id}")
	public List<AssociateSkills> getAllAssociatesSkills(@PathVariable("id") String id) {
		System.out.println("url hit for all skills");
		return service.getAllAssociatesSkills(id);
	}
	
	@GetMapping(path="/associateSkills/all")
	public Iterable<AssociateSkills> getAssociatesSkills() {
		System.out.println("url hit for all associate skills");
		return service.getAssociatesSkills();
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/deleteAssociateSkillByAid/{id}")
	public Iterable<AssociateSkills> deleteAssociatesSkillsByAid(@PathVariable String id) {
		return service.deleteAssociatesSkillsByAid(id);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/updateAssociateSkills")
	public void updateAssociateSkills(@RequestBody AssociateSkills skills) 
	{
		System.out.println(skills);
		service.updateAssociateSkills(skills);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/updateAssociate")
	public void updateAssociate(@RequestBody AssociateInfo associate) 
	{
		System.out.println(associate);
		service.updateAssociate(associate);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/saveAssociate")
	public void saveAssociate(@RequestBody AssociateInfo associate) 
	{
		System.out.println(associate);
		 service.saveAssociate(associate);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/deleteAssociate/{id}")
	public void deleteAssociate(@PathVariable int id) {
		service.deleteAssociate(id);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/deleteAssociateSkill/{id}")
	public void deleteAssociateSkill(@PathVariable Integer id) {
		service.deleteAssociateSkill(id);
	}
	
	@GetMapping(path="/skills/all")
	public Iterable<SkillsInfo> getAllSkills()
	{
		return service.getAllSkills();
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/saveSkills")
	public void saveSkills(@RequestBody List<SkillsInfo> skillInfo) 
	{
		System.out.println("save skills");
		service.saveSkills(skillInfo);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/send-mail")
	public String send(@RequestBody Message msg) 
	{
		System.out.println("controller called");
		System.out.println(msg.getMessage());
		//user.setEmailAddress(hr.getUseremail());  //Receiver's email address
		try {
			notificationService.sendEmail(msg);
		} catch (MailException mailException) {
			System.out.println(mailException);
		}
		return "Congratulations! Your mail has been send to the user.";
	}

	
}
