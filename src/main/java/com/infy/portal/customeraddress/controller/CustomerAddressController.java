package com.infy.portal.customeraddress.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infy.portal.customeraddress.dto.CustomerAddressDTO;
import com.infy.portal.customeraddress.service.CustomerAddressService;

@RestController
@RequestMapping("customeraddress")
public class CustomerAddressController {
	
	@Autowired
	CustomerAddressService customerAddressService;
	
	@PostMapping("insert")
	public ResponseEntity<String> addCustomerAddress( @Valid @RequestBody CustomerAddressDTO customerAddresDTO){
		return customerAddressService.addCustomerAddress(customerAddresDTO);
	}
	
	
	//RestPointApi-4
	@PutMapping("update/{addId}")
	public ResponseEntity<String> updateCustomerAddress(@PathVariable("addId") int addId, @Valid @RequestBody CustomerAddressDTO customerAddresDTO){
		String address = customerAddresDTO.getAddress();
		String city = customerAddresDTO.getCity();
		int pincode = customerAddresDTO.getPincode();
		String state = customerAddresDTO.getState();
		return customerAddressService.updateCustomerAddress(addId, address, city, pincode, state);
	}
	

}
