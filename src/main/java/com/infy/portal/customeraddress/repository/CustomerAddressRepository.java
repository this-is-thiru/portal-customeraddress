package com.infy.portal.customeraddress.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infy.portal.customeraddress.entity.CustomerAddress;

public interface CustomerAddressRepository extends JpaRepository<CustomerAddress,Integer> {

}
