package com.feelfreetocode.springboot.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity(name = "Account")
@Table(name="accounts")
@IdClass(AccountId.class)
public class Account {
	
	
	@Id
	private String accountNumber ; 
	@Id
	private String accountType;
	private String lastName;
	private String firstName;
	private Float balance;

}
