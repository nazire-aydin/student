package uk.co.nazire.model;

import java.util.concurrent.atomic.AtomicLong;

public class Student {
	
	private static final AtomicLong counter = new AtomicLong();
	
	private Long id;
	
	//@NotEmpty
	private String  name;
	private String surName;
	private int age;
	
	//@NotEmpty
	private String courses;
	
	public Student() {
	}
	
	public Student(String name,String surName,int age,String courses) {
		this.id = counter.incrementAndGet();
		this.name = name;
		this.surName = surName;
		this.age = age;
		this.courses = courses;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name= name;
	}
	
	public String getSurName() {
		return surName;
	}
	public void setSurName(String surName) {
		this.surName=surName;
		
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age=age;
	}
	
	public String getCourses() {
		return courses;
	}
	public void setCourses(String courses) {
		this.courses = courses;
	}
	
	
}
