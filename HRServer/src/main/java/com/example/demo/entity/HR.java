package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "hr")
public class HR 
{
	@Id
	@Column(name = "user_email")
	String userEmail;
	@Column(name = "user_password")
	String userPassword;
	@Column(name = "security_question")
	String securityQuestion;
	@Column(name = "security_answer")
	String securityAnswer;
	@Column(name = "bcrypt_pass")
	String bcryptPass;
	
}