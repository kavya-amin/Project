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
@Table(name = "skills_info")
public class SkillsInfo 
{	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "skill_id")
	private int skillId;
	@Column(name = "skill_name")
	private String skillName;
	@Column(name = "skill_category")
	private String skillCategory;
}
