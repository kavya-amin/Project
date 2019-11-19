package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Associate;
import com.example.demo.entity.Skill;
import com.example.demo.entity.SkillsInfo;

@Repository
public class SkillsDao 
{
	@Autowired
	SkillRepository skillsRepo;
	
	@Autowired
	AssociateRepository assoRepo;
	
	@Autowired
	SkillsInfoRepository skillInfoRepo;
	
	@Autowired
	AssociateSkillsInt assoSkillsRepo;
	
	public Optional<Associate> getAssociateInfo(String id)
	{
		System.out.println("In skills dao");
		return skillsRepo.findById(id);
	}

	public Iterable<Associate> getAllAssociates() 
	{
		System.out.println("dao hit for all");
		return skillsRepo.findAll();
	}

	public List<Skill> getAllAssociatesSkills(String id) {
		return assoRepo.findByAidAssociateId(id);
	}

	public Iterable<SkillsInfo> getAllSkills() {
		return skillInfoRepo.findAll();
	}

	public Iterable<Associate> getAssociatesSkills() {
		
		return assoRepo.findAll();
	}

	public void updateAssociate(Associate associate) {
		skillsRepo.save(associate);
		
	}

	public void updateAssociateSkills(Associate skills) 
	{
		assoRepo.save(skills);
	}

	public void deleteAssociate(String id) {
		skillsRepo.deleteById(id);
		
	}

	public void deleteAssociateSkill(Integer id) {
		assoSkillsRepo.deleteById(id);
		
	}

	@Transactional
	public Iterable<Skill> deleteAssociatesSkillsByAid(String id) {
		return assoRepo.deleteByAidAssociateId(id);
	}

	public void saveAssociate(Associate associate) {
		skillsRepo.save(associate);
		
	}

	public void saveSkills(List<SkillsInfo> skillInfo) {
		skillInfoRepo.saveAll(skillInfo);
	}

	public Optional<Associate> getAssociateName(String name) {
		// TODO Auto-generated method stub
		return skillsRepo.findByAssociateName(name);
	}

		
	
}