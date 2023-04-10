package com.hithron.userdata.model;

import com.hithron.userdata.entity.AddressDetailsEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressDetails {

	private String type;
	private String line1;
	private String line2;
	private String postcode;
	private String city;
	private String state;
	
	public AddressDetails(AddressDetailsEntity entity) {
		this.type = entity.getType();
		this.line1 = entity.getLine1();
		this.line2 = entity.getLine2();
		this.postcode = entity.getPostcode();
		this.city = entity.getCity();
		this.state = entity.getState();
	}
}
