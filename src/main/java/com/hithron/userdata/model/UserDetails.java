package com.hithron.userdata.model;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.hithron.userdata.entity.UserDetailsEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDetails {

	private Long userId;
	private String firstName;
	private String lastName;
	private Integer age;
	private String gender;
	private LocalDate dateOfBirth;
	private List<AddressDetails> addressDetails;
	
	public UserDetails(UserDetailsEntity entity) {
		this.userId = entity.getId();
		this.firstName = entity.getFirstName();
		this.lastName = entity.getLastName();
		this.age = entity.getAge();
		this.gender = entity.getGender();
		this.dateOfBirth = entity.getDateOfBirth();
		this.addressDetails = entity.getAddressDetails().stream().map(a -> new AddressDetails(a)).collect(Collectors.toList());
	}
}
