package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="associate_info")
public class AssociateInfo 
{	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "associate_id")
	String associateId;
	@Column(name = "associate_name")
	String associateName;
	@Column(name = "associate_email")
	String associateEmail;
	@Column(name = "associate_image")
	String associateImage;
	@Column(name = "associate_mobile")
	String associateMobile;

}