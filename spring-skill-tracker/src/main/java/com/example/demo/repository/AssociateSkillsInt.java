package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Associate;

public interface AssociateSkillsInt extends CrudRepository<Associate, Integer>
{

	void deleteByAidAssociateId(Integer id);

	//Iterable<AssociateSkills> findAllById(Integer id);

}