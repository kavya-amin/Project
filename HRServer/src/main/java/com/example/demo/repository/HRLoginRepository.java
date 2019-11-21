package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.HR;

public interface HRLoginRepository extends CrudRepository<HR, String> {
		
	HR findByUserEmail(String name);
	
}
