package com.hithron.userdata.service;

import static org.junit.Assert.assertNotNull;

import java.util.Arrays;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import com.hithron.userdata.entity.AddressDetailsEntity;
import com.hithron.userdata.entity.UserDetailsEntity;
import com.hithron.userdata.exception.ResourceNotFoundException;
import com.hithron.userdata.helper.UserMockData;
import com.hithron.userdata.model.UserDetails;
import com.hithron.userdata.model.UserDetailsResponse;
import com.hithron.userdata.repository.AddressDetailsRepository;
import com.hithron.userdata.repository.UserDetailsRepository;
import com.hithron.userdata.service.impl.UserDetailsServiceImpl;

@RunWith(SpringRunner.class)
public class UserDetailsServiceImplTest {

	@InjectMocks
	UserDetailsServiceImpl userDetailsServiceImpl;
	
	@Mock
	UserDetailsRepository userDetailsRepository;
	
	@Mock
	AddressDetailsRepository addressDetailsRepository;
	
	@Test
	public void testSaveUser(){
		UserDetailsEntity entity = new UserDetailsEntity();
		entity.setId(1);
		Mockito.when(userDetailsRepository.save(Mockito.any())).thenReturn(entity);
		AddressDetailsEntity addressDetailsEntity = new AddressDetailsEntity();
		addressDetailsEntity.setId(1);
		Mockito.when(addressDetailsRepository.saveAll(Mockito.any())).thenReturn(Arrays.asList(addressDetailsEntity));
		UserDetails response = userDetailsServiceImpl.saveUser(UserMockData.mockUserDetailsRequest());
		
		assertNotNull(response.getUserId());
	}
	
	@Test
	public void testGetAllUserById() throws ResourceNotFoundException {
		Optional<UserDetailsEntity> entity = Optional.of(new UserDetailsEntity());
		entity.get().setId(1);
		AddressDetailsEntity addressDetailsEntity = new AddressDetailsEntity();
		addressDetailsEntity.setId(1);
		entity.get().setAddressDetails(Arrays.asList(addressDetailsEntity));
		Mockito.when(userDetailsRepository.findById(Mockito.any())).thenReturn(entity);
		UserDetailsResponse response = userDetailsServiceImpl.getAllUserById(1L);
		
		assertNotNull(response);
	}
	
	@Test
	public void testGetAllUsers() throws ResourceNotFoundException {
		Optional<UserDetailsEntity> entity = Optional.of(new UserDetailsEntity());
		entity.get().setId(1);
		AddressDetailsEntity addressDetailsEntity = new AddressDetailsEntity();
		addressDetailsEntity.setId(1);
		entity.get().setAddressDetails(Arrays.asList(addressDetailsEntity));
		Mockito.when(userDetailsRepository.findAll()).thenReturn(Arrays.asList(entity.get()));
		UserDetailsResponse response = userDetailsServiceImpl.getAllUserById(null);
		
		assertNotNull(response);
	}
}
