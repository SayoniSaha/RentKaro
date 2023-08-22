package com.example.demo.repository;

import java.util.List;

import com.example.demo.entity.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	List<Product> findByProductId(String pid);
	
	void deleteByProductId(String pid);
	
	List<Product> findByCategoryAndCity(Object category, Object city);
	
}
