package com.girnarsoft.employees;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;




public class Hr extends Employee {
	Scanner sc = new Scanner(System.in);

	
	public Hr(int id, String name, String password, String designation) {
		super(id, name, password, designation);
		
	}
	public void addEmployee(Map employees,int empId,String empDesignation){
		String empName,empPassword;
		System.out.println("Enter employee name to inserted");
		empName = sc.nextLine();
		validateString(empName);
		System.out.println("Enter password of employee");
		
		empPassword = sc.nextLine();
		
		if(empDesignation.equals("Trainee"))
		{
			int mentor;
			System.out.println("Enter supervised Manager id");
			mentor = Integer.parseInt(sc.nextLine());
			
		
			
		
			

			Trainee trainee = new Trainee(empId,empName,empPassword,"Trainee",mentor);
			employees.put(empId,trainee);
			
		}
		if(empDesignation.equals("Manager"))
		{
			int director;
			System.out.println("Enter supervised director id");
			director = Integer.parseInt(sc.nextLine());
		
			
			
			Manager manager = new Manager(empId,empName,empPassword,"Manager",director);
			employees.put(empId, manager);
			
		}
		
	}
	public void deleteEmployee(Map employees,int empId)
	{
		employees.remove(empId);
		
	}
	public void validateString(String name)
	{
		String regex = "^[a-zA-Z]+$";
		if (name.matches(regex)) { 
		   return;
		}
		else
		{
			System.out.println("Wrong input ! try again");
			validateString(sc.nextLine());
		}
	}
}

