package com.feelfreetocode.springboot.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.transaction.TransactionScoped;
import javax.validation.constraints.Size;

import org.hibernate.annotations.ManyToAny;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.sym.Name;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Component
@Entity(name =  "Employee")
@Table(name = "employees")
public class Employee implements Comparable<Employee> {
	
	
	@Id @Column(name = "employeeNumber")
	private Integer employeeId;
	
	@Column(length = 20 , name = "firstName") @Size(max = 20)
	private String firstName;
	
	@Column(length = 20) @Size(max = 20)
	private String lastName;
	
//	@Column(length = 10) @Size(max = 10)
//	@Transient
	private String extension;
	
	@Column(length = 40 , nullable = false) @Size(max = 40)
	private String email;
	
	
	@ManyToOne
	
	@JoinColumn(name = "officeCode")
	private Office officeCode;
	
	private Integer reportsTo;
	
	@Column(length = 20) @Size(max = 25)
	private String jobTitle;
	
	@Override
	public int compareTo(Employee o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
}
