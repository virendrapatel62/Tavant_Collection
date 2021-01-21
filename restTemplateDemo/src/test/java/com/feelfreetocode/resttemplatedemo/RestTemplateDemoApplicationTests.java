package com.feelfreetocode.resttemplatedemo;



import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.cbor.MappingJackson2CborHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.cbor.CBORFactory;
import com.feelfreetocode.resttemplatedemo.models.Employee;

@SpringBootTest
class RestTemplateDemoApplicationTests {
	
	
	@Test
	void contextLoads() {
		RestTemplate  restTemplate = new RestTemplate();
//		Employee employee =  restTemplate.getForObject("http://localhost:8085/api/employees/1", Employee.class);
//		Assertions.assertNotNull(employee);
		
		Employee employee =  restTemplate.postForObject("http://localhost:8086/api/employees", 
				new Employee(10000, "FirstName", "LastName" , "se", "email@code.in", "1", 1 , "SW") , Employee.class);
		
		
		Assertions.assertNotNull(employee);
		
		
		restTemplate.delete("http://localhost:8086/api/employees/{id}", employee.getEmployeeId());
	}	

}
