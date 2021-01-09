package com.feelfreetocode.springboot;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.IntStream;

import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.feelfreetocode.springboot.dao.EmployeeDao;
import com.feelfreetocode.springboot.dao.EmployeeModelDao;
import com.feelfreetocode.springboot.dao.OfficeDao;
import com.feelfreetocode.springboot.models.Employee;
import com.feelfreetocode.springboot.models.EmployeeModel;
import com.feelfreetocode.springboot.models.Office;
import com.feelfreetocode.springboot.services.EmployeeServiceImpl;

@SpringBootApplication
public class SpringbootApplication {
	private static ApplicationContext context;

	public static void main(String[] args) throws BeansException, SQLException {

		context = SpringApplication.run(SpringbootApplication.class, args);
		EmployeeServiceImpl employeeService = context.getBean(EmployeeServiceImpl.class);
		EmployeeDao dao = context.getBean(EmployeeDao.class);

		OfficeDao dao2 = context.getBean(OfficeDao.class);
		Office office = new Office("of1", "Jabalpur", "123456789", "AVC", "A", "B", "C", "D", "E", null);
//		 	dao2.save(office);

		Employee employee = new Employee();
		employee.setEmail("Virendra@gmail.com");
		employee.setFirstName("Name ");
		employee.setLastName("ln");
		employee.setJobTitle("Software Eng.. traineee");
		employee.setExtension("A");
		employee.setOfficeCode(office);
//			employee.setReportsTo(); 
		employee.setEmployeeId(Math.abs((int) new Date().getTime()));
		try {
//				employee = context.getBean(EmployeeServiceImpl.class).addEmployee(employee);
//				System.out.println(employee.getOfficeCode().getEmployees());
		} catch (Exception ee) {
			// TODO: handle exception
			ee.printStackTrace();
		}
//		 	

//			getAll();

//			Order Details
//			Customer customer = new  Customer(1, "", "", "", "", "", "", "", "","" , "", 1, BigDecimal.valueOf(1.22) , null , null );
//			
//			customer = context.getBean(CustomerDao.class).save(customer);
//			
//			LocalDate date = LocalDate.now();
//			Order order = new Order(1 , date , date , date , "someting" , "--"  , customer , null );
//			order = context.getBean(OrderDao.class).save(order);

//			EmployeeDao dao3 = context.getBean(EmployeeDao.class);
//			Office office2 = new Office();
//			office2.setOfficeCode("1");
//			Page<Employee> pages =  dao3.findByOfficeCode(office2, PageRequest.of(0, 4, Sort.by("firstName")));
////			
//		 	System.out.println(pages.getNumber());
//		 	System.out.println(pages.getNumberOfElements());
//		 	System.out.println(pages.getTotalPages());
//		 	System.out.println(pages.getSize());

//			System.out.println(dao3.findAll());

		EmployeeModelDao employeeModelDao = context.getBean(EmployeeModelDao.class);

//			List<EmployeeModel> employees  =  employeeModelDao.saveAll(createEmployees());
//			System.out.println(employeeModels);

		Pageable pageable = PageRequest.of(0, 4, Sort.by("salary"));
		

		while (true) {
			Page<EmployeeModel> page = employeeModelDao.findByDepartment("Sales", pageable);
			int pageNumber = page.getNumber();
			System.out.println("Page Number : " + pageNumber);

			System.out.println("Total Elemnts " + page.getTotalElements());
			System.out.println("Pages : " + page.getTotalPages());
			List<EmployeeModel> employeeModels = page.getContent();
			employeeModels.forEach(System.out::println);
			
			if(!page.hasNext()){
				break;
			}
			
			pageable = page.nextPageable();
		}

	}

	private static List<EmployeeModel> createEmployees() {
		return Arrays.asList(new EmployeeModel("Diana", "Sales", 2000), new EmployeeModel("Mike", "Sales", 1000),
				new EmployeeModel("Rose", "IT", 4000), new EmployeeModel("Sara", "Sales", 3000),
				new EmployeeModel("Andy", "Sales", 3000), new EmployeeModel("Charlie", "Sales", 2500),
				new EmployeeModel("Jim", "Sales", 4500), new EmployeeModel("Sam", "Sales", 2500));
	}

	private static void insertRandomData(int count) {
		IntStream.range(1, count).forEach(e -> {
			Employee employee = new Employee();
			employee.setEmail("Virendra" + e + "@gmail.com");
			employee.setFirstName("Name " + e);
			employee.setLastName("ln" + e);
			employee.setJobTitle("Software Eng.. traineee");
			employee.setExtension("A" + e);
//			employee.setOfficeCode(""+e);
//			employee.setReportsTo(e); 
			employee.setEmployeeId(Math.abs((int) new Date().getTime()));
			try {
				employee = context.getBean(EmployeeServiceImpl.class).addEmployee(employee);
				System.out.println(employee);
			} catch (Exception ee) {
				// TODO: handle exception
				ee.printStackTrace();
			}
		});

	}

	private static void getAll() {
		context.getBean(EmployeeServiceImpl.class).getEmployees().get().forEach(e -> {
			System.out.println(e);
		});
	}

}
