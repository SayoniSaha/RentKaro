package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.MyCart;

@Repository
public interface MyCartRepository extends JpaRepository<MyCart, Integer>{

	List<MyCart> findByCustomerId(String cid);
	void deleteByCustomerId(String cid);
	List<MyCart> findByCustomerIdAndProductId(String cid, String pid);
	List<MyCart> findAllByCustomerId(String cid);
	void deleteByProductIdAndCustomerId(String pid, String cid);
}