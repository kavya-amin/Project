package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.AssociateInfo;

public interface AssociateInfoRepository extends CrudRepository<AssociateInfo, String> 
{
	Optional<AssociateInfo> findByAssociateName(String associateName);
	List<AssociateInfo> findByAssociateEmail(String associateName);
	//Optional<AssociateInfo> findByName(String name);
}