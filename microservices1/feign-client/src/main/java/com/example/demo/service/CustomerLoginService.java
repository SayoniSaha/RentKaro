package com.example.demo.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.Customer;
import com.example.demo.entity.Login;

@FeignClient(name="customer-login", url = "http://localhost:8887")
public interface CustomerLoginService {
	
	@PostMapping("/register")
	public List<String> createCustomer(@RequestBody Customer customer);
	
	@RequestMapping("/login")
	public String loginCustomer(@RequestBody Login request);
	
	@GetMapping("/findcustomer/{customerEmail}")
	public List<Customer> findByCustomerEmail(@PathVariable("customerEmail") String customerEmail);
	
	@GetMapping("/findcustomerid/{customerId}")
	public List<Customer> findByCustomerId(@PathVariable("customerId") String customerId);
}
