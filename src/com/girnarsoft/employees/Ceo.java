package com.girnarsoft.employees;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ceo extends Employee {
	private Scanner sc = new Scanner(System.in);

	public Ceo(int id, String name, String password, String designation) {
		super(id, name, password, designation);
		
	}
	public void addEmployee(Map employees,int empId,String empDesignation){
		String empName,empPassword;
			
		System.out.println("Enter employee name to inserted");
		empName = sc.nextLine();
		validateString(empName);
		System.out.println("Enter employee password");
		empPassword = sc.nextLine();
		
		if(empDesignation.equals("Trainee"))
		{
			int managerEmpployeeId;
			System.out.println("Enter the supervising Manager Id");
			managerEmpployeeId = Integer.parseInt(sc.nextLine());
	
			Trainee trainee = new Trainee(empId,empName,empPassword,"Trainee",managerEmpployeeId);
			employees.put(empId,trainee);
		
		}
		else if(empDesignation.equals("Manager"))
		{
			int directorEmployeeId;
			System.out.println("Enter the supervising director Id");
			directorEmployeeId = Integer.parseInt(sc.nextLine()); 
			/*while( !employees.containsKey(directorEmployeeId) )
			{
				
				System.out.println("Enter correct id");
				directorEmployeeId = Integer.parseInt(sc.nextLine());
			}*/
			
			Manager manager = new Manager(empId,empName,empPassword,"Manager",directorEmployeeId);
			employees.put(empId, manager);
			
		}
		else if(empDesignation.equals("Director"))
		{
			Director director = new Director(empId,empName,empPassword,"Director");
			employees.put(empId, director);
			
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
