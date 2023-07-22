package com.ssd.ecom2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssd.ecom2.model.Customer;
import com.ssd.ecom2.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	private  CustomerRepository customerRepository;
	
	public Customer createCustomer(Customer customer) {
		return customerRepository.save(customer);
	}
	
	public List<Customer> getAllCustomerDetails(){
		return customerRepository.findAll();
	}
	
	public Customer updateCustomer(Customer customer) {
        return customerRepository.save(customer);
   }
	
	public void deleteCustomerDetails(Long id) {
        customerRepository.deleteById(id);
    }

}
