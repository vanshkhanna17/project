package com.users.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.users.model.User;
import com.users.repo.UserDAL;

@RestController
public class UserController {
	
	@Autowired
	private UserDAL user;
	
	@PostMapping("/users")
	public void create(@RequestBody User u) {
		user.save(u);
	}
	
	@GetMapping("/users/{email}")
	public User find(@PathVariable String email){
		return user.findByEmail(email);
	}
}
