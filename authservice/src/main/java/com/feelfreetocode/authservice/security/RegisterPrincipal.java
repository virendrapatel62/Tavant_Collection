package com.feelfreetocode.authservice.security;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.feelfreetocode.authservice.models.Register;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterPrincipal implements UserDetails {

	private Long id;
	private String firstName;
	private String lastName;
	private String userName;

	@JsonIgnore
	private String email;
	@JsonIgnore
	private String password;

	Collection<? extends GrantedAuthority> authorities;

	public static RegisterPrincipal create(Register register) {
		
		List<GrantedAuthority> authorities = register.getRoles().stream()
				.map(role -> new SimpleGrantedAuthority(role.getName().name())).collect(Collectors.toList());
		
		return new RegisterPrincipal(register.getId(), register.getFirstName(), register.getLastName(),
				register.getUsername(), register.getEmail(), register.getPassword(), authorities);
	}
	
	
	

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.authorities;
	}

	@Override
	public String getPassword() {
		return null;
	}

	@Override
	public String getUsername() {
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		RegisterPrincipal that = (RegisterPrincipal) o;
		return Objects.equals(id, that.id);
	}

}
