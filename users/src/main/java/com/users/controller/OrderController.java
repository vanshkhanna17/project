package com.users.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.users.model.Orders;
import com.users.repo.OrderDAL;

@RestController
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:4200"})
public class OrderController {
	
	@Autowired
	private OrderDAL order;
	
	@PostMapping("/orders")
	public void create(@RequestBody Orders o) {
		System.err.println("inside order creation");
		System.err.println(o);
		order.save(o);
	}
	
	@GetMapping("/ordersbyuser/{uid}")
	public List<Orders> findForUser(@PathVariable String uid) {
		return order.findByUserId(uid);
	}
	
	@GetMapping("/ordersbycounter/{cid}")
	public List<Orders> findForCounter(@PathVariable String cid) {
		System.out.println("inside get orders by counter");
		System.out.println(cid);
		for(Orders o:order.findByCounterId(cid)) {
			System.out.println(o);
		}
		return order.findByCounterId(cid);
	}
	@PutMapping("/orders/{stat}/{id}")
	public void statusChange(@PathVariable String stat, @PathVariable String id) {
		order.stat(stat,id);
	}
}
