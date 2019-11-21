package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.HR;

public interface HRLoginRepository extends CrudRepository<HR, Integer> {
		
	HR findByUserEmail(String name);
	
}
