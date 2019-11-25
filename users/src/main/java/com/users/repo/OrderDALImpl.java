package com.users.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.users.model.Orders;
import com.users.model.User;

@Repository
public class OrderDALImpl implements OrderDAL {

	@Autowired
	private MongoTemplate mongo;

	@Override
	public void save(Orders o) {
		// TODO Auto-generated method stub
		mongo.insert(o);
	}

	@Override
	public List<Orders> findByUserId(String id) {
		// TODO Auto-generated method stub
		return mongo.find(new Query(Criteria.where("user.id").is(id)), Orders.class);
	}

	@Override
	public List<Orders> findByCounterId(String id) {
		// TODO Auto-generated method stub
		return mongo.find(new Query(Criteria.where("counter.id").is(id)), Orders.class);
	}

	@Override
	public void stat(Orders o) {
		// TODO Auto-generated method stub
		mongo.save(o);
	}
	
}
