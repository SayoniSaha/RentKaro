package com.example.demo.service;

import java.security.SecureRandom;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.entity.Customer;
import com.example.demo.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public String createCustomer(Customer customer) {
		String email = customer.getCustomerEmail();
        System.out.println(email);

        List<Customer> customers = customerRepository.findByCustomerEmail(customer.getCustomerEmail());
        if (customers.isEmpty()) {
            System.out.println("Creating new customer");
            customer.setCustomerId(generateRandomString(6));
            String password = customer.getCustomerPassword();
            System.out.println("Password: " + password);
            if (password == null) {
                throw new IllegalArgumentException("Password cannot be null");
            }
            customer.setCustomerPassword(bCryptPasswordEncoder.encode(password));
            System.out.println("Encoded password: " + customer.getCustomerPassword());
            customerRepository.save(customer);
            return customer.getCustomerId().toString();
        }

        System.out.println("User already exists");
        return null;
//		String email = customer.getCustomerEmail();
//		System.out.println(email);
//		
//		List<Customer> customers = customerRepository.findByCustomerEmail(customer.getCustomerEmail());
//		
//		if (customers.isEmpty()) {
//			customer.setCustomerId(generateRandomString(6));
//			customer.setCustomerPassword(bCryptPasswordEncoder.encode(customer.getCustomerPassword()));
//			customerRepository.save(customer);
//			return customer.getCustomerId().toString();
//		}
//		System.out.println("User already exists");
//		return null;
	}

	public List<Customer> findByCustomerEmail(@PathVariable String customerEmail) {
		return customerRepository.findByCustomerEmail(customerEmail);
	}

	public List<Customer> findByCustomerId(@PathVariable String customerId) {
		return customerRepository.findByCustomerId(customerId);
		
	}

	public List<Customer> checkUser(String email, String password) {
		
		List<Customer> customers = customerRepository.findByCustomerEmail(email);
		for (Customer c : customers) {
			if (c.getCustomerEmail().equals(email) && bCryptPasswordEncoder.matches(password, c.getCustomerPassword())) {
				return customers;
			} else {
				return null;
			}

		}
		return null;
	}

	public static String generateRandomString(int length) {
		
	    if (length < 1) {
	        throw new IllegalArgumentException("Length must be greater than 0");
	    }
	    
	    String charLower = "abcdefghijklmnopqrstuvwxyz";
	    String charUpper = charLower.toUpperCase();
	    String digits = "0123456789";
	    String randomChars = charLower + charUpper + digits;
	    
	    SecureRandom random = new SecureRandom();
	    StringBuilder stringbuilder = new StringBuilder(length);
	    
	    for (int i = 0; i < length; i++) {
	        int randomIndex = random.nextInt(randomChars.length());
	        char randomChar = randomChars.charAt(randomIndex);
	        stringbuilder.append(randomChar);
	    }
	    
	    return stringbuilder.toString();
	}

}
