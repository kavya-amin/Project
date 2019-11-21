package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.AssociateSkills;


public interface AssociateSkillsInt extends CrudRepository<AssociateSkills, Integer>
{

	void deleteByAidAssociateId(Integer id);
}