package com.hithron.userdata.helper;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.hithron.userdata.model.AddressDetails;
import com.hithron.userdata.model.UserDetailsRequest;
import com.hithron.userdata.model.UserDetailsUpdateRequest;

public class UserMockData {

	public static UserDetailsRequest mockUserDetailsRequest() {
		UserDetailsRequest request = new UserDetailsRequest();
		request.setFirstName("test1");
		request.setLastName("test2");
		request.setGender("M");
		request.setAge(20);
		request.setDateOfBirth(LocalDate.now());
		AddressDetails addressDetails = new AddressDetails();
		addressDetails.setType("Home");
		addressDetails.setCity("JPT");
		addressDetails.setLine1("test1");
		request.setAddressDetails(Arrays.asList(addressDetails));
		return request;
	}
	
	public static UserDetailsUpdateRequest mockUserDetailsUpdateRequest() {
		UserDetailsUpdateRequest request = new UserDetailsUpdateRequest();
		request.setFirstName("test3");
		request.setLastName("test4");
		request.setAge(20);
		request.setUserId(1L);
		return request;
	}
}
