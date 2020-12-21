package com.tavant.collection;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.Scanner;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import com.tavant.collection.exceptions.InvalidNameException;
import com.tavant.collection.exceptions.InvalidSalaryException;
import com.tavant.collection.models.Employee;
import com.tavant.collection.service.EmployeeService;
import com.tavant.collection.service.EmployeeServiceImpl;


public class Main {
	private static EmployeeService employeeService = EmployeeServiceImpl.getInstance();
	private static Scanner scanner = new Scanner(System.in);
	private static boolean again = false;

	public static void main(String[] args) throws Exception {
//		customInput();
		randomInput(100);
		
		

		Optional<List<Employee>> emOptional = employeeService.getEmployees();
		if(emOptional.isPresent()) {
//			generating for all
			generateCSVForAll(emOptional.get());
			
			emOptional.get().forEach(t -> {
				try {
//					generating for single user
					generateCSVForSingleUser(t);
				} catch (Exception c) {
					c.printStackTrace();
				}
			});
			
			System.out.println("DOne...");
		}
	}
	
	public static void generateCSVForSingleUser(Employee employee) throws Exception {
		String filename = "reports/"+employee.getEmployeeId()+"-" 
	+ LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MMM-YYYY-hhmm"))+".csv";
		
		BufferedWriter writer = new BufferedWriter(new FileWriter(new File(filename)));
		CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT);
		
		csvPrinter.printRecord(employee.getEmployeeId(), employee.getEmployeeFirstName(),
				employee.getEmployeeLastName(), employee.getEmployeeMobileNumber(),
				employee.getEmployeeSalary());
		
		writer.close();
		csvPrinter.close();
		
		
	}

	public static void generateCSVForAll(List<Employee> employees) throws Exception {
		String filename = "reports/EMP-Report" + 
	LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-YYYY"))+".csv";
		BufferedWriter writer = new BufferedWriter(new FileWriter(new File(filename)));
		CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT);

		employees.forEach(employee -> {
			try {
				csvPrinter.printRecord(employee.getEmployeeId(), employee.getEmployeeFirstName(),
						employee.getEmployeeLastName(), employee.getEmployeeMobileNumber(),
						employee.getEmployeeSalary());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		writer.close();
		csvPrinter.close();
		System.out.println("CSV File Generated with file name : " + filename);
	}

	public static void add() throws InvalidSalaryException, InvalidNameException {
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
		
//		generating CSV
		try {
			generateCSVForAll(employeeService.getEmployees().get());
		} catch (Exception e) {
			e.printStackTrace();
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

	private static void randomInput(int count) throws Exception {

		for (int i = 0; i < count; i++) {
			String id = "AB" + new Random().nextInt(1000) + "" + new Random().nextInt(1000) + ""+ new Random().nextInt(1000);
			employeeService.addEmployee(new Employee(id, "Name", "lastname",
					"91444609" + new Random().nextInt(100), new Random().nextFloat() * 1000000));

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
				} catch (InvalidSalaryException e) {
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
