package com.feelfreetocode.authservice.config;


import javax.management.relation.Role;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.feelfreetocode.authservice.security.JwtConfig;
import com.feelfreetocode.authservice.security.JwtUsernameAndPasswordAuthenticationFilter;


@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	@Qualifier("UserDetailsServiceImpl")
	private UserDetailsService  userDetailService;
	
	@Autowired
	private JwtConfig jwtConfig;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public JwtConfig jwtConfig() {
		
		return new JwtConfig();
	}

	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		System.err.println("SecurityConfig.configure()");
		
		http.csrf().disable()
		.sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and()
		.exceptionHandling()
		.authenticationEntryPoint((req , res , e)-> res.sendError(HttpServletResponse.SC_UNAUTHORIZED))
		.and()
		.addFilter(new JwtUsernameAndPasswordAuthenticationFilter(authenticationManager(), jwtConfig))
		.authorizeRequests()
//		.antMatchers("--").permitAll();
		.antMatchers(HttpMethod.POST , jwtConfig.getUri()).permitAll()
		.antMatchers(HttpMethod.POST , "/api/auth/**" ).permitAll()
		.antMatchers(HttpMethod.GET , "/" ).permitAll()
		.anyRequest().authenticated();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailService).passwordEncoder(passwordEncoder());
	}
	
}
