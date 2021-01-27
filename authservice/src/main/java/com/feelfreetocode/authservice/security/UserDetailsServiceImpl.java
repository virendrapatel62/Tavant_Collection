package com.feelfreetocode.authservice.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.feelfreetocode.authservice.models.Register;
import com.feelfreetocode.authservice.repository.RegisterRepository;

public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private RegisterRepository registerRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Register register = registerRepository.findByUsername(username).orElseThrow
				(()->new UsernameNotFoundException("User not found with username"+username)
				);
				
		return RegisterPrincipal.create(register);
	}

}
