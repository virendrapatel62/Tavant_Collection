package com.feelfreetocode.restapi.models;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class AccountId implements Serializable {

	private String accountNumber;
	private String accountType;

}
