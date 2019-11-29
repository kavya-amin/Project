package com.example.demo.repository;

import java.util.List;


import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.AssociateInfo;
import com.example.demo.entity.AssociateSkills;
import com.example.demo.entity.SkillsInfo;


public interface AssociateSkillsRepository extends CrudRepository<AssociateSkills, Integer>
{
	AssociateSkills findByAidAssociateId(Integer associateId);
	Iterable<AssociateSkills> deleteByAidAssociateId(Integer id);
	List<AssociateSkills> findAll();
	List<AssociateSkills> findByAidAssociateFirstNameOrAidAssociateLastNameOrAidAssociateEmailOrAidLocationOrAidCountryOrSidSkillNameOrSidSkillCategory(String res1,String res2,String res3,String res4,String res5,String res6,String res7);
	//
//	AssociateSkills findByAidAssociateLastName(String LastName);
//	AssociateSkills findByAidAssociateEmail(String AssociateEmail);
//	AssociateSkills findByAidAssociateMobile(String AssociateMobile);
//	AssociateSkills findByAidAssociateLocation(String Location);
}
