package com.example.demo.repository;

import java.util.List;


import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.AssociateSkills;


public interface AssociateSkillsRepository extends CrudRepository<AssociateSkills, String>
{
	List<AssociateSkills> findByAidAssociateId(String associateId);
	Iterable<AssociateSkills> deleteByAidAssociateId(String id);
}
