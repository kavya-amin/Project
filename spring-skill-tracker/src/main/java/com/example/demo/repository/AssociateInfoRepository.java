package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.AssociateInfo;

public interface AssociateInfoRepository extends CrudRepository<AssociateInfo, Integer> 
{
	Optional<AssociateInfo> findByAssociateFirstName(String associateFirstName);
	List<AssociateInfo> findByAssociateEmail(String associateName);
	List<AssociateInfo> findByCountryAndLocation(String country,String location);
	
	AssociateInfo findUserByAssociateId(int associateId);
	//Optional<AssociateInfo> findByName(String name);
}