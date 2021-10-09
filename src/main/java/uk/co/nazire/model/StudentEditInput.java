package uk.co.nazire.model;

import javax.validation.constraints.NotEmpty;

public class StudentEditInput {
	
	@NotEmpty
	private String name;
	
	@NotEmpty
	private String surName;
	 
	public StudentEditInput () {
		super();
	}
	public  StudentEditInput (String name, String surName) {
		this.name = name;
		this.surName = surName;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	 
	public String getSurName() {
		return surName;
	}
	
	public void setSurName(String surName) {
		this.surName = surName;
	}
	

}
