package com.example.demo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class HR {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int userId;
	@Column(name = "HR_name")
	private String HRName;
	@Column(name = "first_name")
	private  String fisrtName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "HR_email")
	private String HREmail;
	@Column(name = "HR_password")
	private String HRPassword;
	@Column(name = "HR_phone_number")
	private int HRPhoneNumber;
	private Date dob;
	@Column(name = "security_question")
	private String securityQuestion;
	@Column(name = "security_answer")
	private String securityAnswer;
	private String gender;
	@Column(name = "work_area")
	private String workArea;

}
