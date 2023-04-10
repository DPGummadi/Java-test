package com.hithron.userdata.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.hithron.userdata.entity.AddressDetailsEntity;
import com.hithron.userdata.entity.UserDetailsEntity;
import com.hithron.userdata.exception.ResourceNotFoundException;
import com.hithron.userdata.model.UserDetails;
import com.hithron.userdata.model.UserDetailsRequest;
import com.hithron.userdata.model.UserDetailsResponse;
import com.hithron.userdata.model.UserDetailsUpdateRequest;
import com.hithron.userdata.repository.AddressDetailsRepository;
import com.hithron.userdata.repository.UserDetailsRepository;
import com.hithron.userdata.service.UserDetailsService;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	UserDetailsRepository userDetailsRepository;
	
	@Autowired
	AddressDetailsRepository addressDetailsRepository;

	@Override
	public UserDetails saveUser(UserDetailsRequest request) {
		UserDetails response = new UserDetails();
		UserDetailsEntity entity = new UserDetailsEntity(request);
		userDetailsRepository.save(entity);
		if(!CollectionUtils.isEmpty(request.getAddressDetails())) {
			List<AddressDetailsEntity> addressEntityList = request.getAddressDetails().stream().map(a -> new AddressDetailsEntity(a, entity)).collect(Collectors.toList());
			addressDetailsRepository.saveAll(addressEntityList);
		}
		response.setUserId(entity.getId());
		return response;
	}

	@Override
	public UserDetailsResponse getAllUserById(Long id) throws ResourceNotFoundException {
		List<UserDetails> userDetailsList = new ArrayList<UserDetails>();
		if(null != id) {
		UserDetailsEntity userDetailsEntity = userDetailsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + id));
			if(null != userDetailsEntity) {
				UserDetails userDetails = new UserDetails(userDetailsEntity);
				userDetailsList.add(userDetails);
			}
		} else {
			List<UserDetailsEntity> userDetailsEntityList = userDetailsRepository.findAll();
			if(!CollectionUtils.isEmpty(userDetailsEntityList)) {
				userDetailsList = userDetailsEntityList.stream().map(u -> new UserDetails(u)).collect(Collectors.toList());
			}
		}
		UserDetailsResponse response = new UserDetailsResponse();
		response.setUserDetails(userDetailsList);
		return response;
	}

	@Override
	public UserDetailsResponse updateUserById(Long id, UserDetailsUpdateRequest request) throws ResourceNotFoundException {
		List<UserDetails> userDetailsList = new ArrayList<UserDetails>();
		if(null != id) {
			UserDetailsEntity userDetailsEntity = userDetailsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + id));
				if(null != userDetailsEntity) {
					userDetailsEntity.setAge(request.getAge());
					userDetailsEntity.setFirstName(request.getFirstName());
					userDetailsEntity.setLastName(request.getLastName());
					userDetailsEntity.setGender(request.getGender());
					userDetailsRepository.save(userDetailsEntity);
					UserDetails userDetails = new UserDetails(userDetailsEntity);
					userDetailsList.add(userDetails);
				}
		}
		UserDetailsResponse response = new UserDetailsResponse();
		response.setUserDetails(userDetailsList);
		return response;
	}

}
