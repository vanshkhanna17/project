package com.users.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.users.model.Orders;
import com.users.repo.OrderDAL;

@RestController
public class OrderController {
	
	@Autowired
	private OrderDAL order;
	
	@PostMapping("/orders")
	public void create(@RequestBody Orders o) {
		order.save(o);
	}
	
	@GetMapping("/orders/{uid}")
	public List<Orders> findForUser(@PathVariable String uid) {
		return order.findByUserId(uid);
	}
	
	@GetMapping("/orders/{cid}")
	public List<Orders> findForCounter(@PathVariable String cid) {
		return order.findByCounterId(cid);
	}
	@PutMapping("/orders")
	public void statusChange(@RequestBody Orders o) {
		order.stat(o);
	}
}
