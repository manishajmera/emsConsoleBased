package com.girnarsoft.employees;

public class Manager extends Employee {
	int directorEmployeeId;
	public Manager(int id, String name, String password, String designation, int director) {
		super(id, name, password, designation);
		this.directorEmployeeId = director;
	}
	public int getdirectorEmployeeId() {
		return directorEmployeeId;
	}
	public void setDirectorEmployeeId(int director) {
		this.directorEmployeeId = director;
	}
	

	
	
	

}
