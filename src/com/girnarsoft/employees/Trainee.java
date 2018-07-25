package com.girnarsoft.employees;

public class Trainee extends Employee {

	protected int superVisedBy;
	
	public int getSuperVisedBy() {
		return superVisedBy;
	}
	public void setSuperVisedBy(int superVisedBy) {
		this.superVisedBy = superVisedBy;
	}
	public Trainee(int id, String name, String password, String designation,int manager) {
		super(id, name, password, designation);
		this.superVisedBy = manager;
	}
	

	
	
	

}
