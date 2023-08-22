package com.example.demo.entity;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="product")
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JsonProperty("id")
	private int id;
    
    @JsonProperty("product_id")
	private String productId;
    
    @JsonProperty("product_name")
	private String productName;
    
    @JsonProperty("product_category")
	private String productCategory;
    
    @JsonProperty("product_subcategory")
	private String productSubcategory;
    
    @JsonProperty("product_description")
	private String productDescription;
    
    @JsonProperty("product_price")
	private int productPrice;
    
    @JsonProperty("product_quantity")
	private int productQuantity;
    
    @JsonProperty("product_availability")
	private boolean productAvailability;
    
    @JsonProperty("product_image")
	private String productImage;

	@ManyToOne
	@JoinColumn(name="renter_id")
	private Renter renter;
	
	@ManyToOne
	@JoinColumn(name="category_id")
	private Category category;
	
	@ManyToOne
	@JoinColumn(name="city_id")
	private City city;
	
	public Product(String productId, String productName, String productCategory, String productSubcategory,
			String productDescription, int productPrice, int productQuantity, boolean productAvailability,
			String productImage) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productCategory = productCategory;
		this.productSubcategory = productSubcategory;
		this.productDescription = productDescription;
		this.productPrice = productPrice;
		this.productQuantity = productQuantity;
		this.productAvailability = productAvailability;
		this.productImage = productImage;
	}


	public Product() {
		super();
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductId() {
		return productId;
	}


	public void setProductId(String productId) {
		this.productId = productId;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public String getProductCategory() {
		return productCategory;
	}


	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}


	public String getProductSubcategory() {
		return productSubcategory;
	}


	public void setProductSubcategory(String productSubcategory) {
		this.productSubcategory = productSubcategory;
	}


	public String getProductDescription() {
		return productDescription;
	}


	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}


	public int getProductPrice() {
		return productPrice;
	}


	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}


	public int getProductQuantity() {
		return productQuantity;
	}


	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}


	public boolean isProductAvailability() {
		return productAvailability;
	}


	public void setProductAvailability(boolean productAvailability) {
		this.productAvailability = productAvailability;
	}


	public String getProductImage() {
		return productImage;
	}


	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}


	@JsonIgnore
	public Renter getRenter() {
		return renter;
	}

	public void setRenter(Renter renter) {
		this.renter = renter;
	}

	@JsonIgnore
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@JsonIgnore
	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}
	
}
