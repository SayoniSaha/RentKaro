package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Category;
import com.example.demo.entity.City;
import com.example.demo.entity.Product;
import com.example.demo.entity.Renter;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.CityRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.RenterRepository;

@Service
public class RenterService {
	
	@Autowired 
	private CityRepository cityRepository;
	
	@Autowired 
	private ProductRepository productRepository;
	
	@Autowired
	private RenterRepository renterRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public List<Product> showProduct(String category, String city){
		System.out.println(category + city);
		List<Product> products = productRepository.findByCategoryAndCity(categoryRepository.findByCategory(category),
				cityRepository.findByCity(city));
		
		List<Product> productList = new ArrayList<>();
		
		for(Product p : products) {
			System.out.println(p);
			productList.add(p);
		}
		
		return productList;
	}
	
	public List<Product> showProductByCity(String city){
		System.out.println(city);
	    List<City> cities = cityRepository.findByCity(city);
	    List<Product> pList = productRepository.findByProductId("p2");
		
		for(Product p : pList) {
			System.out.println(p.getCategory());
		}
	    
	    if (cities.isEmpty()) {
	        return new ArrayList<>(); // Return an empty list if no cities are found
	    }
	    
	    City firstCity = cities.get(0); // Assuming you only need one city's product list
	    return firstCity.getProductlist();
	}

	
	public void createProduct(Product product, String renterid, String category, String city) {
		
		List<Renter> renterList = renterRepository.findByRenterId(renterid);
		List<Category> categoryList = categoryRepository.findByCategory(category);
		List<City> cityList = cityRepository.findByCity(city);
		
		for(Renter r : renterList) {
			product.setRenter(r);
			List<Product> prodlist=r.getProductList();
			prodlist.add(product);
			r.setProductlist(prodlist);
			
			System.out.println(r.getRenterName());
			
		   }
		
			for(Category c : categoryList) {
				product.setCategory(c);
				List<Product> prodlist=c.getProductlist();
				prodlist.add(product);
				c.setProductlist(prodlist);
				System.out.println(c.getCategory());
			}
			
			for(City c : cityList) {
				product.setCity(c);
				List<Product> prodlist=c.getProductlist();
				prodlist.add(product);
				c.setProductlist(prodlist);
				System.out.println(c.getCity());
				
			}
			
			productRepository.save(product);
	}
	
	
	@Transactional
	public void deleteProduct(String productId) {
		 productRepository.deleteByProductId(productId);
		
	}
	
	@Transactional
	public void updateProduct(String ProductName, String productId) {
		
		List<Product> products = productRepository.findByProductId(productId);
		for(Product p : products) {
			p.setProductName(ProductName);
		}
		
	}
	
	@Transactional
	public void deleteRenter(String renterId) {
		renterRepository.deleteByRenterId(renterId);
		
	}
}
