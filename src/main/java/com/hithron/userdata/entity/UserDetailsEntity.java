package com.hithron.userdata.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.hithron.userdata.model.UserDetailsRequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user_details")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDetailsEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;	
	private String firstName;
	private String lastName;
	private Integer age;
	private String gender;
	private LocalDate dateOfBirth;
	@OneToMany(fetch = FetchType.LAZY, orphanRemoval = true, mappedBy = "userDetailsEntity")
	private List<AddressDetailsEntity> addressDetails;
	
	public UserDetailsEntity(UserDetailsRequest request) {
		this.firstName = request.getFirstName();
		this.lastName = request.getLastName();
		this.age = request.getAge();
		this.gender = request.getGender();
		this.dateOfBirth = request.getDateOfBirth();
	}
	
	
}
