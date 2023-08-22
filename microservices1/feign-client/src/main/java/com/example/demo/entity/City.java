package com.example.demo.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class City {

    @JsonProperty("id")
	private int id;

    @JsonProperty("city_id")
	private String cityId;
    
    @JsonProperty("city")
	private String city;
    
	private List<Product> productlist;

	public City(String cityId, String city) {
		super();
		this.cityId = cityId;
		this.city = city;
	}
	
	public City() {
		super();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCityId() {
		return cityId;
	}
	public void setCityId(String cityId) {
		this.cityId = cityId;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

	public List<Product> getProductlist() {
		return productlist;
	}

	public void setProductlist(List<Product> productlist) {
		this.productlist = productlist;
	}
	
	
}
