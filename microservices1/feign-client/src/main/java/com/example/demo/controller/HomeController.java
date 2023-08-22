package com.example.demo.controller;

import java.util.List;
import java.util.ArrayList;

import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Customer;
import com.example.demo.entity.Login;
import com.example.demo.entity.MyCart;
import com.example.demo.entity.Product;
import com.example.demo.service.CustomerLoginService;
import com.example.demo.service.CustomerService;
import com.example.demo.service.RenterService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class HomeController {
	@Autowired
	CustomerService customerService;
	@Autowired
	CustomerLoginService customerLoginService;
	@Autowired
	RenterService renterService;

	@RequestMapping("/")
	public String selectCity() {
		return "select-city";
	}

	@RequestMapping("/showallproduct")
	public List<Product> findProductByCity(@RequestParam("city") String city, Model theModel) {
		List<Product> productlist = renterService.showProductByCity(city, theModel);
		
		for (Product p : productlist) {
			System.out.println(p.getProductName());
		}
		
		return productlist;
	}

	@RequestMapping("/showproduct")
	public List<Product> showProduct(@RequestParam("category") String category, @RequestParam("city") String city,
			Model theModel) {
		System.out.println("Renter feign" + category);
		
		List<Product> productlist = renterService.showProduct(category, city);
		for (Product p : productlist) {
			System.out.println(p.getProductName());
		}
		return productlist;
	}

	@RequestMapping("/createproduct/{renterid}/{category}/{city}")
	public void createProduct(@PathVariable String renterid, @PathVariable String category, @PathVariable String city,
			@RequestBody Product p) {
		renterService.createProduct(renterid, category, city, p);

	}

	@RequestMapping("/deleteproduct/{productId}")
	public void deleteProduct(@PathVariable String productId) {
		renterService.deleteProduct(productId);
		
	}

	@RequestMapping("/updateproduct/{name}/{productId}")
	public void updateProduct(@PathVariable String name, @PathVariable String productId) {
		renterService.updateProduct(name, productId);
	}

	@RequestMapping("/deleterenter/{sid}")
	public void deleteRenter(@PathVariable String sid) {
		renterService.deleteRenter(sid);
		
		
	}

	@RequestMapping("/mycart/{productId}/{customerId}")
	public void addToCart(@PathVariable String productId, @PathVariable String customerId) {
		String status = customerService.addToCart(productId, customerId);
		System.out.println(status);
	}

	@RequestMapping("/savecart/{customerId}/{productId}/{quantity}")
	public void saveCart(@PathVariable String customerId, @PathVariable String productId, @PathVariable String quantity) {
		String status = customerService.saveCart(customerId, productId, quantity);
		System.out.println(status);
		
	}

	@RequestMapping("/checkout/{status}/{customerId}")
	public String orderProduct(@PathVariable String customerId, @PathVariable String status) {
		if (status.equals("success")) {
			return customerService.orderProduct(customerId, status);
		} else {
			return null;
		}

	}

	@GetMapping("/showproductbyid/{productId}")
	public List<Product> findByProductid(@PathVariable String productId) {
		return customerService.findByProductid(productId);
	}

	@GetMapping("/viewcart/{customerId}")
	public List<MyCart> viewcart(@PathVariable String customerId) {
		System.out.println("View Cart for customer " + customerId);
		return customerService.viewcart(customerId);
	}

	@GetMapping("/findcustomer/{customerEmail}")
	public List<Customer> findByCustomerEmail(@PathVariable String customerEmail) {
		return customerLoginService.findByCustomerEmail(customerEmail);
		
	}

	@GetMapping("/findcustomerid/{customerId}")
	public List<Customer> findByCustomerId(@PathVariable String customerId) {
		return customerLoginService.findByCustomerId(customerId);
		
	}

	@PostMapping("/register")
	public List<String> createCustomer(@RequestBody Customer customer) {
		System.out.println("Register");
		System.out.println(customer.getCustomerEmail());
		System.out.println(customer.getCustomerPassword());
		List<String> customerId = new ArrayList<>();
		customerId = customerLoginService.createCustomer(customer);
		return customerId;
		
	}

	@PostMapping("/login")
	public String loginCustomer(@RequestBody Login request) {
		String status = customerLoginService.loginCustomer(request);
		return status;
	}

}
