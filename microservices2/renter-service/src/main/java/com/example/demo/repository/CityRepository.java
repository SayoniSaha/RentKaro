package com.example.demo.repository;

import java.util.List;

import com.example.demo.entity.City;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CityRepository extends JpaRepository<City, Integer> {

	List<City> findByCity(String city);
	
}
