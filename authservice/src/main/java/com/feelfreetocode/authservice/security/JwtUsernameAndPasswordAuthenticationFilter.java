package com.feelfreetocode.authservice.security;

import java.io.IOException;
import java.util.Collections;
import java.util.Date;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.feelfreetocode.authservice.models.Register;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
public class JwtUsernameAndPasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
	private AuthenticationManager authenticationManager;

	private final JwtConfig jwtConfig;
	
	public static void main(String[] args) {
		
		Register  register = new Register();
		register.setFirstName("Viendra");
		register.setEmail("v#gailc.");
		String token = Jwts.builder().setSubject("XYZ")
		.claim("authorities", register)
		.signWith(SignatureAlgorithm.HS512, "secret").compact();
		
		System.out.println("JwtUsernameAndPasswordAuthenticationFilter.main()");
		System.out.println(token);
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		// TODO Auto-generated method stub

		try {
		
			UserCredentails credentails = new ObjectMapper().readValue(request.getInputStream(), UserCredentails.class);

			UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
					credentails.getUserName(), credentails.getPassword(), Collections.emptyList());

			return authenticationManager.authenticate(usernamePasswordAuthenticationToken);
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException();
		}

	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {

		Long now = System.currentTimeMillis();

		Jwts.builder().setSubject(authResult.getName())
				.claim("authorities", 
						authResult
						.getAuthorities()
						.stream()
						.map(GrantedAuthority::getAuthority)
						.collect(Collectors.toList()))
				.setIssuedAt(new Date(now))
				.setExpiration(new Date(now + jwtConfig.getExpiration()))
				.signWith(SignatureAlgorithm.HS512, jwtConfig.getSecret()).compact();

		super.successfulAuthentication(request, response, chain, authResult);
	}

	@Data
	@AllArgsConstructor
	private static class UserCredentails {
		private String userName;
		private String password;

		public String getUserName() {
			return userName;
		}

		private void getPaasword() {
			// TODO Auto-generated method stub

		}

		public void setPassword(String password) {
			this.password = password;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

	}
}
