package com.infy.portal.customeraddress.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.infy.portal.customeraddress.dto.CustomerAddressDTO;
import com.infy.portal.customeraddress.entity.CustomerAddress;
import com.infy.portal.customeraddress.repository.CustomerAddressRepository;

@Service
public class CustomerAddressService {
	
	@Autowired
	CustomerAddressRepository customerAddressRepository;
	//Adding Address
	public ResponseEntity<String> addCustomerAddress(CustomerAddressDTO customerAddressDTO){
		CustomerAddress customerAddress = new CustomerAddress();
		customerAddress.setAddressId(customerAddressDTO.getAddressId());
		customerAddress.setAddress(customerAddressDTO.getAddress());
		customerAddress.setCity(customerAddressDTO.getCity());
		customerAddress.setPincode(customerAddressDTO.getPincode());
		customerAddress.setState(customerAddressDTO.getState());
		
		customerAddressRepository.saveAndFlush(customerAddress);
		return new ResponseEntity<String>(customerAddress.toString(),HttpStatus.OK);
	}
	
	// Updating Address
	public ResponseEntity<String> updateCustomerAddress(int addId, String address, String city, int pincode, String state){
		Optional<CustomerAddress> optionalCustomerAddress=customerAddressRepository.findById(addId);
		if(optionalCustomerAddress.isPresent()) {
			CustomerAddress ca=optionalCustomerAddress.get();
			if(ca.getAddress().equals(address)==false) {
				ca.setAddress(address);
			}
			if(ca.getCity().equals(city)==false) {
				ca.setCity(city);
			}
			if(ca.getPincode()!=pincode) {
				ca.setPincode(pincode);
			}
			if(ca.getState().equals(state)==false) {
				ca.setState(state);
			}
			customerAddressRepository.saveAndFlush(ca);
			return new ResponseEntity<String>(ca.toString(),HttpStatus.OK);
		}
		else {
			CustomerAddress ca=new CustomerAddress();
			ca.setAddressId(addId);
			ca.setAddress(address);
			ca.setCity(city);
			ca.setPincode(pincode);
			ca.setState(state);
			
			customerAddressRepository.saveAndFlush(ca);
			return new ResponseEntity<String>(ca.toString(),HttpStatus.OK);
		}
	}

}
