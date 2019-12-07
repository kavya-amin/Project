package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.SkillsInfo;

public interface SkillsInfoRepository extends CrudRepository<SkillsInfo, Integer> 
{
	public SkillsInfo findUserBySkillId(int skillId);
	public SkillsInfo findBySkillCategory(String skill);
}