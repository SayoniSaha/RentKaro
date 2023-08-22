package com.example.demo.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entity.MyCart;
import com.example.demo.entity.Product;

@FeignClient(name="customer-service", url = "http://localhost:8886")
public interface CustomerService {
	
	@RequestMapping(value="/mycart/{productId}/{customerId}",  method=RequestMethod.POST)
	public String addToCart(@PathVariable String productId,@PathVariable String customerId);
	
	@RequestMapping(value="/savecart/{customerId}/{productId}/{quantity}",  method=RequestMethod.GET)
	public String saveCart(@PathVariable String customerId,@PathVariable String productId, @PathVariable String quantity);
	
	@RequestMapping(value="/checkout/{status}/{customerId}",  method=RequestMethod.GET)
	public String orderProduct(@PathVariable String customerId, @PathVariable String status);
	
	@RequestMapping(value="/showproductbyid/{productId}",  method=RequestMethod.GET)
	public List<Product> findByProductid(@PathVariable String productId);
	
	@RequestMapping(value="/viewcart/{customerId}", method=RequestMethod.GET) 
	public List<MyCart> viewcart(@PathVariable String customerId);
}
