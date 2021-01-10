package com.feelfreetocode.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name = "User")
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	
	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy =  GenerationType.AUTO )
	private Long userId ;
	
	@Column(name = "user_name")
	private String name ;
	
	@Column(name = "user_email")
	private String email ;
	
	@Column(name = "user_password")
	private String password;
	
	
	
	@OneToMany(mappedBy = "author" , fetch = FetchType.EAGER)
	private List<Course> courses;

	public User(String name, String email, String password) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
	}
	
	
	
}
