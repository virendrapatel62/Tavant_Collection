package com.tavant.collection;

import java.io.Console;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.tavant.collection.exceptions.InvalidNameException;
import com.tavant.collection.exceptions.InvalidSalaryException;
import com.tavant.collection.models.Employee;
import com.tavant.collection.service.EmployeeService;
import com.tavant.collection.service.EmployeeServiceImpl;

public class Main {
	private static EmployeeService employeeService = new EmployeeServiceImpl();
	private static Scanner scanner = new Scanner(System.in);
	private static boolean again = false;

	public static void add() throws InvalidSalaryException , InvalidNameException{
		Employee employee = new Employee();

		System.out.println("Enter Employee ID");
		employee.setEmployeeId(scanner.next());

		System.out.println("Enter First Name");
		employee.setEmployeeFirstName(scanner.next());

		System.out.println("Enter Last Name Name");
		employee.setEmployeeLastName(scanner.next());

		System.out.println("Enter Mobil Number");
		employee.setEmployeeMobileNumber(scanner.next());

		System.out.println("Enter Salary");
		employee.setEmployeeSalary(Float.valueOf(scanner.nextFloat()));

		employeeService.addEmployee(employee);
	}

	public static void delete() {
		System.out.println("Enter EMployee ID");
		Employee employee2 = employeeService.deleteEmploye(scanner.next()).get();
		if (employee2 != null) {
			System.out.println("EMployee Deleted");
		} else {
			System.out.println("No Employee With Given ID");
		}

	}

	private static void printall() {

		System.out.println("All Employees");
		for (Employee employee3 : employeeService.getEmployees().get()) {
			System.out.println(employee3);
		}

	}

	private static void checkIsExists() {
		System.out.println("Enter EMployee ID");
		boolean isexists = employeeService.isExists(scanner.next());
		if (isexists) {
			System.out.println("Yes ");
		} else {
			System.out.println("No");
		}
	}


	public static void main(String[] args) throws Exception {
		
		

	    
	   
		customInput();
//		randomInput();

	}

	private static  void randomInput() throws Exception {
		
		for (int i = 0; i < 10; i++) {
			employeeService.addEmployee(new Employee(
						"AB"+new Random().nextInt(20)+"", 
						"Name" + i ,
						"lastname" + i ,
						"mobile" + i ,
						new Random().nextFloat()
						)
					);
					
		}
		
		for (Employee iterable: employeeService.getEmployees().get()) {
			System.out.println(iterable);
		}
	}

	public static void customInput() throws InvalidSalaryException {
		System.out.println("Hello ...");

		do {
			showOptions();
			int input = scanner.nextInt();
			switch (input) {

			case 1:
				try {
					add();
				} catch (InvalidNameException e) {
					System.err.println(e);
				}catch (InvalidSalaryException e) {
					System.err.println(e);
				}
				break;

			case 2:
				delete();
				break;

			case 3:
				checkIsExists();
				break;

			case 4:
				printall();
				break;

			default:
				System.out.println("Invalid Input");
				again = false;
				break;
			}

			System.out.println("Wanna Cont.. press 1 for yes or any key ");
			String key = scanner.next();

			if (key.equals("1")) {
				again = true;
			}

		} while (again);

		System.out.println("Bye Bye...");
	}

	public static void showOptions() {
		System.out.println("---------------");
		System.out.println("Choose Option :");
		System.out.println("1 : Add");
		System.out.println("2 : Delete");
		System.out.println("3 : Check Existance By Id");
		System.out.println("4 : Show All ");
		System.out.println("---------------");

	}
}
