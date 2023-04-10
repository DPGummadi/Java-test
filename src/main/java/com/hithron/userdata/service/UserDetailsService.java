package com.hithron.userdata.service;

import com.hithron.userdata.exception.ResourceNotFoundException;
import com.hithron.userdata.model.UserDetails;
import com.hithron.userdata.model.UserDetailsRequest;
import com.hithron.userdata.model.UserDetailsResponse;
import com.hithron.userdata.model.UserDetailsUpdateRequest;

public interface UserDetailsService {
	UserDetails saveUser(UserDetailsRequest request);

	UserDetailsResponse getAllUserById(Long id) throws ResourceNotFoundException;
	
	UserDetailsResponse updateUserById(Long id, UserDetailsUpdateRequest request) throws ResourceNotFoundException;
}
