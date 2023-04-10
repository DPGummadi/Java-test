package com.hithron.userdata.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import com.hithron.userdata.exception.ResourceNotFoundException;
import com.hithron.userdata.helper.UserMockData;
import com.hithron.userdata.model.UserDetails;
import com.hithron.userdata.model.UserDetailsResponse;
import com.hithron.userdata.service.UserDetailsService;

@RunWith(SpringRunner.class)
public class UserControllerTest {
	
	@InjectMocks
	private UserController userController;
	
	@Mock
	private UserDetailsService service;
	
	@Test
	public void testGetAllUsers() throws ResourceNotFoundException {
		UserDetailsResponse userDetailsResponse = new UserDetailsResponse();
		UserDetails userDeatils = new UserDetails();
		userDeatils.setUserId(1L);
		userDetailsResponse.setUserDetails(Arrays.asList(userDeatils));
		Mockito.when(service.getAllUserById(null)).thenReturn(userDetailsResponse);
		UserDetailsResponse response = userController.getAllUsers();
		
		assertNotNull(response);
		assertEquals(userDetailsResponse.getUserDetails().size(), 1);
	}
	
	@Test
	public void testGetUserById() throws ResourceNotFoundException {
		UserDetailsResponse userDetailsResponse = new UserDetailsResponse();
		UserDetails userDeatils = new UserDetails();
		userDeatils.setUserId(1L);
		userDetailsResponse.setUserDetails(Arrays.asList(userDeatils));
		Mockito.when(service.getAllUserById(1L)).thenReturn(userDetailsResponse);
		UserDetailsResponse response = userController.getUserById(1L);
		
		assertNotNull(response);
		assertEquals(userDetailsResponse.getUserDetails().size(), 1);
	}
	
	@Test
	public void testCreateUser() throws ResourceNotFoundException {
		UserDetails userDeatils = new UserDetails();
		userDeatils.setUserId(1L);
		Mockito.when(service.saveUser(UserMockData.mockUserDetailsRequest())).thenReturn(userDeatils);
		UserDetails response = userController.createUser(UserMockData.mockUserDetailsRequest());
		
		assertNotNull(response.getUserId());
	}
	
	@Test
	public void testUpdateUserById() throws ResourceNotFoundException {
		UserDetailsResponse userDetailsResponse = new UserDetailsResponse();
		UserDetails userDeatils = new UserDetails();
		userDeatils.setUserId(1L);
		userDetailsResponse.setUserDetails(Arrays.asList(userDeatils));
		Mockito.when(service.updateUserById(1L, UserMockData.mockUserDetailsUpdateRequest())).thenReturn(userDetailsResponse);
		UserDetailsResponse response = userController.updateEmployee(1L, UserMockData.mockUserDetailsUpdateRequest());
		
		assertNotNull(response);
		assertEquals(userDetailsResponse.getUserDetails().size(), 1);
	}

	
	
}
