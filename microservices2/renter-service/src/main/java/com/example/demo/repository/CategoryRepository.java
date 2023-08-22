package com.example.demo.repository;

import java.util.List;

import com.example.demo.entity.Category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{
	
	List<Category> findByCategory(String category);
	
	List<Category> findByProductlist(String category);
	
}
