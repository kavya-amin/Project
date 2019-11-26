package com.example.demo.entity;

import java.util.Date;
import java.util.Optional;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
@Table(name = "skill")
public class AssociateSkills 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sr_no")
	private Integer srNo;	
	private String certification;
	private String rating;
	@Column(name = "start_date")
	private String startDate;
	@Column(name = "end_date")
	private String endDate;
	private String duration;
	private String experience;
	
	@ManyToOne
	
	@JoinColumn(name = "associate_id",nullable = false)
	public AssociateInfo aid;
	
	
	@ManyToOne
	@JoinColumn(name = "skill_id",nullable = false)
	private SkillsInfo sid;
	
}