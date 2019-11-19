package com.example.demo.repository;

import java.util.List;


import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Associate;
import com.example.demo.entity.Skill;


public interface AssociateRepository extends CrudRepository<Associate, String>
{
	List<Skill> findByAidAssociateId(String associateId);
	Iterable<Skill> deleteByAidAssociateId(String id);
}
