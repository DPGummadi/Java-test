package com.hithron.userdata.model;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class UserDetailsRequest {

	@NotEmpty(message = "FirstName may not be empty")
	private String firstName;
	@NotEmpty(message = "LastName may not be empty")
	private String lastName;
	@NotNull(message = "Age may not be empty")
	private Integer age;
	@NotEmpty(message = "Gender may not be empty")
	private String gender;
	@NotNull(message = "DateOfBirth may not be empty")
	private LocalDate dateOfBirth;
	private List<AddressDetails> addressDetails;
}
