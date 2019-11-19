package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Associate;
import com.example.demo.entity.Skill;
import com.example.demo.entity.SkillsInfo;
import com.example.demo.repository.SkillsDao;

@Service
public class SkillsService 
{
	@Autowired
	SkillsDao sd;
	
	private JavaMailSender javaMailSender;

    public SkillsService(JavaMailSender javaMailSender) {
		super();
		this.javaMailSender = javaMailSender;
	}

	public Optional<Associate> getAssociate(String id)
	{
		return sd.getAssociateInfo(id);
	}

	public Iterable<Associate> getAllAssociates() {
		System.out.println("service for all");
		return sd.getAllAssociates();
	}

	public List<Skill> getAllAssociatesSkills(String id) {
		return sd.getAllAssociatesSkills(id);
	}

	public void updateAssociate(Associate associate) {
		sd.updateAssociate(associate);
		
	}

	public Iterable<SkillsInfo> getAllSkills()
	{
		return sd.getAllSkills();
	}
	
	public Iterable<Associate> getAssociatesSkills() {
		return sd.getAssociatesSkills();
	}

	public void updateAssociateSkills(Associate associateSkills) {
		sd.updateAssociateSkills(associateSkills);
		
	}

	public void deleteAssociate(String id) {
		sd.deleteAssociate(id);
		
	}

	public void deleteAssociateSkill(Integer id) {
		sd.deleteAssociateSkill(id);
		
	}

	

	public Iterable<Skill> deleteAssociatesSkillsByAid(String id) {
		return sd.deleteAssociatesSkillsByAid(id);
	}

	public void saveAssociate(Associate associate) {
		sd.saveAssociate(associate);
	}

	public void saveSkills(List<SkillsInfo> skillInfo) {
		sd.saveSkills(skillInfo);
		
	}

	public Optional<Associate> getAssociateName(String name) {
		// TODO Auto-generated method stub
		return sd.getAssociateName(name);
	}

	
	
}