package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

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
	 
	@RequestMapping(method = RequestMethod.POST, value = "/saveAssociateSkill/{associateId}/{skillId}")
	 public AssociateSkills saveAssociateSkills(@PathVariable(value="associateId") int associateId,
			 @PathVariable(value="skillId") int skillId,@Valid @RequestBody AssociateSkills skills) {
		
		AssociateInfo info=service.findByUserId(associateId);
		SkillsInfo info1=service.findUserById(skillId);
		skills.setAid(info);
		skills.setSid(info1);
		return service.saveAssociateSkills(skills);
		
	 }
	
	@RequestMapping("/associateId/{associateId}")
	public AssociateInfo findByUserId(@PathVariable("associateId") int id) {
		return service.findByUserId(id);	
	}
	
	@RequestMapping("/skillId/{skillId}")
	public SkillsInfo findUserById(@PathVariable("skillId") int id) {
		return service.findUserById(id);
	}
	
	/** 
	 @RequestMapping(method = RequestMethod.POST, value = "/saveAssociateSkill")
	 public AssociateSkills saveAssociateSkills(@RequestBody AssociateSkills skills) {
		 System.out.println(skills);
		 test.create(skills);
		 return skills;
	 }**/
	 
	@RequestMapping("/associate/{id}")
	public void getAssociate(@PathVariable("id") int id) {
		System.out.println("url hit");
		service.getAssociate(id);
	}
	
	@RequestMapping("/name/{associateFirstName}")
	public List<AssociateInfo> getAssociateName(@PathVariable("associateFirstName") String name) {
		System.out.println("url hit");
		return service.getAssociateName(name);
	}
	
	@GetMapping(path="/country/{country}/and/location/{location}")
	public List<AssociateInfo> getByCountryAndLocation(@PathVariable("country") String country,
			@PathVariable("location") String location){
		return service.findByCountryAndLocation(country, location);
	}
	
	@GetMapping(path="/associate/all")
	public  Iterable<AssociateInfo> getAllAssociates() {
		System.out.println("url hit for all");
		return service.getAllAssociates();
	}
	
	@GetMapping(path="/associateSkills/{id}")
	public AssociateSkills getAllAssociatesSkills(@PathVariable("id") int id) {
		System.out.println("url hit for all skills");
		return service.getAllAssociatesSkills(id);
	}
	
	@GetMapping(path="/associateSkills/all")
	public List<AssociateSkills> getAssociatesSkills() {
		System.out.println("url hit for all associate skills");
		return service.getAssociatesSkills();
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/deleteAssociateSkillByAid/{id}")
	public Iterable<AssociateSkills> deleteAssociatesSkillsByAid(@PathVariable int id) {
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
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/deleteAssociate/{AssociateEmail}")
	public void deleteAssociate(@PathVariable String AssociateEmail) {
		service.deleteAssociate(AssociateEmail);
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
	public void saveSkills(@RequestBody SkillsInfo skillInfo) 
	{
		System.out.println("save skills");
		service.saveSkills(skillInfo);
	}
	
	@RequestMapping("/skill/{id}")
	public void getSkillInfo(@PathVariable("id") int id) {
		System.out.println("url hit");
		 service.getSkillInfo(id);
	}
	
	@GetMapping(path = "/AssociateLastName/{associateLastName}")
	public List<AssociateInfo>  findByLastName(@PathVariable(value = "associateLastName")String LastName) {
		return service.findByLastName(LastName);
	}
	
	@GetMapping(path = "/AssociateFirstNameAndLastName/{associateFirstName}/{associateLastName}")
	public List<AssociateInfo> findByFirstNameAndLastName(@PathVariable(value = "associateFirstName")
	String fName,@PathVariable(value = "associateLastName") String lName){
		
		return service.findByFirstNameAndLastName(fName, lName);
		
	}
	
	@GetMapping(path = "/AssociateEmail/{associateEmail}")
	public AssociateInfo findByEmail(@PathVariable(value = "associateEmail") String email){
		return service.findByEmail(email);
	}
	
	@GetMapping(path = "/AssociateMobile/{associateMobile}")
	public List<AssociateInfo> findBymobile(@PathVariable(value = "associateMobile")long mobile){
		return service.findByMobile(mobile);
	}
	
	@GetMapping(path = "/Country/{country}")
	public List<AssociateInfo> findByCountry(@PathVariable(value = "country") String country){
		return service.findByCountry(country);
	}
	
	@GetMapping(path = "/Location/{location}")
	public List<AssociateInfo> findByLocation(@PathVariable(value = "location") String location){
		return service.findByLocation(location);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/login")
	AssociateInfo verifyAssociate(@RequestBody AssociateInfo associateInfo ) {
			return service.verifyAssociate(associateInfo.getAssociateEmail(),associateInfo.getPassword());
	}
	
/**	@RequestMapping(method = RequestMethod.POST, value = "/send-mail")
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
	} **/

	
}
