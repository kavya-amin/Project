package com.example.demo.repository;

import java.util.List;


import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.AssociateSkills;


public interface AssociateSkillsRepository extends CrudRepository<AssociateSkills, Integer>
{
	List<AssociateSkills> findByAidAssociateId(Integer associateId);
	Iterable<AssociateSkills> deleteByAidAssociateId(Integer id);
}
