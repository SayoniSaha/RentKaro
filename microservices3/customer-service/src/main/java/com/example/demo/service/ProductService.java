package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Customer;
import com.example.demo.entity.MyCart;
import com.example.demo.entity.Order;
import com.example.demo.entity.Product;
import com.example.demo.repo.CustomerRepository;
import com.example.demo.repo.MyCartRepository;
import com.example.demo.repo.OrderRepository;
import com.example.demo.repo.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productrepo;
	@Autowired
	CustomerRepository customerrepo;
	@Autowired
	OrderRepository orderrepo;
	@Autowired
	MyCartRepository mycartrepo;

	public String addToCart(String pid, String cid) {
		List<Product> prodlist = productrepo.findByProductId(pid);
		List<Customer> cust = customerrepo.findByCustomerId(cid);
		for (Product p : prodlist) {
			for (Customer c : cust) {
				MyCart mc = new MyCart(c.getCustomerId(), p.getProductId(), 1);
				mycartrepo.save(mc);
				return "saved in cart";
			}
		}
		return null;
	}

	@Transactional
	public String saveCart(String cid, String pid, int quantity) {
		List<MyCart> cartlist = mycartrepo.findByCustomerIdAndProductId(cid, pid);
		for (MyCart mc : cartlist) {
			System.out.println(mc.getQuantity());
			mc.setQuantity(quantity);
			return "succesfully updated!!";
		}
		return null;

	}

	@Transactional
	public String orderProduct(String cid) {
		List<MyCart> cartlist = mycartrepo.findByCustomerId(cid);
		int orderstatus = 0;
		for (MyCart mc : cartlist) {
			List<Product> plist = productrepo.findByProductId(mc.getProductid());
			for (Product p : plist) {
				if (mc.getCustomerId().equals(cid) && p.getProductQuantity() >= mc.getQuantity()) {
					Order o = new Order(mc.getCustomerId(), cid, mc.getProductid(), mc.getQuantity());
					orderrepo.save(o);
					mycartrepo.deleteByCustomerId(cid);
					List<Product> prodlist = productrepo.findByProductId(mc.getProductid());
					for (Product pl : prodlist) {
						int quantity = pl.getProductQuantity() - mc.getQuantity();
						pl.setProductQuantity(quantity);
						orderstatus = 1;
					}

				}
			}
		}
		if (orderstatus == 1) {
			return "Order successfully placed!";
		} else {
			return "null";
		}
	}

	@Transactional
	public List<Product> findByProdoctid(String pid) {
		return productrepo.findByProductId(pid);
	}

	public List<MyCart> viewcart(String cid) {
		return mycartrepo.findAllByCustomerId(cid);
	}
	
	@Transactional
	public void deleteFromCart(String pid, String cid) {
		mycartrepo.deleteByProductIdAndCustomerId(pid, cid);
	}

}