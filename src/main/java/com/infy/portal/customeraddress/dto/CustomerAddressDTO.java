package com.infy.portal.customeraddress.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

public class CustomerAddressDTO {
	int addressId;
	@Length(max=25,message="Address should be maximum of 25 characters")
	String address;
	@Pattern(regexp="^[A-Za-z ]+$",message="City should not contain any special characters except space")
	String city;
	@Min(value=100000,message="Pin should be 6 digit number")
	@Max(value=999999,message="Pin should be 6 digit number")
	int pincode;
	@Pattern(regexp="^[A-Za-z ]+$",message="State should not contain any special characters except space")
	String state;
	
	public CustomerAddressDTO(int addressId, String address, String city, int pincode, String state) {
		super();
		this.addressId = addressId;
		this.address = address;
		this.city = city;
		this.pincode = pincode;
		this.state = state;
	}

	@Override
	public String toString() {
		return "CustomerAddressDTO [addressId=" + addressId + ", address=" + address + ", city=" + city + ", pincode="
				+ pincode + ", state=" + state + "]";
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	

}
