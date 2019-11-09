package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Associate {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "associate_id")
	private int associateId;
	@Column(name = "associate_first_name")
	private String associateFirstName;
	@Column(name = "associate_last_name")
	private String associateLastName;
	@Column(name = "associate_email")
	private String associateEmail;
	@Column(name = "associate_phone_number")
	private int associatePhoneNumber;
	@Column(name = "associate_password")
	private String associatePassword;
	@Column(name = "associate_DOB")
	private String associateDOB;
	@Column(name = "associate_work_city")
	private String associateWorkCity;
	@Column(name = "associate_country")
	private String associateCountry;
	@Column(name = "associate_available")
	private boolean associateAvailable;
	
}
