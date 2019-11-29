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
}
