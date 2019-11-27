package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.AssociateInfo;


public interface AssociateInfoRepository extends CrudRepository<AssociateInfo, Integer> 
{
	List<AssociateInfo> findByAssociateFirstName(String associateFirstName);
	List<AssociateInfo> findByAssociateLastName(String associateLastName);
	List<AssociateInfo> findByAssociateFirstNameAndAssociateLastName(String associateFirstName, String associateLastName);
	AssociateInfo findByAssociateEmail(String associateName);
	List<AssociateInfo> findByAssociateMobile(Long associateMobile);
	List<AssociateInfo> findByCountryAndLocation(String country,String location);
	List<AssociateInfo> findByCountry(String country);
	List<AssociateInfo> findByLocation(String location);
	
	
	AssociateInfo findUserByAssociateId(int associateId);
	//Optional<AssociateInfo> findByName(String name);
}