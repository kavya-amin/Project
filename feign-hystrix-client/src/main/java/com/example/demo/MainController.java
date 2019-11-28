package com.example.demo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
	
	@Autowired
	private IntegrationClient integrationClient;
	
	@SuppressWarnings("rawtypes")
	@GetMapping(value="/allAssociate")
	public Map<String,Iterable> allAssociates(){
		Map<String , Iterable> result = new HashMap<String,Iterable>();
		result.put("associates", integrationClient.getAllAssociates());
		return result;
	}

}
