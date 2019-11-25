package com.users.repo;

import com.users.model.User;

public interface UserDAL {
	void save(User u);
	User findByEmail(String email);
}
