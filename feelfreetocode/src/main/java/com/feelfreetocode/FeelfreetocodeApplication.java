package com.feelfreetocode;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.feelfreetocode.models.Course;
import com.feelfreetocode.models.User;
import com.feelfreetocode.services.CourseService;
import com.feelfreetocode.services.UserService;

@SpringBootApplication
public class FeelfreetocodeApplication {

	public static void main(String[] args) {

		
		ApplicationContext context = SpringApplication.run(FeelfreetocodeApplication.class, args);
		
//		User - user id 
//		Courses - courseName , course price , duration , numberOflecturs,
	
		
		
		UserService userService = context.getBean("UserServiceImplStringName" ,UserService.class);
//		List<User> users = Arrays.asList(new User("Virendra", "virendra@gmail.com", "123456"),
//				new User("Virendra2", "virend2ra@gmail.com", "1233456"),
//				new User("Virendra3", "viren2dra@gmail.com", "1232456"),
//				new User("Virendra4", "viren2dra@gmail.com", "1243456"),
//				new User("Virendra5", "viren1dra@gmail.com", "1253456"));
//
//		User user = new User("Virendra", "virendra@gmail.com", "123456");
//
//		user = userService.saveUser(user);
//		System.err.println(user);
//	 System.out.println("-------------------");
//	 System.out.println(userIterable);
		
		
		userService.getAllUsers().forEach(System.out::println);
		
//		System.out.println("----------------------------");
//		System.out.println(userService.getUserById(1L));
//		try {
//			userService.deleteUser(1L);
//		} catch (Exception e) {
//			System.err.println("user Not Found...");
//		}
//		System.out.println(userService.getUserById(1L));
//		System.out.println("----------------------------");
		
		
//		String name, Integer price, Float duration, Integer numberOfLectures, User author
		
//		UserService userService = context.getBean(UserService.class);
//		CourseService courseService = context.getBean(CourseService.class);

//		User user = new User("Virendra2", "virendra@gmail.com", "123456");
//		user = userService.saveUser(user);
//		Course course = new Course("Java Spring Boot", 299, 13.5F, 58 , user);
//		course = courseService.saveCourse(course);
//		
		
//		System.out.println(course);
	}

}
