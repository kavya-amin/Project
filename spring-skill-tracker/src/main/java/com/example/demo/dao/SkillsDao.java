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

	public List<AssociateSkills> getAllAssociatesSkills(int id) {
		return assoRepo.findByAidAssociateId(id);
	}

	public Iterable<SkillsInfo> getAllSkills() {
		return skillInfoRepo.findAll();
	}

	public Iterable<AssociateSkills> getAssociatesSkills() {
		
		return assoRepo.findAll();
	}
	
	@Transactional
	public void updateAssociate(AssociateInfo associate) {
		skillsRepo.save(associate);
		
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

	public void deleteAssociate(int id) {
		skillsRepo.deleteById(id);
		
	}

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

	public Optional<AssociateInfo> getAssociateName(String name) {
		// TODO Auto-generated method stub
		return skillsRepo.findByAssociateFirstName(name);
	}
	
	public List<AssociateInfo> findByCountryAndLocation(String country,String location){
		return skillsRepo.findByCountryAndLocation(country, location);
		}	
}
