package com.ssd.ecom2.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssd.ecom2.model.Customer;
import com.ssd.ecom2.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerRestController {
	
	@Autowired
	private  CustomerService customerService;
	
   @PostMapping("/create")
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer){
		Customer cuse= customerService.createCustomer(customer);
		return new ResponseEntity<Customer>(cuse,HttpStatus.CREATED);
		
	}
	@GetMapping("/customers")
	public ResponseEntity<List<Customer>>  getAllCustomerDetails(){
		List<Customer> cuses=customerService.getAllCustomerDetails();
		return new ResponseEntity<List<Customer>>(cuses,HttpStatus.OK);
	}

	@PutMapping("{id}") //@PatchMapping("{id}") .. patch place use chesana no probleam update avthndi
    public ResponseEntity<Customer> updateCustomer(@PathVariable("id") Long id,@RequestBody Customer customer) {
		customer.setId(id);
        Customer cuseUpdate = customerService.updateCustomer(customer);
        return new ResponseEntity<Customer>(cuseUpdate,HttpStatus.OK);
    }
	
	  @DeleteMapping("{id}")
      public ResponseEntity<String> deleteEntity(@PathVariable("id") Long id) {
		      customerService.deleteCustomerDetails(id);
       return ResponseEntity.noContent().build();
	  }
}
