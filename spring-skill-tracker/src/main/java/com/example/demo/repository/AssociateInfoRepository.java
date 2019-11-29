package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.AssociateInfo;


public interface AssociateInfoRepository extends CrudRepository<AssociateInfo, Integer> 
{
	public List<AssociateInfo> findByAssociateFirstName(String associateFirstName);
	public List<AssociateInfo> findByAssociateLastName(String associateLastName);
	public List<AssociateInfo> findByAssociateFirstNameAndAssociateLastName(String associateFirstName, String associateLastName);
	public AssociateInfo findByAssociateEmail(String associateEmail);
	public List<AssociateInfo> findByAssociateMobile(Long associateMobile);
	public List<AssociateInfo> findByCountryAndLocation(String country,String location);
	public List<AssociateInfo> findByCountry(String country);
	public List<AssociateInfo> findByLocation(String location);
	
	
	public AssociateInfo findUserByAssociateId(int associateId);
	//Optional<AssociateInfo> findByName(String name);
}