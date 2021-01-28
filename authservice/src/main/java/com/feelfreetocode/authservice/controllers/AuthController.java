package com.feelfreetocode.authservice.controllers;


import java.util.Collections;
import java.util.HashSet;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.feelfreetocode.authservice.exceptions.AppException;
import com.feelfreetocode.authservice.models.Register;
import com.feelfreetocode.authservice.models.Role;
import com.feelfreetocode.authservice.models.RoleName;
import com.feelfreetocode.authservice.payloads.ApiResponse;
import com.feelfreetocode.authservice.payloads.SignUpRequest;
import com.feelfreetocode.authservice.repository.RegisterRepository;
import com.feelfreetocode.authservice.repository.RoleRepository;

@RestController
@RequestMapping("/api/auth/register")
public class AuthController {

	@Autowired
	RegisterRepository registerRepository;
	
	@Autowired
	Environment enviroment;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	BCryptPasswordEncoder  passwordEncoder;
	
	
	@GetMapping("")
	public  Object sayHello() {
//		return "Hello from Auth App " + enviroment.getProperty("server.port");
		return this.registerRepository.findAll();
	}
	

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest){
		if (registerRepository.existsByUsername(signUpRequest.getUsername())) {
			return new ResponseEntity(new ApiResponse(false, "Username is already taken!"), HttpStatus.BAD_REQUEST);
		}

		if (registerRepository.existsByEmail(signUpRequest.getEmail())) {
			return new ResponseEntity(new ApiResponse(false, "Email Address already in use!"), HttpStatus.BAD_REQUEST);
		}

		// Creating register's account
		Register register = new Register();
        register.setFirstName(signUpRequest.getFirstName());
        register.setLastName(signUpRequest.getLastName());
        register.setDateOfBirth(signUpRequest.getDateOfBirth());
        register.setHiringDate(signUpRequest.getHiringDate());
        register.setProvince(signUpRequest.getProvince());
        register.setPostalCode(signUpRequest.getPostalCode());
        register.setUsername(signUpRequest.getUsername());
        register.setEmail(signUpRequest.getEmail());
        
        register.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));

		Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
				.orElseThrow(() -> new AppException("User Role not set."));

        register.setRoles(Collections.singleton(userRole));

		registerRepository.save(register);

		return ResponseEntity.status(HttpStatus.OK)
                .body("user registered successfully");
	}
} 










































