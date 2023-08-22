package com.example.demo.repository;

import java.util.List;

import com.example.demo.entity.Renter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RenterRepository extends JpaRepository<Renter, Integer> {

	List<Renter> findByRenterId(String renterid);
	
	void deleteByRenterId(String renterid);
	
}
