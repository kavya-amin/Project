package com.example.demo.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="associate_info")
public class AssociateInfo 
{	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "associate_id")
	private int associateId;
	@Column(name = "associate_first_name")
	private String associateFirstName;
	@Column(name = "associate_last_name")
	private String associateLastName;
	@Column(name = "associate_email")
	private String associateEmail;
	private String password;
	//@Column(name = "associate_image")
	//private String associateImage;
	@Column(name = "associate_mobile")
	private long associateMobile;
	private Date dob;
	private String gender;
	private String location;
	private String country;
	
	//@OneToMany(fetch = FetchType.LAZY,mappedBy = "aid", cascade = { CascadeType.PERSIST, CascadeType.MERGE,
		//	CascadeType.DETACH, CascadeType.REFRESH })
	//private List<AssociateSkills> associateSkills;
}