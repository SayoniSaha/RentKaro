package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Transaction {
    
    @JsonProperty("id")
	private int id;
    
    @JsonProperty("transaction_id")
	private String transactionId;
    
    @JsonProperty("customer_id")
	private String customerId;
    
    @JsonProperty("product_id")
	private String productId;
    
    @JsonProperty("transaction_amount")
	private String transactionAmount;
	
	
	public Transaction(String transactionId, String customerId, String productId, String transactionAmount) {
		super();
		this.transactionId = transactionId;
		this.customerId = customerId;
		this.productId = productId;
		this.transactionAmount = transactionAmount;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
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

	public String getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(String transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	
}
