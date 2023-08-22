package com.example.demo.entity;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Category {
	

    @JsonProperty("id")
	private int id;
    
    @JsonProperty("category_id")
	private String categoryId;
    
    @JsonProperty("category")
	private String category;
    
	private List<Product> productlist;
	public Category() {
		super();
	}
	
	public Category(String category, String categoryId) {
		super();
		this.category = category;
		this.categoryId=categoryId;
	}
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public List<Product> getProductlist() {
		return productlist;
	}
	public void setProductlist(List<Product> productlist) {
		this.productlist = productlist;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
}
