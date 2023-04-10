package com.hithron.userdata.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hithron.userdata.exception.ResourceNotFoundException;
import com.hithron.userdata.model.UserDetails;
import com.hithron.userdata.model.UserDetailsRequest;
import com.hithron.userdata.model.UserDetailsResponse;
import com.hithron.userdata.model.UserDetailsUpdateRequest;
import com.hithron.userdata.service.UserDetailsService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class UserController {
	
	@Autowired
	private UserDetailsService userDetailsService;

	@GetMapping("/users")
	public UserDetailsResponse getAllUsers() throws ResourceNotFoundException{
		return userDetailsService.getAllUserById(null);
	}

	@GetMapping("/user/{id}")
	public UserDetailsResponse getUserById(@PathVariable(value = "id") Long userId)
			throws ResourceNotFoundException {
		return userDetailsService.getAllUserById(userId);
	}

	@PostMapping("/user")
	public UserDetails createUser(@Valid @RequestBody UserDetailsRequest request) {
		return userDetailsService.saveUser(request);
	}

	@PutMapping("/user/{id}")
	public UserDetailsResponse updateEmployee(@PathVariable(value = "id") Long userId,
			@RequestBody UserDetailsUpdateRequest request) throws ResourceNotFoundException {
		
		return userDetailsService.updateUserById(userId, request);
	}

}
