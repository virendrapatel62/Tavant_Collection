package com.feelfreetocode.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Course")
@Table(name = "courses")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long courseId;
	
	private String name; 
	private Integer price; // 100 , 199
	private Float duration;  // 12.5 hr
	private Integer NumberOfLectures ;
	
	@ToString.Exclude
	@ManyToOne
	@JoinColumn(name = "author")
	private User author;

	public Course(String name, Integer price, Float duration, Integer numberOfLectures, User author) {
		super();
		this.name = name;
		this.price = price;
		this.duration = duration;
		NumberOfLectures = numberOfLectures;
		this.author = author;
	}
	
	

}
