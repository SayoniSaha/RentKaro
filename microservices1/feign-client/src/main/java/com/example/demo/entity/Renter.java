package com.example.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Renter {
    
    @JsonProperty("id")
	private int id;
    
    @JsonProperty("renter_id")
	private String renterId;
    
    @JsonProperty("renter_name")
	private String renterName;
    
    @JsonProperty("renter_email")
	private String renterEmail;
    
    @JsonProperty("renter_password")
	private String renterPassword;
    
    @JsonProperty("renter_contact")
	private String renterContact;
    
    @JsonProperty("renter_gender")
	private String renterGender;
    
    @JsonProperty("renter_address")
	private String renterAddress;
    
    @JsonProperty("renter_pancard")
	private String renterPancard;
    
    @JsonProperty("renter_rating")
	private int renterRating;
	
	@OneToMany(mappedBy = "renter", cascade = CascadeType.ALL)
	private List<Product> productList;
	
	public Renter(String renterId, String renterName, String renterEmail, String renterPassword, String renterContact,
			String renterGender, String renterAddress, String renterPancard, int renterRating) {
		super();
		this.renterId = renterId;
		this.renterName = renterName;
		this.renterEmail = renterEmail;
		this.renterPassword = renterPassword;
		this.renterContact = renterContact;
		this.renterGender = renterGender;
		this.renterAddress = renterAddress;
		this.renterPancard = renterPancard;
		this.renterRating = renterRating;
	}

	public Renter() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRenterId() {
		return renterId;
	}

	public void setRenterId(String renterId) {
		this.renterId = renterId;
	}

	public String getRenterName() {
		return renterName;
	}

	public void setRenterName(String renterName) {
		this.renterName = renterName;
	}

	public String getRenterEmail() {
		return renterEmail;
	}

	public void setRenterEmail(String renterEmail) {
		this.renterEmail = renterEmail;
	}

	public String getRenterPassword() {
		return renterPassword;
	}

	public void setRenterPassword(String renterPassword) {
		this.renterPassword = renterPassword;
	}

	public String getRenterContact() {
		return renterContact;
	}

	public void setRenterContact(String renterContact) {
		this.renterContact = renterContact;
	}

	public String getRenterGender() {
		return renterGender;
	}

	public void setRenterGender(String renterGender) {
		this.renterGender = renterGender;
	}

	public String getRenterAddress() {
		return renterAddress;
	}

	public void setRenterAddress(String renterAddress) {
		this.renterAddress = renterAddress;
	}

	public String getRenterPancard() {
		return renterPancard;
	}

	public void setRenterPancard(String renterPancard) {
		this.renterPancard = renterPancard;
	}

	public int getRenterRating() {
		return renterRating;
	}

	public void setRenterRating(int renterRating) {
		this.renterRating = renterRating;
	}

	@JsonIgnore
	public List<Product> getProductList() {
		return productList;
	}

	public void setProductlist(List<Product> productList) {
		this.productList = productList;
	}

	
	
}
