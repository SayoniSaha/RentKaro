package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.entity.Customer;
import com.example.demo.entity.Login;
import com.example.demo.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CustomerController {
	
	@Autowired CustomerService customerService;
	
	@PostMapping("/register")
	public List<String> createCustomer(@RequestBody Customer customer){
		List<String> id = new ArrayList<>();
		String status = customerService.createCustomer(customer);
		
		if(status == null) {
			id.add("userexist");
		}
		id.add(status);
		return id;
	}
	
	@GetMapping("/findcustomer/{customerEmail}")
	public List<Customer> findByCustomerEmail(@RequestBody @PathVariable String customerEmail){
		return customerService.findByCustomerEmail(customerEmail);
		
	}

	@GetMapping("/findcustomerid/{customerId}")
	public List<Customer> findByCustomerId(@RequestBody @PathVariable String customerId){
		
		return customerService.findByCustomerId(customerId);
		
	}
	
	@PostMapping("/login")
	public String loginCustomer(@RequestBody Login request ){
		String email = request.getEmail();
		System.out.println(email);
		String password = request.getPassword();
		
		List<Customer> customerlist = customerService.checkUser(email, password);
		if(customerlist!=null) {
			return email;
		}
		
		else return "Invalid input";
	}
}
