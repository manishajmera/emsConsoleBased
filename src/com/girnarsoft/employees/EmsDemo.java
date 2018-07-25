package com.girnarsoft.employees;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EmsDemo {
	private static final Map<Integer, Employee> empList = init();
	private static final Scanner SC = new Scanner(System.in);
	private static int empIdNo = 3;
	private static Hr hr;
	private static Ceo ceo;

	public static void main(String[] args) {
		String choice;
		String password;
		Integer empId;
		for (int i = 1; i <= empList.size(); i++) {
			System.out.println(empList.get(i).getName() + " " + empList.get(i).getDesignation());
		}

		while (true) {
			
			System.out.println("Hello ! Please eneter your employee id: ");
			empId = Integer.parseInt(SC.nextLine());

			System.out.println("-----" + empId);
			System.out.println("Enter your Password: ");
			password = SC.nextLine();

			if (!verifyPassword(empId, password)) {
				System.out.println("Please enter correct credentials try again");
				continue;
			}

			choice = empList.get(empId).getDesignation();
			switch (choice) {
			case "CEO":
				actionMenu(empId);
				break;

			case "HR":
				actionMenu(empId);

				break;
			case "Manager":
				actionManager(empId);
				break;
			case "Director":
				actionDirector(empId);

				break;
			default:
				actionTrainee(empId);
				break;

			}

		}

	}

	private static void actionDirector(int empId) {

		System.out.println("Welcome Director");
		System.out.println("Managers Under Me");
		for (int i = 1; i <= empList.size(); i++) {
			Employee employee = empList.get(i);

			if (employee instanceof Manager) {
				Manager manager = (Manager) employee;

				if (manager.getdirectorEmployeeId() == empId) {
					System.out.println(manager.getId() + " " + manager.getName());
				}
			}
		}
	}

	private static void actionManager(int empId) {
		System.out.println("Welcome Manager");
		System.out.println("Trainee Under me");
		for (int i = 1; i <= empList.size(); i++) {
			Employee employee = empList.get(i);

			if (employee instanceof Trainee) {
				Trainee trainee = (Trainee) employee;

				if (trainee.getSuperVisedBy() == empId) {
					System.out.println(trainee.getId() + " " + trainee.getName());
				}
			}
		}
	}

	private static void actionTrainee(int empId) {
		System.out.println("Welcome Trainee");
		System.out.println("Trainee Supervised by");
		Employee employee = empList.get(empId);
		if (employee instanceof Trainee) {
			Trainee trainee = (Trainee) empList.get(empId);
			int mangerId = trainee.getSuperVisedBy();
			Manager manageTrainee = (Manager) empList.get(mangerId);
			System.out.println(manageTrainee.getName() + " " + manageTrainee.getId());
		}
	}

	private static boolean verifyPassword(int id, String enteredPassword) {

		if (empList.get(id) != null && empList.get(id).getPassword().equals(enteredPassword)) {
			return true;
		} else
			return false;

	}

	private static Map<Integer, Employee> init() {
		Map<Integer, Employee> empList = new HashMap<>();
		empList.put(1, new Ceo(1, "Kailash", "kher", "CEO"));
		empList.put(2, new Hr(2, "Sonu", "nigam", "HR"));

		return empList;
	}

	private static void actionMenu(int empId) {
		int flag = 0;
		int exitFromLoop = 0;
		int choose;
		if (empId == 1) {
			ceo = (Ceo) empList.get(empId);
			System.out.println("Welcome Ceo");
			flag = 1;

		} else {
			hr = (Hr) empList.get(empId);
			System.out.println("Welcome Ceo");

		}

		while (exitFromLoop != -1) {
			System.out.println("1. Add employee");
			System.out.println("2. Delete employee");
			System.out.println("3.Show Employees Details");
			System.out.println("4.Promote to Manager");
			if (flag == 1) {

				System.out.println("5.Promote to Director");
			}

			System.out.println("press any integer for logout");
			choose = Integer.parseInt(SC.nextLine());
			switch (choose) {
			case 1:
				System.out.println("Choose Designation");
				System.out.println("1.Add Trainee 2. Add Manager ");
				if (flag == 1)
					System.out.println("3.  Add Director");
				int designation = Integer.parseInt(SC.nextLine());

				if (designation == 1) {
					ceo.addEmployee(empList, empIdNo, "Trainee");
					System.out.println("Trainee added successfully ! with employee id" + empIdNo);
					empIdNo++;
				} else if (designation == 2) {

					ceo.addEmployee(empList, empIdNo, "Manager");

					System.out.println("Manager added successfully ! with employee id: " + empIdNo);

					empIdNo++;

				} else if (flag == 1 && designation == 3) {
					ceo.addEmployee(empList, empIdNo, "Director");
					System.out.println("Director added successfully ! with employee id: " + empIdNo);

					empIdNo++;

				} else {
					System.out.println("Wrong Input ");
				}
				break;
			case 2:
				System.out.println("Enter employee id you want to remove");
				int employeeRemoveId = Integer.parseInt(SC.nextLine());
				if (!empList.containsKey(employeeRemoveId)) {
					System.out.println("please type correct id");
				} else {
					ceo.deleteEmployee(empList, employeeRemoveId);
				}
				break;

			case 3:
				System.out.println("Employees________");
				for (int i = 1; i <= empList.size(); i++) {

					System.out.println(empList.get(i).getId() + " " + empList.get(i).getName() + " "
							+ empList.get(i).getDesignation());

				}
				System.out.println("_________");
				break;
			case 4:

				System.out.println("Enter employee id you want to promote to manager");
				int empId3 = Integer.parseInt(SC.nextLine());
				if ((!empList.containsKey(empId3)) || (empList.get(empId3).getDesignation().equals("Director")
						|| empList.get(empId3).getDesignation().equals("HR")
						|| empList.get(empId3).getDesignation().equals("CEO"))) {
					System.out.println(
							"please type correct id or this employee is already at higher position or at same position that u want to promote.");
				} else
					empList.get(empId3).setDesignation("Manager");
				break;
			case 5:
				if (flag == 1) {
					System.out.println("Enter employee id you want to promote to Director");

					int empId1 = Integer.parseInt(SC.nextLine());

					if (!empList.containsKey(empId1)
							|| (empList.get(empId1).getDesignation().equals("Director")
									|| empList.get(empId1).getDesignation().equals("HR"))
							|| empList.get(empId1).getDesignation().equals("CEO")) {
						System.out.println(
								"please type correct id or this employee is already at higher position or at same position that u want to promote.");
					} else
						empList.get(empId1).setDesignation("Director");
				} else {
					System.out.println("Log Out -----");
					exitFromLoop = -1;
				}

				break;
			default:
				System.out.println("Log Out -----");
				exitFromLoop = -1;
			}
		}
	}
	private static void validateInt()
	{
		
	}

}
