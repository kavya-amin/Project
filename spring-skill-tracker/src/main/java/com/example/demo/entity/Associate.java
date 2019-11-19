package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Associate 
{
	@Id
	String associateId;
	String associateName, associateEmail, associateImage , associateMobile;

	
	
	public Associate() {
		super();
	}

	public Associate(String associateId, String associateName, String associateEmail, String associateImage,
			String associateMobile) {
		super();
		this.associateId = associateId;
		this.associateName = associateName;
		this.associateEmail = associateEmail;
		this.associateImage = associateImage;
		this.associateMobile = associateMobile;
	}

	public String getAssociateMobile() {
		return associateMobile;
	}

	public void setAssociateMobile(String associateMobile) {
		this.associateMobile = associateMobile;
	}

	public String getAssociateId() {
		return associateId;
	}

	public void setAssociateId(String associateId) {
		this.associateId = associateId;
	}

	public String getAssociateName() {
		return associateName;
	}

	public void setAssociateName(String associateName) {
		this.associateName = associateName;
	}

	public String getAssociateEmail() {
		return associateEmail;
	}

	public void setAssociateEmail(String associateEmail) {
		this.associateEmail = associateEmail;
	}

	public String getAssociateImage() {
		return associateImage;
	}

	public void setAssociateImage(String associateImage) {
		this.associateImage = associateImage;
	}
	
	
}