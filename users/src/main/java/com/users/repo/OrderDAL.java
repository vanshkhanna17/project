package com.users.repo;

import java.util.List;

import com.users.model.Orders;
import com.users.model.User;

public interface OrderDAL {
	void save(Orders o);
	List<Orders> findByUserId(String id);
	List<Orders> findByCounterId(String id );
	void stat(Orders o);
	
}
