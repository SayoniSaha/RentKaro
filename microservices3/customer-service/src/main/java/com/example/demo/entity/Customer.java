package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="customer")
public class Customer  {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JsonProperty("id")
	private int id;
	
    @JsonProperty("customer_id")
	private String customerId;
    
    @JsonProperty("customer_name")
	private String customerName;
    
    @JsonProperty("customer_email")
	private String customerEmail;
    
    @JsonProperty("customer_password")
	private String customerPassword;
    
    @JsonProperty("customer_contact")
	private String customerContact;
    
    @JsonProperty("customer_gender")
	private String customerGender;
    
    @JsonProperty("customer_address")
	private String customerAddress;
    
    @JsonProperty("customer_wallet")
	private int customerWallet;
	

	public Customer() {
		super();
	}


	public Customer(String customerId, String customerName, String customerEmail, String customerPassword,
			String customerContact, String customerGender, String customerAddress, int customerWallet) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerEmail = customerEmail;
		this.customerPassword = customerPassword;
		this.customerContact = customerContact;
		this.customerGender = customerGender;
		this.customerAddress = customerAddress;
		this.customerWallet = customerWallet;
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


	public String getCustomerName() {
		return customerName;
	}


	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	public String getCustomerEmail() {
		return customerEmail;
	}


	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}


	public String getCustomerPassword() {
		return customerPassword;
	}


	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}


	public String getCustomerContact() {
		return customerContact;
	}


	public void setCustomerContact(String customerContact) {
		this.customerContact = customerContact;
	}


	public String getCustomerGender() {
		return customerGender;
	}


	public void setCustomerGender(String customerGender) {
		this.customerGender = customerGender;
	}


	public String getCustomerAddress() {
		return customerAddress;
	}


	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}


	public int getCustomerWallet() {
		return customerWallet;
	}


	public void setCustomerWallet(int customerWallet) {
		this.customerWallet = customerWallet;
	}
	

}
	
	
	