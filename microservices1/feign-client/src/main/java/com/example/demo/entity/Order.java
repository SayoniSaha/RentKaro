package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Order {
    
    @JsonProperty("id")
	private int id;
    
    @JsonProperty("order_id")
	private String orderId;
    
    @JsonProperty("customer_id")
	private String customerId;
    
    @JsonProperty("product_id")
	private String productId;
    
    @JsonProperty("quantity")
	private int quantity;
    
	public Order() {
		super();
	}
	
	public Order(String orderId, String customerId, String productId, int quantity) {
		super();
		this.orderId = orderId;
		this.customerId = customerId;
		this.productId = productId;
		this.quantity=quantity;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
