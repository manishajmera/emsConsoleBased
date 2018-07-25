package com.girnarsoft.employees;
public abstract class Employee {
	int id;
	String name,password,designation;
	
	public Employee(int id, String name, String password, String designation) {
		
		this.id = id;
		this.name = name;
		this.password = password;
		this.designation = designation;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}

	
	
	

}
