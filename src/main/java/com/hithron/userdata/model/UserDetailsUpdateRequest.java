package com.hithron.userdata.model;

import java.time.LocalDate;

import lombok.Data;

@Data
public class UserDetailsUpdateRequest {
	
	private Long userId;
	private String firstName;
	private String lastName;
	private Integer age;
	private String gender;
	private LocalDate dateOfBirth;
}
