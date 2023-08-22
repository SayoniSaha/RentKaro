package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MyCart {

    @JsonProperty("id")
	private int id;
    
    @JsonProperty("customer_id")
	private String customerId;
    
    @JsonProperty("product_id")
	private String productId;
    
    @JsonProperty("quantity")
	private int quantity;
    
	public MyCart(String customerId, String productId, int quantity) {
		super();
		this.customerId = customerId;
		this.productId = productId;
		this.quantity=quantity;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public MyCart() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getProductid() {
		return productId;
	}
	public void setProductid(String productId) {
		this.productId = productId;
	}
	
	
	
}
