package com.feelfreetocode.authservice.payloads;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignUpRequest {

	@NotBlank
	@Size(min = 4, max = 40)
	private String firstName;

	@NotBlank
	@Size(min = 4, max = 40)
	private String lastName;

	@NotBlank
	private String dateOfBirth;

	@NotBlank
	private String hiringDate;

	@NotBlank
	private String province;

	@NotBlank
	private String postalCode;

	@NotBlank
	@Size(min = 3, max = 15)
	private String username;

	@NotBlank
	@Size(max = 40)
	@Email
	private String email;

	@NotBlank
	@Size(min = 6, max = 20)
	private String password;


}
