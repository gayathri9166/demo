package com.example.demo.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Dto.CustomerDto;
@Service
public interface CustomerService {

	CustomerDto createCustomer(CustomerDto customerDto);

	CustomerDto getCustomerById(Long id);

	CustomerDto updateCustomer(Long id, CustomerDto customerDto);

	boolean deleteCustomer(Long id);

	List<CustomerDto> getAllCustomers();
	
}
