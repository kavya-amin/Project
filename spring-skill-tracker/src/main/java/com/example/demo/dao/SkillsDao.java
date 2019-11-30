package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.AssociateInfo;
import com.example.demo.entity.AssociateSkills;
import com.example.demo.entity.SkillsInfo;
import com.example.demo.repository.AssociateInfoRepository;
import com.example.demo.repository.AssociateSkillsInt;
import com.example.demo.repository.AssociateSkillsRepository;
import com.example.demo.repository.SkillsInfoRepository;
import com.example.demo.service.MailService;

@Repository
@Transactional
public class SkillsDao 
{
	@Autowired
	private AssociateInfoRepository skillsRepo;
	
	@Autowired
	private AssociateSkillsRepository assoRepo;
	
	@Autowired
	private SkillsInfoRepository skillInfoRepo;
	
	@Autowired
	private AssociateSkillsInt assoSkillsRepo;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private MailService mailService;
	


	public void getAssociateInfo(int id)
	{
		System.out.println("In skills dao");
		 skillsRepo.findById(id);
	}
	
	public AssociateInfo findByUserId(int associateId) {
		return skillsRepo.findUserByAssociateId(associateId);
	}
	
	public SkillsInfo findUserById(int skillId) {
		return skillInfoRepo.findUserBySkillId(skillId);
	}
	
	public void getSkillsInfo(int id){
		System.out.println("In skills dao");
	 skillsRepo.findById(id);
	}
	
	public Iterable<AssociateInfo> getAllAssociates() 
	{
		System.out.println("dao hit for all");
		return skillsRepo.findAll();
	}

	public AssociateSkills getAllAssociatesSkills(int id) {
		return assoRepo.findByAidAssociateId(id);
	}

	public Iterable<SkillsInfo> getAllSkills() {
		return skillInfoRepo.findAll();
	}

	@Transactional
	public List<AssociateSkills> getAssociatesSkills() {
		
		return assoRepo.findAll();
	}
	
	@Transactional
	public void updateAssociate(AssociateInfo associateInfo) {
		String email = associateInfo.getAssociateEmail();
		AssociateInfo associate = skillsRepo.findByAssociateEmail(email);
		associateInfo.setAssociateId(associate.getAssociateId());
		skillsRepo.save(associateInfo);
		
	}
	
	@Transactional
	public void updateAssociateSkills(AssociateSkills skills) 
	{
		assoRepo.save(skills);
	}
	
	@Transactional
	public AssociateSkills saveAssociateSkills(AssociateSkills skills) {
		return assoRepo.save(skills);
	}
	
	@Transactional
	public void deleteAssociat(String email) {
		
		AssociateInfo associateInfo=skillsRepo.findByAssociateEmail(email);
		int id = associateInfo.getAssociateId();
		System.out.println("Associate id :"+id);
		AssociateSkills associateSkills=assoRepo.findByAidAssociateId(id);
		int id1 = associateSkills.getSrNo();
		assoRepo.deleteById(id1);		
		skillsRepo.deleteById(id);
	}
	
	@Transactional
	public void deleteAssociateSkill(Integer id) {
		assoSkillsRepo.deleteById(id);
		
	}

	@Transactional
	public Iterable<AssociateSkills> deleteAssociatesSkillsByAid(int id) {
		return assoRepo.deleteByAidAssociateId(id);
	}
	
	@Transactional
	public void saveAssociate(AssociateInfo associate) {
		mailService.sendEmail(associate.getAssociateEmail(),associate.getPassword());
		associate.setPassword(bCryptPasswordEncoder.encode(associate.getPassword()));
		skillsRepo.save(associate);	
	}

	public void saveSkills(SkillsInfo skillInfo) {
		skillInfoRepo.save(skillInfo);
	}

	public List<AssociateInfo> getAssociateName(String name) {
		// TODO Auto-generated method stub
		return skillsRepo.findByAssociateFirstName(name);
	}
	
	public List<AssociateInfo> getAssociateLastName(String name){
		return skillsRepo.findByAssociateLastName(name);
	}
	
	public List<AssociateInfo> getAssociateFisrtAndLastName(String FirstName, String LastName){
		return skillsRepo.findByAssociateFirstNameAndAssociateLastName(FirstName, LastName);
	}
	
	public AssociateInfo getAssociateEmail(String email){
		return skillsRepo.findByAssociateEmail(email);
	}
	
	public List<AssociateInfo> getAssociateMobile(long mobile){
		return skillsRepo.findByAssociateMobile(mobile);
	}
	
	public List<AssociateInfo> findByCountryAndLocation(String country,String location){
		return skillsRepo.findByCountryAndLocation(country, location);
		}	
	
	public List<AssociateInfo> findByCountry(String country){
		return skillsRepo.findByCountry(country);
	}
	
	public List<AssociateInfo> findByLocation(String location){
		return skillsRepo.findByLocation(location);
	}
	
	public AssociateInfo verifyAssociate(String email, String pass ) {
		
		AssociateInfo associateInfo = skillsRepo.findByAssociateEmail(email);
		if(associateInfo!=null) {
			    if(associateInfo.getAssociateEmail().equals(email) && associateInfo.getPassword().equals(bCryptPasswordEncoder.encode(pass)))
			    {
			    	System.out.print("success");
				return associateInfo;
			    }
			  else
			  {
				  System.out.print("wrong");
				return null;
			  }
			}
		else {
			System.out.print("Null");
			return null;
			}
	}
	
	public List<AssociateSkills> search(String res1,String res2,String res3,String res4,String res5,String res6,String res7) {
		return assoRepo.findByAidAssociateFirstNameStartingWithOrAidAssociateLastNameStartingWithOrAidAssociateEmailStartingWithOrAidLocationStartingWithOrAidCountryStartingWithOrSidSkillNameStartingWithOrSidSkillCategoryStartingWith(res1, res2, res3, res4, res5, res6, res7);
				//return assoRepo.findByAidAssociateFirstNameOrAidAssociateLastNameOrAidAssociateEmailOrAidLocationOrAidCountryOrSidSkillNameOrSidSkillCategory(res1, res2, res3, res4, res5, res6, res7);
	}

	
	
}
