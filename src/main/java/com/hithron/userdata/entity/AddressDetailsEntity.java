package com.hithron.userdata.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.hithron.userdata.model.AddressDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "address_details")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressDetailsEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String type;
	private String line1;
	private String line2;
	private String postcode;
	private String city;
	private String state;
	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private UserDetailsEntity userDetailsEntity;
	
	public AddressDetailsEntity(AddressDetails addressDetails, UserDetailsEntity userDetailsEntity) {
		this.type = addressDetails.getType();
		this.line1 = addressDetails.getLine1();
		this.line2 = addressDetails.getLine2();
		this.postcode = addressDetails.getPostcode();
		this.city = addressDetails.getCity();
		this.state = addressDetails.getState();
		this.userDetailsEntity = userDetailsEntity;
	}
}
