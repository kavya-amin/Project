package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.AssociateInfo;
import com.example.demo.entity.AssociateSkills;
import com.example.demo.entity.SkillsInfo;




public interface AssociateSkillsInt extends CrudRepository<AssociateSkills, Integer>
{
	public List<AssociateSkills> findByAid(AssociateInfo aid);
	
	public void deleteByAidAssociateId(AssociateSkills associateSkills);
	
	public void deleteBySid(SkillsInfo sid);
}