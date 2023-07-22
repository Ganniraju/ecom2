package com.ssd.ecom2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ssd.ecom2.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
