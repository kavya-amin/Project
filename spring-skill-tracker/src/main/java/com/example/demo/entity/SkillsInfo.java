package com.example.demo.entity;

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
	
	//@OneToMany(fetch = FetchType.LAZY,mappedBy = "sid", cascade = { CascadeType.PERSIST, CascadeType.MERGE,
		//	CascadeType.DETACH, CascadeType.REFRESH })
	//private List<AssociateSkills> associateSkills;
}
