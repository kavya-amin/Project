package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Associate;

public interface SkillRepository extends CrudRepository<Associate, String> 
{
	Optional<Associate> findByAssociateName(String associateName);
	List<Associate> findByAssociateEmail(String associateName);
	//Optional<AssociateInfo> findByName(String name);
}